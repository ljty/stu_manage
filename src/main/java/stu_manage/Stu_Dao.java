package stu_manage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.Jedis;
import stu_manage.Student;

public class Stu_Dao {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   
	public  int getNumber() throws  java.text.ParseException{
		   return this.findAll().size();
	   }	 
	
	public List<Student> findAll() throws java.text.ParseException{
			List<Student> students = new ArrayList<Student>();
			Jedis jedis = new Jedis("localhost");
			Set<String> ids= jedis.zrevrange("studentlist", 0, -1);
					jedis.close();
			for(String id:ids){
				Student student = new Student();
				student.setStudent_id(Integer.parseInt(id));
				student.setStudent_name(jedis.hget(id, "name"));
				student.setBrithday(dateFormat.parse(jedis.hget(id, "birthday")));
				student.setNote(jedis.hget(id, "description"));
				student.setAvgscore(Integer.valueOf(jedis.hget(id, "avagscore")));
				students.add(student);
			}
			return students;
			
		}
		
	public void delete(String student_id){
			Jedis jedis = new Jedis("localhost");
			jedis.zrem("studentlist", student_id);
			jedis.del(student_id);
			jedis.close();
		}
		
	public void save(Student student) throws Exception{
			Jedis jedis = new Jedis("localhost");
			String id =String.valueOf(student.getStudent_id());
				jedis.zadd("studentlist",student.getAvgscore(),id);
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", student.getStudent_name());
				map.put("birthday", dateFormat.format(student.getBrithday()));
				map.put("description", student.getNote());
				map.put("avagscore", String.valueOf(student.getAvgscore()));
				jedis.hmset(id, map);
				jedis.close();
		}
		
	public void update(Student student){
			Jedis jedis = new Jedis("localhost");
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", student.getStudent_name());
			map.put("birthday", dateFormat.format(student.getBrithday()));
			map.put("description", student.getNote());
			map.put("avagscore", String.valueOf(student.getAvgscore()));
			jedis.hmset(String.valueOf(student.getStudent_id()), map);
			jedis.zadd("studentlist", student.getAvgscore(),String.valueOf(student.getStudent_id()));
			jedis.close();
		}
}

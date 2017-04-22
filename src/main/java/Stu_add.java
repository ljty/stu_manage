

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stu_manage.Stu_Dao;
import stu_manage.Student;


public class Stu_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request. setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Stu_Dao student_dao = new Stu_Dao(); 
		Student student = new Student();
		student.setStudent_id(Integer.valueOf(request.getParameter("stu_id")));
		student.setStudent_name(request.getParameter("stu_name"));
			try {
				student.setBrithday(dateFormat.parse(request.getParameter("stu_brithday")));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		student.setAvgscore(Integer.valueOf(request.getParameter("stu_avregarde")));
		student.setNote(request.getParameter("stu_note"));
			try {
				student_dao.save(student);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		request.getRequestDispatcher("Stu_message").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

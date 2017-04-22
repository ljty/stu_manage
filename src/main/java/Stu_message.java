import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import stu_manage.Stu_Dao;
import stu_manage.Student;

public class Stu_message extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8"); 
		Stu_Dao student_dao = new Stu_Dao(); 
		int pageNos;
	      if (request.getParameter("pageNos") == null|| Integer.parseInt(request.getParameter("pageNos")) < 1) {
		          pageNos = 1;
		      } else {
		         pageNos = Integer.parseInt(request.getParameter("pageNos"));
		      }
	        request.setAttribute("pageNos", pageNos);
		    List<Student> student_list = null;
			try {
				student_list = student_dao.findAll();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			request.setAttribute("student_List", student_list);
			int countPage = 0;
			try {
				countPage = student_dao.findAll().size()/10+(student_dao.findAll().size()%10>0?1:0);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			request.setAttribute("countPage", countPage);
			try {
				request.setAttribute("totalnuber", student_dao.findAll().size());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("/studentmessage.jsp").forward(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

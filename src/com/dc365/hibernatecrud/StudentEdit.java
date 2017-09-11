package com.dc365.hibernatecrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.dc365.hibernatecrud.orm.Student;

public class StudentEdit extends HttpServlet
{

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 获取数据
		request.setCharacterEncoding("utf-8");
		String strID = "";
		String strName = "";
		
		strID = request.getParameter("ID");
		strName = request.getParameter("Name");
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Student student = (Student)session.load(Student.class, strID);
		student.setName(strName);
		
		session.update(student);
		
		session.getTransaction().commit();
		session.close();
		
		response.sendRedirect("../StudentList.jsp");
		
	}

}

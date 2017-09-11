package com.dc365.hibernatecrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.dc365.hibernatecrud.orm.Student;



public class StudentAdd extends HttpServlet
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

		request.setCharacterEncoding("utf-8");
		String strID = "";
		String strName = "";
		
		strID = request.getParameter("ID");
		strName = request.getParameter("Name");
				
		

		try
		{
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			
			Student student = new Student();
			student.setId(strID);
			student.setName(strName);
			session.save(student);
			
			session.getTransaction().commit();
			session.close();
			
			response.sendRedirect("../StudentList.jsp");
		}
		catch(Exception e)
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.print("    add fail! ");
			out.println(" <a href='..//StudentList.jsp'>return</a> ");
			out.println(e.getMessage());
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}

}

package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Edit Student</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; background:#f4f6f9; text-align:center; padding:50px; }");
		out.println(".container { background:white; max-width:500px; margin:auto; padding:30px; border-radius:8px; }");
		out.println("input { padding:8px; margin:10px; width:90%; border:1px solid #ddd; border-radius:4px; }");
		out.println(
				"button { padding:10px 20px; background:#3498db; color:white; border:none; border-radius:4px; cursor:pointer; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");
		out.println("<h2>Edit Student</h2>");
		out.println("<form action='finalUpdate' method='post'>");
		out.println("ID: <input type='text' name='sid' value='" + sid + "' readonly><br>");
		out.println("Name: <input type='text' name='name' value='" + name + "' required><br>");
		out.println("Age: <input type='text' name='age' value='" + age + "' required><br>");
		out.println("Address: <input type='text' name='address' value='" + address + "' required><br>");
		out.println("<button type='submit'>Update Student</button>");
		out.println("</form>");
		out.println("<br><a href='index.html'>Back to Home</a>");
		out.println("</div></body></html>");
	}
}
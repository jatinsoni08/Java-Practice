package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import in.jatindb.util.DB_Connection;

public class AdminPanelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || !"admin".equals(session.getAttribute("role"))) {
			response.sendRedirect("studentLogin.html");
			return;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Admin Panel</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; background: #f4f6f9; margin:0; padding:20px; }");
		out.println(".container { max-width: 1200px; margin: 0 auto; }");
		out.println(
				".header { background: #2c3e50; color: white; padding: 20px; border-radius: 8px; margin-bottom: 20px; }");
		out.println(".grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(300px, 1fr)); gap: 20px; }");
		out.println(
				".card { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }");
		out.println(".card h3 { color: #2c3e50; margin-bottom: 15px; }");
		out.println(
				".btn { display: inline-block; padding: 10px 20px; background: #3498db; color: white; text-decoration: none; border-radius: 4px; margin: 5px; }");
		out.println(".btn-danger { background: #e74c3c; }");
		out.println("input { padding: 8px; margin: 5px; width: 90%; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");
		out.println("<div class='header'>");
		out.println("<h2>Admin Panel</h2>");
		out.println("<p>Welcome, " + session.getAttribute("studentName") + "</p>");
		out.println("<a href='logout' class='btn btn-danger' style='float:right;'>Logout</a>");
		out.println("</div>");

		out.println("<div class='grid'>");

		// Add Student Card
		out.println("<div class='card'>");
		out.println("<h3>Add New Student</h3>");
		out.println("<form action='addStudent' method='post'>");
		out.println("<input type='text' name='name' placeholder='Name' required><br>");
		out.println("<input type='number' name='age' placeholder='Age' required><br>");
		out.println("<input type='text' name='address' placeholder='Address' required><br>");
		out.println("<button type='submit' class='btn'>Add Student</button>");
		out.println("</form>");
		out.println("</div>");

		// Search Student Card
		out.println("<div class='card'>");
		out.println("<h3>Search Student</h3>");
		out.println("<form action='searchStudent' method='post'>");
		out.println("<input type='number' name='sid' placeholder='Enter Student ID' required><br>");
		out.println("<button type='submit' class='btn'>Search</button>");
		out.println("</form>");
		out.println("</div>");

		// View All Students Card
		out.println("<div class='card'>");
		out.println("<h3>All Students</h3>");
		out.println("<a href='viewAllStudents' class='btn'>View All Students</a>");
		out.println("</div>");

		// Dashboard Card
		out.println("<div class='card'>");
		out.println("<h3>Dashboard</h3>");
		out.println("<a href='dashboard' class='btn'>View Statistics</a>");
		out.println("</div>");

		out.println("</div>");
		out.println("</div></body></html>");
	}
	
}
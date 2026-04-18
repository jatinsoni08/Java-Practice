package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import in.jatindb.util.DB_Connection;

public class SearchStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("studentId") == null) {
			response.sendRedirect("studentLogin.html");
			return;
		}

		String sid = request.getParameter("sid");
		if (sid == null)
			sid = request.getParameter("id");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Search Student</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; background:#f4f6f9; text-align:center; padding:20px; }");
		out.println(".container { background:white; max-width:600px; margin:auto; padding:20px; border-radius:8px; }");
		out.println("table { width:100%; border-collapse:collapse; margin:20px 0; }");
		out.println("th, td { padding:10px; border:1px solid #ddd; text-align:left; }");
		out.println("th { background:#2c3e50; color:white; }");
		out.println(
				".btn { padding:8px 15px; margin:5px; border:none; border-radius:4px; cursor:pointer; text-decoration:none; display:inline-block; }");
		out.println(".edit { background:green; color:white; }");
		out.println(".delete { background:red; color:white; }");
		out.println(".back { background:#3498db; color:white; }");
		out.println(".error { color:red; background:#ffebee; padding:15px; border-radius:4px; margin:20px 0; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");

		if (sid == null || sid.trim().isEmpty()) {
			out.println("<div class='error'>Student ID is required.</div>");
			out.println("<a href='adminDashboard' class='btn back'>Back to Admin Panel</a>");
			out.println("</div></body></html>");
			return;
		}

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DB_Connection.getConnection();
			ps = con.prepareStatement("SELECT * FROM student WHERE sid = ?");
			ps.setInt(1, Integer.parseInt(sid));
			rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("sid");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");

				out.println("<h2>Student Details</h2>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>" + id + "</td></tr>");
				out.println("<tr><th>Name</th><td>" + name + "</td></tr>");
				out.println("<tr><th>Age</th><td>" + age + "</td></tr>");
				out.println("<tr><th>Address</th><td>" + address + "</td></tr>");
				out.println("</table>");

				// Edit button
				out.println("<form action='updateStudent' method='post' style='display:inline;'>");
				out.println("<input type='hidden' name='sid' value='" + id + "'>");
				out.println("<input type='hidden' name='name' value='" + name + "'>");
				out.println("<input type='hidden' name='age' value='" + age + "'>");
				out.println("<input type='hidden' name='address' value='" + address + "'>");
				out.println("<button type='submit' class='btn edit'>Edit Student</button>");
				out.println("</form>");

				// Delete button
				out.println("<form action='deleteStudent' method='post' style='display:inline;'>");
				out.println("<input type='hidden' name='sid' value='" + id + "'>");
				out.println(
						"<button type='submit' class='btn delete' onclick='return confirm(\"Are you sure?\")'>Delete Student</button>");
				out.println("</form>");

			} else {
				out.println("<div class='error'>Student not found with ID: " + sid + "</div>");
			}
		} catch (NumberFormatException e) {
			out.println("<div class='error'>Invalid ID format.</div>");
		} catch (Exception e) {
			out.println("<div class='error'>Error: " + e.getMessage() + "</div>");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
		}

		out.println("<br><a href='adminDashboard' class='btn back'>Back to Admin Panel</a>");
		out.println("</div></body></html>");
	}
}
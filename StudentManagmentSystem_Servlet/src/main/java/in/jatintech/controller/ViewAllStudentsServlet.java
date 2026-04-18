package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import in.jatindb.util.DB_Connection;

public class ViewAllStudentsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>All Students</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; background:#f4f6f9; text-align:center; padding:20px; }");
		out.println(".container { background:white; max-width:1000px; margin:auto; padding:20px; border-radius:8px; }");
		out.println("table { width:100%; border-collapse:collapse; margin:20px 0; }");
		out.println("th, td { padding:10px; border:1px solid #ddd; text-align:left; }");
		out.println("th { background:#2c3e50; color:white; }");
		out.println("tr:hover { background:#f5f5f5; }");
		out.println(
				".btn { display:inline-block; padding:8px 15px; background:#3498db; color:white; text-decoration:none; border-radius:4px; margin:5px; }");
		out.println(".view-link { color:#27ae60; text-decoration:none; }");
		out.println(".view-link:hover { text-decoration:underline; }");
		out.println(".no-data { text-align:center; padding:40px; color:#999; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");
		out.println("<h2>All Students List</h2>");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DB_Connection.getConnection();
			ps = con.prepareStatement("SELECT * FROM student ORDER BY sid DESC");
			rs = ps.executeQuery();

			out.println("<table>");
			out.println(
					"<thead><tr><th>#</th><th>ID</th><th>Name</th><th>Age</th><th>Address</th><th>Action</th></tr></thead>");
			out.println("<tbody>");

			int serial = 1;
			boolean hasData = false;
			while (rs.next()) {
				hasData = true;
				int id = rs.getInt("sid");
				out.println("<tr>");
				out.println("<td>" + serial++ + "</td>");
				out.println("<td>" + id + "</td>");
				out.println("<td>" + rs.getString("sname") + "</td>");
				out.println("<td>" + rs.getInt("sage") + "</td>");
				out.println("<td>" + rs.getString("saddress") + "</td>");
				out.println("<td><a href='searchStudentDirect?id=" + id + "' class='view-link'>View Details</a></td>");
				out.println("</tr>");
			}
			if (!hasData) {
				out.println("<tr><td colspan='6' class='no-data'>No students found.</td></tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
		} catch (Exception e) {
			out.println("<p style='color:red'>Error: " + e.getMessage() + "</p>");
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

		out.println("<a href='index.html' class='btn'>Back to Home</a>");
		out.println("</div></body></html>");
	}
}
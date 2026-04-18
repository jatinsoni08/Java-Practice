package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import in.jatindb.util.DB_Connection;

public class DashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Dashboard</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; background:#f4f6f9; text-align:center; padding:20px; }");
		out.println(".container { background:white; max-width:800px; margin:auto; padding:20px; border-radius:8px; }");
		out.println(".stats { display:flex; justify-content:space-around; margin:20px 0; }");
		out.println(".stat-card { background:#f8f9fa; padding:20px; border-radius:8px; width:200px; }");
		out.println(".stat-number { font-size:36px; font-weight:bold; color:#2c3e50; }");
		out.println(".btn { display:inline-block; padding:8px 15px; background:#3498db; color:white; text-decoration:none; border-radius:4px; margin:5px; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");
		out.println("<h2>Student Dashboard</h2>");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DB_Connection.getConnection();

			// Total students
			ps = con.prepareStatement("SELECT COUNT(*) as total FROM student");
			rs = ps.executeQuery();
			int total = 0;
			if (rs.next()) total = rs.getInt("total");
			rs.close(); ps.close();

			// Average age
			ps = con.prepareStatement("SELECT AVG(sage) as avg FROM student");
			rs = ps.executeQuery();
			double avg = 0;
			if (rs.next()) avg = rs.getDouble("avg");
			rs.close(); ps.close();

			// Age range
			ps = con.prepareStatement("SELECT MIN(sage) as min, MAX(sage) as max FROM student");
			rs = ps.executeQuery();
			int min = 0, max = 0;
			if (rs.next()) {
				min = rs.getInt("min");
				max = rs.getInt("max");
			}

			out.println("<div class='stats'>");
			out.println("<div class='stat-card'><div class='stat-number'>" + total + "</div><div>Total Students</div></div>");
			out.println("<div class='stat-card'><div class='stat-number'>" + String.format("%.1f", avg) + "</div><div>Average Age</div></div>");
			out.println("<div class='stat-card'><div class='stat-number'>" + min + " - " + max + "</div><div>Age Range</div></div>");
			out.println("</div>");

		} catch (Exception e) {
			out.println("<p style='color:red'>Error: " + e.getMessage() + "</p>");
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {}
			try { if (ps != null) ps.close(); } catch (Exception e) {}
		}

		out.println("<a href='viewAllStudents' class='btn'>View All Students</a>");
		out.println("<a href='index.html' class='btn'>Back to Home</a>");
		out.println("</div></body></html>");
	}
}
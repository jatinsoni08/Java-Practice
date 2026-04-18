package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import in.jatindb.util.DB_Connection;

public class StudentDashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("studentId") == null) {
			response.sendRedirect("studentLogin.html");
			return;
		}

		int studentId = (Integer) session.getAttribute("studentId");
		String studentName = (String) session.getAttribute("studentName");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Student Dashboard</title>");
		out.println("<style>");
		out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
		out.println(
				"body { font-family: 'Segoe UI', Arial; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; padding: 20px; }");
		out.println(".container { max-width: 800px; margin: 0 auto; }");
		out.println(
				".header { background: white; border-radius: 15px; padding: 20px; margin-bottom: 20px; text-align: center; }");
		out.println(
				".card { background: white; border-radius: 15px; padding: 25px; margin-bottom: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.1); }");
		out.println("h2 { color: #2c3e50; margin-bottom: 15px; }");
		out.println(
				".btn { display: inline-block; padding: 10px 20px; background: #3498db; color: white; text-decoration: none; border-radius: 5px; margin: 5px; }");
		out.println(".btn-danger { background: #e74c3c; }");
		out.println(".info-row { display: flex; padding: 10px 0; border-bottom: 1px solid #eee; }");
		out.println(".info-label { font-weight: bold; width: 120px; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");
		out.println("<div class='header'>");
		out.println("<h2>Welcome, " + studentName + "!</h2>");
		out.println("<p>Student Dashboard</p>");
		out.println("</div>");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DB_Connection.getConnection();
			ps = con.prepareStatement("SELECT * FROM student WHERE sid = ?");
			ps.setInt(1, studentId);
			rs = ps.executeQuery();

			if (rs.next()) {
				out.println("<div class='card'>");
				out.println("<h3>My Profile</h3>");
				out.println("<div class='info-row'><div class='info-label'>Student ID:</div><div>" + rs.getInt("sid")
						+ "</div></div>");
				out.println("<div class='info-row'><div class='info-label'>Name:</div><div>" + rs.getString("sname")
						+ "</div></div>");
				out.println("<div class='info-row'><div class='info-label'>Age:</div><div>" + rs.getInt("sage")
						+ "</div></div>");
				out.println("<div class='info-row'><div class='info-label'>Address:</div><div>"
						+ rs.getString("saddress") + "</div></div>");
				out.println("<div class='info-row'><div class='info-label'>Email:</div><div>" + rs.getString("email")
						+ "</div></div>");
				out.println("<div class='info-row'><div class='info-label'>Registered:</div><div>"
						+ rs.getTimestamp("registration_date") + "</div></div>");
				out.println("<div style='margin-top: 20px;'>");
				out.println("<a href='UpdateStudentServlet' class='btn'>Update Profile</a>");
				out.println("</div>");
				out.println("</div>");
			}

		} catch (Exception e) {
			out.println("<p>Error: " + e.getMessage() + "</p>");
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

		out.println("<div class='card'>");
		out.println("<h3>Quick Actions</h3>");
		out.println("<a href='viewMyCourses' class='btn'>View Courses</a>");
		out.println("<a href='viewMyAttendance' class='btn'>View Attendance</a>");
		out.println("<a href='submitFeedback' class='btn'>Submit Feedback</a>");
		out.println("<a href='logout' class='btn btn-danger'>Logout</a>");
		out.println("</div>");

		out.println("</div></body></html>");
	}
}
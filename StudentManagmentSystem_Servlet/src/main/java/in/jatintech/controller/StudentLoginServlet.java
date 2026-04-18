package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import in.jatindb.util.DB_Connection;

public class StudentLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Connection con = DB_Connection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("sid");
				String name = rs.getString("sname");
				String role = rs.getString("role");

				// Create session
				HttpSession session = request.getSession();
				session.setAttribute("studentId", id);
				session.setAttribute("studentName", name);
				session.setAttribute("studentEmail", email);
				session.setAttribute("role", role);

				// Redirect based on role
				if ("admin".equals(role)) {
					response.sendRedirect("adminDashboard");
				} else {
					response.sendRedirect("studentDashboard");
				}
				return;
			} else {
				out.println("<!DOCTYPE html>");
				out.println("<html><head><meta charset='UTF-8'><title>Login Failed</title>");
				out.println("<style>");
				out.println(
						"body { font-family: Arial; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; display: flex; justify-content: center; align-items: center; padding: 20px; }");
				out.println(
						".container { background: white; border-radius: 15px; padding: 35px; max-width: 400px; width: 100%; text-align: center; }");
				out.println(
						".error { color: red; background: #ffebee; padding: 15px; border-radius: 8px; margin: 20px 0; }");
				out.println(
						".btn { display: inline-block; padding: 10px 20px; background: #3498db; color: white; text-decoration: none; border-radius: 5px; }");
				out.println("</style>");
				out.println("</head><body>");
				out.println("<div class='container'>");
				out.println("<div class='error'>Invalid email or password!</div>");
				out.println("<a href='studentLogin.html' class='btn'>Try Again</a>");
				out.println("</div></body></html>");
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import in.jatindb.util.DB_Connection;

public class StudentRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Tells browser that we are sending HTML content
		response.setContentType("text/html");
		// Creates a writer object that can send text to browser
		PrintWriter out = response.getWriter();

		// out.println() will write to browser page
		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Student Registration</title>");
		out.println("<style>");
		out.println(
				"body { font-family: Arial; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; display: flex; justify-content: center; align-items: center; padding: 20px; }");
		out.println(
				".container { background: white; border-radius: 15px; padding: 35px; max-width: 500px; width: 100%; box-shadow: 0 20px 40px rgba(0,0,0,0.1); text-align: center; }");
		out.println("h2 { color: #2c3e50; margin-bottom: 25px; }");
		out.println(
				"input { width: 100%; padding: 12px; margin: 10px 0; border: 2px solid #e0e0e0; border-radius: 8px; }");
		out.println(
				"button { width: 100%; padding: 12px; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; border: none; border-radius: 8px; cursor: pointer; font-size: 16px; }");
		out.println(
				".success { color: green; background: #d4edda; padding: 15px; border-radius: 8px; margin: 20px 0; }");
		out.println(".error { color: red; background: #f8d7da; padding: 15px; border-radius: 8px; margin: 20px 0; }");
		out.println(
				".btn { display: inline-block; padding: 10px 20px; background: #3498db; color: white; text-decoration: none; border-radius: 5px; margin-top: 15px; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");

		try {
			// Validate inputs
			if (name == null || name.trim().isEmpty() || age == null || age.trim().isEmpty() || address == null
					|| address.trim().isEmpty() || email == null || email.trim().isEmpty() || password == null
					|| password.trim().isEmpty()) {

				out.println("<div class='error'>All fields are required!</div>");
				out.println("<a href='studentRegister.html' class='btn'>Try Again</a>");
				out.println("</div></body></html>");
				return;
			}

			Connection con = DB_Connection.getConnection();

			// Check if email already exists
			PreparedStatement checkPs = con.prepareStatement("SELECT * FROM student WHERE email = ?");
			checkPs.setString(1, email);

			// executeQuery() → Runs SELECT query
			ResultSet rs = checkPs.executeQuery();

			if (rs.next()) {
				out.println("<div class='error'>Email already registered! Please use different email.</div>");
				out.println("<a href='studentRegister.html' class='btn'>Try Again</a>");
				out.println("</div></body></html>");
				return;
			}
			rs.close();
			checkPs.close();

			// Insert new student
			String sql = "INSERT INTO student(sname, sage, saddress, email, password, role) VALUES(?, ?, ?, ?, ?, 'student')";

			// RETURN_GENERATED_KEYS → Asks MySQL to return auto-generated ID
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setInt(2, Integer.parseInt(age));
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setString(5, password);

			// executeUpdate() → Runs INSERT/UPDATE/DELETE queries
			int rows = ps.executeUpdate();

			if (rows == 1) {
				ResultSet generatedKeys = ps.getGeneratedKeys();
				int id = 0;
				if (generatedKeys.next())
					id = generatedKeys.getInt(1);

				out.println("<div class='success'>");
				out.println("<h3>Registration Successful!</h3>");
				out.println("<p>Your Student ID: " + id + "</p>");
				out.println("<p>Email: " + email + "</p>");
				out.println("<p>Please login to access your profile.</p>");
				out.println("</div>");
				out.println("<a href='studentLogin.html' class='btn'>Login Now</a>");
			} else {
				out.println("<div class='error'>Registration failed. Please try again.</div>");
				out.println("<a href='studentRegister.html' class='btn'>Try Again</a>");
			}

			ps.close();
			con.close();

		} catch (NumberFormatException e) {
			out.println("<div class='error'>Invalid age format!</div>");
			out.println("<a href='studentRegister.html' class='btn'>Try Again</a>");
		} catch (Exception e) {
			out.println("<div class='error'>Error: " + e.getMessage() + "</div>");
			e.printStackTrace();
		}

		out.println("</div></body></html>");
	}
}
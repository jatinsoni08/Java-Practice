package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import in.jatindb.util.DB_Connection;

public class AddStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Add Student</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; background:#f4f6f9; text-align:center; padding:50px; }");
		out.println(
				".container { background:white; max-width:500px; margin:auto; padding:30px; border-radius:8px; box-shadow:0 2px 8px rgba(0,0,0,0.1); }");
		out.println(".success { color:green; background:#e8f5e9; padding:15px; border-radius:4px; }");
		out.println(".error { color:red; background:#ffebee; padding:15px; border-radius:4px; }");
		out.println(
				".btn { display:inline-block; padding:10px 20px; background:#3498db; color:white; text-decoration:none; border-radius:4px; margin-top:20px; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");

		try {
			if (name == null || name.trim().isEmpty() || age == null || age.trim().isEmpty() || address == null
					|| address.trim().isEmpty()) {
				out.println("<div class='error'>All fields are required!</div>");
				out.println("<a href='index.html' class='btn'>Back to Form</a>");
				out.println("</div></body></html>");
				return;
			}

			Connection con = DB_Connection.getConnection();
			String sql = "INSERT INTO student(sname, sage, saddress) VALUES(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setInt(2, Integer.parseInt(age));
			ps.setString(3, address);

			int rows = ps.executeUpdate();

			if (rows == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				int id = 0;
				if (rs.next())
					id = rs.getInt(1);
				out.println("<div class='success'>Student added successfully!<br>Student ID: " + id + "</div>");
			} else {
				out.println("<div class='error'>Failed to add student. Please try again.</div>");
			}
			ps.close();
			con.close();
		} catch (NumberFormatException e) {
			out.println("<div class='error'>Invalid age format.</div>");
		} catch (Exception e) {
			out.println("<div class='error'>Database error: " + e.getMessage() + "</div>");
		}

		out.println("<a href='index.html' class='btn'>Back to Home</a>");
		out.println("</div></body></html>");
	}

}
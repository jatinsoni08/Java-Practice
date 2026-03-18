package com.jatin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Accept the Data
		String userName = request.getParameter("uname");
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		String userCity = request.getParameter("ucity");

		// JDBC Variables
		String url = "jdbc:mysql://localhost:3306/java100";
		String username = "root";
		String password = "jatinsoni";

		// JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, username, password);

			PreparedStatement pstmt = con.prepareStatement(
					"Insert into personinformation(uname, email, upassword, ucity) VALUES (?, ?, ?, ?)");

			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userPassword);
			pstmt.setString(4, userCity);


			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected != 0) {
			    response.sendRedirect("success.html");
			} else {
			    response.sendRedirect("error.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

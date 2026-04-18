package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import in.jatintech.service.RStudentService;
import in.jatintech.servicefactory.StudentServiceFactory;

public class DeleteStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Delete Student</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; background:#f4f6f9; text-align:center; padding:50px; }");
		out.println(".container { background:white; max-width:500px; margin:auto; padding:30px; border-radius:8px; }");
		out.println(".success { color:green; background:#e8f5e9; padding:15px; border-radius:4px; }");
		out.println(".error { color:red; background:#ffebee; padding:15px; border-radius:4px; }");
		out.println(
				".btn { display:inline-block; padding:10px 20px; background:#3498db; color:white; text-decoration:none; border-radius:4px; margin-top:20px; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<div class='container'>");

		try {
			if (sid == null || sid.trim().isEmpty()) {
				out.println("<div class='error'>Student ID is required.</div>");
				out.println("<a href='index.html' class='btn'>Back to Home</a>");
				out.println("</div></body></html>");
				return;
			}

			RStudentService service = StudentServiceFactory.getStudentService();
			String status = service.deleteStudent(Integer.parseInt(sid));

			if (status.equalsIgnoreCase("success")) {
				out.println("<div class='success'>Student deleted successfully.</div>");
			} else {
				out.println("<div class='error'>Delete failed. Student not found.</div>");
			}
		} catch (NumberFormatException e) {
			out.println("<div class='error'>Invalid ID format.</div>");
		} catch (Exception e) {
			out.println("<div class='error'>Database error: " + e.getMessage() + "</div>");
			e.printStackTrace();
		}

		out.println("<a href='index.html' class='btn'>Back to Home</a>");
		out.println("</div></body></html>");
	}
}
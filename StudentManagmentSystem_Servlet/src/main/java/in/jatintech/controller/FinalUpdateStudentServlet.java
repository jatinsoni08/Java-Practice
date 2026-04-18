package in.jatintech.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import in.jatintech.service.RStudentService;
import in.jatintech.servicefactory.StudentServiceFactory;

public class FinalUpdateStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Update Status</title>");
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
			RStudentService service = StudentServiceFactory.getStudentService();
			String status = service.updateStudent(Integer.parseInt(sid), name, Integer.parseInt(age), address);

			if (status.equalsIgnoreCase("success")) {
				out.println("<div class='success'>Student updated successfully.</div>");
			} else {
				out.println("<div class='error'>Update failed. Student may not exist.</div>");
			}
		} catch (Exception e) {
			out.println("<div class='error'>Error: " + e.getMessage() + "</div>");
			e.printStackTrace();
		}

		out.println("<a href='index.html' class='btn'>Back to Home</a>");
		out.println("</div></body></html>");
	}
}
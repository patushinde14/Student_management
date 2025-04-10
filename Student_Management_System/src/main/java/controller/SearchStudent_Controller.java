package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AddStudent_bo;
import dao.Admin_dao;

/**
 * Servlet implementation class SearchStudent_Controller
 */
@WebServlet("/SearchStudent_Controller")
public class SearchStudent_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStudent_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String std = request.getParameter("std");
		String name = request.getParameter("name");

		List<AddStudent_bo> list = Admin_dao.search(std, name);

		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>Search Results</title>");
		pw.print("<style>");

		pw.print("body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px; }");
		pw.print("h1 { color: #333; text-align: center; }");
		pw.print("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
		pw.print("th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }");
		pw.print("th { background-color: #4CAF50; color: white; }");
		pw.print("tr:nth-child(even) { background-color: #f2f2f2; }");
		pw.print("tr:hover { background-color: #ddd; }");
		pw.print("h3 { color: #555; text-align: center; }");

		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");


		pw.print("<h1>Search Results</h1>");
		pw.print("<table>");
		pw.print("<tr><th>ID</th><th>Name</th><th>Age</th><th>Standard</th><th>Address</th></tr>");

		for (AddStudent_bo asb : list) {
			pw.print("<tr>");
			pw.print("<td>" + asb.getId() + "</td>");
			pw.print("<td>" + asb.getName() + "</td>");
			pw.print("<td>" + asb.getAge() + "</td>");
			pw.print("<td>" + asb.getStd() + "</td>");
			pw.print("<td>" + asb.getAddress() + "</td>");
			pw.print("</tr>");
		}

		pw.print("</table>");
	}

}


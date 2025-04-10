package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AddStudent_bo;
import dao.Admin_dao;

/**
 * Servlet implementation class AddStudent_Controller
 */
@WebServlet("/AddStudent_Controller")
public class AddStudent_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html") ;
        PrintWriter pw=response.getWriter();
        
       String name= request.getParameter("name");
       String age=request.getParameter("age");
       String std=request.getParameter("std");
       String address=request.getParameter("address");
       
       AddStudent_bo asb=new AddStudent_bo();
       
       asb.setName(name);
       asb.setAge(age);
       asb.setStd(std);
       asb.setAddress(address);
       
       int status=Admin_dao.addStudent(asb);
       if(status>0) {
    	   pw.write("data inserted");
    	   RequestDispatcher re=request.getRequestDispatcher("home.html");
           re.include(request,response);
    	   
       }
       else
       {
       	pw.write("something went wrong");
       	RequestDispatcher re=request.getRequestDispatcher("AddStudent.html");
       	re.include(request,response);
       }
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AddStudent_bo;
import dao.Admin_dao;

/**
 * Servlet implementation class Update_Controller
 */
@WebServlet("/Update_Controller")
public class Update_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html") ;
         PrintWriter pw=response.getWriter();
         
        int id=Integer.parseInt(request.getParameter("id"));
        
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String std=request.getParameter("std");
        String address=request.getParameter("address");
        
        AddStudent_bo asb=new AddStudent_bo();
        
        asb.setId(id);
        asb.setName(name);
        asb.setAge(age);
        asb.setStd(std);
        asb.setAddress(address);
        
        int status=Admin_dao.update(asb);
        
        if (status > 0) {
//            pw.print("<div style='text-align:center; margin-top:20px; font-family:Arial, sans-serif; color:green;'>Update Successful!</div>");
//            pw.print("<a href='home.html' style='display:block; text-align:center; margin-top:15px; text-decoration:none; padding:10px 20px; background-color:#007BFF; color:white; border-radius:4px;'>Back to Home</a>");
        	  response.sendRedirect("SeeAllStrudent_Controller");

        } else {
            pw.print("<div style='text-align:center; margin-top:20px; font-family:Arial, sans-serif; color:red;'>Something went wrong. Please try again!</div>");
               }
        
        
        
	}

}

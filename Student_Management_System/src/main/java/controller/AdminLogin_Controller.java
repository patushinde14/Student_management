package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Admin_dao;

/**
 * Servlet implementation class AdminLogin_Controller
 */
@WebServlet("/AdminLogin_Controller")
public class AdminLogin_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html") ;
         PrintWriter pw=response.getWriter();
         
        String email= request.getParameter("username");
        String pass= request.getParameter("password");
        
        if(Admin_dao.Adminlogin(email, pass))
        {
        	pw.write("login successfully");
        	RequestDispatcher re=request.getRequestDispatcher("home.html");
        	re.include(request,response);
        	
        }
        else
        {
        	pw.write("username or password is wrong");
        	RequestDispatcher re=request.getRequestDispatcher("Login.html");
        	re.include(request,response);       
        }
	}

}

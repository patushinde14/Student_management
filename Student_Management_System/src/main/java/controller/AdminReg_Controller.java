package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Admin_bo;
import dao.Admin_dao;

/**
 * Servlet implementation class AdminReg_Controller
 */
@WebServlet("/AdminReg_Controller")
public class AdminReg_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReg_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Admin_bo ab=new Admin_bo();
		ab.setName(name);
		ab.setPhone(phone);
		ab.setEmail(email);
		ab.setPassword(password);
		
		int status=Admin_dao.Registration(ab);
		
		if(status>0) {
			pw.write("registration is done");
			RequestDispatcher re=request.getRequestDispatcher("Login.html");
	       	re.include(request,response);
		}
		else {
			pw.write("kahitri gadbad hai baba");
		}

		}
	}


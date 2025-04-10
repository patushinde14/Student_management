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
 * Servlet implementation class EditStudent_Controller
 */
@WebServlet("/EditStudent_Controller")
public class EditStudent_Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String id = request.getParameter("id");
        int sid = Integer.parseInt(id);

        AddStudent_bo asb = Admin_dao.getStudentbyId(sid);

        pw.print("<!DOCTYPE html>");
        pw.print("<html>");
        pw.print("<head>");
        pw.print("<title>Edit Student</title>");
        pw.print("<style>");
        pw.print("form { max-width: 400px; margin: 0 auto; font-family: Arial, sans-serif; }");
        pw.print("input[type='text'], textarea { width: 100%; padding: 8px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px; }");
        pw.print("input[type='submit'] { padding: 10px 15px; background-color: #007BFF; color: white; border: none; border-radius: 4px; cursor: pointer; }");
        pw.print("input[type='submit']:hover { background-color: #0056b3; }");
        pw.print("</style>");
        pw.print("</head>");
        pw.print("<body>");
        pw.print("<h1 style='text-align: center;'>Edit Student</h1>");
        pw.print("<form action='Update_Controller' method='post'>");

        pw.print("<input type='hidden' name='id' value='" + asb.getId() + "' />");

        pw.print("<label for='name'>Name:</label>");
        pw.print("<input type='text' id='name' name='name' value='" + asb.getName() + "' required />");
        	

        pw.print("<label for='age'>Age:</label>");
        pw.print("<input type='text' id='age' name='age' value='" + asb.getAge() + "' required />");

        pw.print("<label for='std'>Standard (Std):</label>");
        pw.print("<input type='text' id='std' name='std' value='" + asb.getStd() + "' required />");

        
        pw.print("<label for='address'>Address:</label>");
        pw.print("<textarea id='address' name='address' rows='4' required>" + asb.getAddress() + "</textarea>");

        pw.print("<input type='submit' value='Update' />");
        pw.print("</form>");
        pw.print("</body>");
        pw.print("</html>");
    }
}

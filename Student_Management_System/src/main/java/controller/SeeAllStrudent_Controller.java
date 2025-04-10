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
 * Servlet implementation class SeeAllStrudent_Controller
 */
@WebServlet("/SeeAllStrudent_Controller")
public class SeeAllStrudent_Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SeeAllStrudent_Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.print("<!DOCTYPE html>");
        pw.print("<html>");
        pw.print("<head>");
        pw.print("<title>Student List</title>");
        pw.print("</head>");
        pw.print("<body style='font-family: Arial, sans-serif; margin: 20px;'>");

        // Back Button
        pw.print("<a href='home.html' style='text-decoration: none; padding: 8px 15px; background-color: #007BFF; color: white; border-radius: 4px; font-weight: bold; display: inline-block; margin-bottom: 15px;'>Back</a>");

        // Table Header
        pw.print("<h1 style='text-align: center;'>Student List</h1>");
        pw.print("<table style='width: 100%; border-collapse: collapse; margin-top: 15px;'>");
        pw.print("<tr style='background-color: #f2f2f2;'>");
        pw.print("<th style='border: 1px solid #ddd; padding: 12px; text-align: center;'>ID</th>");
        pw.print("<th style='border: 1px solid #ddd; padding: 12px; text-align: center;'>NAME</th>");
        pw.print("<th style='border: 1px solid #ddd; padding: 12px; text-align: center;'>AGE</th>");
        pw.print("<th style='border: 1px solid #ddd; padding: 12px; text-align: center;'>STD</th>");
        pw.print("<th style='border: 1px solid #ddd; padding: 12px; text-align: center;'>ADDRESS</th>");
        pw.print("<th style='border: 1px solid #ddd; padding: 12px; text-align: center;'>EDIT ACTION</th>");
        pw.print("<th style='border: 1px solid #ddd; padding: 12px; text-align: center;'>DELETE ACTION</th>");
        pw.print("</tr>");

        List<AddStudent_bo> studentList = Admin_dao.getAllStudent();
        for (AddStudent_bo student : studentList) {
            pw.print("<tr style='background-color: #f9f9f9;'>");
            pw.print("<td style='border: 1px solid #ddd; padding: 12px; text-align: center;'>" + student.getId() + "</td>");
            pw.print("<td style='border: 1px solid #ddd; padding: 12px; text-align: center;'>" + student.getName() + "</td>");
            pw.print("<td style='border: 1px solid #ddd; padding: 12px; text-align: center;'>" + student.getAge() + "</td>");
            pw.print("<td style='border: 1px solid #ddd; padding: 12px; text-align: center;'>" + student.getStd() + "</td>");
            pw.print("<td style='border: 1px solid #ddd; padding: 12px; text-align: center;'>" + student.getAddress() + "</td>");
            pw.print("<td style='border: 1px solid #ddd; padding: 12px; text-align: center; vertical-align: middle;'>"
                    + "<a href='EditStudent_Controller?id=" + student.getId() + "' style='text-decoration: none; padding: 5px 10px; background-color: #28a745; color: white; border-radius: 4px;'>Edit</a>"
                    + "</td>");
           pw.print("<td style='border: 1px solid #ddd; padding: 12px; text-align: center; vertical-align: middle;'>"
                    + "<a href='DeleteStudent_Controller?id=" + student.getId() + "' style='text-decoration: none; padding: 5px 10px; background-color: #dc3545; color: white; border-radius: 4px;'>Delete</a>"
                    + "</td>");
        }

        pw.print("</table>");
       
    }
}

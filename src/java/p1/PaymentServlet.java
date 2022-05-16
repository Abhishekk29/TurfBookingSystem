/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TechNorider
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String cardno = request.getParameter("cno");
        String cvv = request.getParameter("cvv");
        String name = request.getParameter("n1");
        PreparedStatement stmt;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");
            String sql="select * from carddetails";
           stmt=con.prepareStatement(sql);
          
           
           
        if (name.equals("name")) {
            stmt.executeQuery();
            out.println("booked successfully!");
        }else{
                out.println("<p style='text-align: center;background-color: white;color: red;font-family: Nunito Sans;font-size:20px;font-weight: bold;'>login failed!!<br>Check your username or password again!</p>");
                request.getRequestDispatcher("cardpayment.html").include(request, response); 
            }
            out.println("<h1>Booked Successfully!!</h1>");
      
        }
            

        catch (Exception e) {
            out.println("<strong>error!!</strong> " + e.getMessage());

        }


    }
}

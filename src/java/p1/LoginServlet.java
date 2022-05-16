package p1;

import java.io.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("t1");
        String pwd = request.getParameter("t2");
    
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select uname,password from signup where uname='"+uname+"'and password='"+pwd+"'");
            if(rs.next()){
            HttpSession session=request.getSession();
            session.setAttribute("uname", uname);
            response.sendRedirect("booking1.html");
        }else{
                out.println("<p style='text-align: center;background-color: white;color: red;font-family: Nunito Sans;font-size:20px;font-weight: bold;'>login failed!!<br>Check your username or password again!</p>");
                request.getRequestDispatcher("index.html").include(request, response); 
            }
   
  

        } catch (Exception e) {
            out.println("error " + e.getMessage());
        }

    }

}

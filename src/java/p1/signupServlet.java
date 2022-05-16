package p1;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
@WebServlet(name = "signupServlet", urlPatterns = {"/signupServlet"})
public class signupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       String uname =request.getParameter("u1");
       String password =request.getParameter("p1");
       String Cpwd =request.getParameter("p2");
       PreparedStatement stmt;
  
       try{
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb","root","root");
           
           String sql="insert into signup values(?,?,?)";
           stmt=con.prepareStatement(sql);
           stmt.setString(1, uname);
           stmt.setString(2, password);
           stmt.setString(3, Cpwd);
           
           
        if (password.equals(Cpwd)) {
            stmt.executeUpdate();
            out.println("<p style='text-align: center;background-color: white;color: MediumSeaGreen;font-family: Nunito Sans;font-size:25px;font-weight: bold;'>SignUp Successfull!</p>");
                request.getRequestDispatcher("index.html").include(request, response); 
        }else{
            out.println("<p style='text-align: center; background-color: white;color: red;font-family: 'Nunito Sans';font-size:800px;font-weight: bold;'>SignUp failed!!<br>Check your password again!</p>");
                request.getRequestDispatcher("index.html").include(request, response); 
        }
          
       }   catch (Exception e){
           out.println("<strong>Error:Change Your Username </strong>"+e.getMessage());
       }
       
    }

   

}

package p1;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
     
        String fullname = request.getParameter("t2");
        String email = request.getParameter("t4");
        String mobno = request.getParameter("t5");
        String date = request.getParameter("dt"); 
          
        booking e=new booking();  
        e.setFullname(fullname);  
        e.setEmail(email);  
        e.setMobno(mobno);  
        e.setDate(date);    
          
        int status=BookingServlet.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}
	
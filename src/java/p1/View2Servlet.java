package p1;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;   
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import p1.Turf2BookingServlet;
import p1.booking2;
@WebServlet("/View2Servlet")  
public class View2Servlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='booking1.html'>back</a>"); 
        out.println("<html><body style='background-color:skyblue;'>");
        out.println("<h1>Booking List</h1>");          
        List<booking2> list=Turf2BookingServlet.getBookingByPk();  
          
        out.print("<table border='1' width='100%' style='background-color:orange;'");  
        out.print("<tr><th>Fullname</th><th>Email</th><th>Mobile no</th><th>Date</th><th>Turf</th><th>Starting Time</th><th>End Time</th><th>Amount</th><th>Payment</th></tr>");  
        for(booking2 e:list){  
         out.print("<tr><td>"+e.getFullname()+"</td><td>"+e.getEmail()+"</td><td>"+e.getMobno()+"</td><td>"+e.getDate()+"</td><td>"+e.getTurf()+"</td><td>"+e.getTime()+"</td><td>"+e.getTo_time()+"</td><td>"+e.getAmount()+"</td><td>"+e.getPayment()+"</td>");  
        }  
        out.print("</table>");  
         out.println("</html></body>"); 
        out.close();  
    }  
}  
	
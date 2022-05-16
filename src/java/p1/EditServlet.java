package p1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Update Booking</h1>");
        String date = request.getParameter("dt");
        String time = request.getParameter("Time");
        String to_time = request.getParameter("Time2");
        

        booking e = BookingServlet.getBookingByPk(date,time,to_time);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td>Name:</td><td><input type='text' name='t2' value='" + e.getFullname() + "'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='t4' value='" + e.getEmail() + "'/></td></tr>");
        out.print("<tr><td>Mobno:</td><td><input type='text' name='t5' value='" + e.getMobno() +"'/></td></tr>");
        out.print("<tr><td>Date:</td><td><input type='date' name='dt' value='" + e.getDate() +"'/></td></tr>");      
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}

package p1;
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet {  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String date = request.getParameter("dt");
        String time = request.getParameter("Time");
        String to_time = request.getParameter("Time2");

        BookingServlet.delete(date,time,to_time);
        response.sendRedirect("ViewServlet");  
    }  
}
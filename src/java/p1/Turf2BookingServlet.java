package p1;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Turf2BookingServlet", urlPatterns = {"/Turf2BookingServlet"})
public class Turf2BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("t1");
        String fullname = request.getParameter("t2");
        String email = request.getParameter("t4");
        String mobno = request.getParameter("t5");
        String date = request.getParameter("dt");
        String turf = request.getParameter("turf1");
        String time = request.getParameter("Time");
        String to_time = request.getParameter("Time2");
        String amount = request.getParameter("tot_amount");
        String payment = request.getParameter("payment");
        String tnc = request.getParameter("tnc");      
       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");
           
            PreparedStatement ps = con.prepareStatement("insert into T2BOOKINGDETAILS values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, uname);
            ps.setString(2, fullname);
            ps.setString(3, email);
            ps.setString(4, mobno);
            ps.setString(5, date);
            ps.setString(6, turf);
            ps.setString(7, time);
            ps.setString(8, to_time);
            ps.setString(9, amount);
            ps.setString(10, payment);
            ps.setString(11, tnc);
            
            
            
            if (payment.equals("Cash")||payment.equals("Card")) {             
            ps.executeUpdate();
            out.println("<h1>Booked Successfully!!</h1>");
            out.println("<html>\n"
                    + "  <head>\n"
                    + "    <link href=\"https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap\" rel=\"stylesheet\">\n"
                    + "  </head>\n"
                    + "    <style>\n"
                    + "      body {\n"
                    + "        text-align: center;\n"
                    + "        padding: 40px 0;\n"
                    + "        background: #EBF0F5;\n"
                    + "      }\n"
                    + "        h1 {\n"
                    + "          color: #88B04B;\n"
                    + "          font-family: \"Nunito Sans\", \"Helvetica Neue\", sans-serif;\n"
                    + "          font-weight: 900;\n"
                    + "          font-size: 40px;\n"
                    + "          margin-bottom: 10px;\n"
                    + "        }\n"
                    + "        p1 {\n"
                    + "          color: #88B04B;\n"
                    + "          font-family: \"Nunito Sans\", \"Helvetica Neue\", sans-serif;\n"
                    + "          font-weight: 300;\n"
                    + "          font-size: 20px;\n"
                    + "          margin-bottom: 10px;\n"
                    + "        }\n"
                    + "        p {\n"
                    + "          color: #404F5E;\n"
                    + "          font-family: \"Nunito Sans\", \"Helvetica Neue\", sans-serif;\n"
                    + "          font-size:20px;\n"
                    + "          margin: 0;\n"
                    + "        }\n"
                    + "      i {\n"
                    + "        color: #9ABC66;\n"
                    + "        font-size: 100px;\n"
                    + "        line-height: 200px;\n"
                    + "        margin-left:-15px;\n"
                    + "      }\n"
                    + "      .card {\n"
                    + "        background: white;\n"
                    + "        padding: 60px;\n"
                    + "        border-radius: 4px;\n"
                    + "        box-shadow: 0 2px 3px #C8D0D8;\n"
                    + "        display: inline-block;\n"
                    + "        margin: 0 auto;\n"
                    + "      }\n"
                    + "    </style>\n"
                    + "    <body>\n"
                    + "      <div class=\"card\">\n"
                    + "      <div style=\"border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;\">\n"
                    + "        <i class=\"checkmark\">&#10004;</i>\n"
                    + "      </div>\n"
                    + "        <h1>Success</h1> \n"
                    + "        <p>We received your Booking request;<br/> you'll be notified shortly!</p>\n"
                    + "      </div>\n"
                    + "    </body>\n"
                    + "</html><br>");
            out.println("<html><h1>Booking details</h1>");
            out.println("<p1>Username: " + uname +"</p1>" + "<br/>");
            out.println("<p1>Fullname: " + fullname +"</p1>" + "<br/>");
            out.println("<p1>Email: " + email +"</p1>" + "<br/>");
            out.println("<p1>Mob no: " + mobno +"</p1>" + "<br/>");
            out.println("<p1>Date: " + date +"</p1>" + "<br/>");
            out.println("<p1>Turf name: " + turf +"</p1>" + "<br/>");
            out.println("<p1>Timing: " + time + " " + to_time +"</p1>" + "<br/>");
            out.println("<p1>Amount: " + amount + "</p1>" +"<br/>");
            out.println("<p1>Payment mode: " + payment + "</p1>" + "<br/>");
            out.println("</html>");

            out.println("<a href='LogoutServlet'>Logout</a>"+"  ");
            out.println("<a href='booking1.html'>Book again</a>");
            
            }
        }
    

         catch (Exception e) {
          
            out.println("<strong>error!!</strong> " + e.getMessage());
        
          }
        }
      public static int update(booking e){  
        int status=0;  
        try{  
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");  
            PreparedStatement ps=con.prepareStatement("update t2bookingdetails set fullname=?,email=?,mobno=? where date=? and time=? and to_time=?");  
          
           
            ps.setString(2, e.getFullname());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getMobno());
            ps.setString(5, e.getDate());
            ps.setString(7, e.getTime());
            ps.setString(8, e.getTo_time());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
        public static int delete(String date,String time,String to_time){ 
        int status=0;
        try{             
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");  
            PreparedStatement ps=con.prepareStatement("delete * from t2bookingdetails where date=? and time=? and to_time=?");
            ps.setString(5,date);
            ps.setString(7,time);
            ps.setString(8,to_time);
            
          
            status=ps.executeUpdate();  
                         
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
        public static booking2 getBookingByPk(String date,String time,String to_time){  
        booking2 e=new booking2();  
          
        try{  
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");  
            PreparedStatement ps=con.prepareStatement("select * from ROOT.T2BOOKINGDETAILS where date=? and time=? and to_time=?");  
            ps.setString(5,date); 
            ps.setString(7,time);
            ps.setString(8,to_time);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){    
                e.setUname(rs.getString(1)); 
                e.setFullname(rs.getString(2)); 
                e.setEmail(rs.getString(3)); 
                e.setMobno(rs.getString(4)); 
                e.setDate(rs.getString(5)); 
                e.setTurf(rs.getString(6)); 
                e.setTime(rs.getString(7)); 
                e.setTo_time(rs.getString(8)); 
                e.setAmount(rs.getString(9)); 
                e.setPayment(rs.getString(10)); 
                e.setTnc(rs.getString(11)); 
                
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
         public static List<booking2> getBookingByPk(){  
        List<booking2> list=new ArrayList<booking2>();  
          
        try{  
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ejdb", "root", "root");  
            PreparedStatement ps=con.prepareStatement("select * from t2bookingdetails");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                booking2 e=new booking2();  
                e.setUname(rs.getString(1)); 
                e.setFullname(rs.getString(2)); 
                e.setEmail(rs.getString(3)); 
                e.setMobno(rs.getString(4)); 
                e.setDate(rs.getString(5)); 
                e.setTurf(rs.getString(6)); 
                e.setTime(rs.getString(7)); 
                e.setTo_time(rs.getString(8)); 
                e.setAmount(rs.getString(9)); 
                e.setPayment(rs.getString(10)); 
                e.setTnc(rs.getString(11)); 
                 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
  

}}



import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class MarkServlet extends HttpServlet
{
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
{
String SeatNum,Name;
String ans1,ans2,ans3,ans4,ans5;
int a1,a2,a3,a4,a5;
a1=a2=a3=a4=a5=0;
PrintWriter out=response.getWriter();

SeatNum = request.getParameter("Seat_no");
Name = request.getParameter("Name");
ans1 =request.getParameter("group1");
if(ans1.equals("True"))
a1=2;
else
a1=0;
ans2 = request.getParameter("group2");
if(ans2.equals("False"))
a2=2;
else
a2=0;
ans3 = request.getParameter("group3");
if(ans3.equals("False"))
a3=2;
else
a3=0;
ans4 = request.getParameter("group4");
if(ans4.equals("True"))
a4=2;
else
a4=0;
ans5 = request.getParameter("group5");
if(ans5.equals("False"))
a5=2;
else
a5=0;

int Total=a1+a2+a3+a4+a5;

Connection connect=null;
Statement stmt=null;
ResultSet rs=null;
   try {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            } catch (ClassNotFoundException ex) {
                
            }
                connect = DriverManager.getConnection("jdbc:odbc:EQuiz","2cs244","2cs244");
        
stmt = connect.createStatement();
String query = "INSERT INTO student_entry VALUES (" +SeatNum + ", '" + Name + "', "+Total+ ")";
int result = stmt.executeUpdate(query);

query = "SELECT * FROM student_entry";
rs = stmt.executeQuery(query);

out.println("<html><head><title>Student Mark List</title></head>");
out.println("<body bgcolor=khaki>");
out.println("<center>");
out.println("<h2>Students Marksheet</h2>");
out.println("<h3>Name of the College:PANIMALAR INSTITUTE OF TECHNOLOGY</h3>");
out.println("<table border='1' cellspacing='0' cellpadding='0'>");
out.println("<tr>");
out.println("<td><b>Seat_No</b></td>");
out.println("<td><b>Name</b></td>");
out.println("<td><b>Marks</b></td>");
out.println("</tr>");
while(rs.next())
{
out.println("<tr>");
out.println("<td>"+rs.getInt(1)+"</td>");
out.println("<td>"+rs.getString(2)+"</td>");
out.println("<td>"+rs.getInt(3)+"</td>");
out.println("</tr>");
}
out.println("</table></center>");
out.println("</body></html>");
rs.close();
stmt.close();
connect.close();
            }
       
            catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}

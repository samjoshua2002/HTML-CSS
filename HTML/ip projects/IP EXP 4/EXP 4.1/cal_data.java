import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "cal_data", urlPatterns = {"/cal_data"})

public class cal_data extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        String name=req.getParameter("uname");
        int mark1=Integer.parseInt(req.getParameter("m1"));
        int mark2=Integer.parseInt(req.getParameter("m2"));
        int mark3=Integer.parseInt(req.getParameter("m3"));
        int total=mark1+mark2+mark3;
        float avg=total/3;
        
        out.println("<html>");
        out.println("<table border='1'>");
        out.println("<tr><th> User Name: </th><td>"+name+"</td></tr>");
        out.println("<tr><th> Mark 1: </th><td>"+mark1+"</td></tr>");
        out.println("<tr><th> Mark 2: </th><td>"+mark2+"</td></tr>");
        out.println("<tr><th> Mark 3: </th><td>"+mark3+"</td></tr>");
        out.println("<tr><th> Total : </th><td>"+total+"</td></tr>");
        out.println("<tr><th> Average : </th><td>"+avg+"</td></tr>");
        out.println("</table>");
        out.println("</html>");
    }   
}

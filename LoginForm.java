import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.*;
public class Login extends HttpServlet{
  Connection conn;
  public void service(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
    ServletOutputStream.out = response.getOutputStreamI();
    String url ="jdbc.odbc.logindatabase";
    try{
      String login = request.getParameter("LoginId");
      String pass = request.getParameter("Password");
      Class.forName("user.jdbc.odbc.JdbcOdbcDriver");
      conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select * from loing wher loginname= '"+ login + " 'and password='" + pass +"' ");
      response.setContentType("text/index.html");
      response.setStatus(HttpServletResponse.SC_OK);
      if(rs.next()==false){
        out.println("<index.html><head><title>login check</title></head><body>");
         out.println("<br><br><br><br><br>");
        out.println("<center><br>Unknown user<br>");
        out.println("<h1>Accesss Denied Try Again</h1></center>");
        out.println("</body></html>");
      }
      else{
         out.println("<index.html><head><title>login check</title></head><body>");
         out.println("<br><br><br><br><br>");
        out.println("<center><br>Welcome " + " " + rs.getString("loginname") + "</br>
      }
    }
  }
}

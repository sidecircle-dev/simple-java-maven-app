// Reflecting the directory structure where the file lives
package org.example;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

@WebServlet(name = "CodePostalServlet", urlPatterns = {"/ville"})
public class CodePostalServlet extends HttpServlet {

    private final String url = "jdbc:postgresql://10.96.184.31/codepostal";
    private final String user = "codepostal";
    private final String password = "codepostal";
    private final String driver = "org.postgresql.Driver";

    Connection conn = null; 

    public void init() throws ServletException { 
  
        // Database connection through Driver Manager 
        try { 
            Class.forName(driver); 
            conn = DriverManager.getConnection(url, user, password); 
        } catch (ClassNotFoundException | SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
try { 
  
            // Set the response content type and  
            // get the PrintWriter object. 
            response.setContentType("text/html"); 
            PrintWriter out = response.getWriter(); 
  
            // Set up HTML table formatting for the output 
            out.println("<html><body>"); 
            out.println("<h3>CodePostal</h3>"); 
            out.println("<table border=1><tr>" + "<td><b>Code</b></td>" + "<td><b>Ville</b></td></tr>"); 
  
            // Create JDBC statement object, construct  
            // the SQL query and execute the query. 
            Statement stmt = conn.createStatement(); 
            String sql = "select * from codepostal where cp='14480';"; 
            ResultSet rs = stmt.executeQuery(sql); 
  
            // Loop through the result set to  
            // retrieve the individual data items. 
  
            while (rs.next()) { 
               
                String cp = rs.getString("cp"); 
                String ville = rs.getString("ville"); 
  
                out.println("<tr>" + "<td>" + cp + "</td>" + "<td>" + ville + "</td></tr>"); 
  
            } 
  
            out.println("</table></body></html>"); 
  
            // Close Result set, Statement 
            // and PrintWriter objects. 
            rs.close(); 
            stmt.close(); 
            out.close(); 
  
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
              
              
            
    }

    public void destroy() { 
  
        // Close connection object. 
        try { 
            conn.close(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
}

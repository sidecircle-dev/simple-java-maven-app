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

    private final String url = "jdbc:postgresql://localhost/codepostal";
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
        
                
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<!DOCTYPE html> <html lang=\"en\"><head><title>title</title></head><body><h2>codepostal-ville!</h2></body></html>");
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

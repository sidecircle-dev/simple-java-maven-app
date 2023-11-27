// Reflecting the directory structure where the file lives
package org.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet(name = "CodePostalServlet", urlPatterns = {"/ville"})
public class CodePostalServlet extends HttpServlet {

    private final String url = "jdbc:postgresql://localhost/codepostal";
    private final String user = "codepostal";
    private final String password = "codepostal";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<!DOCTYPE html> <html lang=\"en\"><head><title>title</title></head><body><h2>codepostal-ville!</h2></body></html>");
 }
}

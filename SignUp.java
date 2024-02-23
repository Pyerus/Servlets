package Servlets;


import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("newUsername");
        String password = request.getParameter("newPassword");

        ServletContext servletContext = getServletContext();
        HashMap<String, String> userAccount = (HashMap<String, String>) servletContext.getAttribute("userAccount");
        
        if (userAccount == null){
            userAccount = new HashMap<>();
        }
        
        if(userAccount.containsKey(username)){
            response.sendRedirect("error1.jsp");
            return; // Stop further processing
        }
        
        userAccount.put(username, password);
        
        servletContext.setAttribute("userAccount", userAccount);
        response.sendRedirect("user.jsp");
    }
}


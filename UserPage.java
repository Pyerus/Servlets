package Servlets;


import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class UserPage extends HttpServlet{
       String username;
       String password;
       
       @Override
       public void init(ServletConfig config) throws ServletException{
           super.init(config);
           username = getServletConfig().getInitParameter("username");
           password = getServletConfig().getInitParameter("password");
       }

       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                String tryUsername = request.getParameter("username");
                String tryPassword = request.getParameter("password");
                
                if (username.equals(tryUsername) && password.equals(tryPassword)) {
                response.sendRedirect("homepage_user.jsp");
                return;
                }
                
                if(checkUserPass(tryUsername, tryPassword)){
                    response.sendRedirect("homepage_user.jsp");
                }

                else{
                     response.sendRedirect("error1.jsp");
                }
 }
       
       
       private boolean checkUserPass (String username, String password){
           ServletContext servletContext = getServletContext();
           HashMap<String, String> userAccount = (HashMap<String, String>) servletContext.getAttribute("userAccount");
           
           if (userAccount != null && userAccount.containsKey(username) && userAccount.get(username).equals(password)) {
        return true;
    }
           String checkUsername = getServletConfig().getInitParameter("username");
           String checkPassword = getServletConfig().getInitParameter("password");
           
           return (checkUsername != null && checkPassword != null && checkUsername.equals(username) && checkPassword.equals(password));
       }
}



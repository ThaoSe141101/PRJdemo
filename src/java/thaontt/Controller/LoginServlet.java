/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaontt.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thaontt.DAO.RegistrationDAO;

/**
 *
 * @author Thao
 */
public class LoginServlet extends HttpServlet {
    private final String INVALID_PAGE = "invalid.html";
    private final String SEARCH_PAGE = "search.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //get parameters
        System.out.println("đay la servlet ");
        String button = request.getParameter("btAction");
        String url = INVALID_PAGE;
        
        try {
            if (button.equals("Login")){
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                // khi can moi lay
                
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.checkLogin(username, password);
                
                if(result){
                    url = SEARCH_PAGE;
                    // end of result
                }
            }// end if login is clecked
    }catch(SQLException ex){
        ex.printStackTrace();
    }catch(ClassNotFoundException ex){
        ex.printStackTrace();
    }
        finally{
            response.sendRedirect(url);
        out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.http.Cookie;


/**
 *
 * @author faycal
 */
@WebServlet(urlPatterns = {"/Create"})
public class Create extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static Vector  tabanimaux=new Vector();
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
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
       // processRequest(request, response);
      
      
         response.setContentType("text/html;charset=UTF-8");
         
         
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menagerie</title>");            
            out.println("</head>");
            out.println("<body>");
            switch(request.getParameter("type")){
            case "Chat" : tabanimaux.add(new Chat(request.getParameter("Nom")));out.println("<h1>l'animal "+ request.getParameter("type") +" nommé "+ request.getParameter("Nom") +" a été crée </h1>");break;
            case "Chien" : tabanimaux.add(new Chien(request.getParameter("Nom")));out.println("<h1>l'animal "+ request.getParameter("type") +" nommé "+ request.getParameter("Nom") +" a été crée </h1>");break;
            case "Oiseau" : tabanimaux.add(new Oiseau(request.getParameter("Nom")));out.println("<h1>l'animal "+ request.getParameter("type") +" nommé "+ request.getParameter("Nom") +" a été crée </h1>");break;
            }
             try{
                FileOutputStream fs = new FileOutputStream("tabanimaux.dat");//sérialisation
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(tabanimaux);
                os.close();
           }
            catch(FileNotFoundException e) {}
            catch(IOException e) {}
           // out.println("<h1>l'animal "+ request.getParameter("type") +" nommé "+ request.getParameter("Nom") +" a été crée </h1>");
            out.println("<form name=Liste action=Liste method=POST> <input type=submit value=Afficher la liste name=Liste/></form>");
            out.println("</body>");
            out.println("</html>");
        }
       
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

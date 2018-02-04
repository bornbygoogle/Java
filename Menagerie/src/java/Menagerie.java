/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bornbygoogle
 */
public class Menagerie extends HttpServlet {
    
    
    Vector tabanimal=new Vector();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Menagerie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Menagerie at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException 
    {
        int size = tabanimal.size();
        request.setAttribute("tablesize", tabanimal);
        request.getRequestDispatcher("afficheliste.jsp").forward(request, response);
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
            throws ServletException, IOException 
    {        
        String animaltype = request.getParameter("animaltype");
        String animalname = request.getParameter("animalname");
        switch(animaltype)
        {
            case "chien" : 
                tabanimal.add(new Chien(animalname));
                break;
            case "chat" : 
                tabanimal.add(new Chat(animalname));
                break;
            case "oiseau" : 
                tabanimal.add(new Oiseau(animalname));
                break;                
        }
        animalname = ((Animal)tabanimal.lastElement()).getNom();
        if (animalname!="") request.setAttribute("saved","alors");
        request.setAttribute("animalname", animalname);
        request.setAttribute("animaltype",animaltype);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

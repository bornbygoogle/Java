/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menagerie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bornbygoogle
 */
public class ControlServlet extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
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
        //processRequest(request, response);
        //response.sendRedirect("http://localhost:8080/ControlServlet");
        request.getRequestDispatcher("index.jsp").forward(request,response);
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
        //processRequest(request, response);
        AnimalBean animal = new AnimalBean();
        request.setAttribute("monbean", animal);
        switch(request.getParameter("action"))
        {
            case "Afficher" : 
                //AfficheBean affiche = new AfficheBean();
                //request.setAttribute("monbean", affiche);
            //request.getRequestDispatcher("index.jsp").forward(request,response);
                request.getRequestDispatcher("affiche.jsp").forward(request,response);
                break;
            case "Creer" :
                //CreateBean create = new CreateBean();
                animal.setName(request.getParameter("Nom"));
                animal.setType(request.getParameter("type"));
                animal.addAnimal();
                request.setAttribute("monbean", animal);
                request.getRequestDispatcher("creation.jsp").forward(request,response);
                break;
            default : 
                request.getRequestDispatcher("form.jsp").forward(request,response);
                break;
        }
        /*if (request.getParameter("action").equals("Afficher")) 
        {
            AfficheBean a = new AfficheBean();
            request.setAttribute("monbean", a);
            //request.getRequestDispatcher("index.jsp").forward(request,response);
            request.getRequestDispatcher("affiche.jsp").forward(request,response);
        }
        else if (request.getParameter("action").equals("Creer")) 
        {
            request.getRequestDispatcher("creation.jsp").forward(request,response);
        }*/
        
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

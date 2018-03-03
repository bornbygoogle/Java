/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author p0607615
 */
public class Controller extends HttpServlet {
    
    static Vector  tabclient=new Vector();

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
            out.println("<title>Servlet controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controller at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        request.getRequestDispatcher("form.jsp").forward(request, response);
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
        if (request.getParameter("action").equals("Recapituler")) 
        {
            if (request.getParameter("Nom").isEmpty() || request.getParameter("Prenom").isEmpty()) 
            {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } 
            else 
            {
            // Invoke FirstServlet's job here.
            /*try{
                FileInputStream fis = new FileInputStream("tabclient.dat");//désérialisation
                ObjectInputStream ois = new ObjectInputStream(fis);
                tabclient = (Vector) ois.readObject(); 
                ois.close();
            }
            catch(FileNotFoundException e) {}
            catch(IOException e) {} catch (ClassNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }*/
                request.setAttribute("Num", ((Client)tabclient.lastElement()).getNumplace());
                request.setAttribute("Nom", ((Client)tabclient.lastElement()).getNom());
                request.setAttribute("Prenom", ((Client)tabclient.lastElement()).getPrenom());
                request.setAttribute("Type", (((Client)tabclient.lastElement()).getClass()).getName());
                request.setAttribute("Prix", ((Client)tabclient.lastElement()).calculPrix());
                request.getRequestDispatcher("validation.jsp").forward(request, response);
            }
        } 
        else if (request.getParameter("action").equals("Calculer")) 
        {
            if (request.getParameter("Nom").isEmpty() || request.getParameter("Prenom").isEmpty()) 
            {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } 
            else 
            {
                // Invoke SecondServlet's job here.
                switch(request.getParameter("type"))
                {
                    case "Adulte" : tabclient.add(new Adulte(request.getParameter("Nom"),request.getParameter("Prenom")));break;
                    case "Enfant" : tabclient.add(new Enfant(request.getParameter("Nom"),request.getParameter("Prenom")));break;
                    case "Etudiant" : tabclient.add(new Etudiant(request.getParameter("Nom"),request.getParameter("Prenom")));break;
                }
                /*try{
                    FileOutputStream fs = new FileOutputStream("tabclient.dat");//sérialisation
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(tabclient);
                    os.close();
                    }
                catch(FileNotFoundException e) {}
                catch(IOException e) {}*/
                request.setAttribute("Nom", ((Client)tabclient.lastElement()).getNom());
                request.setAttribute("Prenom", ((Client)tabclient.lastElement()).getPrenom());
                request.setAttribute("Resultat", ((Client)tabclient.lastElement()).calculPrix());
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
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

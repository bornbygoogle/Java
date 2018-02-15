/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author faycal
 */
@WebServlet(urlPatterns = {"/Liste"})
public class Liste extends HttpServlet {

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
         response.setContentType("text/html;charset=UTF-8");
         
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menagerie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=1 cellpadding=10>");
            //out.println("<TD> nombre d'animaux "+Create.tabanimaux.size()+"</TD>");
            out.println("<TR><TH>NOM</TH>");
            out.println("<TH>TYPE</TH>");
            out.println("<TH>CRI</TH></TR>");
            try{
                FileInputStream fis = new FileInputStream("tabanimaux.dat");//désérialisation
                ObjectInputStream ois = new ObjectInputStream(fis);
                Create.tabanimaux = (Vector) ois.readObject(); 
                ois.close();
            }
            catch(FileNotFoundException e) {}
            catch(IOException e) {}
            catch (ClassNotFoundException ex) {
            Logger.getLogger(Liste.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i=0;i< Create.tabanimaux.size();i++)
            {
                //out.println("<TR><TD>"+Create.tabanimaux.elementAt(i)+"</TD></TR>");//utilise toString()
                out.println("<TR><TD>"+((Animal)Create.tabanimaux.elementAt(i)).nom+"</TD>");
                out.println("<TD>"+(Create.tabanimaux.elementAt(i).getClass()).getName()+"</TD>");
                out.println("<TD>"+((Animal)Create.tabanimaux.elementAt(i)).cri()+"</TD></TR>");
                
            }
            out.println("</table>");
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

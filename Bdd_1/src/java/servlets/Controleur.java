/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import beans.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author faycal
 */
public class Controleur extends HttpServlet {
    
    // Tableau tab;// un javabean
     Connection connexion;
     String erreur;
    public void init(){        
       try {
           Class.forName("org.apache.derby.jdbc.ClientDriver");
       }
       catch(ClassNotFoundException e){
           erreur=new String("Erreur lors du chargement du driver"+ e);
       }
       String serveur= "//localhost";
       String dbName = "sample";//sample
       int port = 1527;
       String derbyURL = "jdbc:derby:" + serveur + ":" + port +"/"+ dbName;
       String user = "app";
       String pass = "app";
       try{
       connexion =DriverManager.getConnection(derbyURL, user, pass);
       }
       catch (SQLException e){ erreur=new String("Erreur lors de la connexion"+ e);}
    }
    public void destroy() {        
      
         try {
             connexion.close();
         } catch (SQLException e) {
             erreur=new String("Erreur lors de la connexion"+ e);;
         }
       
    }

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
        response.sendRedirect("menu.jsp");
       
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
        response.sendRedirect("menu.jsp");
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
        switch(request.getParameter("Operation")){
            case "Afficher tous les enregistrements" :
                try{
                if(!connexion.isValid(0)){
                    if(erreur==null)erreur="connexion invalide";
                    request.setAttribute("erreur", erreur);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
                else{
                    resultatrequete tab = new resultatrequete();//initialisation de mon 1er javabean
                    Statement traitement =connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//création d'un traitement parcourable dans les 2 sens
                    String requete = "SELECT customer_id,name,addressline1,addressline2,zip FROM APP.CUSTOMER";//initalisation de ma requête
                    ResultSet resultat = traitement.executeQuery(requete);//exécution de ma requête
                    tab.setResult(resultat);//chargement du résultat de ma requête dans de mon javabean
                    request.setAttribute("resultat",tab);//déclaration de mon javabean dans mes paramètres POST
                    request.getRequestDispatcher("resultat.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                    traitement.close();
                }
            }
            
            catch (SQLException e){
            request.setAttribute("erreur", "erreur requete "+e);
            request.getRequestDispatcher("error.jsp").forward(request,response);
            };
            break;
            case "inserer un enregistrement" :
                try{
                if(!connexion.isValid(0)){
                    if(erreur==null)erreur="connexion invalide";
                    request.setAttribute("erreur", erreur);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
                else{
                    resultatrequete tab1 = new resultatrequete();//instanciation d'un 2ème javabean pour les codes postaux
                    Statement traitement1 =connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//création d'un traitement parcourable dans les 2 sens
                    String requete1 = "SELECT ZIP_CODE FROM APP.MICRO_MARKET";//initalisation de ma requête
                    ResultSet resultat1 = traitement1.executeQuery(requete1);//exécution de ma requête
                    tab1.setResult(resultat1);//chargement du résultat de ma requête dans de mon javabean
                    request.setAttribute("cp",tab1);//déclaration de mon javabean dans mes paramètres POST
                    resultatrequete tab2 = new resultatrequete();//instanciation d'un 3ème javabean pour les codes remise
                    Statement traitement2 =connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String requete2 = "SELECT DISCOUNT_CODE FROM APP.DISCOUNT_CODE";
                    ResultSet resultat2 = traitement2.executeQuery(requete2);
                    tab2.setResult(resultat2);
                    request.setAttribute("dc",tab2);
                    request.getRequestDispatcher("form_inscription.jsp").forward(request,response);
                }
            }
            
            catch (SQLException e){
            request.setAttribute("erreur", "erreur requete "+e);
            request.getRequestDispatcher("error.jsp").forward(request,response);
            };
            break;
            case "Enregistrer" :
                try{
                Statement traitement1 =connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String param1 = request.getParameter("nom");
                String param2 = request.getParameter("adresse");
                String param3 = request.getParameter("telephone");
                String param4 = request.getParameter("email");
                String param5 = request.getParameter("code_remise");
                String param6 = request.getParameter("CP");
                String requete1 = "INSERT INTO APP.CUSTOMER (customer_id,name,addressline1,phone,email,discount_code,zip) VALUES(5001,'"+param1+"','"+param2+"','"+param3+"','"+param4+"','"+param5+"','"+param6+"')";
                traitement1.executeUpdate(requete1);
                }
                catch (SQLException e){
                    request.setAttribute("erreur", "erreur requete "+e);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                };
                request.setAttribute("confirm", "enregistrement effectué");
                request.getRequestDispatcher("confirm.jsp").forward(request,response);
                break;               
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import LOREntities.*;
import beans.*;

import hibernateConfig.HibernateUtil;
import java.io.IOException;
import static java.lang.Math.round;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.*;

/**
 *
 * @author bornbygoogle
 */
public class Controleur extends HttpServlet 
{
    String erreur;
    private Session modele;
    
    public Controleur() throws InitException
    {
        init();
    }
    
    public void init() 
    {
        try {
            this.modele = (HibernateUtil.getSessionFactory()).openSession();
        }
        catch (ExceptionInInitializerError eiie)    {System.out.println("Erreur lors de l'initialisation du modèle.\n"
                + eiie.getMessage());}
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
        response.sendRedirect("index.jsp");
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
                if(modele==null){
                    if(erreur==null)erreur="connexion invalide";
                    request.setAttribute("erreur", erreur);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
                else{
                    try {
                        int idPromo=0;
                        int idVersionConsole=0;
                        int idVersionJeu=0;
                        String typeConsole = "Console";
                        String typeJeu = "Jeu";
                        String cb = ""/*CodeBarre*/;
                        String nom = ""/*Nom*/;
                        String edition = "";
                        String zone = "";
                        String fabricant = "";
                        String urlphoto = ""/*Photo*/;
                        String descr = ""/*Description*/;
                        String tags = "";
                        String plateforme = "";
                        float prixbase = 0f;
                        float prix = 0f;
                        int stock = 0;
                        float cote = 0f;
                        // Instancier le bean pour une recherche des Promos
                        /*PromoBean promoBean = new PromoBean(idPromo,idVersionConsole, idVersionJeu,
                                type, cb, nom, edition, zone, fabricant, urlphoto, descr,
                                tags, plateforme, prixbase, prix, stock, cote);*/
                        PromoBeans vpbs = new PromoBeans();
                        Vector<PromoBean> vpb = new Vector<PromoBean>();
                        //vpb.setResult(chercherPromo(promoBean));
                        // Instancier le bean pour une recherche des Produits
                        /*ProduitBean produitBean = new ProduitBean(idPromo,idVersionConsole, idVersionJeu,
                                type, cb, nom, edition, zone, fabricant, urlphoto, descr,
                                tags, plateforme, prixbase, prix, stock, cote);*/
                        Vector<ProduitBean> vpds = new Vector<ProduitBean>();
                        //Chercher tous les Produits
                        vpds.addAll(chercherProduit(new ProduitBean(/*idPromo,*/idVersionConsole, idVersionJeu,
                                "", cb, nom, edition, zone, fabricant, urlphoto, descr,
                                tags, plateforme, /*prixbase,*/ prix, stock, cote)));
                        
                        for (ProduitBean pb : vpds)
                        {
                            if ((pb.getType()).equals("Console"))     // Si le type est Console
                            {
                                if (chercherPromoExiste(pb.getType(),pb.getIdVersionConsole()))  // et il existe une promotion sur cette console
                                {
                                    float prixpromo = Math.round(pb.getPrix()*pb.getCote()*100)/100;
                                    PromoBean promoBean = new PromoBean(chercherIdPromo("Console",pb.getIdVersionConsole()) ,pb.getIdVersionConsole(), 0,
                                                                typeConsole, pb.getCodeBarre(), pb.getNom(), pb.getEdition(), pb.getZone(), pb.getEditeur(), "", pb.getDescription(),
                                                                pb.getTags(), "", pb.getPrix(), prixpromo , pb.getStock(), pb.getCote());
                                    vpb.add(promoBean);
                                }
                                else
                                {
                                    PromoBean promoBean = new PromoBean(0 ,pb.getIdVersionConsole(), 0,
                                                                typeConsole, pb.getCodeBarre(), pb.getNom(), pb.getEdition(), pb.getZone(), pb.getEditeur(), "", pb.getDescription(),
                                                                pb.getTags(), "", pb.getPrix(), 0 , pb.getStock(), pb.getCote());
                                    vpb.add(promoBean);
                                }
                            }
                            else  if ((pb.getType()).equals("Jeu")) // Si le type est un Jeu
                            {
                                if (chercherPromoExiste(pb.getType(),pb.getIdVersionJeu()))  // et il existe une promotion sur ce Jeu
                                {
                                    float prixpromo = pb.getPrix()*pb.getCote();
                                    PromoBean promoBean = new PromoBean(chercherIdPromo("Jeu",pb.getIdVersionJeu()) , 0, pb.getIdVersionJeu(),
                                                                typeJeu, pb.getCodeBarre(), pb.getNom(), pb.getEdition(), pb.getZone(), pb.getEditeur(), pb.getPhoto() , pb.getDescription(),
                                                                pb.getTags(), pb.getPlateforme(), pb.getPrix(), prixpromo , pb.getStock(), pb.getCote());
                                    vpb.add(promoBean);
                                }
                                else
                                {
                                    PromoBean promoBean = new PromoBean(0 , 0, pb.getIdVersionJeu(),
                                                                typeJeu, pb.getCodeBarre(), pb.getNom(), pb.getEdition(), pb.getZone(), pb.getEditeur(), pb.getPhoto(), pb.getDescription(),
                                                                pb.getTags(), pb.getPlateforme(), pb.getPrix(), 0 , pb.getStock(), pb.getCote());
                                    vpb.add(promoBean);
                                }
                            }
                        }
                        
                        vpbs.setResult(vpb);
                        /*PromoBeans requete = new PromoBeans();
                        requete.setResult(bean);*/
                        /*Statement traitement =connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//création d'un traitement parcourable dans les 2 sens
                        String requete = "SELECT customer_id,name,addressline1,addressline2,zip FROM APP.CUSTOMER";//initalisation de ma requête
                        ResultSet resultat = traitement.executeQuery(requete);//exécution de ma requête*/
                        //chargement du résultat de ma requête dans de mon javabean
                        //request.setAttribute("produit", vpd); //déclaration de mon javabean dans mes paramètres POST
                        request.setAttribute("promos", vpbs);
                        //request.getRequestDispatcher("resultat.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                        //traitement.close();*/
                        System.out.println("Connection succeded !!");
                        request.getRequestDispatcher("index.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                        //response.sendRedirect("index.jsp");
                    /*} catch (ResultatInvalideException ex) {
                        Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);*/
                    } catch (DonneeInvalideException ex) {
                        Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                    }/* catch (DonneesInsuffisantesException ex) {
                        Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }      
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
                if(modele==null){
                    if(erreur==null)erreur="connexion invalide";
                    request.setAttribute("erreur", erreur);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
                else{
                    /*resultatrequete tab = new resultatrequete();//initialisation de mon 1er javabean
                    Statement traitement =connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//création d'un traitement parcourable dans les 2 sens
                    String requete = "SELECT customer_id,name,addressline1,addressline2,zip FROM APP.CUSTOMER";//initalisation de ma requête
                    ResultSet resultat = traitement.executeQuery(requete);//exécution de ma requête
                    tab.setResult(resultat);//chargement du résultat de ma requête dans de mon javabean
                    request.setAttribute("resultat",tab);//déclaration de mon javabean dans mes paramètres POST
                    request.getRequestDispatcher("resultat.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                    traitement.close();
                    System.out.println("Connection succeded !!");
                    response.sendRedirect("index.jsp");*/
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

    /**
     * Détermine, à partir d'un bean, quelle(s) requête(s) de recherche générer et exécuter. Transforme les résultats en formulaires.
     * Les formulaires renvoyés correspondront à des produits : nommément, soit à une version de jeu, soit à une version de console.
     * @throws DonneesInsuffisantesException si l'utilisateur rentre de donnes insufisantes
     * @throws ResultatInvalideException si le resultat affiché n'est pas conforme
     * @throws DonneeInvalideException si l'utilisateur va entrer des variables non conformes comme type
     * @param  form met en parametre une variable objet de type Form ce objet contien des attributs qui vont etre decharger dans un vecteur de type generique
 le but est de chercherProduit une version de console ou une verion de jeu dans la base de données
     * @return Vecteur( un vecteur de type  générique)retourne un vecteur des objets de type ProduitForm le but est
    */
    public Vector<ProduitBean> chercherProduit(ProduitBean form) //throws DonneeInvalideException, ResultatInvalideException, DonneesInsuffisantesException
    {
        Vector<ProduitBean> ret = new Vector<ProduitBean>();

        //On récupère les variables du bean pour améliorer la lisibilité
        int idVersionConsole = form.getIdVersionConsole();
        int idVersionJeu = form.getIdVersionJeu();
        String type = form.getType();
        String cb = form.getCodeBarre();
        //if (!"".equals(cb))
        //    cb = codeBarreValide(cb);
        String nom = normalize(form.getNom());
        String edition = normalize(form.getEdition());
        String zone = form.getZone();
        String editeur = normalize(form.getEditeur());
        String description = form.getDescription();      //La description n'est pas un critère de recherche viable.
        Vector<String> tags = stringToVector(normalize(form.getTags()).replace(" ", ""), ',');
        String plateforme = form.getPlateforme();
        //Pas besoin de récupérer les identifiants, la description de jeu, le prix et le stock.

        for (VersionConsole enr : chercherVersionsConsole(cb, edition, zone, nom, editeur))
            {
                ProduitBean pf = new ProduitBean();
                pf.setIdVersionConsole(enr.getIdVersionConsole());
                pf.setIdVersionJeu(-1);
                pf.setType("Console");
                pf.setCodeBarre(enr.getCodeBarre());
                pf.setNom(enr.getConsole().getNomConsole());
                pf.setEdition(enr.getEdition());
                pf.setZone(enr.getZone().getNomZone());
                pf.setEditeur(enr.getConsole().getFabricant().getNomFabricant());
                pf.setPrix(enr.getPrix());
                pf.setStock(enr.getStock());
                pf.setCote(getCoteProduct("Console",enr.getIdVersionConsole()));
                ret.add(pf);
            }
        for (VersionJeu enr : chercherVersionsJeu(cb, edition, zone, plateforme, nom, editeur, tags))
            {
                ProduitBean pf = new ProduitBean();
                pf.setIdVersionConsole(-1);
                pf.setIdVersionJeu(enr.getIdVersionJeu());
                pf.setType("Jeu");
                pf.setCodeBarre(enr.getCodeBarre());
                pf.setNom(enr.getJeu().getNomJeu());
                pf.setEdition(enr.getEdition());
                pf.setZone(enr.getZone().getNomZone());
                pf.setEditeur(enr.getJeu().getEditeur().getNomEditeur());
                pf.setPhoto(enr.getJeu().getPhotoJeu());
                pf.setDescription(enr.getJeu().getDescriptionJeu());
                pf.setTags(decriresToString(enr.getJeu().getDecrires(), ','));
                pf.setPlateforme(enr.getConsole().getNomConsole());
                pf.setPrix(enr.getPrix());
                pf.setStock(enr.getStock());
                pf.setCote(getCoteProduct("Jeu",enr.getIdVersionJeu()));
                ret.add(pf);
            }
        return ret;
    }
    public Vector<PromoBean> chercherPromo(PromoBean form) throws DonneeInvalideException //throws ResultatInvalideException, DonneeInvalideException, DonneesInsuffisantesException
    {
        Vector<PromoBean> ret = new Vector<PromoBean>();

        //On récupère les variables du bean pour améliorer la lisibilité
        int idPromo = form.getIdPromo();
        String type = form.getType();
        String cb = form.getCodeBarre();
        /*if (!"".equals(cb))
            cb = codeBarreValide(cb);*/
        String nom = normalize(form.getNom());
        String edition = normalize(form.getEdition());
        String zone = form.getZone();
        String editeur = normalize(form.getEditeur());
        String description = form.getDescription();
        Vector<String> tags = stringToVector(normalize(form.getTags()).replace(" ", ""), ',');
        String plateforme = form.getPlateforme();
        Float cote = 0.0f;
        //Pas besoin de récupérer les identifiants, la description de jeu, le prix et le stock.

        if ("Console".equals(type))
        {
            for (VersionConsole enr : chercherVersionsConsolePromo(edition, zone, editeur))
            {
                /*if (enr.getIdVersionConsole()<1) cote = 0.0f;
                else 
                {   System.out.println(enr.getIdVersionConsole());
                    cote = getCoteProduct("Console", enr.getIdVersionConsole());}*/
                // Vérifier s'il y a pas deja une promo sur ce VersionConsole
                float prixbase = enr.getPrix();
                float prix = enr.getPrix();
                if (chercherPromoExiste(type, enr.getIdVersionConsole()))
                {
                    PromoConsole pctmp = chercherPromoConsole(chercherIdPromo(type,enr.getIdVersionConsole()));
                    idPromo = pctmp.getIdPromoConsole();
                    prix = pctmp.getPrixPromoConsole();
                }
                else { idPromo = 0; }
                ret.add(new PromoBean(idPromo,enr.getIdVersionConsole(), -1, "Console",
                        enr.getCodeBarre(), enr.getConsole().getNomConsole(), enr.getEdition(), enr.getZone().getNomZone(),
                        enr.getConsole().getFabricant().getNomFabricant(), "", "", "", "",
                        prixbase, prix, enr.getStock(), getCoteProduct(type, enr.getIdVersionConsole())));
            }
        }
        else if ("Jeu".equals(type))
        {
            for (VersionJeu enr : chercherVersionsJeuPromo(edition, zone, plateforme,editeur, tags))
            {
                // Vérifier s'il y a pas deja une promo sur ce VersionConsole
                float prixbase= enr.getPrix();
                float prix = enr.getPrix();
                if (chercherPromoExiste(type, enr.getIdVersionJeu()))
                {
                    PromoJeu pctmp = chercherPromoJeu(chercherIdPromo(type,enr.getIdVersionJeu())); 
                    idPromo = pctmp.getIdPromoJeu();
                    prix = pctmp.getPrixPromoJeu();
                }
                else { idPromo = 0; }
                ret.add(new PromoBean(idPromo,-1, enr.getIdVersionJeu(), "Jeu",
                    enr.getCodeBarre(), enr.getJeu().getNomJeu(), enr.getEdition(), enr.getZone().getNomZone(),
                    enr.getJeu().getEditeur().getNomEditeur(), ""/*Photo*/, enr.getJeu().getDescriptionJeu(),
                    decriresToString(enr.getJeu().getDecrires(), ','), enr.getConsole().getNomConsole(),
                    prixbase, prix, enr.getStock(), getCoteProduct(type, enr.getIdVersionJeu())));
            }
        }

        return ret;
    }
   /**
     * Recherche les versions de consoles dont le code barre, l'édition, la zone et le fabricant correspondent parfaitement aux données renseignées,
     * et dont le nom contient la chaîne renseignée.
     * La zone et l'édition ne sont pas suffisantes pour lancer une recherche.
     * @param cb met en parametre une variable String qui represente le code barre
     * @param edition met en parametre une variable String qui represente l'editeur
     * @param zone met en parametre une variable String qui represente la zone
     * @param nome en parametre une variable String qui represente de la console
     * @param fabricant met en parametre une variable String qui represente le nome de fabricante de la console
     * @throws DonneesInsuffisantesException si l'utilisateur rentre de données insufisantes
     * @throws EnregistrementExistantException si la valeur entre existe deja dans la base de données
     * @throws DonneeInvalideException si l'utilisateur va rentrer des variable non conformes comme type
     * @return Vector retourne un vecteur generique des objets de type VersionConsole pour afficher dans l'interface
     */
    private Vector<VersionConsole> chercherVersionsConsole(String cb, String edition, String zone, String nom, String fabricant)
            //throws DonneesInsuffisantesException, DonneeInvalideException
    {
        //if ("".equals(cb) && "".equals(nom) && "".equals(fabricant))
         //   throw new DonneesInsuffisantesException("Erreur lors de la recherche des produits de type console : il faut renseigner un code barre, un nom, ou un fabricant.");

        Vector<VersionConsole> ret = new Vector<VersionConsole>();

        HQLRecherche q = new HQLRecherche("LOREntities.VersionConsole vc");
        //rédaction de la requête imbriquée pour console
        if (!"".equals(nom) || !"".equals(fabricant)) //si la console est renseignée (et/ou son fabricant)
        {
            HQLRecherche imbrCons = new HQLRecherche("LOREntities.Console c");
            imbrCons.setImbriquee(true);
            imbrCons.setSelect("c.idConsole");
            imbrCons.addCondition("c.nomConsole", nom, HQLRecherche.Operateur.LIKE);
            //rédaction de la requête imbriquée pour fabricant
            if (!"".equals(fabricant)) //si le fabricant est renseigné
            {
                HQLRecherche imbrFabr = new HQLRecherche("LOREntities.Fabricant f");
                imbrFabr.setImbriquee(true);
                imbrFabr.addCondition("f.nomFabricant", fabricant, HQLRecherche.Operateur.LIKE);
                imbrCons.addCondition("c.fabricant", imbrFabr.toString(), HQLRecherche.Operateur.IN);
            }
            q.addCondition("vc.console", imbrCons.toString(), HQLRecherche.Operateur.IN);
        }
        //rédaction des requêtes imbriquées pour zone
        if (!"".equals(zone)) //si la zone est renseignée
        {
            HQLRecherche imbrZone = new HQLRecherche("LOREntities.Zone z");
            imbrZone.setImbriquee(true);
            imbrZone.setSelect("z.idZone");
            imbrZone.addCondition("z.nomZone", zone, HQLRecherche.Operateur.LIKE);
            q.addCondition("vc.zone", imbrZone.toString(), HQLRecherche.Operateur.IN);
        }
        //autres conditions
        /*if (!"".equals(cb))
            q.addCondition("vc.codeBarre", cb, HQLRecherche.Operateur.EGAL);
        if (!"".equals(edition))
            q.addCondition("vc.edition", edition, HQLRecherche.Operateur.LIKE);*/

        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();
        ret.addAll(resultats);

        return ret;
    }
   /**
     * Recherche les promotions des versions de consoles 
     * @param id id du PromoConsole
     * @return Vector retourne un vecteur generique des objets de type PromoConsole 
     */
    private PromoConsole chercherPromoConsole(int id) throws DonneeInvalideException
    {
        if (id < 0)
            throw new DonneeInvalideException("Impossible de chercher un promotion produit (console) : aucun identifiant n'a été renseigné.");

        HQLRecherche q = new HQLRecherche("PromoConsole pc");
        q.addCondition("pc.idPromoConsole", id, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();
        
        if (resultats.isEmpty())
            return null;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return (PromoConsole) resultats.get(resultats.size()-1);
    }
   /**
     * Recherche les promotions des versions de produit
     * @param string type du produit
     * @param id id du VersionConsole
     * @return id du PromoConsole correspond
     */
    private int chercherIdPromo(String type, int id) throws DonneeInvalideException
    {
        int idPromo = 0;
        List resultats = null;
        if (id < 0)
            throw new DonneeInvalideException("Impossible de chercher un promotion produit (console) : aucun identifiant n'a été renseigné.");
  
        if ("Console".equals(type))
        {
            HQLRecherche q = new HQLRecherche("PromoConsole pc");
            HQLRecherche imbrVersionConsole = new HQLRecherche("LOREntities.VersionConsole vc");
            imbrVersionConsole.setImbriquee(true);
            imbrVersionConsole.setSelect("vc.idVersionConsole");
            imbrVersionConsole.addCondition("vc.idVersionConsole", id, HQLRecherche.Operateur.EGAL);
            q.addCondition("pc.versionConsole", imbrVersionConsole.toString(), HQLRecherche.Operateur.IN);
            resultats = modele.createQuery(q.toString()).list();
        }
        else if ("Jeu".equals(type))
        {
            HQLRecherche q = new HQLRecherche("PromoJeu pj");
            HQLRecherche imbrVersionConsole = new HQLRecherche("LOREntities.VersionJeu vj");
            imbrVersionConsole.setImbriquee(true);
            imbrVersionConsole.setSelect("vj.idVersionJeu");
            imbrVersionConsole.addCondition("vj.idVersionJeu", id, HQLRecherche.Operateur.EGAL);
            q.addCondition("pj.versionJeu", imbrVersionConsole.toString(), HQLRecherche.Operateur.IN);
            resultats = modele.createQuery(q.toString()).list();
        }        
                
        if (resultats.isEmpty())
            return 0;
        else //on suppose qu'il n'y a qu'un seul résultat !
        {
            if ("Console".equals(type))
            {
                idPromo  = ((PromoConsole) resultats.get(resultats.size()-1)).getIdPromoConsole();
            }
            else if ("Jeu".equals(type))
            {
                idPromo  = ((PromoJeu) resultats.get(resultats.size()-1)).getIdPromoJeu();
            } 
        }
            return idPromo;
    }
   /**
     * Recherche les promotions des versions de produits
     * @param String type du produit
     * @param id id du PromoConsole
     * @return Vector retourne un vecteur generique des objets de type PromoConsole 
     */
    private boolean chercherPromoExiste(String type, int id) throws DonneeInvalideException
    {
        List resultats = null;
        if (id < 0)
            throw new DonneeInvalideException("Impossible de chercher un promotion produit (console) : aucun identifiant n'a été renseigné.");

        if ("Console".equals(type))
        {
            HQLRecherche q = new HQLRecherche("PromoConsole pc");
            HQLRecherche imbrVersionConsole = new HQLRecherche("LOREntities.VersionConsole vc");
            imbrVersionConsole.setImbriquee(true);
            imbrVersionConsole.setSelect("vc.idVersionConsole");
            imbrVersionConsole.addCondition("vc.idVersionConsole", id, HQLRecherche.Operateur.EGAL);
            q.addCondition("pc.versionConsole", imbrVersionConsole.toString(), HQLRecherche.Operateur.IN);
            resultats = modele.createQuery(q.toString()).list();
        }
        else if ("Jeu".equals(type))
        {
            HQLRecherche q = new HQLRecherche("PromoJeu pj");
            HQLRecherche imbrVersionConsole = new HQLRecherche("LOREntities.VersionJeu vj");
            imbrVersionConsole.setImbriquee(true);
            imbrVersionConsole.setSelect("vj.idVersionJeu");
            imbrVersionConsole.addCondition("vj.idVersionJeu", id, HQLRecherche.Operateur.EGAL);
            q.addCondition("pj.versionJeu", imbrVersionConsole.toString(), HQLRecherche.Operateur.IN);
            resultats = modele.createQuery(q.toString()).list();
        } 
        
        if (resultats.isEmpty())
            return false;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return true;
    }
   /**
     * Recherche les promotions des versions de jeux 
     * @param id id du PromoJeu
     * @return Vector retourne un vecteur generique des objets de type PromoJeux 
     */
    private PromoJeu chercherPromoJeu(int id) throws DonneeInvalideException
    {
        if (id < 0)
            throw new DonneeInvalideException("Impossible de chercher un produit (jeu) : aucun identifiant n'a été renseigné.");

        HQLRecherche q = new HQLRecherche("PromoJeu pj");
        q.addCondition("pj.idPromoJeu", id, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();

        if (resultats.isEmpty())
            return null;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return (PromoJeu) resultats.get(resultats.size() - 1);
    }

    private Vector<VersionConsole> chercherVersionsConsolePromo(String edition, String zone, String fabricant)
            //throws DonneesInsuffisantesException, DonneeInvalideException
    {
        Vector<VersionConsole> ret = new Vector<VersionConsole>();

        HQLRecherche q = new HQLRecherche("LOREntities.VersionConsole vc");
        //rédaction de la requête imbriquée pour console
        if (!"".equals(fabricant)) //si la console est renseignée (et/ou son fabricant)
        {
            HQLRecherche imbrCons = new HQLRecherche("LOREntities.Console c");
            imbrCons.setImbriquee(true);
            imbrCons.setSelect("c.idConsole");
            //imbrCons.addCondition("c.nomConsole", nom, HQLRecherche.Operateur.LIKE);
            //rédaction de la requête imbriquée pour fabricant
            if (!"".equals(fabricant)) //si le fabricant est renseigné
            {
                HQLRecherche imbrFabr = new HQLRecherche("LOREntities.Fabricant f");
                imbrFabr.setImbriquee(true);
                imbrFabr.addCondition("f.nomFabricant", fabricant, HQLRecherche.Operateur.LIKE);
                imbrCons.addCondition("c.fabricant", imbrFabr.toString(), HQLRecherche.Operateur.IN);
            }
            q.addCondition("vc.console", imbrCons.toString(), HQLRecherche.Operateur.IN);
        }
        //rédaction des requêtes imbriquées pour zone
        if (!"".equals(zone)) //si la zone est renseignée
        {
            HQLRecherche imbrZone = new HQLRecherche("LOREntities.Zone z");
            imbrZone.setImbriquee(true);
            imbrZone.setSelect("z.idZone");
            imbrZone.addCondition("z.nomZone", zone, HQLRecherche.Operateur.LIKE);
            q.addCondition("vc.zone", imbrZone.toString(), HQLRecherche.Operateur.IN);
        }
        //autres conditions
        if (!"".equals(edition))
            q.addCondition("vc.edition", edition, HQLRecherche.Operateur.LIKE);

        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();
        ret.addAll(resultats);

        return ret;
    }
    private VersionConsole chercherVersionConsole(int id) throws DonneeInvalideException
    {
        if (id < 0)
            throw new DonneeInvalideException("Impossible de chercher un produit (console) : aucun identifiant n'a été renseigné.");

        HQLRecherche q = new HQLRecherche("VersionConsole vc");
        q.addCondition("vc.idVersionConsole", id, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();

        if (resultats.isEmpty())
            
            return null;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return (VersionConsole) resultats.get(0);
    }
    /**
     * Recherche les versions de jeux dont le code barre, l'édition, la zone et le fabricant correspondent parfaitement aux données renseignées,et dont le nom contient la chaîne renseignée.
     * La zone et l'édition ne sont pas suffisantes pour lancer une recherche.
     * A l'intérieur de cette méthode il y a appelé des méthodes de la classe -voir See Also
     * @see HQLRecherche
     * @param cb met en parametre une variable String qui represente le code barre
     * @param edition met en parametre une variable String qui represente l'editeur
     * @param zone met en parametre une variable String qui represente la zone
     * @param nome en parametre une variable String qui represente de la console
     * @param fabricant met en parametre une variable String qui represente le nome de fabricante de la console
     * @throws DonneesInsuffisantesException si l'utilisateur rentre de données insufisantes
     * @throws EnregistrementExistantException si la valeur entre existe deja dans la base de données
     * @throws DonneeInvalideException si l'utilisateur va rentrer des variable non conformes comme type
     * @return Vector retourne un vecteur generique des objets de type VersionConsole pour afficher dans l'interface
     */
    private Vector<VersionJeu> chercherVersionsJeu(String cb, String edition, String zone,
            String plateforme, String nom, String editeur, Vector<String> tags)
            //throws DonneesInsuffisantesException
    {
        //if ("".equals(cb) && "".equals(plateforme) && "".equals(nom) && "".equals(editeur) && tags.isEmpty())
        //    throw new DonneesInsuffisantesException("Erreur lors de la recherche des produits de type jeu : il faut renseigner un code barre, une plateforme, un nom, un éditeur ou au moins un tag.");

        Vector<VersionJeu> ret = new Vector<VersionJeu>();

        HQLRecherche q = new HQLRecherche("LOREntities.VersionJeu vj");
        //rédaction de la requête imbriquée pour console
        if (!"".equals(plateforme)) //si la console est renseignée
        {
            HQLRecherche imbrCons = new HQLRecherche("LOREntities.Console c");
            imbrCons.setImbriquee(true);
            imbrCons.setSelect("c.idConsole");
            imbrCons.addCondition("c.nomConsole", plateforme, HQLRecherche.Operateur.EGAL);

            q.addCondition("vj.console.idConsole", imbrCons.toString(), HQLRecherche.Operateur.IN);
        }

        // rédaction de la requete imbriquée Jeu
        if (!"".equals(nom) || !"".equals(editeur) || !tags.isEmpty()) //si le nom du jeu est renseignée
        {
            HQLRecherche imbrJeu = new HQLRecherche("LOREntities.Jeu j");
            imbrJeu.setImbriquee(true);

            if (!"".equals(nom)) //condition sur le nom
                imbrJeu.addCondition("j.nomJeu", nom, HQLRecherche.Operateur.LIKE);
            if (!"".equals(editeur)) //condition sur le développeur
            {
                HQLRecherche imbrEditeur = new HQLRecherche("LOREntities.Editeur e");
                imbrEditeur.setImbriquee(true);
                imbrEditeur.setSelect("e.idEditeur");
                imbrEditeur.addCondition("e.nomEditeur", editeur, HQLRecherche.Operateur.LIKE);

                imbrJeu.addCondition("j.editeur.idEditeur", imbrEditeur.toString(), HQLRecherche.Operateur.IN);
            }
            if (!tags.isEmpty())
            {
                for (String tag : tags)
                {
                    //on sélectionne le tag
                    HQLRecherche imbrTag = new HQLRecherche("LOREntities.Tag t");
                    imbrTag.setImbriquee(true);
                    imbrTag.setSelect("t.idTag");
                    imbrTag.addCondition("t.labelTag", tag, HQLRecherche.Operateur.EGAL);

                    //on liste les jeux des relations "décrire" correspondant à ce tag (identifiants seulement)
                    HQLRecherche imbrDecr = new HQLRecherche("LOREntities.Decrire d");
                    imbrDecr.setImbriquee(true);
                    imbrDecr.setSelect("d.jeu.idJeu");
                    imbrDecr.addCondition("d.tag.idTag", imbrTag.toString(), HQLRecherche.Operateur.IN);

                    //la requête qui recherche le jeu sélectionne parmi les jeux qui ont tous ces tags
                    imbrJeu.addCondition("j.idJeu", imbrDecr.toString(), HQLRecherche.Operateur.IN);
                }
            }

            q.addCondition("vj.jeu", imbrJeu.toString(), HQLRecherche.Operateur.IN);
        }

        //rédaction des requêtes imbriquées pour zone
        if (!"".equals(zone)) //si la zone est renseignée
        {
            HQLRecherche imbrZone = new HQLRecherche("LOREntities.Zone z");
            imbrZone.setImbriquee(true);
            imbrZone.setSelect("z.idZone");
            imbrZone.addCondition("z.nomZone", zone, HQLRecherche.Operateur.LIKE);
            q.addCondition("vj.zone", imbrZone.toString(), HQLRecherche.Operateur.IN);
        }
        //autres conditions
        /*if (!"".equals(cb)) //code barre
            q.addCondition("vj.codeBarre", cb, HQLRecherche.Operateur.EGAL);
        if (!"".equals(edition)) //edition
            q.addCondition("vj.edition", edition, HQLRecherche.Operateur.LIKE);*/

        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();
        ret.addAll(resultats);

        return ret;
    }
    private Vector<VersionJeu> chercherVersionsJeuPromo(String edition, String zone,
            String plateforme, String editeur, Vector<String> tags)
            //throws DonneesInsuffisantesException
    {
        Vector<VersionJeu> ret = new Vector<VersionJeu>();

        HQLRecherche q = new HQLRecherche("LOREntities.VersionJeu vj");
        //rédaction de la requête imbriquée pour console
        if (!"".equals(plateforme)) //si la console est renseignée
        {
            HQLRecherche imbrCons = new HQLRecherche("LOREntities.Console c");
            imbrCons.setImbriquee(true);
            imbrCons.setSelect("c.idConsole");
            imbrCons.addCondition("c.nomConsole", plateforme, HQLRecherche.Operateur.EGAL);

            q.addCondition("vj.console.idConsole", imbrCons.toString(), HQLRecherche.Operateur.IN);
        }

        // rédaction de la requete imbriquée Jeu
        if (!"".equals(editeur) || !tags.isEmpty()) //si le nom du jeu est renseignée
        {
            HQLRecherche imbrJeu = new HQLRecherche("LOREntities.Jeu j");
            imbrJeu.setImbriquee(true);

            /*if (!"".equals(nom)) //condition sur le nom
                imbrJeu.addCondition("j.nomJeu", nom, HQLRecherche.Operateur.LIKE);*/
            if (!"".equals(editeur)) //condition sur le développeur
            {
                HQLRecherche imbrEditeur = new HQLRecherche("LOREntities.Editeur e");
                imbrEditeur.setImbriquee(true);
                imbrEditeur.setSelect("e.idEditeur");
                imbrEditeur.addCondition("e.nomEditeur", editeur, HQLRecherche.Operateur.LIKE);

                imbrJeu.addCondition("j.editeur.idEditeur", imbrEditeur.toString(), HQLRecherche.Operateur.IN);
            }
            if (!tags.isEmpty())
            {
                for (String tag : tags)
                {
                    //on sélectionne le tag
                    HQLRecherche imbrTag = new HQLRecherche("LOREntities.Tag t");
                    imbrTag.setImbriquee(true);
                    imbrTag.setSelect("t.idTag");
                    imbrTag.addCondition("t.labelTag", tag, HQLRecherche.Operateur.EGAL);

                    //on liste les jeux des relations "décrire" correspondant à ce tag (identifiants seulement)
                    HQLRecherche imbrDecr = new HQLRecherche("LOREntities.Decrire d");
                    imbrDecr.setImbriquee(true);
                    imbrDecr.setSelect("d.jeu.idJeu");
                    imbrDecr.addCondition("d.tag.idTag", imbrTag.toString(), HQLRecherche.Operateur.IN);

                    //la requête qui recherche le jeu sélectionne parmi les jeux qui ont tous ces tags
                    imbrJeu.addCondition("j.idJeu", imbrDecr.toString(), HQLRecherche.Operateur.IN);
                }
            }

            q.addCondition("vj.jeu", imbrJeu.toString(), HQLRecherche.Operateur.IN);
        }

        //rédaction des requêtes imbriquées pour zone
        if (!"".equals(zone)) //si la zone est renseignée
        {
            HQLRecherche imbrZone = new HQLRecherche("LOREntities.Zone z");
            imbrZone.setImbriquee(true);
            imbrZone.setSelect("z.idZone");
            imbrZone.addCondition("z.nomZone", zone, HQLRecherche.Operateur.LIKE);
            q.addCondition("vj.zone", imbrZone.toString(), HQLRecherche.Operateur.IN);
        }
        //autres conditions
        /*if (!"".equals(cb)) //code barre
            q.addCondition("vj.codeBarre", cb, HQLRecherche.Operateur.EGAL);*/
        if (!"".equals(edition)) //edition
            q.addCondition("vj.edition", edition, HQLRecherche.Operateur.LIKE);

        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();
        ret.addAll(resultats);

        return ret;
    }
    private VersionJeu chercherVersionJeu(int id) throws DonneeInvalideException
    {
        if (id < 0)
            throw new DonneeInvalideException("Impossible de chercher un produit (jeu) : aucun identifiant n'a été renseigné.");

        HQLRecherche q = new HQLRecherche("VersionJeu vj");
        q.addCondition("vj.idVersionJeu", id, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();

        if (resultats.isEmpty())
            return null;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return (VersionJeu) resultats.get(0);
    }
    /**
     * Recherche les consoles dont le nom correspond parfaitement à la chaîne renseignée et ayant le fabricant désigné.
     *@param nomCons une variable de type String utilisé dans la methode addCondition("c.nomConsole", nomCons, HQLRecherche.Operateur.EGAL) pour la recherche d'une console ou le nom correspond
     *@param nomFabr une variable de type String utilisé dans la methode addCondition("c.fabricant.nomFabricant", nomFabr, HQLRecherche.Operateur.EGAL) pour la recherche d'une console ou le nome est désigné
     *@return un objet de type Console,(voir See Also) qui est une classe.
     * @see  HQLRecherche#addCondition(java.lang.String, java.lang.String, controleur.HQLRecherche.Operateur)
     * @see  LOREntities.Console
     */
    private Console chercherConsole(String nomCons, String nomFabr) throws DonneesInsuffisantesException
    {
        if (nomCons == null || "".equals(nomCons))
            throw new DonneesInsuffisantesException("Erreur lors de la recherche de la console : nom de la console non renseigné.");

        HQLRecherche q = new HQLRecherche("LOREntities.Console c");
        q.addCondition("c.nomConsole", nomCons, HQLRecherche.Operateur.EGAL);
        if (!"".equals(nomFabr))
            q.addCondition("c.fabricant.nomFabricant", nomFabr, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();

        if (resultats.isEmpty())
            return null;
        else if (resultats.size() != 1)
            throw new DonneesInsuffisantesException("Erreur lors de la recherche de la console : plusieurs résultats sont retournés.");
        else
            return (Console) resultats.get(0);
    }
    /**
     * Recherche le jeu dont le nom correspond parfaitement à la chaîne renseignée et ayant l'éditeur et les tags renseignés.
     * @param nomJeu est ultilisé pour la methode faire declanché la methode DonneesInsuffisantesException
     * @param tags-n'est pas utilisé
     * @param  nomEditeur-une variable de type String utilisé dans la methode appelé chercherEditeur(nomEditeur)-voir SeeAlso
     * @return un objet de type Jeu(voir See Also) qui est une classe
     * @see LOREntities.Jeu
     * @see #chercherEditeur(java.lang.String)
     */
    private Jeu chercherJeu(String nomJeu, Vector<String> tags, String nomEditeur)
            throws DonneesInsuffisantesException
    {
        int idEditeur = 0;
        if (nomJeu == null || "".equals(nomJeu))
            throw new DonneesInsuffisantesException("Erreur lors de la recherche du jeu : nom du jeu non renseigné.");

        if (nomEditeur != null && !"".equals(nomEditeur))
        {
            Editeur edtr = chercherEditeur(nomEditeur);
            if (edtr == null)
                return null;
            //else
            idEditeur = edtr.getIdEditeur();
        }

        HQLRecherche q = new HQLRecherche("LOREntities.Jeu j");
        q.addCondition("j.nomJeu", nomJeu, HQLRecherche.Operateur.EGAL);
        if (!"".equals(nomEditeur))
            q.addCondition("j.editeur.idEditeur", idEditeur , HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();

        if (resultats.isEmpty())
            return null;
        else if (resultats.size() != 1)
            throw new DonneesInsuffisantesException("Erreur lors de la recherche du jeu : plusieurs résultats sont retournés.");
        else
            return (Jeu) resultats.get(0);
    }
    /**
     * Recherche les fabricants dont le nom contient la chaîne renseignée.
     * @param nomFabr une variable utilisé pour declancher eventuelment DonneesInsuffisantesException Exception et dans la methode addCondition-voir See Also
     * @return Fabricant un objet de type Fabricant qui est une classe voir See Also
     * @see HQLRecherche#addCondition(java.lang.String, java.lang.String, controleur.HQLRecherche.Operateur)
     * @see LOREntities.Fabricant
     */
    private Fabricant chercherFabricant(String nomFabr) throws DonneesInsuffisantesException
    {
        if (nomFabr == null || "".equals(nomFabr))
            throw new DonneesInsuffisantesException("Erreur lors de la recherche du fabricant : nom du fabricant non renseigné.");

        HQLRecherche q = new HQLRecherche("Fabricant f");
        q.addCondition("f.nomFabricant", nomFabr, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();

        if (resultats.isEmpty())
            return null;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return (Fabricant) resultats.get(0);
    }
    /**
     * Recherche l'éditeur dont le nom correspond parfaitement à la chaîne renseignée.
     */
    private Editeur chercherEditeur(String nomEdit) throws DonneesInsuffisantesException
    {
        if (nomEdit == null || "".equals(nomEdit))
            throw new DonneesInsuffisantesException("Erreur lors de la recherche de l'éditeur : nom de l'éditeur non renseigné.");

        HQLRecherche q = new HQLRecherche("Editeur e");
        q.addCondition("e.nomEditeur", nomEdit, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();
        //modele.flush();

        if (resultats.isEmpty())
            return null;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return (Editeur) resultats.get(0);
    }
    /**
     * Recherche une zone dans la base de données. Si la zone renseignée est trouvé, un objet Zone est renvoyé. Sinon, la méthode renvoie null.
     */
    private Zone chercherZone(String zone) throws DonneesInsuffisantesException
    {
        if (zone == null || "".equals(zone))
            throw new DonneesInsuffisantesException("Erreur lors de la recherche de la zone : nom de la zone non renseigné.");

        HQLRecherche q = new HQLRecherche("Zone z");
        q.addCondition("z.nomZone", zone, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();

        if (resultats.isEmpty())
            return null;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return (Zone) resultats.get(0);
    }
    /**
     * Recherche un tag dans la base de données. Si le tag renseigné est trouvé, un objet Tag est renvoyé. Sinon, la méthode renvoie null.
     */
    private Tag chercherTag(String tag) throws DonneesInsuffisantesException
    {
        if (tag == null || "".equals(tag))
            throw new DonneesInsuffisantesException("Erreur lors de la recherche du tag : nom du tag non renseigné.");

        HQLRecherche q = new HQLRecherche("Tag t");
        q.addCondition("t.labelTag", tag, HQLRecherche.Operateur.EGAL);
        List resultats = modele.createQuery(q.toString()).list();
        modele.flush();

        if (resultats.isEmpty())
            return null;
        else //on suppose qu'il n'y a qu'un seul résultat !
            return (Tag) resultats.get(0);
    }
    
   /**
     * Recherche le client/fournisseur dont le nom correspond parfaitement à la chaîne renseignée et/ou ayant le prenom renseigné.
     *@param nomPers une variable de type String utilisé dans la methode .addCondition("pers.nom", nomPers, HQLRecherche.Operateur.LIKE) pour la recherche d'un client via son nom
     *@param prenomPers une variable de type String utilisé dans la methode query.addCondition("pers.prenom", prenomPers, HQLRecherche.Operateur.LIKE) pour la recherche d'un client via son prenom
     *@return un objet de type Personne,(voir See Also) qui est une classe.
     * @see  HQLRecherche#addCondition(java.lang.String, java.lang.String, controleur.HQLRecherche.Operateur)
     * @see  LOREntities.Personne
     */
    
   public Personne chercherPersonne(String nomPers, String prenomPers) throws DonneesInsuffisantesException{
       
        if ("".equals(nomPers) || "".equals(prenomPers)){
            throw new DonneesInsuffisantesException(
                    "Erreur lors de la recherche du client/fournisseur : le nom ET le prenom doivent être renseignés.");
        }
        
        HQLRecherche query = new HQLRecherche("LOREntities.Personne pers");
               
        if (!"".equals(nomPers))
            query.addCondition("pers.nom", nomPers, HQLRecherche.Operateur.LIKE);
        if (!"".equals(prenomPers))
            query.addCondition("pers.prenom", prenomPers, HQLRecherche.Operateur.LIKE);
     
        List resultats = modele.createQuery(query.toString()).list();
        modele.flush();

        if (resultats.isEmpty())
            return null;
        else if (resultats.size() != 1)
            throw new DonneesInsuffisantesException("Erreur lors de la recherche de la console : plusieurs résultats sont retournés.");
        else
            return (Personne) resultats.get(0);
    }

    public Rapport modifierPromo(PromoBean form) throws DonneesInsuffisantesException, DonneeInvalideException, EnregistrementInexistantException
    {
        Rapport rapport = new Rapport();
        int id;
        int idPromo;
        String type = form.getType();

        float prix = form.getPrix();

        if (prix <= 0f)
            throw new DonneeInvalideException("Erreur : le prix ne peut pas être négatif ou nul.");
        
        if ("Console".equals(type))
        {
            idPromo = form.getIdPromo();
            id = form.getIdVersionConsole();
            if (id <= 0)
                throw new DonneesInsuffisantesException(
                        "Erreur : impossible de modifier console (version) d'identifiant " + id);
            // Chercher s'il existe un promo sur Console
            PromoConsole pc = chercherPromoConsole(idPromo);
            // Si non
            if (pc==null)
            {
                VersionConsole vc = chercherVersionConsole(id);
                if (vc == null)
                    throw new EnregistrementInexistantException("Erreur : version de console " + id
                                                                + " non trouvée");
                PromoConsole newpc = new PromoConsole();
                newpc.setVersionConsole(vc);
                newpc.setPrixPromoConsole(prix);
                newpc.setCoteConsole(calculCoteAPartirPrix(type,id,prix));
                //sauvegarde de la version de console
                modele.beginTransaction();
                modele.saveOrUpdate(newpc);
                modele.getTransaction().commit();
                modele.flush();
                idPromo = newpc.getIdPromoConsole();
            }
            else // Si promo existe
            {
                if (pc.getPrixPromoConsole() != prix)
                    pc.setPrixPromoConsole(prix);
                pc.setIdPromoConsole(idPromo);
                pc.setCoteConsole(calculCoteAPartirPrix(type,id,prix));
                //sauvegarde de la version de console
                modele.beginTransaction();
                modele.saveOrUpdate(pc);
                modele.getTransaction().commit();
                modele.flush(); 
            }
        }
        else if ("Jeu".equals(type))
        {
            idPromo = form.getIdPromo();
            id = form.getIdVersionJeu();
            if (id <= 0)
                throw new DonneesInsuffisantesException(
                        "Erreur : impossible de modifier jeu (version) d'identifiant " + id);
            
            PromoJeu pj = chercherPromoJeu(idPromo);
            if (pj == null)
            {
                VersionJeu vj = chercherVersionJeu(id);
                if (vj == null)
                    throw new EnregistrementInexistantException("Erreur : version de jeu " + id
                                                                + " non trouvée");
                PromoJeu newpj = new PromoJeu();
                newpj.setVersionJeu(vj);
                newpj.setPrixPromoJeu(prix);
                newpj.setCoteJeu(calculCoteAPartirPrix(type,id,prix));
                //sauvegarde de la version de console
                modele.beginTransaction();
                modele.saveOrUpdate(newpj);
                modele.getTransaction().commit();
                modele.flush();
                idPromo = newpj.getIdPromoJeu();
            }
            else
            {
                // Chercher a changer le prix
                if (pj.getPrixPromoJeu() != prix)
                    pj.setPrixPromoJeu(prix);
                pj.setIdPromoJeu(idPromo);
                pj.setCoteJeu(calculCoteAPartirPrix(type,id,prix));
                //sauvegarde de la version de jeu
                modele.beginTransaction();
                modele.saveOrUpdate(pj);
                modele.getTransaction().commit();
                modele.flush();
            }
           rapport.addOperation(idPromo, Rapport.Table.PROMOJEU, Rapport.Operation.MODIFIER);
        }
        return rapport;    
    }
     
    /**
     * Renvoie la liste des Editions.
     * @param : type Console / Jeu
     * @return : un vecteur/liste de resultat de type Edition
     */
    public Vector<String> listeEdition(String type)
    {
        Vector<String> ret = new Vector();
        List editions = new ArrayList();
        if (type.equals("Console"))
            { editions = modele.createQuery("select vc.edition from LOREntities.VersionConsole vc").list(); }
        else if (type.equals("Jeu"))
            { editions = modele.createQuery("select vj.edition from LOREntities.VersionJeu vj").list(); }
        for (Object e : editions)
            if (e!=null) ret.add((String) e);
        modele.flush();
            
        return ret;
    }

    /**
     * Renvoie la liste des Editions.
     * @param : void
     * @return : un vecteur/liste de resultat de type Edition
     */
    public Vector<String> listeFabricant()
    {
        Vector<String> ret = new Vector();

        List fabricants = modele.createQuery("from LOREntities.Fabricant").list();
        for (Object f : fabricants)
            if (f!=null) ret.add(((Fabricant) f).getNomFabricant());
        modele.flush();

        return ret;
    }    
    
    /**
     * Renvoie la liste des zones.
     * @param : void
     * @return : un vecteur/liste de resultat de type Zone
     */
    public Vector<String> listeZones()
    {
        Vector<String> ret = new Vector();

        List zones = modele.createQuery("from LOREntities.Zone z order by z.nomZone").list();
        for (Object z : zones)
            if (z!=null) ret.add(((Zone) z).getNomZone());
        modele.flush();

        return ret;
    }
    /**
     * Renvoie la liste des consoles.
     * @param : void
     * @return : un vecteur/liste de resultat de type Console
     */
    public Vector<String> listeConsoles()
    {
        Vector<String> ret = new Vector();

        List consoles = modele.createQuery("from LOREntities.Console c order by c.nomConsole").list();
        for (Object c : consoles)
            if (c!=null) ret.add(((Console) c).getNomConsole());
        modele.flush();

        return ret;
    }

    /**
     * Renvoie la liste des tags.
     * @param : void
     * @return : un vecteur/liste de resultat de type Tags
     */
    public Vector<String> listeTags()
    {
        Vector<String> ret = new Vector();
        
        List tags = modele.createQuery("from LOREntities.Tag t order by t.labelTag").list();
        for (Object t : tags)
            ret.add(((Tag) t).getLabelTag());
        modele.flush();
        
        return ret;
    }
    
    /**
     * Renvoie la liste des pays.
     * @param : void
     * @return : un vecteur/liste de resultat qui contient les noms des pays
     */
    public Vector<String> listePays()
    {
        Vector<String> ret = new Vector();
        
        List pays = modele.createQuery("from LOREntities.Pays p order by p.nomPays").list();
        for (Object p : pays)
            ret.add(((Pays) p).getNomPays());
        modele.flush();
        
        return ret;
    }
    /**
     * Renvoie la liste des villes d'un pays.
     * @param : void
     * @return : un vecteur/liste de resultat qui contient les noms des villes
     */
    public Vector<String> listeVilles(String pays)
    {
        Vector<String> ret = new Vector();
        
        List villes = modele.createQuery(
                "from LOREntities.Ville v where v.pays.nomPays = '" + pays + "' order by v.nomVille"
                ).list();
        for (Object v : villes)
            ret.add(((Ville) v).getNomVille() + " (" + ((Ville) v).getCp() + " )");
        modele.flush();
        
        return ret;
    }

    /**
     * Convertit une chaîne de 1 à 13 chiffres en code barre valides. Si le code barre fait moins de 13 chiffres, il est complété par des 0 à gauche.
     * @param cb le code barre à vérifier.
     * @return un code barre valide.
     * @throws DonneeInvalideException le code barre renseigné n'est pas composé de 1 à 13 chiffres.
     */
    protected final String codeBarreValide(String cb)
            throws DonneeInvalideException
    {
        //si le code barre n'est pas renseigné, il n'y a rien à faire
        if (cb == null || "".equals(cb))
            return cb;

        //on vérifie que l'entrée est légale
        String ret = "";
        if (cb.length() > 13)
            throw new DonneeInvalideException("Veuillez entrer un code barre composé de 13 chiffres");
        else
            try { long test = new Long(cb); }
            catch (NumberFormatException nfe) {
                throw new DonneeInvalideException("Veuillez entrer un code barre composé de 13 chiffres.");
            }

        //si le code barre est trop court, on complète à gauche par des 0.
        int missingCharacters = 13 - cb.length();
        for (int i = 0 ; i < missingCharacters ; i++)
            ret = ret.concat("0");
        return ret.concat(cb);
    }
    /**
     * Renvoie la quantite de vente d'un produit
     * @param : type de produit, ID du produit
     * @return : la quantité du produit demandé en Integer
     */
    private int getSellQuantityProduct(String typeProduit, Integer idProduit)
    {
        int nombreAchat = 0;
        //int resul;
        Query resul = null;
        if ("CONSOLE".equals(normalize(typeProduit))) 
        {
            resul = modele.createQuery("select sum(quantite) from LOREntities.LigneFactureConsole lfc "
                    + "where "
                    + "(lfc.versionConsole IN (select vc.idVersionConsole from LOREntities.VersionConsole vc  where vc.idVersionConsole="+idProduit+")"
                            + " AND lfc.facture IN ( select f.idFacture from LOREntities.Facture f where f.typeFacture='v')"
                            + " )");
        }
        else if ("JEU".equals(normalize(typeProduit))) 
        {
            resul = modele.createQuery("select sum(quantite) from LOREntities.LigneFactureJeu lfj "
                    + "where "
                    + "(lfj.versionJeu IN (select vj.idVersionJeu from LOREntities.VersionJeu vj  where vj.idVersionJeu="+idProduit+")"
                            + " AND lfj.facture IN ( select f.idFacture from LOREntities.Facture f where f.typeFacture='v')"
                            + " )");
        } 
        modele.flush();
        nombreAchat = Integer.valueOf(resul.uniqueResult().toString());
        return nombreAchat;
    }
    /**
     * Renvoie la quantite de stock d'un produit
     * @param : type de produit, ID du produit
     * @return : la quantité du produit demandé en Integer
     */
    private int getStockProduct(String typeProduit, Integer idProduit) throws DonneeInvalideException
    {
        int stock = 0;
        if ("CONSOLE".equals(normalize(typeProduit))) 
        {
            VersionConsole vc = new VersionConsole();
            vc = chercherVersionConsole(idProduit);
            stock = vc.getStock();
        }
        else if ("JEU".equals(normalize(typeProduit))) 
        {
            VersionJeu vj = new VersionJeu();
            vj = chercherVersionJeu(idProduit);
            stock = vj.getStock();
        }  
        modele.flush();
        return stock;
    }
    /**
     * Renvoie le prix de vente d'un produit
     * @param : type de produit, ID du produit
     * @return : le prix du produit demandé en réel
     */
    private float getSellPrixProduct(String typeProduit, Integer idProduit)
    {
        float prixProduit = 0.0f;
        //int resul;
        List resul = null;
        if ("CONSOLE".equals(normalize(typeProduit))) 
        {
            HQLRecherche q = new HQLRecherche("VersionConsole vc");
            q.setSelect("vc.prix");
            q.addCondition("vc.idVersionConsole", idProduit, HQLRecherche.Operateur.EGAL);
            List resultats = modele.createQuery(q.toString()).list();
        
            if (resultats.isEmpty())
                prixProduit = 0;
            else //on suppose qu'il n'y a qu'un seul résultat !
                prixProduit = Float.valueOf(resultats.get(0).toString());          
        }
        else if ("JEU".equals(normalize(typeProduit))) 
        {
            HQLRecherche q = new HQLRecherche("VersionJeu vj");
            q.setSelect("vj.prix");
            q.addCondition("vj.idVersionJeu", idProduit, HQLRecherche.Operateur.EGAL);
            List resultats = modele.createQuery(q.toString()).list();
        
            if (resultats.isEmpty())
                prixProduit = 0;
            else //on suppose qu'il n'y a qu'un seul résultat !
                prixProduit = Float.valueOf(resultats.get(0).toString());  
        } 
        modele.flush();
        return prixProduit;
    }
    /**
     * Renvoie la frequence de vendre d'un produit
     * 
     * Par défault, j'ai pris le choix de prendre en compte que les ventes sur un an
     * 
     * @param : type de produit, ID du produit
     * @return : la fréquence de ventre du produit demandé en Integer
     */
    private float getFrequentSellProduct(String typeProduit, int idProduit)
    {
        
        float frequenceDeVente = 0.0f;
        Integer yearDebutPeriod = 0;

        Integer yearActuel = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
         
        String HQL_QUERY = "select sum(lfc.quantite) from LigneFactureConsole lfc  "
                         + "where (lfc.versionConsole IN (select vc.idVersionConsole from VersionConsole vc  where vc.idVersionConsole=2) "
                           + "AND lfc.facture IN ( select f.idFacture from Facture f where f.typeFacture LIKE '%v%' "
                                                + "AND year(f.dateFacture) BETWEEN :yearDebutPeriod AND :yearActuel ))";                       

        Query query = modele.createQuery(HQL_QUERY)
                      .setParameter("yearDebutPeriod", yearDebutPeriod)
                      .setParameter("yearActuel",yearActuel);
        int nombreVente = Integer.valueOf(query.uniqueResult().toString());
        modele.flush();
        
        return frequenceDeVente = nombreVente/12;
    }
    /**
     * Renvoie la cote d'un produit
     * 
     * @param : type de produit, ID du produit
     * @return : le cote du produit demandé en Float
     */
    public float getCoteProduct(String typeProduit, int idProduit)
    {
        float coteProduit = 0.0f;
        if ("CONSOLE".equals(normalize(typeProduit))) 
        {
            String HQL_QUERY = "select pc.coteConsole from LOREntities.PromoConsole pc where pc.versionConsole IN (select vc.idVersionConsole from VersionConsole vc where vc.idVersionConsole= :idProduit)";
            Query query = modele.createQuery(HQL_QUERY).setParameter("idProduit", idProduit);
            if (query.list().isEmpty()) { coteProduit = 0f; } else { coteProduit = Float.valueOf(query.list().get(query.list().size()-1).toString()); }
            modele.flush();
        }
        else if ("JEU".equals(normalize(typeProduit))) 
        {
        modele.flush();
            String HQL_QUERY = "select pj.coteJeu from LOREntities.PromoJeu pj where pj.versionJeu IN (select vj.idVersionJeu from VersionJeu vj where vj.idVersionJeu= :idProduit)";
            Query query = modele.createQuery(HQL_QUERY).setParameter("idProduit", idProduit);
            if (query.list().isEmpty()) { coteProduit = 0f; } else { coteProduit = Float.valueOf(query.list().get(query.list().size()-1).toString()); }
            modele.flush();
         }
        return coteProduit;
    }    
   
    /**
     * Calcule et mis a jour dans la BDD le cote d'un produit pour Promotion
     * @param type de produit, ID du produit
     */
    public void calculCote(String typeProduit, Integer idProduit) throws EnregistrementInexistantException, DonneeInvalideException
    {
        float cote, prixPromo; 
        

        //on vérifie que le jeu existe déjà !
        if ((chercherVersionJeu(idProduit) == null) && (chercherVersionConsole(idProduit) == null))
            throw new EnregistrementInexistantException("Le produit recherché n'existe pas !!!");
        else
        {
            // Recuperer la fréquence de vente d'un produit sur une période donnée
            Float frequentDeVente = getFrequentSellProduct(typeProduit, idProduit);
            // Recuperer le nombre de vente
            int nbreVente = getSellQuantityProduct(typeProduit, idProduit);
            // Recuperer le stock actuel
            int stockActuel = getStockProduct(typeProduit, idProduit);
            //Calculer cote
            cote = (float) Math.round(((frequentDeVente/stockActuel)*100) + Float.valueOf(nbreVente/10)) / 100;
            prixPromo = (float) Math.round(( getSellPrixProduct(typeProduit, idProduit) * cote * 100 )) / 100;
        }
        // Enregistrement le calcul de cote dans la BDD
        if ("CONSOLE".equals(normalize(typeProduit)))
        {
            //Remplissage des cote et prix Promo
            PromoConsole pc = new PromoConsole();
            pc.setVersionConsole(chercherVersionConsole(idProduit));
            pc.setCoteConsole(cote);
            pc.setPrixPromoConsole(prixPromo);

            //création de l'enregistrement dans la table PromoConsole
            modele.beginTransaction();
            modele.save(pc);
            modele.getTransaction().commit();
            modele.flush();
        }
        else if ("JEU".equals(normalize(typeProduit)))
        {
            //Remplissage des cote et prix Promo
            PromoJeu pj = new PromoJeu();
            pj.setVersionJeu(chercherVersionJeu(idProduit));
            pj.setCoteJeu(cote);
            pj.setPrixPromoJeu(prixPromo);

            //création de l'enregistrement dans la table PromoJeu
            modele.beginTransaction();
            modele.save(pj);
            modele.getTransaction().commit();
            modele.flush();
        }
        //return cote;
    }
    /**
     * Calcule et mis a jour dans la BDD le cote d'un produit pour Promotion à partir d'un prix donné
     * @param type de produit
     * @param id de produit
     * @param prix en promotion donné de produit
     * @return cote en float
     */
    public float calculCoteAPartirPrix(String typeProduit, Integer idProduit, Float prixPromo) throws EnregistrementInexistantException, DonneeInvalideException
    {
        
        float cote = (float) Math.round(prixPromo/getSellPrixProduct(typeProduit, idProduit))*100 / 100;
        return cote;
    }
    /**
     * Transforme un vecteur de tags en un vecteur de strings pour l'affichage.
     * @param decrires un objet de type Decrire dans une colection,il est utilisé pour l'intération
     * @param separator est utilisé pour l'iterateur
     * @return return un String re resultat d'itération voir la classe Decrire (See Also)
     */
    protected final String decriresToString(Set<Decrire> decrires, char separator)
    {
        Vector <String> vect = new Vector<String>();
        for (Decrire d : decrires)
            vect.add(((Tag) this.modele.load(Tag.class, d.getId().getIdTag()))
                    .getLabelTag());
        return vectorToString(vect, separator);
    }
    protected final Vector<String> stringToVector(String s, char separator)
    {
        Vector<String> ret = new Vector();
        String[] tab = s.split(Character.toString(separator));
        for (String str : tab)
            if (!"".equals(str)) //Cela arrive si le paramètre s est une chaîne vide.
                ret.add(str);
        return ret;
    }
    protected final String vectorToString(Vector<String> v, char separator)
    {
        String ret = "";
        for (String s : v)//on ajoute la chaîne suivie d'un séparateur.
            ret = ret.concat(s + separator);
        //Par exemple, le vecteur {"mario", "plateforme", "3D"} donne ici ret = "mario,plateforme,3D,"
        if (!"".equals(ret)) //si le vecteur n'était pas vide,
            //on enlève le dernier séparateur (dans notre exemple, la dernière virgule)
            ret = ret.substring(0, ret.length() - 1);
        return ret;
    }
    protected final String normalize(String s)
    {
        s = s.replaceAll(" ", "");
        s = s.replaceAll("é", "e");
        s = s.replaceAll("è", "e");
        s = s.replaceAll("ê", "e");
        s = s.replaceAll("à", "a");
        s = s.replaceAll("î", "i");
        s = s.replaceAll("ù", "u");
        s = s.toUpperCase(new Locale("FRENCH", "FRANCE"));
        return s;
    }  
}

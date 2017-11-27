package editeur;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Editor extends JFrame implements ActionListener, MouseListener{
   private JTextArea tA;
   private JMenuItem MI_NEW, MI_OPEN, MI_SAVE, MI_SAVEAS, MI_EXIT;
   private JMenu M_EDIT;
   private JMenuItem MI_CUT, MI_COPY, MI_PASTE, MI_ERASE, MI_SLCTALL;
   private JMenuItem MI_CMT, MI_CR, MI_ABOUT;
   private File fichierCourant = null;

   public Editor() {
      super("Éditeur");    
      tA = new JTextArea();     
      JMenuBar barre = new JMenuBar();
      
      // Menu 1: Fichier
      JMenu M_FILE = new JMenu("Fichier");
      MI_NEW = new JMenuItem("Nouveau");
      MI_NEW.addActionListener(this);
      M_FILE.add(MI_NEW);
      MI_OPEN = new JMenuItem("Ouvrir...");
      MI_OPEN.addActionListener( this);
      M_FILE.add(MI_OPEN);
      MI_SAVE = new JMenuItem("Enregistrer");
      MI_SAVE.addActionListener(this);
      M_FILE.add(MI_SAVE);
      MI_SAVEAS = new JMenuItem("Enregistrer sous...");
      MI_SAVEAS.addActionListener(this);
      M_FILE.add(MI_SAVEAS);
      M_FILE.addSeparator();
      MI_EXIT = new JMenuItem("Quitter");
      MI_EXIT.addActionListener(this);
      M_FILE.add(MI_EXIT);
      barre.add(M_FILE);

      // Menu 2: Edition
      M_EDIT = new JMenu("Édition");
      
     /* M_EDIT.addMouseListener(
        new MouseAdapter() {//classe anonyme
            public void mousePressed(MouseEvent e) {
               updateMenuOptions();
            }
         }
      );*/
      M_EDIT.addMouseListener(this);
      MI_CUT = new JMenuItem("Couper");
      MI_CUT.addActionListener(this);
      M_EDIT.add(MI_CUT);
      MI_COPY = new JMenuItem("Copier");
      MI_COPY.addActionListener(this);
      M_EDIT.add(MI_COPY);
      MI_PASTE = new JMenuItem("Coller");
      MI_PASTE.addActionListener(this);
      M_EDIT.add(MI_PASTE);
      MI_ERASE = new JMenuItem("Effacer");
      MI_ERASE.addActionListener(this);
      M_EDIT.add(MI_ERASE);
      M_EDIT.addSeparator();
      MI_SLCTALL = new JMenuItem("Selectionner tout");
      MI_SLCTALL.addActionListener(this);
      M_EDIT.add(MI_SLCTALL);
      barre.add(M_EDIT);

      // Menu 3 : À Propos
      JMenu M_INFO = new JMenu("À Propos");
      MI_CMT = new JMenuItem("Commentaires");
      MI_CMT.addActionListener(this);
      M_INFO.add(MI_CMT);
      MI_CR = new JMenuItem("Droit d'auteur");
      MI_CR.addActionListener(this);
      M_INFO.add(MI_CR);
      MI_ABOUT = new JMenuItem("Version");
      MI_ABOUT.addActionListener(this);
      M_INFO.add(MI_ABOUT);
      barre.add(M_INFO);

      this.setJMenuBar(barre);
      JScrollPane jsp = new JScrollPane(tA);
      Container c = getContentPane();
      c.setLayout( new BorderLayout() );
      c.add(jsp, BorderLayout.CENTER);
      setSize(600, 500);
      setLocation(200, 100);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   private void updateMenuOptions() {
      if (tA.getSelectedText() == null) {
         MI_CUT.setEnabled(false);
         MI_COPY.setEnabled(false);
         MI_ERASE.setEnabled(false);
      }
      else {
         MI_CUT.setEnabled(true);
         MI_COPY.setEnabled(true);
         MI_ERASE.setEnabled(true);
      }
   }

   private void nouveauFichier() {
      fichierCourant = null;
      tA.setText("");
   }

   private void ouvrirFichier() {
      JFileChooser jfc = new JFileChooser();

      int resultat = jfc.showOpenDialog(this);
      if (resultat == JFileChooser.APPROVE_OPTION) {
         fichierCourant = jfc.getSelectedFile();
         lireFichier(fichierCourant);
      }
      else {
         fichierCourant = null;
      }
   }

   private void enregistrerFichier() {
      if (fichierCourant == null) {
         afficheMessage("Aucun emplacement n'a été spécifié, un fichier nommé \"Nouveau Document Text.txt\" \nsera créé dans le répertoire du projet.", "Information");
         ecrireFichier( new File("Nouveau Document Texte.txt") );
      }
      else
         ecrireFichier(fichierCourant);
   }

   private void enregistrerFichierSous() {
      JFileChooser jfc = new JFileChooser();
      jfc.setDialogTitle("Enregistrer sous...");
      jfc.setApproveButtonText("Enregistrer");
    
      int resultat = jfc.showOpenDialog(this);
      if (resultat == JFileChooser.APPROVE_OPTION)
         ecrireFichier(jfc.getSelectedFile());
   }

   private void lireFichier(File fichier) {
      String ligne;
      StringBuffer buf = new StringBuffer();
      try {
         tA.setText("");
         BufferedReader in = new BufferedReader(
               new FileReader(fichier) );
         while ((ligne = in.readLine()) != null)
            buf.append(ligne + (char) '\n');
         tA.setText(buf.toString());
      }
      
      catch(FileNotFoundException e) {}
      catch(IOException e) {}
   }

   private void ecrireFichier(File fichier) {
      try {
         BufferedWriter out = new BufferedWriter(
               new FileWriter(fichier) );
         out.write(tA.getText());
         out.close();
      }
      catch(FileNotFoundException e) {}
      catch(IOException e) {}
   }
   
   private void afficheMessage(String message, String titre) {
      JOptionPane.showMessageDialog(null, message,
            titre, JOptionPane.INFORMATION_MESSAGE);
   }

   public String getComments() {
      return "Éditeur de texte java rudimentaire";
   }
   
   public String getCR() {
      return "auteur: FB \ndate : 05/11/2017";
   }
   
   public String getAbout() {
      return "Version 1.0";
   }

      public void actionPerformed(ActionEvent e) {
         if (MI_NEW == e.getSource())
            nouveauFichier();
            
         if (MI_OPEN == e.getSource())
            ouvrirFichier();
            
         if (MI_SAVE == e.getSource())
            enregistrerFichier();
            
         if (MI_SAVEAS == e.getSource())
            enregistrerFichierSous();
            
         if (MI_EXIT == e.getSource())
           //System.exit(0);
             dispose();
            
         if (M_EDIT == e.getSource())
            updateMenuOptions();
            
         if ( "Couper" == e.getActionCommand() )
            tA.cut();
            
         if ( "Copier" == e.getActionCommand() )
            tA.copy();
            
         if ( "Coller" == e.getActionCommand() )
            tA.paste();
            
         if ( "Effacer" == e.getActionCommand() )
            tA.replaceSelection("");
            
         if ( "Selectionner tout" == e.getActionCommand() )
             tA.selectAll();
                               
         if (MI_CMT == e.getSource())
            afficheMessage(getComments(), "Commentaires");
            
         if (MI_CR == e.getSource())
            afficheMessage(getCR(), "Droit d'auteur");
            
         if (MI_ABOUT == e.getSource())
            afficheMessage(getAbout(), "À Propos");
      }
      public void mousePressed(MouseEvent e) {
               updateMenuOptions();
            }
      //inconvénient implémentation d'une interface (toutes les méthodes doivent être redéfinies) ==>classe anonyme
      public void mouseReleased(MouseEvent ev) {}
      public void mouseEntered(MouseEvent ev) {}
      public void mouseExited(MouseEvent ev) {}
      public void mouseClicked(MouseEvent ev){}

}
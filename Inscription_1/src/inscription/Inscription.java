/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscription;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author faycal
 */
public class Inscription extends JFrame implements ActionListener{
    JLabel LA_NOM=new JLabel("Nom");
    JLabel LA_PRENOM=new JLabel("Prénom");
    JLabel LA_APAYER=new JLabel("A Payer");
    JTextField TF_NOM=new JTextField(null,10);
    JTextField TF_PRENOM=new JTextField(null,10);
    JTextField TF_APAYER=new JTextField(null,5);
    /*ButtonGroup CIVILITE = new ButtonGroup();
    JRadioButton MR = new JRadioButton("Monsieur");
    JRadioButton MME = new JRadioButton("Madame");*/
    JComboBox CHOIX_TARIF;
    JButton B_RECAP=new JButton("Récapituler");
    protected static final double PRIX_BASE=10;
    protected static final double TVA=20;
    String civilite,nom, prenom;
    JOptionPane pane;
    File fichier=new File("inscription.csv");
    Vector tabclient;
    public Inscription(){
        super("Inscription");
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        Container panneau=getContentPane();
        panneau.setLayout(new BorderLayout());
        tabclient=new Vector();
        Vector tarifs= new Vector();
        tarifs.add("Adulte");
        tarifs.add("Enfant");
        tarifs.add("Etudiant");
        CHOIX_TARIF=new JComboBox(tarifs);
        CHOIX_TARIF.addActionListener(this);
       /* CIVILITE.add(MR);
        MR.addActionListener(this);
        MME.addActionListener(this);
        CIVILITE.add(MME);
        JPanel ligne1 =new JPanel();
        ligne1.add(MR);
        ligne1.add(MME);*/
        JPanel ligne2 = new JPanel();
        ligne2.add(LA_PRENOM);
        ligne2.add(TF_PRENOM);
        ligne2.add(LA_NOM);
        ligne2.add(TF_NOM);
        ligne2.add(CHOIX_TARIF);
        ligne2.add(LA_APAYER);
        ligne2.add(TF_APAYER);
        
        JPanel ligne3 = new JPanel();
        B_RECAP.addActionListener(this);
        ligne3.add(B_RECAP);
     //   panneau.add(ligne1,BorderLayout.NORTH);
        panneau.add(ligne2,BorderLayout.CENTER);
        panneau.add(ligne3,BorderLayout.SOUTH);
        setContentPane(panneau);
        setVisible(true);
       // this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    
}
   /* public double calculPrix(int tarif){
        double apayer=0;
        switch(tarif){
            case 0 : apayer=PRIX_BASE *(1+TVA/100);
                break;
            case 1 : apayer=(PRIX_BASE *(1+TVA/100))/2;
            break;
            case 2 : apayer=(PRIX_BASE * 0.8) *(1+TVA/100);
            break;
        }
        return apayer;
    }*/
    private int afficheMessage(String message, String titre) {
      pane=new JOptionPane();
     return pane.showConfirmDialog(null, message,titre, JOptionPane.YES_NO_OPTION);
          }
     private void ecrireFichier(File fichier) {
      try {
         BufferedWriter out = new BufferedWriter(
               new FileWriter(fichier,true) );
         out.write(TF_NOM.getText()+","+TF_PRENOM.getText()+","+CHOIX_TARIF.getSelectedItem()+","+TF_APAYER.getText()+"\n");
         out.close();
      }
      catch(FileNotFoundException e) {}
      catch(IOException e) {}
   }
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==CHOIX_TARIF){
             
        switch(CHOIX_TARIF.getSelectedIndex()){
            case 0 : tabclient.add(new Adulte(TF_NOM.getText()));
            TF_APAYER.setText("Adulte");
                break;
            case 1 : tabclient.add(new Enfant(TF_NOM.getText()));
            TF_APAYER.setText("Enfant");
            break;
            case 2 : tabclient.add(new Etudiant(TF_NOM.getText()));
            TF_APAYER.setText("Etudiant");
            break;
    }
    }
   /* if(e.getSource()==MR)civilite="Monsieur";
    if(e.getSource()==MME)civilite="Madame";*/
    if(e.getSource()==B_RECAP){    
        
       if((TF_PRENOM.getText()).isEmpty()||(TF_NOM.getText()).isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Saisie Incomplète","Saisie Incomplète", JOptionPane.ERROR_MESSAGE);
        }
        else{
          
           String message = "Nom : "+((Client)tabclient.lastElement()).getNom()+"\n"+"Prénom : "+TF_PRENOM.getText()+"\n"+"Tarif : "+CHOIX_TARIF.getSelectedItem()+"\n"+"A payer : "+((Client)(tabclient.lastElement())).calculPrix()+"\n"+"Confirmer ? ";
           afficheMessage(message, "Récapitulatif Inscription");
          /* if (afficheMessage(message, "Récapitulatif Inscription")==0){
               ecrireFichier(fichier);
               TF_NOM.setText("");
               TF_PRENOM.setText("");
               CHOIX_TARIF.setSelectedIndex(0);
               TF_APAYER.setText("");*/
               
           }
        }
    }
    
    
    
    
    }




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise_interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author faycal
 */
public class IG extends JFrame implements ActionListener {
    ArrayList liste =new ArrayList();
    JComboBox maliste ;
    JScrollPane ascenseur=new JScrollPane(maliste);
    JLabel heures=new JLabel();
    JLabel nom=new JLabel("NOM");
    JTextField TF_NOM=new JTextField(10);
    JLabel ventes=new JLabel();
    JLabel salaire=new JLabel();
    JTextField texte1=new JTextField(10);
    JTextField texte2=new JTextField(10);
    JButton B_CREER=new JButton("Récapituler");
    JOptionPane pane;
    Vector tabemploye;
    public IG(){
        super("calcul salaire");
        this.setSize(800,400);
        this.setLocationRelativeTo(null);
        Container panneau =getContentPane();
        panneau.setLayout(new BorderLayout());
        B_CREER.setVisible(false);
        B_CREER.addActionListener(this);
        tabemploye=new Vector();
        JPanel ligne1 =new JPanel();
        JPanel ligne2 =new JPanel();
        JPanel ligne3 =new JPanel();
        liste.add(new String("Fixe"));
        liste.add(new String("horaire"));
        liste.add(new String("commercial"));
        maliste=new JComboBox(liste.toArray());
        maliste.addActionListener(this);
        ligne1.add(nom);
        ligne1.add(TF_NOM);
        JLabel label1=new JLabel("Choisissez un type d'employé dans la liste");
        ligne1.add(label1);
        ligne1.add(maliste);
        heures.setVisible(false);
        texte1.setVisible(false);
        ventes.setVisible(false);
        texte2.setVisible(false);
        ligne2.add(heures);
        ligne2.add(texte1);
        ligne2.add(ventes);
        ligne2.add(texte2);
        ligne2.add(B_CREER);
        ligne3.add(salaire);
        panneau.add(ligne1,BorderLayout.NORTH);
        panneau.add(ligne2,BorderLayout.CENTER);
        panneau.add(ligne3,BorderLayout.SOUTH);
        setContentPane(panneau);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    private int afficheMessage(String message, String titre) {
      pane=new JOptionPane();
     return pane.showConfirmDialog(null, message,titre, JOptionPane.YES_NO_OPTION);
          }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==maliste){
            switch(maliste.getSelectedIndex()){
                case 0 : 
                break;
                case 1 : 
                    heures.setText("Nombre d'heures");
                    heures.setVisible(true);
                    texte1.setVisible(true);
                    
                    break;
                case 2 :
                    heures.setText("Nombre d'heures");
                    heures.setVisible(true);
                    texte1.setVisible(true);
                    ventes.setText("Montant des ventes");
                    ventes.setVisible(true);
                    texte2.setVisible(true);
                    break;
            }
            B_CREER.setVisible(true);
        }
        try{
        if(e.getSource()==B_CREER){
            switch(maliste.getSelectedIndex()){
                case 0 : tabemploye.add(new Fixe(TF_NOM.getText()));
                break;
                case 1 : tabemploye.add(new Horaire(TF_NOM.getText(),Double.parseDouble(texte1.getText())));
                break;
                case 2 : tabemploye.add(new Commercial(TF_NOM.getText(),Double.parseDouble(texte1.getText()),Double.parseDouble(texte2.getText())));
                break;
            }
            String message = "Numero " +((Employe)tabemploye.lastElement()).getNum()+"\n"+"Nom : "+((Employe)tabemploye.lastElement()).getNom()+"\n"+"Salaire " +((Employe)tabemploye.lastElement()).laPaye()+"\n"+"Confirmer ? ";
            if (afficheMessage(message, "Récapitulatif")==0){
                heures.setVisible(false);
                texte1.setVisible(false);
                texte1.setText("");
                ventes.setVisible(false);
                texte2.setVisible(false);
                texte2.setText("");
                TF_NOM.setText("");
                maliste.setSelectedIndex(-1);
            }
            
        }
            
            
        }
        catch(NumberFormatException evt){salaire.setText("erreur de saisie");}
    
}
    
}

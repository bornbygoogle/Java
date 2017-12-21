/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affcourriercolis;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author p0607615
 */
public class EnvoiInterface extends JFrame implements ActionListener
{
    ArrayList liste =new ArrayList();
    JComboBox maliste;
    JLabel poids=new JLabel();    
    JTextField texte_dest=new JTextField(30);
    JTextField texte_poids = new JTextField(10);
    private JRadioButton choix1, choix2;
    private JButton B_Recap=new JButton("Récapituler Envoi");    
    private int flag;
    private JOptionPane pane;
    private ButtonGroup bg = new ButtonGroup();
    Vector tabcourrier;
    
    public EnvoiInterface()
    {
        super("envoi de courrier");
        this.setSize(800,400);
        this.setLocationRelativeTo(null);
        Container panneau = getContentPane();
        panneau.setLayout(new BorderLayout());
        
        Vector tabcourrier = new Vector();
        JPanel ligne1 =new JPanel();
        JPanel ligne2 =new JPanel();
        JPanel ligne3 =new JPanel();
        
        JLabel label1=new JLabel("Express : ");
        ligne1.add(label1);
        choix1 = new JRadioButton("Oui");
        choix1.setActionCommand("Oui");
        choix2 = new JRadioButton("Non");
        choix2.setActionCommand("Non");

        bg.add(choix1);
        bg.add(choix2);
        ligne1.add(choix1);
        ligne1.add(choix2);
     
        liste.add(new String("Lettre"));
        liste.add(new String("Colis"));
        maliste=new JComboBox(liste.toArray());
        maliste.addActionListener(this);       
        poids.setText("POIDS en g :");
        poids.setVisible(false);
        texte_poids.setVisible(false);
        ligne2.add(maliste);
        JLabel label2=new JLabel("Adresse du destinataire : ");
        ligne2.add(label2);
        ligne2.add(texte_dest);
        ligne2.add(poids);
        ligne2.add(texte_poids);
        
        B_Recap.addActionListener(this);
        ligne3.add(B_Recap);
        
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
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==maliste){
            switch(maliste.getSelectedIndex()){
                case 0 : 
                break;
                case 1 : 
                    //heures.setText("Nombre d'heures");
                    poids.setVisible(true);
                    texte_poids.setVisible(true);
                    
                    break;
            }
            //B_CREER.setVisible(true);
        }
        if(e.getSource()==B_Recap)
        {
            if((maliste.getSelectedIndex()==-1)||(bg.getSelection()==null)||(texte_dest.getText().isEmpty()))
            {
                JOptionPane.showMessageDialog(null, "Saisie Incomplète","Saisie Incomplète", JOptionPane.ERROR_MESSAGE);
            }
            else{
                switch(maliste.getSelectedIndex())
                {
                    case 0 : 
                        if (bg.getSelection().getActionCommand()=="Oui") { tabcourrier.add(new Lettre(texte_dest.getText(),true)); }
                        else { tabcourrier.add(new Lettre(texte_dest.getText(),false)); }
                        break;
                    case 1 : 
                        if (bg.getSelection().getActionCommand()=="Oui") { tabcourrier.add(new Colis(texte_dest.getText(),true,Double.parseDouble(texte_poids.getText()))); }
                        else { tabcourrier.add(new Colis(texte_dest.getText(),false,Double.parseDouble(texte_poids.getText()))); }
                    break;
                    default: break;
                }
                        String message = "Type : "+ maliste.getSelectedItem()+"\n"
                            +"Express : "+bg.getSelection().getActionCommand()+"\n"
                            +"Adresse : "+texte_dest.getText()+"\n"
                            +"Confirmer ?"
                    ;
           //afficheMessage(message, "Récapitulatif");
           if (afficheMessage(message, "Récapitulatif")==0){
               String message2 = "Numéro : "+((Courrier)tabcourrier.lastElement()).getNum()+"\n"
                                +"Prix : "+((Courrier)tabcourrier.lastElement()).calculPrix()+"\n"           
                       ;
               poids.setVisible(false);
               texte_poids.setVisible(false);
               texte_dest.setText("");
               maliste.setSelectedIndex(-1);;
               JOptionPane.showMessageDialog(null, message2,"Message", JOptionPane.INFORMATION_MESSAGE);
           }
           }

                
           //String message = "Type : "+tabcourrier.lastElement().getClass().getName()+"\n"/*+"Prénom : "+TF_PRENOM.getText()+"\n"+"Tarif : "+CHOIX_TARIF.getSelectedItem()+"\n"+"A payer : "+((Client)(tabclient.lastElement())).calculPrix()+"\n"+"Confirmer ? "*/;

               /*ecrireFichier(fichier);
               TF_NOM.setText("");
               TF_PRENOM.setText("");
               CHOIX_TARIF.setSelectedIndex(0);
               TF_APAYER.setText("");*/
            }
        }
    }

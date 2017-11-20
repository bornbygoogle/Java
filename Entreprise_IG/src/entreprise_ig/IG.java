/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise_ig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.swing.event.ListSelectionListener;
/**
 *
 * @author faycal
 */
public class IG extends JFrame implements ActionListener,ListSelectionListener {
    ArrayList liste =new ArrayList();
    int flag =0;
    JList maliste ;
    JScrollPane ascenseur=new JScrollPane(maliste);
    JLabel heures=new JLabel();
    JLabel ventes=new JLabel();
    JLabel salaire=new JLabel();
    JTextField texte1=new JTextField(10);
    JTextField texte2=new JTextField(10);
    JButton calcul=new JButton("Calculer");
    public IG(){
        super("calcul salaire");
        this.setSize(800,400);
        this.setLocationRelativeTo(null);
        Container panneau =getContentPane();
        panneau.setLayout(new BorderLayout());
        calcul.setVisible(false);
        calcul.addActionListener(this);
        
        JPanel ligne1 =new JPanel();
        JPanel ligne2 =new JPanel();
        JPanel ligne3 =new JPanel();
        liste.add(new String("Fixe"));
        liste.add(new String("horaire"));
        liste.add(new String("commercial"));
        maliste=new JList(liste.toArray());
        maliste.addListSelectionListener(this);
        maliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        ligne2.add(calcul);
        ligne3.add(salaire);
        panneau.add(ligne1,BorderLayout.NORTH);
        panneau.add(ligne2,BorderLayout.CENTER);
        panneau.add(ligne3,BorderLayout.SOUTH);
        setContentPane(panneau);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void valueChanged(ListSelectionEvent evt){
      //  salaire.setText(((Integer)maliste.getSelectedIndex()).toString());
       if(maliste.getSelectedIndex()==0){salaire.setText("Salaire : 1500 euros");}
       if(maliste.getSelectedIndex()==1){
            heures.setText("Nombre d'heures");
            heures.setVisible(true);
            texte1.setVisible(true);
            calcul.setVisible(true);
            flag=1; 
        }
        if(maliste.getSelectedIndex()==2){
            heures.setText("Nombre d'heures");
            heures.setVisible(true);
            texte1.setVisible(true);
            ventes.setText("Montant des ventes");
            ventes.setVisible(true);
            texte2.setVisible(true);
            calcul.setVisible(true);
            flag=2;
        }
        }
    public void actionPerformed(ActionEvent e){
        try{
        double a = Double.parseDouble(texte1.getText());
        if(e.getSource()==calcul && flag==1)salaire.setText("Salaire : " + String.valueOf(a*50.12)+ " Euros");
        if(e.getSource()==calcul && flag==2){
            double b=Double.parseDouble(texte2.getText());
            salaire.setText("Salaire : " + String.valueOf(a*50.12+b*0.1)+ " Euros");
        }
        }
        catch(NumberFormatException evt){salaire.setText("erreur de saisie");}
    
}
}

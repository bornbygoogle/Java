/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainticket;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author p0607615
 */
public class TrainTicket extends JFrame implements ActionListener,ItemListener
{
    private JButton button1;
    private JTextField txtGaucheHaut,txtDroiteHaut,txtCentreDroite;
    private JComboBox clientList;
    private JOptionPane jop;
    private int typeClient=0;
    private File fichierCourant = new File("inscription.csv");    
    
    public TrainTicket()
    {
        super("Inscription");
        
        setSize(400, 200);
        setLocation(200, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Déclaration des panneaux
        Container panGlobal = getContentPane();
        panGlobal.setLayout(new BorderLayout());
        JPanel panHaut = new JPanel(new BorderLayout());
        panHaut.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JPanel panGaucheHaut = new JPanel(new BorderLayout());
        panGaucheHaut.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        JPanel panDroiteHaut = new JPanel(new BorderLayout());
        panDroiteHaut.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));        
        JPanel panCentre = new JPanel(new BorderLayout());
        panCentre.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JPanel panCentreGauche = new JPanel(new BorderLayout());
        panCentreGauche.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 20));
        JPanel panCentreDroite = new JPanel(new BorderLayout());
        panCentreDroite.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 20));        
        JPanel panBas = new JPanel(new FlowLayout());
        panBas.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        // Formation de la panneau du haut
        JLabel lblGaucheHaut = new JLabel("Prénom : ", JLabel.CENTER);
        txtGaucheHaut = new JTextField(10);
        panGaucheHaut.add(lblGaucheHaut, BorderLayout.WEST);
        panGaucheHaut.add(txtGaucheHaut, BorderLayout.EAST);     
        JLabel lblDroiteHaut = new JLabel("Nom : ", JLabel.CENTER);
        txtDroiteHaut = new JTextField(10);
        panDroiteHaut.add(lblDroiteHaut, BorderLayout.WEST);
        panDroiteHaut.add(txtDroiteHaut, BorderLayout.EAST);     
        panHaut.add(panGaucheHaut, BorderLayout.WEST);
        panHaut.add(panDroiteHaut, BorderLayout.EAST);
        
        // Formation de la panneau centre
        String[] clientStrings = { "adulte", "enfant", "etudiant" }; // Déclaration array client
        clientList = new JComboBox(clientStrings);
        clientList.setSelectedIndex(0);
        clientList.addItemListener(this);
        clientList.addActionListener(this);
        panCentreGauche.add(clientList, BorderLayout.WEST);
        JLabel lblCentreDroite = new JLabel("A Payer : ", JLabel.CENTER);
        txtCentreDroite = new JTextField(20);
        txtCentreDroite.setText(String.valueOf(calculPrix(typeClient)));
        panCentreDroite.add(lblCentreDroite, BorderLayout.WEST);
        panCentreDroite.add(txtCentreDroite, BorderLayout.EAST);     
        panCentre.add(panCentreGauche, BorderLayout.WEST);
        panCentre.add(panCentreDroite, BorderLayout.EAST);        
        
        // Formation de la panneau Bas
        button1 = new JButton("Récapituler");
        button1.addActionListener(this);
        panBas.add(button1);
        
        panGlobal.add(panHaut, BorderLayout.NORTH);
        panGlobal.add(panCentre, BorderLayout.CENTER);
        panGlobal.add(panBas, BorderLayout.SOUTH);
        
        this.setContentPane(panGlobal);
        this.pack();
    }

    public void itemStateChanged(ItemEvent e) 
    {
        typeClient = clientList.getSelectedIndex();
        String prix = String.valueOf(calculPrix(typeClient));
        this.txtCentreDroite.setText(prix);
    }
    
    private double calculPrix(Integer typeClient)
    {
        double prixHT = 10,prix=0;
        switch (typeClient)
        {
            case 0 : prix = prixHT * 1.2;
                break;
            case 1 : prix = (prixHT/2) * 1.2;
                break;
            case 2 : prix = (prixHT*0.8) * 1.2;
                break;
        }
        return prix;
    }

    private void nouveauFichier() { fichierCourant = null; }
    
    private void ecrireFichier(File fichier, boolean option) 
    {
        String ligne,content="";
        try {
            BufferedWriter out;
            if (!option)
            {
                out = new BufferedWriter(new FileWriter(fichier) );
            }
            else
            {
                out = new BufferedWriter(new FileWriter(fichier, true ));
            }
            String textSave = "Nom : "+ txtDroiteHaut.getText()
                                 +", Prénom : "+ txtGaucheHaut.getText()
                                 +", Tarif : "+ clientList.getSelectedItem()
                                 +", A payer : "+ txtCentreDroite.getText()
                                 +"\n";
            if (option)
            {
                out.write(textSave);
            }
            else
            {
                out.append(textSave);
            }
            JOptionPane.showMessageDialog(null,
                    "Enregistré !",
                    "Enregistré !",
                    JOptionPane.INFORMATION_MESSAGE);
            out.close();
            txtDroiteHaut.setText("");
            txtGaucheHaut.setText("");
            clientList.setSelectedIndex(0);
        }
        catch(FileNotFoundException e) {}
        catch(IOException e) {}
    }    

    private void enregistrerFichier() 
    {
        if (!(fichierCourant.exists())) 
        {
            ecrireFichier(fichierCourant, false); //Créer un nouveau fichier
        }
        else  ecrireFichier(fichierCourant, true); // Ajouter au fichier existant
   }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Récapituler" )
        {
            if (!(txtDroiteHaut.getText().isEmpty()) && !(txtGaucheHaut.getText().isEmpty()))
                    {
            String textConfirm = "Nom : "+ txtDroiteHaut.getText()
                                 +"\n Prénom : "+ txtGaucheHaut.getText()
                                 +"\n Tarif : "+ clientList.getSelectedItem()
                                 +"\n A payer : "+ txtCentreDroite.getText()
                                 +"\n Confirmer ?"
                                 ;
            jop = new JOptionPane();    	
            int option = jop.showConfirmDialog(null, 
                textConfirm, 
                "Récapitulatif Inscription", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
                
                if(option == JOptionPane.OK_OPTION)
                {
                    enregistrerFichier();
                }
                else 
                {
                    System.out.println("Click NOn !");
                }
                    }
                    else
                {
            JOptionPane.showMessageDialog(null,
                    "Saisie Incomplète",
                    "Saisie Incomplète",
                    JOptionPane.ERROR_MESSAGE);
        }
        }

    }
}


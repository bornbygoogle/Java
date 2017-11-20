/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textediteur;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author bornbygoogle
 */
public class TextEditorFenetre extends JFrame
{
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemNouveau, menuItemOuvrir, menuItemEnregistrer, menuItemEnregistrerSous, menuItemQuitter, menuItemColler, menuItemEffacer, menuItemSelectionnerTout, menuItemCouper, menuItemCopier, menuItemCommentaires, menuItemDroitAuteur, menuItemVersions;
    JTextArea TextZone;
        
    public TextEditorFenetre()
    {
        super("Éditeur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                
        this.setSize(500,500);
        this.setLocationRelativeTo(null);// équivalent à this.setLocation(500,250);
        
        //Création du menu bar
        menuBar = new JMenuBar();

        //1er menu.
        menu = new JMenu("Fichier");
        menuBar.add(menu);
        // Submenu 1er menu
        menuItemNouveau = new JMenuItem("Nouveau"/*,KeyEvent.VK_T*/);
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        //menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(menuItemNouveau);
        
        menuItemOuvrir = new JMenuItem("Ouvrir ...");
        menu.add(menuItemOuvrir);
        
        menuItemEnregistrer = new JMenuItem("Enregistrer ...");
        menu.add(menuItemEnregistrer);
        
        menuItemEnregistrerSous = new JMenuItem("Enregistrer sous ...");
        menu.add(menuItemEnregistrerSous);        

        menu.add(new JSeparator(SwingConstants.HORIZONTAL));

        menuItemQuitter = new JMenuItem("Quitter");
        menu.add(menuItemQuitter);                
        
        //2e menu.
        menu = new JMenu("Édition");
        menuBar.add(menu);
        
        // Submenu 2e menu
        menuItemCouper = new JMenuItem("Couper"/*,KeyEvent.VK_T*/);
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        //menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(menuItemCouper);
        
        menuItemCopier = new JMenuItem("Copier");
        menu.add(menuItemCopier);
        
        menuItemColler = new JMenuItem("Coller");
        menu.add(menuItemColler);
        
        menuItemEffacer = new JMenuItem("Effacer");
        menu.add(menuItemEffacer);        

        menu.add(new JSeparator(SwingConstants.HORIZONTAL));

        menuItemSelectionnerTout = new JMenuItem("Sélectionner tout");
        menu.add(menuItemSelectionnerTout);          
        
        //3e menu.
        menu = new JMenu("À Propos");
        menuBar.add(menu);
        
        // Submenu 3e menu
        menuItemCommentaires = new JMenuItem("Commentaires"/*,KeyEvent.VK_T*/);
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        //menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(menuItemCommentaires);
        
        menuItemDroitAuteur = new JMenuItem("Droit d'auteur");
        menu.add(menuItemDroitAuteur);
        
        menuItemVersions = new JMenuItem("Versions");
        menu.add(menuItemVersions);
        
        this.setJMenuBar(menuBar);
        
        //Déclaration de la zone texte
        Container panGlobal = getContentPane();
        panGlobal.setLayout(new BorderLayout());
        
        TextZone = new JTextArea();
        TextZone.setText("\tHI\nMY name\nis Raku");
        
        panGlobal.add(TextZone, BorderLayout.CENTER);
        
        this.setContentPane(panGlobal);
        //this.pack();
        this.setVisible(true);//on rend visible la frame
    }

}

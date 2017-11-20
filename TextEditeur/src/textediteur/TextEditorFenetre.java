/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textediteur;

import javax.swing.*;

/**
 *
 * @author bornbygoogle
 */
public class TextEditorFenetre extends JFrame
{
    JMenuBar menuBar;
    JMenu menu, submenu;
    
    public TextEditorFenetre()
    {
        super("Éditeur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                
        this.setSize(400,200);
        this.setLocationRelativeTo(null);// équivalent à this.setLocation(500,250);
        
        //Création du menu bar
        menuBar = new JMenuBar();

        //1er menu.
        menu = new JMenu("Fichier");
        menuBar.add(menu);
        
        //2e menu.
        menu = new JMenu("Édition");
        menuBar.add(menu);
        //3e menu.
        menu = new JMenu("À Propos");
        menuBar.add(menu);
        
        this.setJMenuBar(menuBar);
        /*this.pack();*/
        this.setVisible(true);//on rend visible la frame
    }
}

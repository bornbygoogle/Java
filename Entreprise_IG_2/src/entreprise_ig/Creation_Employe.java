/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise_ig;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import entreprise_interface.*;

/**
 *
 * @author faycal
 */
public class Creation_Employe extends javax.swing.JInternalFrame {

    /**
     * Creates new form Creation_Employe
     */
    public Creation_Employe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        RADIO_M = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        RADIO_MME = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 400));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jTextField3.setColumns(10);

        jLabel4.setText("Prénom");

        jLabel3.setText("Nom");

        jTextField4.setColumns(10);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RADIO_M);
        RADIO_M.setSelected(true);
        RADIO_M.setText("M.");
        RADIO_M.setName("Radio_M"); // NOI18N
        RADIO_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RADIO_MActionPerformed(evt);
            }
        });

        jLabel6.setText("Type Employé");

        jComboBox2.setMaximumRowCount(3);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fixe", "Horaire", "Commercial" }));

        buttonGroup1.add(RADIO_MME);
        RADIO_MME.setText("Mme");
        RADIO_MME.setName("RADIO_MME"); // NOI18N
        RADIO_MME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RADIO_MMEActionPerformed(evt);
            }
        });

        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(RADIO_MME)
                        .addComponent(RADIO_M))
                    .addContainerGap(92, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(81, 81, 81)
                .addComponent(jButton1)
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(RADIO_M)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RADIO_MME)
                    .addContainerGap(193, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void RADIO_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RADIO_MActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RADIO_MActionPerformed

    private void RADIO_MMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RADIO_MMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RADIO_MMEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String message;
        
        
       //Vector tabemploye=new Vector();
        if(RADIO_M.isSelected())message="M. "+jTextField3.getText()+" "+jTextField4.getText()+"\n"+"Type :"+(String)jComboBox2.getSelectedItem();
        else message="Mme "+jTextField3.getText()+" "+jTextField4.getText()+"\n"+"Type : "+(String)jComboBox2.getSelectedItem();
       if(JOptionPane.showConfirmDialog(null, message,"Confirmation", JOptionPane.YES_NO_OPTION)==0)
       {
           
            switch(jComboBox2.getSelectedIndex()){
                case 0 : tabemploye.add(new Fixe(jTextField3.getText()));
                break;
                case 1 : tabemploye.add(new Horaire(jTextField3.getText(),0));
                break;
                case 2 : tabemploye.add(new Commercial(jTextField3.getText(),0,0));
                break;
       }
            
            try{
                FileOutputStream fs = new FileOutputStream("C:\\Users\\fbraiki\\Desktop\\tabemploye.dat");//sérialisation
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(tabemploye);
                os.close();
           }
            catch(FileNotFoundException e) {}
            catch(IOException e) {}
            jTextField3.setText("");
            jTextField4.setText("");
            jComboBox2.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        //tabemploye=new Vector();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        tabemploye=new Vector();
        
        try{
        
        FileInputStream fis = new FileInputStream("C:\\Users\\fbraiki\\Desktop\\tabemploye.dat");//désérialisation
        ObjectInputStream ois = new ObjectInputStream(fis);
        tabemploye = (Vector) ois.readObject(); 
        ois.close();
        }
        catch(FileNotFoundException e) {}
        catch(IOException e) {} catch (ClassNotFoundException ex) {
            Logger.getLogger(Liste_Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RADIO_M;
    private javax.swing.JRadioButton RADIO_MME;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    Vector tabemploye;

    public Vector getTabemploye() {
        return tabemploye;
    }

    public void setTabemploye(Vector tabemploye) {
        this.tabemploye = tabemploye;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import projetbdm.Miniature;
import projetbdm.ProjetBDM;

/**
 *
 * @author cmolin
 */
public class Window extends javax.swing.JFrame {
    
    private final Connection con;
    String image_chargement = " ";
    Image img;
    JPanel paner;
    /**
     * Creates new form Window
     */
    public Window(Connection con) {
        this.con = con;
        initComponents();
        this.setVisible(true);
        this.setTitle("Le monde des applications");
        jPanelAcceuil.setVisible(true);
        jPanelAffiche.setVisible(false);
        jPanelLogAdmin.setVisible(false);
        jPanelImageCompa.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMotRech = new javax.swing.JTextField();
        jButtonLanceRechMot = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonLanceRechCompa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonAfficheAdmin = new javax.swing.JButton();
        jPanelLogAdmin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jButtonAdmin = new javax.swing.JButton();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jTextFieldRechImage = new javax.swing.JTextField();
        jButtonParcourir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanelImageCompa = new javax.swing.JPanel();
        jComboBoxRech = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jPanelAcceuil = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelAffiche = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 750));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(210, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(210, 700));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel1.setText("Recherche suivant un mot");

        jTextFieldMotRech.setMinimumSize(new java.awt.Dimension(125, 20));
        jTextFieldMotRech.setPreferredSize(new java.awt.Dimension(125, 20));

        jButtonLanceRechMot.setText("Lancer");
        jButtonLanceRechMot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLanceRechMotActionPerformed(evt);
            }
        });

        jLabel2.setText("Recherche suivant une image");

        jButtonLanceRechCompa.setText("Lancer");
        jButtonLanceRechCompa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLanceRechCompaActionPerformed(evt);
            }
        });

        jButtonAfficheAdmin.setText("Administrateur");
        jButtonAfficheAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfficheAdminActionPerformed(evt);
            }
        });

        jPanelLogAdmin.setPreferredSize(new java.awt.Dimension(189, 100));

        jLabel3.setText("Login");

        jLabel4.setText("Password");

        jButtonAdmin.setText("Go");
        jButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLogAdminLayout = new javax.swing.GroupLayout(jPanelLogAdmin);
        jPanelLogAdmin.setLayout(jPanelLogAdminLayout);
        jPanelLogAdminLayout.setHorizontalGroup(
            jPanelLogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAdmin)
                    .addGroup(jPanelLogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLogAdminLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelLogAdminLayout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelLogAdminLayout.setVerticalGroup(
            jPanelLogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdmin)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTextFieldRechImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRechImageActionPerformed(evt);
            }
        });

        jButtonParcourir.setText("Parcourir");
        jButtonParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParcourirActionPerformed(evt);
            }
        });

        jPanelImageCompa.setPreferredSize(new java.awt.Dimension(190, 130));

        javax.swing.GroupLayout jPanelImageCompaLayout = new javax.swing.GroupLayout(jPanelImageCompa);
        jPanelImageCompa.setLayout(jPanelImageCompaLayout);
        jPanelImageCompaLayout.setHorizontalGroup(
            jPanelImageCompaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanelImageCompaLayout.setVerticalGroup(
            jPanelImageCompaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jComboBoxRech.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dans tout", "Dans image", "Dans application", "Dans catégorie", "Dans système" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonParcourir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLanceRechCompa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldMotRech, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jButtonLanceRechMot, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jSeparator1))
                            .addComponent(jPanelLogAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxRech, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldRechImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelImageCompa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAfficheAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMotRech, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxRech, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButtonLanceRechMot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldRechImage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonParcourir)
                    .addComponent(jButtonLanceRechCompa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelImageCompa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAfficheAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLogAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setLayout(new java.awt.CardLayout());

        jLabel5.setText("acceuil");

        javax.swing.GroupLayout jPanelAcceuilLayout = new javax.swing.GroupLayout(jPanelAcceuil);
        jPanelAcceuil.setLayout(jPanelAcceuilLayout);
        jPanelAcceuilLayout.setHorizontalGroup(
            jPanelAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcceuilLayout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel5)
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanelAcceuilLayout.setVerticalGroup(
            jPanelAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcceuilLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel5)
                .addContainerGap(417, Short.MAX_VALUE))
        );

        jPanel7.add(jPanelAcceuil, "card5");

        jPanelAffiche.setBorder(javax.swing.BorderFactory.createTitledBorder("Résultat de la recherche"));
        jPanelAffiche.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanelAfficheComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanelAfficheLayout = new javax.swing.GroupLayout(jPanelAffiche);
        jPanelAffiche.setLayout(jPanelAfficheLayout);
        jPanelAfficheLayout.setHorizontalGroup(
            jPanelAfficheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        jPanelAfficheLayout.setVerticalGroup(
            jPanelAfficheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );

        jPanel7.add(jPanelAffiche, "card4");

        jMenu1.setText("File");

        jMenuItem1.setText("Acceuil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Quitter");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void afficheImage(JPanel pan,Image img)
    {
        Graphics g=pan.getGraphics();
        g.drawImage(img, 0, 0, pan.getWidth(),pan.getHeight(),this);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if(img!=null)
            afficheImage(paner,img);
    }
    
    private void jButtonAfficheAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfficheAdminActionPerformed
        if(jPanelLogAdmin.isVisible() == false) jPanelLogAdmin.setVisible(true);
        else jPanelLogAdmin.setVisible(false);
    }//GEN-LAST:event_jButtonAfficheAdminActionPerformed

    private void jButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdminActionPerformed
        WindowAdmin wa;
        String login = this.jTextFieldLogin.getText();
        String password = new String(this.jPasswordFieldPassword.getPassword());
        if (!ProjetBDM.uConnexion(login, password)) {
            System.out.println("Erreur login/mot de passe");
        } else {
            wa = new WindowAdmin(this.con);
            wa.setVisible(true);
        }
    }//GEN-LAST:event_jButtonAdminActionPerformed

    private void jTextFieldRechImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRechImageActionPerformed
       
    }//GEN-LAST:event_jTextFieldRechImageActionPerformed

    private void jButtonLanceRechMotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLanceRechMotActionPerformed
        jPanelAcceuil.setVisible(false);
        jPanelAffiche.setVisible(true);
        jPanelImageCompa.setVisible(false);
        jLabel7.setText(" ");
        String indic = (String)jComboBoxRech.getSelectedItem();
        this.foncRecherche(indic);
    }//GEN-LAST:event_jButtonLanceRechMotActionPerformed

    void foncRecherche(String choix)
    {
        jPanelAffiche.removeAll();
        ArrayList<Miniature> trouve = new ArrayList();
        switch(choix)
        {
            case "Dans tout" :
                
                break;
            case "Dans image" : 
                
                break;
            case "Dans application" :
                
                break;
            case "Dans catégorie" :
                
                break;
            case "Dans système" :
                
                break;
            default :
                System.out.println("erreur combo box");
                break;
        }
        Miniature mini1 = new Miniature(1, "rien.png", "nomImage1", "typeImage1");
        Miniature mini2 = new Miniature(2, "rien.png", "nomImage2", "typeImage2");
        Miniature mini3 = new Miniature(3, "rien.png", "nomImage3", "typeImage3");
        Miniature mini4 = new Miniature(4, "rien.png", "nomImage4", "typeImage4");
        Miniature mini5 = new Miniature(4, "rien.png", "nomImage4", "typeImage4");
        Miniature mini6 = new Miniature(4, "rien.png", "nomImage4", "typeImage4");
        Miniature mini7 = new Miniature(4, "rien.png", "nomImage4", "typeImage4");
        Miniature mini8 = new Miniature(4, "rien.png", "nomImage4", "typeImage4");
        Miniature mini9 = new Miniature(4, "rien.png", "nomImage4", "typeImage4");
        Miniature mini10 = new Miniature(4, "rien.png", "nomImage4", "typeImage4");
        trouve.add(mini1);
        trouve.add(mini2);
        trouve.add(mini3);
        trouve.add(mini4);
        trouve.add(mini5);
        trouve.add(mini6);
        trouve.add(mini7);
        trouve.add(mini8);
        trouve.add(mini9);
        trouve.add(mini10);
        int abscisse = 20;
        int ordonne = 10;
        int largueur = jPanelAffiche.getSize().width;
        int cmp = 0;
        int cmpMax = largueur/110;
        for(Miniature mimi : trouve)
        {
            mimi.afficheMini(jPanelAffiche, ordonne, abscisse);
            cmp++;
            if(cmp<cmpMax)
            {
                ordonne += 110;
            }
            else
            {
                abscisse += 110;
                ordonne = 10;
                cmp = 0;
            }
        }
    }
    
    private void jButtonLanceRechCompaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLanceRechCompaActionPerformed
        jPanelAcceuil.setVisible(false);
        jPanelAffiche.setVisible(true);
        jPanelImageCompa.setVisible(true);
        image_chargement = jTextFieldRechImage.getText();
        jLabel7.setText("Image Chargée ");
        img = jPanelImageCompa.getToolkit().getImage(image_chargement);
        paner = jPanelImageCompa;
        repaint();
    }//GEN-LAST:event_jButtonLanceRechCompaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jPanelAcceuil.setVisible(true);        
        jPanelAffiche.setVisible(false);
        jPanelImageCompa.setVisible(false);
        jLabel7.setText(" ");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButtonParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParcourirActionPerformed
        JFileChooser jf=new JFileChooser();
        int i=jf.showOpenDialog(this);
        if(i==JFileChooser.APPROVE_OPTION)
        {
            image_chargement=jf.getSelectedFile().getAbsolutePath();
        }
        jTextFieldRechImage.setText(image_chargement);
    }//GEN-LAST:event_jButtonParcourirActionPerformed

    private void jPanelAfficheComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelAfficheComponentResized
        String indic = (String)jComboBoxRech.getSelectedItem();
        this.foncRecherche(indic);
    }//GEN-LAST:event_jPanelAfficheComponentResized

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdmin;
    private javax.swing.JButton jButtonAfficheAdmin;
    private javax.swing.JButton jButtonLanceRechCompa;
    private javax.swing.JButton jButtonLanceRechMot;
    private javax.swing.JButton jButtonParcourir;
    private javax.swing.JComboBox jComboBoxRech;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelAcceuil;
    private javax.swing.JPanel jPanelAffiche;
    private javax.swing.JPanel jPanelImageCompa;
    private javax.swing.JPanel jPanelLogAdmin;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldMotRech;
    private javax.swing.JTextField jTextFieldRechImage;
    // End of variables declaration//GEN-END:variables
}

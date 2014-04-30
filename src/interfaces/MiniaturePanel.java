/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import projetbdm.Miniature;

/**
 *
 * @author ra185310
 */
public class MiniaturePanel extends javax.swing.JPanel {
    
    Image img;
    JPanel paner;
    
    /**
     * Creates new form MiniaturePanel
     */
    public MiniaturePanel() {
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

        jPanelMini = new javax.swing.JPanel();
        jLabelNom = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jButtonVoir = new javax.swing.JButton();

        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(100, 140));

        jPanelMini.setPreferredSize(new java.awt.Dimension(100, 70));

        javax.swing.GroupLayout jPanelMiniLayout = new javax.swing.GroupLayout(jPanelMini);
        jPanelMini.setLayout(jPanelMiniLayout);
        jPanelMiniLayout.setHorizontalGroup(
            jPanelMiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelMiniLayout.setVerticalGroup(
            jPanelMiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jButtonVoir.setText("Voir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonVoir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVoir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
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
    
    public void remplir(Miniature mini)
    {        
        jLabelNom.setText(mini.getNom());
        jLabelType.setText(mini.getType());
        int largueur = jPanelMini.getPreferredSize().width;
        int hauteur = jPanelMini.getPreferredSize().height;
        ImageIcon ii = new ImageIcon(new ImageIcon(mini.getImg()).getImage().getScaledInstance(largueur, hauteur, Image.SCALE_DEFAULT));;
        /*ImageIcon icon = new ImageIcon(mini.getImg());
        Image imgg = icon.getImage();
        BufferedImage bi = new BufferedImage(imgg.getWidth(null), imgg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(imgg, 0, 0, WIDTH, HEIGHT, null);
        IconImage newIcon = new IconImage(bi); */
        JLabel imagee = new JLabel(ii);
        
        jPanelMini.add(imagee);
        /*img = jPanelMini.getToolkit().getImage(mini.getImg());
        paner = jPanelMini;*/
        //repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoir;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanelMini;
    // End of variables declaration//GEN-END:variables
}

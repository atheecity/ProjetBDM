/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;

import interfaces.WindowAffiche;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rémus
 */
public class Miniature {
    
    //numéro de l'image dans la base
    int num;
    //url de l'image
    String img;   
    // nom de l'image
    String nom;
    //score si comparaison
    String type;
    //connection a la base
    private final Connection con;    
    
    public Miniature(int n, String i, String s, String t, Connection c)
    {
        this.num = n;
        this.img = i;
        this.nom = s;
        this.type = t;
        this.con = c;
    }
    
    public void afficheMini(JPanel panel, int x, int y)
    {
        //initialisation et positionnement des labels
        JLabel lalala = new JLabel(new ImageIcon(this.img));
        JLabel nomt = new JLabel(this.nom);
        JLabel typet = new JLabel(this.type);
        lalala.setBounds(x, y, 150, 150);
        nomt.setBounds(x, y+160, 150, 15);
        typet.setBounds(x, y+175, 100, 15);
        //ajout au panel ou afficher
        panel.add(lalala);
        panel.add(nomt);
        panel.add(typet);
        panel.repaint();
        //action quand on clique sur le label
        lalala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                WindowAffiche waff = new WindowAffiche(con, num, nom);
            }
        });
        nomt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                WindowAffiche waff = new WindowAffiche(con, num, nom);
            }
        });
        typet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                WindowAffiche waff = new WindowAffiche(con, num, nom);
            }
        });
    }
}

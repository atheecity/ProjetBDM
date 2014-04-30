/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;

import interfaces.WindowAffiche;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rémus
 */
public class Miniature {
    
    int num;
    String img;    
    String nom;
    String type;
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    public Miniature(int n, String i, String s, String t)
    {
        this.num = n;
        this.img = i;
        this.nom = s;
        this.type = t;
    }
    
    public void afficheMini(JPanel panel, int x, int y)
    {
        JLabel lalala = new JLabel(new ImageIcon(this.img));
        JLabel nomt = new JLabel(this.nom);
        JLabel typet = new JLabel(this.type);
        lalala.setBounds(x, y, 100, 70);
        nomt.setBounds(x, y+70, 100, 15);
        typet.setBounds(x, y+85, 100, 15);
        panel.add(lalala);
        panel.add(nomt);
        panel.add(typet);
        panel.repaint();
        lalala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                WindowAffiche waff = new WindowAffiche(num, nom);
            }
        });
        nomt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                WindowAffiche waff = new WindowAffiche(num, nom);
            }
        });
        typet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                WindowAffiche waff = new WindowAffiche(num, nom);
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;

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
        lalala.setBounds(x, y, 100, 100);
        panel.add(lalala);
        panel.repaint();
    }
}

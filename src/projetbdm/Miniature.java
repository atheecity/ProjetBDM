/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;

import javax.swing.JPanel;

/**
 *
 * @author Rémus
 */
public class Miniature {
    
    int num;
    Image img;
    String nom;
    
    public Miniature(int n, Image i, String s)
    {
        this.num = n;
        this.img = i;
        this.nom = s;
    }
    
    public JPanel afficheMin()
    {
        JPanel pan = new JPanel();
        
        return pan;
    }
}

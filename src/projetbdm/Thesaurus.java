/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cmolin
 */
public class Thesaurus {
    
    public String nameThesaurus;
    public Connection con;
    
    public Thesaurus(String nameThesaurus) 
    {
        this.nameThesaurus = nameThesaurus;
        this.con = ProjetBDM.connect();
    }
    
    public void createRelation(String phrase, String rel, String relPhrase)
    {
        try {
            PreparedStatement pst = con.prepareStatement("BEGIN ctx_thes.create_relation(?, ?, ?, ?); END;");
            pst.setString(1, this.nameThesaurus);
            pst.setString(2, phrase);
            pst.setString(3, rel);
            pst.setString(4, relPhrase);
            pst.execute();
            con.commit();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Thesaurus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

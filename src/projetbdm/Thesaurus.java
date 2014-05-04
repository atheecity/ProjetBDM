/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleResultSet;

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
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("BEGIN ctx_thes.create_relation(?, ?, ?, ?); END;");
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
    
    public OracleResultSet rechercheThes(String motU, String rel)
    {
        PreparedStatement pst;
        OracleResultSet rset = null;
        try {
            switch(rel){
                case "BT":
                case "NT":
                    pst = con.prepareStatement("select value(a) from application a "
                        + "where contains(descriptionA,?)>0 "
                        + "or contains(nomA, ?)>0");
                    pst.setString(1, rel + "(" + motU + ",1," + nameThesaurus + ")");
                    pst.setString(2, rel + "(" + motU + ",1," + nameThesaurus + ")");
                    rset = (OracleResultSet) pst.executeQuery();
                    break;
                case "SYN":
                case "RT":
                    pst = con.prepareStatement("select value(a) from application a "
                        + "where contains(descriptionA,?)>0 "
                        + "or contains(nomA, ?)>0");
                    pst.setString(1, rel + "(" + motU + "," + nameThesaurus + ")");
                    pst.setString(2, rel + "(" + motU + "," + nameThesaurus + ")");
                    rset = (OracleResultSet) pst.executeQuery();
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Thesaurus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rset;
    }
}

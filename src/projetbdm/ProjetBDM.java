/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;
import interfaces.*;
import java.sql.*;
import oracle.jdbc.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sun.security.util.Password;

/**
 *
 * @author cmolin
 */
public class ProjetBDM {

    public static Connection connect() 
    {
        Connection con = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            String url = "jdbc:oracle:thin:@butor:1521:ensb2013";
            //String url = "jdbc:oracle:thin:@ufrsciencestech.u-bourgogne.fr:25561/ensb2013";
            con = DriverManager.getConnection(url, "cm429363", "cm429363");
        } catch (SQLException ec) {
            ec.printStackTrace();
        }
        
        return con;
    }
    
    public static boolean uConnexion(String login,String pass)
    {
        Connection con = connect();
        try {
            java.util.Map maMap = con.getTypeMap();
            maMap.put("CM429363.UTILISATEUR_TYPE", Class.forName("projetbdm.Utilisateur"));
            OracleStatement st = (OracleStatement) con.createStatement();
            OracleResultSet rst = (OracleResultSet) st.executeQuery("");
        }
        catch(Exception e) {}
        
        return true;
    }
    
    public static void main(String[] args) {
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        Connection con = connect();
        Window w = new Window();
    }
    
}

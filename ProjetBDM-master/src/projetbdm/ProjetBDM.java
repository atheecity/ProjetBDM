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
            //String url = "jdbc:oracle:thin:@butor:1521:ensb2013";
            String url = "jdbc:oracle:thin:@ufrsciencestech.u-bourgogne.fr:25561/ensb2013";
            con = DriverManager.getConnection(url, "cm429363", "cm429363");
        } catch (SQLException ec) {
            ec.printStackTrace();
        }
        
        return con;
    }
    
    public static boolean uConnexion(String login,String pass)
    {
        Connection con = connect();
        Utilisateur u = new Utilisateur();
        try {
            java.util.Map maMap = con.getTypeMap();
            maMap.put("CM429363.UTILISATEUR_TYPE", Class.forName("projetbdm.Utilisateur"));
            PreparedStatement st = con.prepareStatement("select value(u) from utilisateur u where login = ?");
            st.setString(1, login);
            ResultSet rst = st.executeQuery();
            rst.next();
            u = (Utilisateur) rst.getObject(1, maMap);
        }
        catch(SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        
        return (u.password == null ? pass == null : u.password.equals(pass));
    }
    
    public static void main(String[] args) {
        try { 
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); 
        } catch (Exception ex) { 
        }
        Connection con = connect();
        Window w = new Window();
    }
    
}

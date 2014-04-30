/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;
import interfaces.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;


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
    
    public static int getId(String nameTable)
    {
        Connection con = connect();
        int nb = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rset = st.executeQuery("SELECT count(*) FROM " + nameTable);
            while(rset.next())
            {
                nb = Integer.parseInt(rset.getString(1));
            }
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetBDM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nb+1;
    }
    
    public static void main(String[] args) {
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); 
        } catch (Exception ex) { 
        }
        Connection con = connect();
        Window w = new Window(con);
        //WindowAdmin wa = new WindowAdmin(con);
    }
    
}

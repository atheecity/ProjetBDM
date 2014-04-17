/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbdm;
import interfaces.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
    
    public static String[] wConnectionAdmin()
    {
        String[] log = new String[2]; 
        
        //Données
        Object[] message = new Object[4];
        message[0] = "Login administrateur : "; //Message apparaîssant dans le corps du dialog
        message[1] = new JTextField ();
        message[2] = "Mot de passe : "; //Message apparaîssant dans le corps du dialog
        message[3] = new JPasswordField ();
 
        //Options (nom des boutons)
        String option[] = {"OK", "Annuler"};
 
        int result = JOptionPane.showOptionDialog(
                null, // fenêtre parente
                message, // corps du dialogue
                "Connexion administrateur",// Titre du dialogue
                JOptionPane.DEFAULT_OPTION, // type de dialogue
                JOptionPane.QUESTION_MESSAGE, // type icone
                null, // icône optionnelle
                option, // boutons
                message[1] // objet ayant le focus par défaut
        );
 
        if(result == 0){
            log[0] = ((JTextField )message[1]).getText();
            log[1] = new String(((JPasswordField )message[3]).getPassword());
        }
        
        return log;
    }
    
    public static void main(String[] args) {
        Connection con = connect();
        WindowAdmin winA = new WindowAdmin();
    }
    
}

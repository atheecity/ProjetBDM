package projetbdm;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;
import oracle.ord.im.*;

public class Image
{ 
    
    private Connection con;
    
    public Image() 
    {
        this.con = ProjetBDM.connect();
    }
 
    public void addImage(String url, int idI)
    {
        try { 
            Statement stmt = this.con.createStatement();
            
            String sql2 = "SELECT imageI from image where idI = " + idI + " FOR UPDATE";
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sql2);
            while(rset.next())
            {
                System.out.println(url);
                OrdImage img = (OrdImage) rset.getORAData(1, OrdImage.getORADataFactory());
                img.loadDataFromFile(url);
                img.setProperties();
                String sql3 = "UPDATE image set imageI = ? where idI = ?";
                OraclePreparedStatement pstmt = (OraclePreparedStatement) con.prepareStatement(sql3);
                pstmt.setORAData(1, img);
                pstmt.setInt(2, idI);
                pstmt.execute();
                pstmt.close();
            }
            rset.close();
            
        } catch (Exception ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addChampImage(int idI, String nom, String dateI, String description, String url)
    {
        String sql = "INSERT INTO image VALUES (" + idI + ",to_date('" + dateI + "', 'YYYY-MM-DD')"
                + " ,'" + nom + "','" + description + "',ORDSYS.ORDImage.init())";
        
        try {
            OracleStatement ost = (OracleStatement) con.createStatement();
            ost.execute(sql);
            this.addImage(url, idI);
        } catch (SQLException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package projetbdm;

import java.io.IOException;
import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.ord.im.OrdImage;

public class Image 
{ 
    
    private Connection con;
    
    public Image() 
    {
        this.con = ProjetBDM.connect();
    }
    
    public void insererImage(int id, String nom, String date, String description, String urlI)
    {
        String sql = "INSERT INTO image VALUES (" + id + ",to_date('" + date 
                + "', 'YYYY-MM-DD'),'" + nom + "','" + description + "', ordsys.ordimage.init())";
        try {
            Statement stmt = this.con.createStatement();
            stmt.executeQuery(sql);
            this.insererOrdImage(urlI, 1);
        } catch (SQLException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insererOrdImage(String urlI, int idI)
    {
        try {
            Statement stmt = con.createStatement();
            OracleResultSet rset;
            rset = (OracleResultSet) stmt.executeQuery("select imageI from image where "
                    + "idI=" + idI + " for update");
            while(rset.next())
            {
                OrdImage img = (OrdImage) rset.getORAData(1, OrdImage.getORADataFactory());
                img.loadDataFromFile(urlI);
                img.setProperties();
                OraclePreparedStatement pstmt = (OraclePreparedStatement) con.prepareStatement("update "
                        + "image set imageI = ? where idI=?");
                pstmt.setORAData(1, img);
                pstmt.setInt(2, idI);
                pstmt.execute();
                con.commit();
                pstmt.close();
            }
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

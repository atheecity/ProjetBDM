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
                + "', 'YYYY-MM-DD'),'" + nom + "','" + description + "', ordsys.ordimage.init(), ordsys.ordimage.init(), null)";
        try {
            Statement stmt = this.con.createStatement();
            stmt.executeQuery(sql);
            this.insererOrdImage(urlI, id);
        } catch (SQLException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insererOrdImage(String urlI, int idI)
    {
        try {
            Statement stmt = con.createStatement();
            OracleResultSet rset;
            rset = (OracleResultSet) stmt.executeQuery("select imageI, miniature from image where "
                    + "idI=" + idI + " for update");
            while(rset.next())
            {
                OrdImage img = (OrdImage) rset.getORAData(1, OrdImage.getORADataFactory());
                OrdImage miniature = (OrdImage) rset.getORAData(2, OrdImage.getORADataFactory());
                img.loadDataFromFile(urlI);
                img.processCopy("MaxScale=100 100", miniature);
                img.setProperties();
                miniature.setProperties();
                //Mise à jour de l'attribut image
                OraclePreparedStatement pstmt = (OraclePreparedStatement) con.prepareStatement("update "
                        + "image set imageI = ? where idI=?");
                pstmt.setORAData(1, img);
                pstmt.setInt(2, idI);
                pstmt.execute();
                con.commit();
                pstmt.close();
                //Mise à jour de l'attribut miniature
                OraclePreparedStatement pstmt2 = (OraclePreparedStatement) con.prepareStatement("update "
                        + "image set miniature = ? where idI=?");
                pstmt2.setORAData(1, miniature);
                pstmt2.setInt(2, idI);
                pstmt2.execute();
                con.commit();
                pstmt2.close();
            }
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

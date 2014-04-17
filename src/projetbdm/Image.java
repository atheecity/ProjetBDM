package projetbdm;

import java.sql.*; 

public class Image implements SQLData
{ 

    String sql_type;
    public Date dateI;
    public String nomI;
    public Ref refApplicationI;
    
    public Image() {}
 
    @Override
    public String getSQLTypeName ()
    { 
        return "CM429363.IMAGE_TYPE";
    }

    @Override
    public void readSQL(SQLInput  stream , String typeName) throws SQLException 
    { 
        sql_type = typeName;
        this.dateI = stream.readDate();
        this.nomI = stream.readNString();
        this.refApplicationI = stream.readRef();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException 
    { 
       stream.writeDate(this.dateI);
       stream.writeString(this.nomI);
       stream.writeRef(this.refApplicationI);
    }
}

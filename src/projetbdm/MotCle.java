package projetbdm;

import java.sql.*; 

public class MotCle implements SQLData
{ 

    String sql_type;
    public String mot;
    
    public MotCle() {}
 
    @Override
    public String getSQLTypeName ()
    { 
        return "CM429363.MOTCLE_TYPE";
    }

    @Override
    public void readSQL(SQLInput  stream , String typeName) throws SQLException 
    { 
        sql_type = typeName;
        this.mot = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException 
    { 
       stream.writeString(this.mot);
    }
}

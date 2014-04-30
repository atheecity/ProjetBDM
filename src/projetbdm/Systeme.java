package projetbdm;

import java.sql.*; 

public class Systeme implements SQLData
{ 

    String sql_type;
    public String nomS;
    public String fabriquantS;
    public float versionA;
    
    public Systeme() {}
 
    @Override
    public String getSQLTypeName ()
    { 
        return "CM429363.SYSTEME_TYPE";
    }

    @Override
    public void readSQL(SQLInput  stream , String typeName) throws SQLException 
    { 
        sql_type = typeName;
        this.nomS = stream.readString();
        this.fabriquantS = stream.readString();
        this.versionA = stream.readFloat();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException 
    { 
        stream.writeString(this.nomS);
        stream.writeString(this.fabriquantS);
        stream.writeFloat(this.versionA);
    }
}

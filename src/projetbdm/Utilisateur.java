package projetbdm;

import java.sql.*; 

public class Utilisateur implements SQLData
{ 

    String sql_type;
    public String login;
    public String password;
    
    public Utilisateur() {}
 
    @Override
    public String getSQLTypeName ()
    { 
        return "CM429363.UTILISATEUR_TYPE";
    }

    @Override
    public void readSQL(SQLInput  stream , String typeName) throws SQLException 
    { 
        sql_type = typeName;
        this.login = stream.readString();
        this.password = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException 
    { 
        stream.writeString(this.login);
        stream.writeString(this.password);
    }
}

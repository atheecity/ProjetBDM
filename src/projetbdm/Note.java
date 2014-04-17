package projetbdm;

import java.sql.*; 

public class Note implements SQLData
{ 

    String sql_type;
    public int note;
    public String text;
    public Ref refApplicationN;
    
    public Note() {}
 
    @Override
    public String getSQLTypeName ()
    { 
        return "CM429363.NOTE_TYPE";
    }

    @Override
    public void readSQL(SQLInput  stream , String typeName) throws SQLException 
    { 
        sql_type = typeName;
        this.note = stream.readInt();
        this.text = stream.readNString();
        this.refApplicationN = stream.readRef();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException 
    { 
       stream.writeInt(this.note);
       stream.writeString(this.text);
       stream.writeRef(this.refApplicationN);
    }
}

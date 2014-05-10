create or replace type body image_type as 
    member function compare(average in double precision, colorHisto in double precision, PostColor in double precision, texture in double precision) return double precision is
            blob1 BLOB;
            blob2 BLOB;
            img1 SI_StillImage;
            img2 SI_StillImage;
            sig1 SI_FeatureList;
            score double precision;
    BEGIN
            SELECT i.imageI.source.localdata INTO blob1 FROM image i WHERE i.idI=self.idI;
            SELECT i.imageI.source.localdata INTO blob2 FROM image i WHERE i.idI=0;
            img1 := new ORDSYS.SI_StillImage(blob1);
            img2 := new ORDSYS.SI_StillImage(blob2);
            sig1 := new SI_FeatureList(new SI_AverageColor(img1),average,new SI_ColorHistogram(img1),colorHisto,new SI_PositionalColor(img1),PostColor,new SI_Texture(img1),texture);
            score := sig1.SI_Score(img2);
            return score;
    end compare;
    --Méthode pour afficher les informations de l'image
    member function affiche return varchar2 is
        aff varchar2(1000);
    begin
        aff := 'Nom image: ' || self.nomI || '<br/>Description image: ' || self.descriptionI;
        return aff;
    end affiche;
end;
/

create or replace type body application_type as 
    --Méthode pour afficher les informations de l'application
    member function afficheA return varchar2 is
        aff varchar2(1000);
    begin
        aff := 'Nom: ' || self.nomA || '<br/>Description application: ' || self.descriptionA
        || '<br/>Taille (en MO): ' || self.taille || '<br/>Version: ' || self.version;
        return aff;
    end afficheA;
end;
/

create or replace type body categorie_type as 
    --Méthode pour afficher les informations de l'application
    member function afficheC return varchar2 is
        aff varchar2(1000);
    begin
        aff := 'Nom categorie: ' || self.nomC;
        return aff;
    end afficheC;
end;
/

create or replace type body systeme_type as 
    --Méthode pour afficher les informations de l'application
    member function afficheS return varchar2 is
        aff varchar2(1000);
    begin
        aff := 'Nom systeme: ' || self.nomS || '<br/>Fabriquant: ' || self.fabriquant
        || '<br/>Version: ' || self.versionA;
        return aff;
    end afficheS;
end;
/

--test
select i.idI, i.compare(1.0,1.0,1.0,1.0)
from image i;



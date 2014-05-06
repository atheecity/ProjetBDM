/* Méthode table Utilisateur */
CREATE OR REPLACE TYPE BODY utilisateur_type AS 
    STATIC PROCEDURE addUtilisateur(l varchar2, p varchar2) IS
    BEGIN
        INSERT INTO utilisateur VALUES (l, p); 
    END addUtilisateur;
END;
/

CREATE OR REPLACE TYPE BODY image_type AS 
    member PROCEDURE addMini IS
		img ordsys.ordimage;
		mini ordsys.ordimage;
	BEGIN
        select i.imageI into img
		from image i
		where i.idI=self.idI
		for update;
		img.processCopy('maxScale = 100 70', mini);
		update image i set i.miniature=mini where i.idI=self.idI;
    END addMini;
END;
/

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
end;
/

--test
select i.idI, i.compare(1.0,1.0,1.0,1.0)
from image i;

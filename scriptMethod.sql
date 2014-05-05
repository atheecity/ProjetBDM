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
		
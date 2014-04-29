/* Méthode table Utilisateur */
CREATE OR REPLACE TYPE BODY utilisateur_type AS 
    STATIC PROCEDURE addUtilisateur(l varchar2, p varchar2) IS
    BEGIN
        INSERT INTO utilisateur VALUES (l, p); 
    END addUtilisateur;
END;
/
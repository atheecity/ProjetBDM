	drop table utilisateur;
drop table applicationSysteme;
drop table systeme;
drop table application;
drop table image;
drop table categorie;

drop type utilisateur_type;
drop type application_ref_type force;
drop type applications_type force;
drop type application_type force;
drop type images_type force;
drop type image_ref_type force;
drop type image_type force;
drop type systeme_type force;
drop type applicationSysteme_type force;
drop type categorie_type force;

create type application_type;
/

create type image_type as object (
    idI integer, 
    dateI date, 
    nomI varchar2(50),
    descriptionI varchar2(150),
    imageI ORDSYS.ORDImage, 
    miniature ordsys.ordimage, 
    applicationI ref application_type, 
    member function compare(average in double precision, colorHisto in double precision, PostColor in double precision, texture in double precision) return double precision, 
    member function affiche return varchar2
);
/

create type image_ref_type as object (
    imageR ref image_type
);
/

create type images_type as table of image_ref_type;
/

create type categorie_type;
/

create type application_type as object (
    idA integer, 
    nomA varchar2(50),
    dateA date, 
    descriptionA varchar2(250),
    taille float, 
    version float,
    categorieA ref categorie_type,
    imagesA images_type,
    member function affiche return varchar2
);
/

create type application_ref_type as object (
    applicationR ref application_type
);
/

create type applications_type as table of application_ref_type;
/

create type systeme_type as object (
    nomS varchar2(50), 
    fabriquant varchar2(150), 
    versionA float, 
    member function afficheS return varchar2
);
/

create type applicationSysteme_type as object (
    systemeA ref systeme_type, 
    applicationS ref application_type
);
/

create type categorie_type as object (
    idC integer, 
    nomC varchar2(50),
    applicationsC applications_type,
    member function affiche return varchar2
);
/

create type utilisateur_type as object (
    login varchar2(50),
    password varchar2(50)
);
/

/********** TABLE ************/
create table systeme of systeme_type (
    primary key(nomS)
);

create table categorie of categorie_type (
    primary key(idC)
) nested table applicationsC store as tabApplications ;

CREATE SEQUENCE NumC
  MINVALUE 0
  START WITH 0
  INCREMENT BY 1
  NOCACHE;

create table application of application_type (
    primary key(idA), 
    categorieA scope is categorie
) nested table imagesA store as tabImages;

CREATE SEQUENCE NumA
  MINVALUE 0
  START WITH 0
  INCREMENT BY 1
  NOCACHE;

create table image of image_type (
    primary key(idI),
    applicationI scope is application
);

--IMAGE
CREATE SEQUENCE NumI
  MINVALUE 0
  START WITH 1
  INCREMENT BY 1
  NOCACHE;

create table applicationSysteme of applicationSysteme_type (
    systemeA scope is systeme,
    applicationS scope is application
);

create table utilisateur of utilisateur_type (
    primary key (login)
);

/* Création du thesaurus */
BEGIN
	CTX_THES.CREATE_THESAURUS('app_thes', FALSE); 
END;
/

begin 
	ctx_thes.create_relation('app_thes', 'social', 'SYN', 'social');
end;
/

begin
  Dbms_Output.Put_Line (
    Ctx_Thes.syn (
      phrase => 'social',
      tname  => 'app_thes' ));
end;
/

--création des index
create index nomIindex on image(nomI) indextype is ctxsys.context;
create index descriptionIindex on image(descriptionI) indextype is ctxsys.context;
create index nomAindex on application(nomA) indextype is ctxsys.context;
create index descriptionAindex on application(descriptionA) indextype is ctxsys.context;

--reconstruction des index
alter index nomIindex rebuild;
alter index descriptionIindex rebuild;
alter index nomAindex rebuild;
alter index descriptionAindex rebuild;

--function
alter type image_type add member function compare(average in double precision, colorHisto in double precision, PostColor in double precision, texture in double precision) return double precision
cascade;
alter type image_type drop member procedure addMini cascade;
alter type image_type add member function affiche return varchar2 cascade;
alter type application_type add member function afficheA return varchar2 cascade;
alter type categorie_type add member function afficheC return varchar2 cascade;
alter type systeme_type add member function afficheS return varchar2 cascade;
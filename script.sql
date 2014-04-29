create or replace type motCle_type as object (
    mot varchar2(50)
);
/

create or replace type application_type;
/

create or replace type note_type as object (
    idN integer, 
    note integer,
    text varchar2(200),
    applicationN ref application_type
);
/

create or replace type note_ref_type as object (
    noteR ref note_type
);
/

create or replace type notes_type as table of note_ref_type;
/

create or replace type image_type as object (
    idI integer, 
    dateI date, 
    nomI varchar2(50),
    applicationI ref application_type
);
/

create or replace type image_ref_type as object (
    imageR ref image_type
);
/

create or replace type images_type as table of image_ref_type;
/

create or replace type motCleImage_type as object (
    imageM ref image_type,
    motCleI ref motCle_type
);
/

create or replace type video_type as object (
    idV integer, 
    dateV date, 
    nomV varchar2(50),
    applicationV ref application_type
);
/

create type video_ref_type as object (
    videoR ref video_type
);
/

create type videos_type as table of video_ref_type;
/ 

create or replace type motCleVideo_type as object (
    videoM ref video_type,
    motCleV ref motCle_type
);
/

create or replace type categorie_type;
/

create or replace type application_type as object (
    idA integer, 
    nomA varchar2(50),
    dateA date, 
    descriptionA varchar2(250),
    taille float, 
    version integer,
    categorieA ref categorie_type,
    imagesA images_type
);
/

create or replace type application_ref_type as object (
    applicationR ref application_type
);
/

create or replace type applications_type as table of application_ref_type;
/

create or replace type systeme_type as object (
    nomS varchar2(50)
);
/

create or replace type applicationSysteme_type as object (
    systemeA ref systeme_type, 
    applicationS ref application_type
);
/

create or replace type categorie_type as object (
    idC integer, 
    nomC varchar2(50),
    logoC varchar2(250),
    applicationsC applications_type
);
/

create type utilisateur_type as object (
    login varchar2(50),
    password varchar2(50)
);
/

/********** TABLE ************/
DROP table systeme;
DROP table motCle;
DROP table categorie;

create table systeme of systeme_type (
    primary key(nomS)
);

create table motCle of motCle_type (
    primary key(mot)
);

create table categorie of categorie_type (
    primary key(idC)
) nested table applicationsC store as tabApplications ;

create table application of application_type (
    primary key(idA), 
    categorieA scope is categorie
) nested table imagesA store as tabImages;

create table note of note_type (
    primary key(idN), 
    applicationN scope is application
);

create table image of image_type (
    primary key(idI),
    applicationI scope is application
);

create table video of video_type (
    primary key(idV),
    applicationV scope is application
);

create table motCleVideo of motCleVideo_type (
    videoM scope is video,
    motCleV scope is motCle
);

create table motCleImage of motCleImage_type (
    imageM scope is image, 
    motCleI scope is motCle
);

create table applicationSysteme of applicationSysteme_type (
    systemeA scope is systeme,
    applicationS scope is application
);

create table utilisateur of utilisateur_type (
    primary key (login)
);

alter type image_type add attribute miniature ordsys.ordimage cascade;
alter type image_type add member procedure addMini;


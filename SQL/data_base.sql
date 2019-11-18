#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Film
#------------------------------------------------------------

CREATE TABLE Film(
        idf   Int  Auto_increment  NOT NULL ,
        Titre Varchar (50) NOT NULL ,
        Annee Year NOT NULL ,
        Genre Varchar (50) NOT NULL
	,CONSTRAINT Film_PK PRIMARY KEY (idf)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Acteur
#------------------------------------------------------------

CREATE TABLE Acteur(
        Ida             Int  Auto_increment  NOT NULL ,
        Nom             Varchar (50) NOT NULL ,
        DateDeNaissance Date NOT NULL ,
        Nationalite     Varchar (50) NOT NULL ,
        Sexe            Varchar (50) NOT NULL
	,CONSTRAINT Acteur_PK PRIMARY KEY (Ida)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Jouer
#------------------------------------------------------------

CREATE TABLE Jouer(
        Ida Int NOT NULL ,
        idf Int NOT NULL
	,CONSTRAINT Jouer_PK PRIMARY KEY (Ida,idf)

	,CONSTRAINT Jouer_Acteur_FK FOREIGN KEY (Ida) REFERENCES Acteur(Ida)
	,CONSTRAINT Jouer_Film0_FK FOREIGN KEY (idf) REFERENCES Film(idf)
)ENGINE=InnoDB;
#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Films
#------------------------------------------------------------

CREATE TABLE cinema.Films(
        idf   Int  Auto_increment  NOT NULL ,
        Titre Varchar (50) NOT NULL ,
        Annee Year NOT NULL ,
        Genre Varchar (50) NOT NULL
	,CONSTRAINT Films_PK PRIMARY KEY (idf)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Acteurs
#------------------------------------------------------------

CREATE TABLE cinema.Acteur(
        Ida         Int  Auto_increment  NOT NULL ,
        Nom         Varchar (50) NOT NULL ,
        Prenom      Varchar (50) NOT NULL ,
        Age         Int NOT NULL ,
        Nationalite Varchar (50) NOT NULL ,
        Sexe         Varchar (50) NOT NULL
	,CONSTRAINT Acteur_PK PRIMARY KEY (Ida)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Jouer
#------------------------------------------------------------

CREATE TABLE cinema.Jouer(
        Ida Int NOT NULL ,
        idf Int NOT NULL
	,CONSTRAINT Jouer_PK PRIMARY KEY (Ida,idf)

	,CONSTRAINT Jouer_Acteurs_FK FOREIGN KEY (Ida) REFERENCES Acteurs(Ida)
	,CONSTRAINT Jouer_Films0_FK FOREIGN KEY (idf) REFERENCES Films(idf)
)ENGINE=InnoDB;


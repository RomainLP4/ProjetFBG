package cinema;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import api.Requete;
import cinema.model.Acteur;
import cinema.model.Film;
import jdbc.CrudActeurs;
import jdbc.CrudFilms;
import jdbc.Session;

public class Test {

	public static void main(String[] args) throws MalformedURLException, IOException, SQLException {
		Session session= new Session();
		

		 Acteur tom = Requete.actorDetails(Requete.acteur("Tom cruise"));//recherche de l'acteur Tom Cruise via l'api
		 CrudActeurs.creationActeur(session.getConnection(), tom); // ajout de tom cruise dans la DB
		 Requete.actorFilm(Requete.acteur("Tom cruise"));//les des film de Tom Cruise
		 
		 Acteur julia = Requete.actorDetails(Requete.acteur("Julia Roberts"));//recherche de l'actric Julia Roberts
		 CrudActeurs.creationActeur(session.getConnection(), julia);//Ajout de cette actrive dans la DB
		 
		 CrudActeurs.afficherTable(session.getConnection()); //affichage de la table Acteurs dans la console
		 
		 julia.setNoms("Erin Brokovitch"); //modification du nom de julia roberts par Erin brokovitch
		 CrudActeurs.miseAJourTable(session.getConnection(), julia);//MaJ de la DB
		 
		 CrudActeurs.suppressionDonnee(session.getConnection(), julia); // suppression de l'actrice julia Roberts de la DB
		 
		 Requete.detailFilm(11); // detail d'un film via son ID 
		 Requete.detailFilm(Requete.idFilm("star wars")); //recherche du film Star Wars via l'API
		 Film shrek = Requete.detailFilm(Requete.idFilm("shrek"));//recup des infos du film Shrek via l'API
		 CrudFilms.creationFilm(session.getConnection(), shrek);//ajout du film Shrek ds la DB
		 CrudFilms.afficherTableFilm(session.getConnection());//afichage de la table Film
		 shrek.setAnnee("2001");//modification de l'année de prod de shrek par 2001
		 CrudFilms.miseAJourTableFilm(session.getConnection(), shrek); // MaJ de la table film
		 

		 CrudFilms.suppressionFilm(session.getConnection(), shrek);//suppression du film de la DB
	}

}

package cinema;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import cinema.model.Acteur;
import cinema.model.Film;
import jdbc.CrudActeurs;
import jdbc.CrudFilms;
import jdbc.Requete;
import jdbc.Session;

public class App{
	

public static void main(String[] args) throws MalformedURLException, IOException, SQLException {
	Session session = new Session();
				//Acteur tom = new Acteur(500,name, birth, lieu, sexe, movies<titre>);
		//Acteur julia = req.actorDetails(5);
		//System.out.println(">> "+julia.getLieuDeNaissance());
	
//	Acteur tom = Requete.actorDetails(Requete.acteur("Tom cruise"));
//	CrudActeurs.creationActeur(session.getConnection(), tom);
//	Requete.actorFilm(Requete.acteur("Tom cruise"));

	//Acteur julia = Requete.actorDetails(Requete.acteur("Julia Roberts"));
//	CrudActeurs.creationActeur(session.getConnection(), julia);
	
	//CrudActeurs.afficherTable(session.getConnection());
//	julia.setNoms("Erin Brokovitch");
//	CrudActeurs.miseAJourTable(session.getConnection(), julia);
	
	//CrudActeurs.suppressionDonnee(session.getConnection(), julia);	
	//Requete.detailFilm(11);
	//Requete.detailFilm(Requete.idFilm("star wars"));
	Film star = Requete.detailFilm(Requete.idFilm("star wars"));
	CrudFilms.creationFilm(session.getConnection(), star);
}
}
package cinema;

import java.io.IOException;
import java.net.MalformedURLException;

import cinema.model.Acteur;
import jdbc.CrudActeurs;
import jdbc.Requete;
import jdbc.Session;

public class App{
	

public static void main(String[] args) throws MalformedURLException, IOException {
				//Acteur tom = new Acteur(500,name, birth, lieu, sexe, movies<titre>);
		//Acteur julia = req.actorDetails(5);
		//System.out.println(">> "+julia.getLieuDeNaissance());
	Session session = new Session();
	
	Acteur tom = Requete.actorDetails(Requete.acteur("Tom cruise"));
	CrudActeurs.creationActeur(session.getConnection(), tom);
		Requete.actorFilm(Requete.acteur("Tom cruise"));
	}
}
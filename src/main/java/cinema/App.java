package cinema;

import java.io.IOException;
import java.net.MalformedURLException;

import cinema.model.Acteur;
import jdbc.Requete;

public class App{
	

public static void main(String[] args) throws MalformedURLException, IOException {
		Requete req = new Requete();
		//Acteur julia = new Acteur(5,name, birth, lieu, sexe, movies<titre>);
		Acteur julia = req.actorDetails(5);
		System.out.println(">> "+julia.getLieuDeNaissance());
		// film("Star wars");
		// test.acteur("tom cruise");
		// System.out.println("l'id est "+actorID);
		// System.out.println(test.acteur("Tom Cruise"));
		//test.actorDetails(test.acteur("tom cruise"));
		//test.detailFilm(test.idFilm("rocky 2"));
		req.actorFilm(1204);
	}
}
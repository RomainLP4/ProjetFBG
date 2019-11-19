package cinema;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.*;
import cinema.model.Acteur;
import cinema.model.Film;
import jdbc.CrudActeurs;
import jdbc.CrudFilms;
import jdbc.Requete;
import jdbc.Session;

public class App {

	public static void main(String[] args) throws MalformedURLException, IOException, SQLException {
		Session session = new Session();
		// Acteur tom = new Acteur(500,name, birth, lieu, sexe, movies<titre>);
		// Acteur julia = req.actorDetails(5);
		// System.out.println(">> "+julia.getLieuDeNaissance());

//	Acteur tom = Requete.actorDetails(Requete.acteur("Tom cruise"));
//	CrudActeurs.creationActeur(session.getConnection(), tom);
//	Requete.actorFilm(Requete.acteur("Tom cruise"));

		// Acteur julia = Requete.actorDetails(Requete.acteur("Julia Roberts"));
//	CrudActeurs.creationActeur(session.getConnection(), julia);

		// CrudActeurs.afficherTable(session.getConnection());
//	julia.setNoms("Erin Brokovitch");
//	CrudActeurs.miseAJourTable(session.getConnection(), julia);

		// CrudActeurs.suppressionDonnee(session.getConnection(), julia);
		// Requete.detailFilm(11);
		// Requete.detailFilm(Requete.idFilm("star wars"));
		// Film shrek = Requete.detailFilm(Requete.idFilm("shrek"));
//	CrudFilms.creationFilm(session.getConnection(), shrek);

		// CrudFilms.afficherTableFilm(session.getConnection());
//	shrek.setAnnee("2001");
//	CrudFilms.miseAJourTableFilm(session.getConnection(), shrek);

		// CrudFilms.suppressionFilm(session.getConnection(), shrek);
		
		
		
 

//		if (menu == 1) {
//			CrudActeurs.afficherTable(session.getConnection());
//			System.out.println("Vous avez demandé d'afficher la table Acteur.");
//		} else {
//			CrudFilms.afficherTableFilm(session.getConnection());
//			System.out.println("Vous avez demandé d'afficher la table Film");
//		
Scanner sc = new Scanner(System.in);
int menu = 0;

  do{
  System.out.print("Bonjour, quelle table voulez vous afficher?\n 1 Acteur\n 2 Film \n");
    while(!sc.hasNextInt()){
        
        System.out.println("Entrée incorrect, recommencez");
        System.out.println("Bonjour, quelle table voulez vous afficher?\n 1 Acteur\n 2 Film \n");
        sc.next();
    } menu= sc.nextInt();
}
while (menu < 1 || menu > 2) ;}}
		
		
	
//		} else if (menu < 1 || menu > 2) {
//			System.out.println("Veuillez entrer 1 pour Acteur ou 2 pour Film.");
//		} else {
//			System.out.println("Saisie incorrect");
//		}

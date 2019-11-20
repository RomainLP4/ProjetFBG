package cinema.model;

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

public class Menu {

//Session session = new Session();
// Acteur tom = new Acteur(500,name, birth, lieu, sexe, movies<titre>);
// Acteur julia = req.actorDetails(5);
	// System.out.println(">> "+julia.getLieuDeNaissance());

//		Acteur tom = Requete.actorDetails(Requete.acteur("Tom cruise"));
//		CrudActeurs.creationActeur(session.getConnection(), tom);
//		Requete.actorFilm(Requete.acteur("Tom cruise"));

			// Acteur julia = Requete.actorDetails(Requete.acteur("Julia Roberts"));
//		CrudActeurs.creationActeur(session.getConnection(), julia);

			// CrudActeurs.afficherTable(session.getConnection());
//		julia.setNoms("Erin Brokovitch");
//		CrudActeurs.miseAJourTable(session.getConnection(), julia);

			// CrudActeurs.suppressionDonnee(session.getConnection(), julia);
			// Requete.detailFilm(11);
			// Requete.detailFilm(Requete.idFilm("star wars"));
			// Film shrek = Requete.detailFilm(Requete.idFilm("shrek"));
//		CrudFilms.creationFilm(session.getConnection(), shrek);

			// CrudFilms.afficherTableFilm(session.getConnection());
//		shrek.setAnnee("2001");
//		CrudFilms.miseAJourTableFilm(session.getConnection(), shrek);

			// CrudFilms.suppressionFilm(session.getConnection(), shrek);
			
			
			
	static Session session = new Session();
	static Scanner sc = new Scanner(System.in);
	static int menu = 0;
	static int menu2 = 0;
	int menu3 = 0;

	public static void choixDeLaTable() throws SQLException {
	
		 do{
			  System.out.print("Bonjour, quelle table voulez vous afficher?\n 1 Acteur\n 2 Film \n");
			    while(!sc.hasNextInt()){
			        
			        System.out.println("Entrée incorrect, recommencez");
			        System.out.println("Bonjour, quelle table voulez vous afficher?\n 1 Acteur\n 2 Film \n");
			        sc.next();
			    } menu = sc.nextInt();
			  
			}
			while (menu < 1 || menu > 2) ;

				if (menu == 1) {
					System.out.println("Vous avez demandé d'afficher la table Acteur.");
					CrudActeurs.afficherTable(session.getConnection());
	
				} else {
					System.out.println("Vous avez demandé d'afficher la table Film");
					CrudFilms.afficherTableFilm(session.getConnection());
				}
	}
	
	public static void sousMenuActeur() throws SQLException, MalformedURLException, IOException {

			do{
				  System.out.print("Et maintenant, que voulez vous faire ?");
				  System.out.println("\n1 | Ajouter un acteur.\n2 | Réafficher la table.\n3 | Modifier un paramètre. \n4 | Supprimer un acteur.");
				    while(!sc.hasNextInt()){
				    	System.out.println("Entrée incorrect, recommencez");
				    	sc.next();
				    } menu2= sc.nextInt();
			}
				    	
			while (menu2 < 1 || menu2 > 4) ;
				        
				    	
			if (menu2 == 1) {
				System.out.println("Vous allez créer un nouvel acteur !");
				System.out.println("Entrez son prénom et son nom :");
				
				Scanner scActeur = new Scanner(System.in);
				String saisie = scActeur.nextLine();
				
				Acteur acteur = Requete.actorDetails(Requete.acteur(saisie));
				CrudActeurs.creationActeur(session.getConnection(), acteur);
				
			
				
				// TODO si acteur inconnu
				
			} else if (menu2 == 2) 	{
				System.out.println("Vous voulez réafficher la table Acteur. Et bien, la voici :");
				CrudActeurs.afficherTable(session.getConnection());	
			
			} else if (menu2 == 3) {
				System.out.println("Vous allez maintenant modifier un ou plusieurs paramètres d'un acteur.");
				System.out.println("Quel acteur ou actrice voulez-vous modifier ?\n Entrez son prénom et son nom :");
				
				Scanner scActeur = new Scanner(System.in);
				String saisie = scActeur.nextLine();
				Acteur acteur = Requete.actorDetails(Requete.acteur(saisie));
				
			} else if (menu2 == 4) {
				System.out.println("Vous avez maintenant la possibilité de supprimer un acteur.");
				System.out.println("Quel acteur ou actrice voulez-vous supprimer ?\n Entrez son prénom et son nom :");
				
				Scanner scActeur = new Scanner(System.in);
				String saisie = scActeur.nextLine();
				Acteur acteur = Requete.actorDetails(Requete.acteur(saisie));
				
				CrudActeurs.suppressionDonnee(session.getConnection(), acteur);
			}
				
	}		
			
			public void sousMenuUpdateActeur() {
				
				System.out.println("Quel paramètre voulez-vous modifier ?");
				System.out.println(" Pour modifier son nom, tappez 1.\n Pour modifier sa date de naissance, tappez 2.\n Pour modifier son lieu de naissance, tappez 3. \n Pour lui changer de sexe, tappez 4 !...");
				
					do{
					 
					    while(!sc.hasNextInt()){
					    	System.out.println("Entrée incorrect, recommencez");
					    	sc.next();
					    } menu3= sc.nextInt();
				}
					    	
				while (menu3 < 1 || menu3 > 4) ;
				
						
				if (menu3 == 1) {
					System.out.println("Comment voulez-vous l'appeler ?");
					
					Scanner scModif = new Scanner(System.in);
					String modif = scModif.nextLine();
				
				    acteur.setNoms(modif);
				    CrudActeurs.miseAJourTable(session.getConnection(), acteur);
				
				} else if (menu3 == 2) {
					System.out.println("Quand voulez vous qu'il ou elle soit né(e) ?");
					
					Scanner scModif2 = new Scanner(System.in);
					String modif2 = scModif2.nextLine();
					
					acteur.setDateDeNaissance(modif2);
					CrudActeurs.miseAJourTable(session.getConnection(), acteur);
				
				} else if (menu3 == 3) {
					System.out.println("Où voulez-vous qu'il ou elle soit né(e) ? ");
					
					Scanner scModif3 = new Scanner(System.in);
					String modif3 = scModif3.nextLine();
					
					acteur.setLieuDeNaissance(modif3);
					CrudActeurs.miseAJourTable(session.getConnection(), acteur);
				
				} else if (menu3 == 4) {
					System.out.println("Si vous voulez lui changer de sexe, tappez Homme ou Femme :");
					
					Scanner scModif4 = new Scanner(System.in);
					String modif4 = scModif4.nextLine();
					
					acteur.setSexe(modif4);
					CrudActeurs.miseAJourTable(session.getConnection(), acteur);	
				}	
			
			
			
				
			}

			
			
		
	
}

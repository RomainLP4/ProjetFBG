package cinema.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import api.Requete;

import java.util.*;
import cinema.model.Acteur;
import cinema.model.Film;
import jdbc.CrudActeurs;
import jdbc.CrudFilms;
import jdbc.Session;

public class Menu {
		
	Session session = new Session();
	Scanner sc = new Scanner(System.in);
	//static int menu = 0;
	//static int menu2 = 0;
	//static int menu3 = 0;
	
	
	
	

	public void choixDeLaTable() throws SQLException {
		
//		Session session = new Session();
//		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
	
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
	
	public void sousMenuActeur() throws SQLException, MalformedURLException, IOException {

//		Session session = new Session();
//		Scanner sc = new Scanner(System.in);
		
		int menu2 = 0;
			
			do{
				  System.out.print("Et maintenant, que voulez vous faire ?");
				  System.out.println("\n1 | Ajouter un acteur.\n2 | Réafficher la table.\n3 | Modifier un paramètre. \n4 | Supprimer un acteur.");
				    while(!sc.hasNextInt()){
				    	System.out.println("Entrée incorrect, recommencez");
				    	sc.next();
				    } menu2 = sc.nextInt();
			}
				    	
			while (menu2 < 1 || menu2 > 4) ;
				        
				    	
			if (menu2 == 1) {
				System.out.println("Vous allez créer un nouvel acteur !");
				System.out.println("Entrez son prénom et son nom :");
				
				//Scanner scActeur = new Scanner(System.in);
				String saisie = sc.next();
				
				
				Acteur acteur = Requete.actorDetails(Requete.acteur(saisie));
				CrudActeurs.creationActeur(session.getConnection(), acteur);
				
			
				
				// TODO si acteur inconnu
				
			} else if (menu2 == 2) 	{
				System.out.println("Vous voulez réafficher la table Acteur. Et bien, la voici :");
				CrudActeurs.afficherTable(session.getConnection());	
			
			} else if (menu2 == 3) {
				System.out.println("Vous allez maintenant modifier un ou plusieurs paramètres d'un acteur.");
				System.out.println("Quel acteur ou actrice voulez-vous modifier ?\n Entrez son prénom et son nom :");
				
				//Scanner scActeur = new Scanner(System.in);
				//String saisie = sc.nextLine();
				//Acteur acteur = Requete.actorDetails(Requete.acteur(saisie));
				
				sousMenuUpdateActeur();
				
			} else if (menu2 == 4) {
				System.out.println("Vous avez maintenant la possibilité de supprimer un acteur.");
				System.out.println("Quel acteur ou actrice voulez-vous supprimer ?\n Entrez son prénom et son nom :");
				
				//Scanner scActeur = new Scanner(System.in);
				String saisie = sc.next();
				Acteur acteur = Requete.actorDetails(Requete.acteur(saisie));//get from DB?
				
				CrudActeurs.suppressionDonnee(session.getConnection(), acteur);
			}
				
	}		
			
		public void sousMenuUpdateActeur() throws SQLException, MalformedURLException, IOException {
			
			//sousMenuActeur();
			
			
//			Session session = new Session();
//			Scanner sc = new Scanner(System.in);
			
			int menu3;
				
			//Scanner scActeur = new Scanner(System.in);
			String saisie = sc.next();
			Acteur acteur = CrudActeurs.getActeur(session.getConnection(), saisie);// on devrai pas plutot get from acteur DB ?	
			if (acteur==null) System.out.println("ERREEEEEUR");
				System.out.println("Quel paramètre voulez-vous modifier ?");
				System.out.println(" Pour modifier son nom, tappez 1.\n Pour modifier sa date de naissance, tappez 2.\n Pour modifier son lieu de naissance, tappez 3. \n Pour lui changer de sexe, tappez 4 !...");
				
				
				do{
					    while(!sc.hasNextInt()){
					    	System.out.println("Entrée incorrect, recommencez");
					    	sc.next();
					    } menu3 = sc.nextInt();
					    
				}while (menu3 < 1 || menu3 > 4) ;
				
						sc.nextLine();
				if (menu3 == 1) {
					
					System.out.println("Comment voulez-vous l'appeler ?");
								
					//Scanner scModif = new Scanner(System.in);
					String modif = sc.nextLine();
					//Acteur acteur = Requete.actorDetails(Requete.acteur(saisie));
					
					acteur.setNoms(modif);
					System.out.println("noms : "+acteur.getNoms());
				    CrudActeurs.miseAJourTable(session.getConnection(), acteur);
				
				    				 							    
				} else if (menu3 == 2) {
					
					System.out.println("Quand voulez vous qu'il ou elle soit né(e) ?");
									
					//Scanner scModif2 = new Scanner(System.in);
					String modif2 = sc.next();
					//Acteur acteur = Requete.actorDetails(Requete.acteur(saisie));
					
					acteur.setDateDeNaissance(modif2);
					CrudActeurs.miseAJourTable(session.getConnection(), acteur);
				
				
				} else if (menu3 == 3) {
					
					System.out.println("Où voulez-vous qu'il ou elle soit né(e) ? ");
										
					//Scanner scModif3 = new Scanner(System.in);
					String modif3 = sc.next();
					//Acteur acteur = Requete.actorDetails(Requete.acteur(modif3));
					
					
					acteur.setLieuDeNaissance(modif3);
					CrudActeurs.miseAJourTable(session.getConnection(), acteur);
				
				} else if (menu3 == 4) {
					
					System.out.println("Si vous voulez lui changer de sexe, tappez Homme ou Femme :");
									
					//Scanner scModif4 = new Scanner(System.in);
					String modif4 = sc.next();
					//Acteur acteur = Requete.actorDetails(Requete.acteur(modif4));
					
					acteur.setSexe(modif4);
					CrudActeurs.miseAJourTable(session.getConnection(), acteur);	
				}	
				
			}

}


package cinema.model;

import jdbc.CrudActeurs;
import jdbc.CrudFilms;
import jdbc.Session;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.*;

import api.Requete;

public class Menu
{
	Session session = new Session();
	Scanner entreeClavierInt = new Scanner(System.in); // Choix utilisateur destiné au menu(entier)
	Scanner entreeClavierTexte = new Scanner (System.in); // Choix utilisateur destiné aux noms, genres et dates(String)
	public String acteurAModif; // Déclaration variable de classe afin de la rappeler n'importe où
	public static String menuPrincipal = " 1. Acteur\n 2. Film\nVotre choix :";
	public static String sousMenu1 = "Et maintenant, que voulez vous faire ?\n1 | Ajouter un acteur.\n2 | Réafficher la table.\n3 | Modifier un paramètre. \n4 | Supprimer un acteur. \n5 | Sortir.";
	public static String sousMenu2 = "Quel paramètre voulez-vous modifier ?\n Pour modifier son nom, tapez 1.\n Pour modifier sa date de naissance, tapez 2.\n Pour modifier son lieu de naissance, tapez 3. \n Pour lui changer de sexe, tapez 4 !...";
	public static int choixMenuGeneral;
	public static int choixSousMenu1;
	public static int choixSousMenu2;

	// Menu général dirigeant vers la partie menu film ou menu acteur
	public void menuGeneral () throws SQLException 
	{
		// Boucle si l'utilisateur entre un charactere hors champs
		do 
		{								
			while(!entreeClavierInt.hasNextInt())
			{	        
				System.out.println("Entrée incorrect, recommencez");
				System.out.println(menuPrincipal);
				entreeClavierInt.next();
			} 
			choixMenuGeneral = entreeClavierInt.nextInt();
		}
		while(choixMenuGeneral < 1 || choixMenuGeneral > 2); // Jusqu'à ce que l'utilisateur choisisse 1 ou 2

		if (choixMenuGeneral == 1) {
			System.out.println("Vous avez demandé d'afficher la table Acteur.");
			CrudActeurs.afficherTable(session.getConnection()); // Affichage de la table acteur enregistré dans le tableau SQL
		} else {
			System.out.println("Vous avez demandé d'afficher la table Film");
			CrudFilms.afficherTableFilm(session.getConnection()); //affichage de la table film enregistré dans le tableau SQL
		}
	}
	public void sousMenuActeur () throws MalformedURLException, IOException, SQLException 
	{
		// Boucle si l'utilisateur entre un charactere hors champs
		do 
		{			
			while(!entreeClavierInt.hasNextInt())
			{
				System.out.println("Entrée incorrect, recommencez");
				System.out.println(sousMenu1);
		    	entreeClavierInt.next();
		    } choixSousMenu1 = entreeClavierInt.nextInt();
		}
		while (choixSousMenu1 < 1 || choixSousMenu1 > 5) ; // Jusqu'à ce que l'utilisateur choisisse entre 1 et 5
		
		switch (choixSousMenu1) {
		case 1 : // Choix ajout d'un nouvel acteur dans le tableau SQL
			System.out.println("Vous allez créer un nouvel acteur !");
			System.out.println("Entrez son prénom et son nom :");			
			String saisieNom = entreeClavierTexte.nextLine();			
			Acteur acteurCree = Requete.actorDetails(Requete.acteur(saisieNom));
			CrudActeurs.creationActeur(session.getConnection(), acteurCree);
			System.out.println("Vous avez ajouté " + saisieNom);
			break;
			// TODO si acteur inconnu
		case 2 : // choix affichage de la table acteur depuis le tableau SQL
			System.out.println("Vous voulez réafficher la table Acteur. Et bien, la voici :");
			CrudActeurs.afficherTable(session.getConnection());	
			break;		
		case 3 : // choix modification de parametres dans le tableau SQL
			System.out.println("Vous allez maintenant modifier un ou plusieurs paramètres d'un acteur.");
			System.out.print("Quel acteur ou actrice voulez-vous modifier ?\nEntrez son prénom et son nom :");
			acteurAModif = entreeClavierTexte.nextLine();
			System.out.println("vous avez choisi de modifier " + acteurAModif);
			sousMenuUpdateActeur();
			break;			
		case 4 : // choix suppression d'un acteur dans le tableau SQL
			System.out.println("Vous avez maintenant la possibilité de supprimer un acteur.");
			System.out.print("Quel acteur ou actrice voulez-vous supprimer ?\n Entrez son prénom et son nom :");			
			String acteurASupp = entreeClavierTexte.nextLine();
			Acteur acteurSupp = CrudActeurs.getActeur(session.getConnection(), acteurASupp);
			CrudActeurs.suppressionDonnee(session.getConnection(), acteurSupp);
			System.out.println("Vous avez supprimé : " + acteurASupp);
			break;
		case 5 : //choix sortie du programme
			System.out.println("Au revoir, merci de votre visite !");
			System.exit(1);
		}
	}
	public void sousMenuUpdateActeur () throws MalformedURLException, IOException, SQLException
	{
		System.out.println(sousMenu2); // Affichage du 2ème menu
		// Boucle si l'utilisateur entre un charactère hors champs
		do 
		{
			while(!entreeClavierInt.hasNextInt())
			{
				System.out.println("Entrée incorrect, recommencez");
		    	entreeClavierInt.next();
		    } choixSousMenu2 = entreeClavierInt.nextInt();
		}
		while (choixSousMenu2 < 1 || choixSousMenu2 > 4) ;// Jusqu'à ce que l'utilisateur choisisse entre 1 et 4
		
		if (choixSousMenu2 == 1) { // Choix saisie du nom du nouvel acteur
			System.out.println("Comment voulez-vous l'appeler ?");
			String saisieNom = entreeClavierTexte.nextLine(); // Saisie clavier de l'utilisateur
			Acteur acteurModif = CrudActeurs.getActeur(session.getConnection(), acteurAModif);
			acteurModif.setNoms(saisieNom);
			CrudActeurs.miseAJourTable(session.getConnection(), acteurModif);
			System.out.println("Acteur ou actrice renommé(e) ! "); // Modification effectuée
		} else if (choixSousMenu2 == 2) { // Choix saisie d'une nouvelle date (YYYY-MM-DD)
			System.out.println("Quand voulez vous qu'il ou elle soit né(e) ? (Format : YYYY-MM-DD)");
			String modifAnnee = entreeClavierTexte.nextLine(); // Saisie clavier de l'utilisateur
			Acteur acteur = CrudActeurs.getActeur(session.getConnection(), acteurAModif);
			acteur.setDateDeNaissance(modifAnnee);
			CrudActeurs.miseAJourTable(session.getConnection(), acteur);
			System.out.println("Date de naissance mise à jour !"); // Modification effectuée
		} else if (choixSousMenu2 == 3) { // Choix saisie d'un nouveau lieu par l'utilisateur
			System.out.println("Où voulez-vous qu'il ou elle soit né(e) ? ");
			String modifLieu = entreeClavierTexte.nextLine(); // Saisie clavier de l'utilisateur
			Acteur acteur = CrudActeurs.getActeur(session.getConnection(), acteurAModif);
			acteur.setLieuDeNaissance(modifLieu);
			CrudActeurs.miseAJourTable(session.getConnection(), acteur);
			System.out.println("Lieu de naissance mis à jour !"); // Modification effectuée
		} else if (choixSousMenu2 == 4) { // Choix saisie d'un nouveau sexe par l'utilisateur
			System.out.println("Si vous voulez lui changer de sexe, tappez Homme ou Femme :");
			String modifSexe = entreeClavierTexte.nextLine(); // Saisie clavier de l'utilisateur
			Acteur acteur = CrudActeurs.getActeur(session.getConnection(), acteurAModif);
			acteur.setSexe(modifSexe);
			CrudActeurs.miseAJourTable(session.getConnection(), acteur);
			System.out.println("Sexe mis à jour !"); // Modification effectuée
		} 
	}
}


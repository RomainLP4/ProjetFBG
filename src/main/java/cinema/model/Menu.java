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
	Scanner entreeClavier = new Scanner(System.in);
	public static String menuPrincipal = " 1. Acteur\n 2. Film\nVotre choix :";
	public static String sousMenu1 = "Et maintenant, que voulez vous faire ?\n1 | Ajouter un acteur.\n2 | Réafficher la table.\n3 | Modifier un paramètre. \n4 | Supprimer un acteur. \n5 | Sortir.";
	public static String sousMenu2 = "Quel paramètre voulez-vous modifier ?\n Pour modifier son nom, tapez 1.\n Pour modifier sa date de naissance, tapez 2.\n Pour modifier son lieu de naissance, tapez 3. \n Pour lui changer de sexe, tapez 4 !...";
	public static int choixMenuGeneral;
	public static int choixSousMenu1;
	public static int choixSousMenu2;
	
	public void menuGeneral () throws SQLException 
	{
		do 
		{								
			while(!entreeClavier.hasNextInt())
			{	        
				System.out.println("Entrée incorrect, recommencez");
				System.out.println(menuPrincipal);
				entreeClavier.next();
			} 
			choixMenuGeneral = entreeClavier.nextInt();
		}
		while(choixMenuGeneral < 1 || choixMenuGeneral > 2);

		if (choixMenuGeneral == 1) {
			System.out.println("Vous avez demandé d'afficher la table Acteur.");
			CrudActeurs.afficherTable(session.getConnection());
		} else {
			System.out.println("Vous avez demandé d'afficher la table Film");
			CrudFilms.afficherTableFilm(session.getConnection());
		}
	}
	public void sousMenuActeur () throws MalformedURLException, IOException, SQLException 
	{
		do 
		{			
			while(!entreeClavier.hasNextInt())
			{
				System.out.println("Entrée incorrect, recommencez");
		    	entreeClavier.next();
		    } choixSousMenu1 = entreeClavier.nextInt();
		}
		while (choixSousMenu1 < 1 || choixSousMenu1 > 5) ;
		
		switch (choixSousMenu1) {
		case 1 :
			System.out.println("Vous allez créer un nouvel acteur !");
			System.out.println("Entrez son prénom et son nom :");			
			String saisieNom = entreeClavier.next();			
			Acteur acteurCree = Requete.actorDetails(Requete.acteur(saisieNom));
			CrudActeurs.creationActeur(session.getConnection(), acteurCree);
			System.out.println("Vous avez ajouté " + saisieNom);
			break;
			// TODO si acteur inconnu
		case 2 :
			System.out.println("Vous voulez réafficher la table Acteur. Et bien, la voici :");
			CrudActeurs.afficherTable(session.getConnection());	
			break;		
		case 3 :
			System.out.println("Vous allez maintenant modifier un ou plusieurs paramètres d'un acteur.");
			System.out.print("Quel acteur ou actrice voulez-vous modifier ?\nEntrez son prénom et son nom :");
			sousMenuUpdateActeur();
			break;			
		case 4 :
			System.out.println("Vous avez maintenant la possibilité de supprimer un acteur.");
			System.out.print("Quel acteur ou actrice voulez-vous supprimer ?\n Entrez son prénom et son nom :");			
			String saisie = entreeClavier.next();
			Acteur acteurSupp = CrudActeurs.getActeur(session.getConnection(), saisie);
			CrudActeurs.suppressionDonnee(session.getConnection(), acteurSupp);
			System.out.println("Vous avez supprimé : " + saisie);
			break;
		case 5 :
			System.out.println("Au revoir, merci de votre visite !");
			System.exit(1);
		}
	}
	public void sousMenuUpdateActeur () throws MalformedURLException, IOException, SQLException
	{
		String saisie = entreeClavier.next();
		Acteur acteur = CrudActeurs.getActeur(session.getConnection(), saisie);
		if (acteur == null) {
		System.out.print("ERREEEEEUR \n Quel paramètre voulez-vous modifier ?");
		System.out.println(sousMenu2);
		}
		do 
		{
			while(!entreeClavier.hasNextInt())
			{
				System.out.println("Entrée incorrect, recommencez");
		    	entreeClavier.next();
		    } choixSousMenu2 = entreeClavier.nextInt();
		}
		while (choixSousMenu2 < 1 || choixSousMenu2 > 4) ;
		
		entreeClavier.nextLine();
		if (choixSousMenu2 == 1) {
			System.out.println("Comment voulez-vous l'appeler ?");
			String modifNom = entreeClavier.next();
			acteur.setNoms(modifNom);
			System.out.println("noms : " + acteur.getNoms());
			CrudActeurs.miseAJourTable(session.getConnection(), acteur);
		} else if (choixSousMenu2 == 2) {
			System.out.println("Quand voulez vous qu'il ou elle soit né(e) ?");
			String modifAnnee = entreeClavier.next();
			acteur.setDateDeNaissance(modifAnnee);
			CrudActeurs.miseAJourTable(session.getConnection(), acteur);
		} else if (choixSousMenu2 == 3) {
			System.out.println("Où voulez-vous qu'il ou elle soit né(e) ? ");
			String modifLieu = entreeClavier.next();
			acteur.setLieuDeNaissance(modifLieu);
			CrudActeurs.miseAJourTable(session.getConnection(), acteur);
		} else if (choixSousMenu2 == 4) {
			System.out.println("Si vous voulez lui changer de sexe, tappez Homme ou Femme :");
			String modifSexe = entreeClavier.next();
			acteur.setSexe(modifSexe);
			CrudActeurs.miseAJourTable(session.getConnection(), acteur);
		} 
	}
}


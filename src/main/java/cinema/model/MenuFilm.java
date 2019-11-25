package cinema.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import api.Requete;
import jdbc.CrudActeurs;
import jdbc.CrudFilms;
import jdbc.Session;

public class MenuFilm 
{
	Session session = new Session();
	Scanner entreeClavierInt = new Scanner(System.in); // Choix utilisateur destiné au menu(entier)
	Scanner entreeClavierTexte = new Scanner(System.in); // Choix utilisateur destiné aux noms, genres et dates(String)
	public String titreAModif; // Déclaration variable de classe afin de la rappeler n'importe où
	public static String menu1 = "Et maintenant, que voulez vous faire ?\n1 | Ajouter un film.\n2 | Réafficher la table.\n3 | Modifier un paramètre. \n4 | Supprimer un film. \n5 | Sortir.";
	public static String menu2 = "Quel paramètre voulez-vous modifier ?\n Pour modifier son nom, tappez 1.\n Pour modifier son annee de sortie, tappez 2.\n Pour modifier son genre, tappez 3 !...";
	public static int choixMenu1;
	public static int choixMenu2;
	
	// Menu principal de la partie film
	public void sousMenuFilm () throws SQLException, MalformedURLException, IOException 
	{
		// Boucle si l'utilisateur entre un charactère hors champs
		do 
		{								
			while(!entreeClavierInt.hasNextInt())
			{	        
				System.out.println("Entrée incorrect, recommencez");
				System.out.println(menu1);
				entreeClavierInt.next();
			} 
			choixMenu1 = entreeClavierInt.nextInt();
		}
		while(choixMenu1 < 1 || choixMenu1 > 5); // Jusqu'à ce que l'utilisateur choisisse entre 1 et 5

		switch (choixMenu1) { 
			case 1 : // choix ajout d'un nouveau titre dans le tableau SQL
			System.out.print("Vous voulez ajouter un nouveau film !\nEntrez son titre :");
			String saisieTitre = entreeClavierTexte.nextLine();
			Film filmCree = Requete.detailFilm(Requete.idFilm(saisieTitre));
			CrudFilms.creationFilm(session.getConnection(), filmCree);
			System.out.println("Nouveau film cree :" + saisieTitre);
			break;
			case 2 : // choix affichage de la table film depuis le tableau SQL
			System.out.println("Vous avez demandé d'afficher la table Film");
			CrudFilms.afficherTableFilm(session.getConnection());
			break;
			case 3 : // choix modification de paramètres dans le tableau SQL
			System.out.print("Vous allez maintenant modifier un ou plusieurs paramètres d'un film.\n Quel film voulez-vous modifier ?");			
			titreAModif = entreeClavierTexte.nextLine();
			System.out.println("vous avez choisi de modifier " + titreAModif);
			sousMenuFilmParametre();
			break;
			case 4 : // choix suppression d'un titre dans le tableau SQL
			System.out.println("Vous avez maintenant la possibilité de supprimer un film.");
			System.out.println("Quel film voulez-vous supprimer ?\n Entrez son nom :");
			String titreASupp = entreeClavierTexte.nextLine();
			Film filmSupp = Requete.detailFilm(Requete.idFilm(titreASupp));
			CrudFilms.suppressionFilm(session.getConnection(), filmSupp);
			System.out.println("Vous avez supprimé " + titreASupp);
			break;
			case 5 : //choix sortie du programme
			System.out.println("Au revoir, merci de votre visite !");
			System.exit(1);
		}
	}
	
	// Menu de la partie modification des paramètres
	public void sousMenuFilmParametre () throws MalformedURLException, IOException, SQLException 
	{
		System.out.println(menu2); // Affichage du 2ème menu
		// Boucle si l'utilisateur entre un charactère hors champs
		do 
		{			
			while(!entreeClavierInt.hasNextInt())
			{
				System.out.println("Entrée incorrect, recommencez");
				System.out.println(menu2);
		    	entreeClavierInt.next();
		    } choixMenu2 = entreeClavierInt.nextInt();
		}
		while (choixMenu2 < 1 || choixMenu2 > 3) ; // Jusqu'à ce que l'utilisateur choisisse entre 1 et 3
		
		if (choixMenu2 == 1) { // Choix saisie du nom du nouveau titre
			System.out.print("Comment voulez-vous l'appeler ?");			
			String saisieTitre = entreeClavierTexte.nextLine(); // Saisie clavier de l'utilisateur
			Film filmModif = CrudFilms.getFilm(session.getConnection(), titreAModif);
			filmModif.setTitre(saisieTitre);
			CrudFilms.miseAJourTableFilm(session.getConnection(), filmModif);
			System.out.println("Nouveau film renommé !"); // Modification effectuée
			
		} else if (choixMenu2 == 2) { // Choix saisie d'une nouvelle date (YYYY-MM-DD)
			System.out.println("Quand voulez vous qu'il soit sorti ?(Format : YYYY-MM-DD)");
			String modifAnnee = entreeClavierTexte.nextLine(); // Saisie clavier de l'utilisateur
			Film filmModif = CrudFilms.getFilm(session.getConnection(), titreAModif);
			filmModif.setAnnee(modifAnnee);
			CrudFilms.miseAJourTableFilm(session.getConnection(), filmModif);
			System.out.println("Date mise à jour !"); // Modification effectuée
			
		} else if (choixMenu2 == 3) { // Choix saisie d'un nouveau genre par l'utilisateur
			System.out.println("De quel genre voulez vous qu'il soit ? ");
			String modifGenre = entreeClavierTexte.nextLine(); // Saisie clavier de l'utilisateur
			Film filmModif = CrudFilms.getFilm(session.getConnection(), titreAModif);
			filmModif.setGenre(modifGenre);
			CrudFilms.miseAJourTableFilm(session.getConnection(), filmModif);
			System.out.println("Genre mis à jour !"); // Modification effectuée
		}
	}
}

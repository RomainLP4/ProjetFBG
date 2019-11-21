package cinema.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import api.Requete;
import jdbc.CrudFilms;
import jdbc.Session;

public class MenuFilm {
	 Session session = new Session();
	 Scanner sc = new Scanner(System.in);
	 
	 
	 
	

	public void sousMenuFilm() throws SQLException, MalformedURLException, IOException {
		int menu2 = 0;
		do {
			System.out.print("Et maintenant, que voulez vous faire ?");
			System.out.println(
					"\n1 | Ajouter un film.\n2 | Réafficher la table.\n3 | Modifier un paramètre. \n4 | Supprimer un film.");
			while (!sc.hasNextInt()) {
				System.out.println("Entrée incorrect, recommencez");
				sc.next();
			}
			menu2 = sc.nextInt();
		}

		while (menu2 < 1 || menu2 > 4);
		sc.nextLine();
		if (menu2 == 1) {
			System.out.println("Vous allez créer un nouveau film !");
			System.out.println("Entrez son titre :");

			//Scanner scFilm = new Scanner(System.in);
			String saisieTitre = sc.next();

			Film film = Requete.detailFilm(Requete.idFilm(saisieTitre));
			CrudFilms.creationFilm(session.getConnection(), film);

			// TODO si Film inconnu

		} else if (menu2 == 2) {
			System.out.println("Vous voulez réafficher la table Film. Et bien, la voici :");
			CrudFilms.afficherTableFilm(session.getConnection());

		} else if (menu2 == 3) {
			System.out.println("Vous allez maintenant modifier un ou plusieurs paramètres d'un film.");
			System.out.println("Quel film voulez-vous modifier ? ");

			//Scanner scFilm = new Scanner(System.in);
			//
			//System.out.println(film);
			//CrudFilms.miseAJourTableFilm(session.getConnection(), film);
			
			sousMenuUpdateFilm();

		} else if (menu2 == 4) {
			System.out.println("Vous avez maintenant la possibilité de supprimer un film.");
			System.out.println("Quel film voulez-vous supprimer ?\n Entrez son nom :");

			//Scanner scFilm = new Scanner(System.in);
			String titreASupp = sc.nextLine();
			//Film film = Requete.detailFilm(Requete.idFilm(titreASupp));//TODO a modifier par GetFilm
			Film film = CrudFilms.getFilm(session.getConnection(), titreASupp);
			
			if (film==null)System.out.println("EERRRRRRRRR");
			CrudFilms.suppressionFilm(session.getConnection(), film);
		}
		

	}

	public void sousMenuUpdateFilm() throws SQLException, MalformedURLException, IOException {
		
		int menu3 = 0;
		String titreAModif = sc.nextLine();
		//Film film = Requete.detailFilm(Requete.idFilm(titreAModif));//TODO a modif avec GetFilm
		Film film = CrudFilms.getFilm(session.getConnection(), titreAModif);
		System.out.println("Quel paramètre voulez-vous modifier ?");
		System.out.println(" Pour modifier son nom, tappez 1.\n Pour modifier son annee de sortie, tappez 2.\n Pour modifier son genre, tappez 3 !...");
		
		//Scanner scFilm = new Scanner(System.in);
		
		do {

			while (!sc.hasNextInt()) {
				System.out.println("Entrée incorrect, recommencez");
				sc.next();
			}
			menu3 = sc.nextInt();
		}

		while (menu3 < 1 || menu3 > 3);
		sc.nextLine();

		if (menu3 == 1) {
			System.out.println("Comment voulez-vous l'appeler ?");
			//String saisieTitre = sc.nextLine();
			//Film film = CrudFilms.getFilm(session.getConnection(), saisieTitre);
			//Scanner scModif = new Scanner(System.in);
			String modifTitre = sc.nextLine();
			//System.out.println(modifTitre);
			film.setTitre(modifTitre);
			CrudFilms.miseAJourTableFilm(session.getConnection(), film);

		} else if (menu3 == 2) {
			System.out.println("Quand voulez vous qu'il soit sorti ?");

			//Scanner scModif2 = new Scanner(System.in);
			String modifAnnee = sc.next();

			film.setAnnee(modifAnnee);
			CrudFilms.miseAJourTableFilm(session.getConnection(), film);

		} else if (menu3 == 3) {
			System.out.println("De quel genre voulez vous qu'il soit ? ");

			//Scanner scModif3 = new Scanner(System.in);
			String modifGenre = sc.next();

			film.setGenre(modifGenre);
			CrudFilms.miseAJourTableFilm(session.getConnection(), film);

		}

	}
}

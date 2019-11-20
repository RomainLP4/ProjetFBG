package cinema.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import api.Requete;
import jdbc.CrudFilms;
import jdbc.Session;

public class MenuFilm {
	static Session session = new Session();
	static Scanner sc = new Scanner(System.in);
	static int menu = 0;
	static int menu2 = 0;
	static int menu3 = 0;
	private static String titreAModif;

	public static void sousMenuFilm() throws SQLException, MalformedURLException, IOException {

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

		if (menu2 == 1) {
			System.out.println("Vous allez créer un nouveau film !");
			System.out.println("Entrez son titre :");

			Scanner scFilm = new Scanner(System.in);
			String saisieTitre = scFilm.nextLine();

			Film film = Requete.detailFilm(Requete.idFilm(saisieTitre));
			CrudFilms.creationFilm(session.getConnection(), film);

			// TODO si Film inconnu

		} else if (menu2 == 2) {
			System.out.println("Vous voulez réafficher la table Film. Et bien, la voici :");
			CrudFilms.afficherTableFilm(session.getConnection());

		} else if (menu2 == 3) {
			System.out.println("Vous allez maintenant modifier un ou plusieurs paramètres d'un film.");
			System.out.println("Quel film voulez-vous modifier ? ");

			Scanner scFilm = new Scanner(System.in);
			String titreAModif = scFilm.nextLine();
			Film film = Requete.detailFilm(Requete.idFilm(titreAModif));
			CrudFilms.miseAJourTableFilm(session.getConnection(), film);
			MenuFilm.sousMenuUpdateFilm();

		} else if (menu2 == 4) {
			System.out.println("Vous avez maintenant la possibilité de supprimer un film.");
			System.out.println("Quel film voulez-vous supprimer ?\n Entrez son nom :");

			Scanner scFilm = new Scanner(System.in);
			String titreASupp = scFilm.nextLine();
			Film film = Requete.detailFilm(Requete.idFilm(titreASupp));
			CrudFilms.suppressionFilm(session.getConnection(), film);
		}
		

	}

	public static void sousMenuUpdateFilm() throws SQLException, MalformedURLException, IOException {
		System.out.println("Quel paramètre voulez-vous modifier ?");
		System.out.println(" Pour modifier son nom, tappez 1.\n Pour modifier son annee de sortie, tappez 2.\n Pour modifier son genre, tappez 3 !...");
		Scanner scFilm = new Scanner(System.in);
		String saisieTitre = scFilm.nextLine();
		Film film = Requete.detailFilm(Requete.idFilm(saisieTitre));

		do {

			while (!sc.hasNextInt()) {
				System.out.println("Entrée incorrect, recommencez");
				sc.next();
			}
			menu3 = sc.nextInt();
		}

		while (menu3 < 1 || menu3 > 4);

		if (menu3 == 1) {
			System.out.println("Comment voulez-vous l'appeler ?");

			Scanner scModif = new Scanner(System.in);
			String modifTitre = scModif.nextLine();

			Requete.detailFilm(Requete.idFilm(titreAModif)).setTitre(modifTitre);
			CrudFilms.miseAJourTableFilm(session.getConnection(), Requete.detailFilm(Requete.idFilm(modifTitre)));

		} else if (menu3 == 2) {
			System.out.println("Quand voulez vous qu'il soit sorti ?");

			Scanner scModif2 = new Scanner(System.in);
			String modifAnnee = scModif2.nextLine();

			Requete.detailFilm(Requete.idFilm(titreAModif)).setAnnee(modifAnnee);
			CrudFilms.miseAJourTableFilm(session.getConnection(), Requete.detailFilm(Requete.idFilm(modifAnnee)));

		} else if (menu3 == 3) {
			System.out.println("De quel genre voulez vous qu'il soit ? ");

			Scanner scModif3 = new Scanner(System.in);
			String modifGenre = scModif3.nextLine();

			Requete.detailFilm(Requete.idFilm(titreAModif)).setGenre(modifGenre);
			CrudFilms.miseAJourTableFilm(session.getConnection(), Requete.detailFilm(Requete.idFilm(modifGenre)));

		}

	}
}

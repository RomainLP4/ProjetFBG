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
	Scanner entreeClavier = new Scanner(System.in);
	public static String menu1 = "Et maintenant, que voulez vous faire ?\n1 | Ajouter un film.\n2 | Réafficher la table.\n3 | Modifier un paramètre. \n4 | Supprimer un film. \n5 | Sortir.";
	public static String menu2 = "Quel paramètre voulez-vous modifier ?\n Pour modifier son nom, tappez 1.\n Pour modifier son annee de sortie, tappez 2.\n Pour modifier son genre, tappez 3 !...";
	public static int choixMenu1;
	public static int choixMenu2;
	
	public void sousMenuFilm1 () throws SQLException, MalformedURLException, IOException 
	{
		do 
		{								
			while(!entreeClavier.hasNextInt())
			{	        
				System.out.println("Entrée incorrect, recommencez");
				System.out.println(menu1);
				entreeClavier.next();
			} 
			choixMenu1 = entreeClavier.nextInt();
		}
		while(choixMenu1 < 1 || choixMenu1 > 5);

		switch (choixMenu1) {
			case 1 :
			System.out.print("Vous voulez ajouter un nouveau film !\nEntrez son titre :");
			String saisieTitre = entreeClavier.next();
			Film filmCree = Requete.detailFilm(Requete.idFilm(saisieTitre));
			CrudFilms.creationFilm(session.getConnection(), filmCree);
			System.out.println("Nouveau film cree :" + saisieTitre);
			break;
			case 2 :
			System.out.println("Vous avez demandé d'afficher la table Film");
			CrudFilms.afficherTableFilm(session.getConnection());
			break;
			case 3 :
			System.out.print("Vous allez maintenant modifier un ou plusieurs paramètres d'un film.\n Quel film voulez-vous modifier ?");			
			sousMenuFilm2();
			break;
			case 4 :
			System.out.println("Vous avez maintenant la possibilité de supprimer un film.");
			System.out.println("Quel film voulez-vous supprimer ?\n Entrez son nom :");
			String titreASupp = entreeClavier.next();
			Film filmSupp = Requete.detailFilm(Requete.idFilm(titreASupp));
			CrudFilms.suppressionFilm(session.getConnection(), filmSupp);
			System.out.println("Vous avez supprimé " + titreASupp);
			break;
			case 5 :
			System.out.println("Au revoir, merci de votre visite !");
			System.exit(1);
		}
	}	
	public void sousMenuFilm2 () throws MalformedURLException, IOException, SQLException 
	{
		String titreAModif = entreeClavier.next();
		Film filmModif = CrudFilms.getFilm(session.getConnection(), titreAModif);
		System.out.println("vous avez choisi de modifier " + titreAModif);
		System.out.println(menu2);
		do 
		{			
			while(!entreeClavier.hasNextInt())
			{
				System.out.println("Entrée incorrect, recommencez");
		    	entreeClavier.next();
		    } choixMenu2 = entreeClavier.nextInt();
		}
		while (choixMenu2 < 1 || choixMenu2 > 3) ;
		
		if (choixMenu2 == 1) {
			System.out.print("Comment voulez-vous l'appeler ?");			
			String saisieTitre = entreeClavier.next();			
			filmModif.setTitre(saisieTitre);
			CrudFilms.miseAJourTableFilm(session.getConnection(), filmModif);
			System.out.println("Nouveau film renommé !");
		} else if (choixMenu2 == 2) {
			System.out.println("Quand voulez vous qu'il soit sorti ?");
			String modifAnnee = entreeClavier.next();
			filmModif.setAnnee(modifAnnee);
			CrudFilms.miseAJourTableFilm(session.getConnection(), filmModif);
			System.out.println("Date mise à jour !");
		} else if (choixMenu2 == 3) {
			System.out.println("De quel genre voulez vous qu'il soit ? ");
			String modifGenre = entreeClavier.next();
			filmModif.setGenre(modifGenre);
			CrudFilms.miseAJourTableFilm(session.getConnection(), filmModif);
			System.out.println("Genre mis à jour !");
		}
	}
}

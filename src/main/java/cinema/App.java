package cinema;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import menu.Menu;
import menu.MenuFilm;
// Classe du main
public class App 
{
	public static void main(String[] args) throws SQLException, MalformedURLException, IOException 
	{
		Menu menuActeur = new Menu(); // Nouvelle instance acteur
		MenuFilm menuFilm = new MenuFilm(); // Nouvelle instance film
		System.out.println("Bonjour, quelle table voulez vous afficher?");
		System.out.println(Menu.menuPrincipal); // Affichage du menu. Appel depuis la classe Menu
		menuActeur.menuGeneral(); // Appel de la methode depuis la classe Menu
		if (Menu.choixMenuGeneral == 1) // Redirige vers la partie acteur
		{
			// Boucle de la partie acteur avec possibilité de sortie via le menu
			do 
			{				
				System.out.println(Menu.sousMenu1);
				System.out.println("Votre choix :");
				menuActeur.sousMenuActeur();
				if (Menu.choixSousMenu1 == 6) // Choix affichage des tableaux acteurs ou film
				{
					System.out.println(Menu.menuPrincipal);
					menuActeur.menuGeneral();
				}
			}
			while(MenuFilm.choixMenu1 < 1); // Condition toujours vrai(boucle infinie)
		} else { // Sinon redirection vers la partie film
			// Boucle de la partie film avec possibilité de sortie via le menu
			do 
			{				
				System.out.println(MenuFilm.menu1);
				System.out.println("Votre choix :");
				menuFilm.sousMenuFilm();
				if (MenuFilm.choixMenu1 == 5) // Choix affichage des tableaux acteurs ou film
				{
					System.out.println(Menu.menuPrincipal);
					menuActeur.menuGeneral();
				}
			}
			while (Menu.choixSousMenu1 < 1); // Condition toujours vrai(boucle infinie)
		}
	}
} // Fin de la classe main

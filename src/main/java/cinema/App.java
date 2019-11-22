package cinema;

import cinema.model.MenuActeur1;
import cinema.model.MenuFilm1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class App
{

	public static void main(String[] args) throws SQLException, MalformedURLException, IOException 
	{
		MenuActeur1 menuActeur = new MenuActeur1();
		MenuFilm1 menuFilm = new MenuFilm1();
		System.out.println("Bonjour, quelle table voulez vous afficher?");
		System.out.println(MenuActeur1.menuPrincipal);		
		menuActeur.menuGeneral();
		if (MenuActeur1.choixMenuGeneral == 1) 
		{
			do 
			{				
				System.out.println(MenuActeur1.sousMenu1);
				System.out.println("Votre choix :");
				menuActeur.sousMenuActeur();
			}
			while(MenuFilm1.choixMenu1 < 1 || MenuFilm1.choixMenu1 > 5);
		} else {
			do 
			{				
				System.out.println(MenuFilm1.menu1);
				System.out.println("Votre choix :");
				menuFilm.sousMenuFilm1();
			}
			while (MenuActeur1.choixSousMenu1 < 1 || MenuActeur1.choixSousMenu1 > 5);
		}
	}
}

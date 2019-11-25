package cinema;

import cinema.model.Menu;
import cinema.model.MenuFilm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class App
{

	public static void main(String[] args) throws SQLException, MalformedURLException, IOException 
	{
		Menu menuActeur = new Menu();
		MenuFilm menuFilm = new MenuFilm();
		System.out.println("Bonjour, quelle table voulez vous afficher?");
		System.out.println(Menu.menuPrincipal);		
		menuActeur.menuGeneral();
		if (Menu.choixMenuGeneral == 1) 
		{
			do 
			{				
				System.out.println(Menu.sousMenu1);
				System.out.println("Votre choix :");
				menuActeur.sousMenuActeur();
			}
			while(MenuFilm.choixMenu1 < 1 || MenuFilm.choixMenu1 > 5);
		} else {
			do 
			{				
				System.out.println(MenuFilm.menu1);
				System.out.println("Votre choix :");
				menuFilm.sousMenuFilm();
			}
			while (Menu.choixSousMenu1 < 1 || Menu.choixSousMenu1 > 5);
		}
	}
}

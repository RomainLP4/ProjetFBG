package cinema;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import cinema.model.Menu;

public class App {

	public static void main(String[] args) throws MalformedURLException, IOException, SQLException {

		Menu menu = new Menu();
		
		menu.choixDeLaTable();
		
	}

}

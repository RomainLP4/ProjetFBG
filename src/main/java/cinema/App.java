package cinema;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;

import api.Requete;

import java.util.*;
import cinema.model.Acteur;
import cinema.model.Film;
import cinema.model.Menu;

import jdbc.CrudActeurs;
import jdbc.CrudFilms;
import jdbc.Session;

public class App {

	public static void main(String[] args) throws MalformedURLException, IOException, SQLException {

		Menu menu = new Menu();
		
		menu.choixDeLaTable();
		
	}

}

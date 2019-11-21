package jdbc;

import java.sql.*;
import java.text.MessageFormat;

import cinema.model.Acteur;
import cinema.model.Film;

public class CrudFilms {

	public final static String ACTEUR_TABLE = "cinema.acteur";
	public final static String FILM_TABLE = "cinema.film";
	
	
	public static Film getFilm (Connection connect,String titre) throws SQLException {
		String req = "select * from cinema.film where Titre=?";
		PreparedStatement etat = connect.prepareStatement(req);
		
		etat.setString(1, titre);
		System.out.println(titre);
		ResultSet resultat = etat.executeQuery();
		Film film = null;
		while(resultat.next()) {
			System.out.println("i'm here");
			int idf = resultat.getInt("idf");
			String titres = resultat.getString("Titre");
			String annee = resultat.getString("Annee");
			String genre = resultat.getString("Genre");
			
			film = new Film(idf, titres, annee, genre);
		}
		etat.close();
		return film;
	}

	// READ ok
	public static void afficherTableFilm(Connection connect) throws SQLException {
		Statement etat = connect.createStatement();
		String requete = "select * from cinema.film";

		ResultSet resultat = etat.executeQuery(requete);
		ResultSetMetaData resultAutoReference = resultat.getMetaData();
		int colonneNum = resultAutoReference.getColumnCount();

		while (resultat.next()) {
			for (int ligne = 1; ligne < colonneNum; ligne++) {
				String valeurColonne = resultat.getString(ligne);
				String nomColonne = resultAutoReference.getColumnName(ligne);
				System.out.print(MessageFormat.format("<{0}>\t\t", valeurColonne));
			}
			System.out.println();
		}
	}

	// CREATE ok
	public static void creationFilm(Connection connect, cinema.model.Film nvFilm) {
		PreparedStatement etat;
		String requete = "insert into cinema.film values(?, ?, ?, ?)";
		try {
			etat = connect.prepareStatement(requete);

			etat.setInt(1, nvFilm.getIdf());
			etat.setString(2, nvFilm.getTitre());
			etat.setString(3, nvFilm.getAnnee());
			etat.setString(4, nvFilm.getGenre());
			

			etat.executeUpdate();
			etat.close();

		} catch (SQLException e) {
			System.out.println("ERREUR ! ");
			e.printStackTrace();
		}
	}

	// UPDATE OK
	public static void miseAJourTableFilm(Connection connect, cinema.model.Film filmModifier) throws SQLException {
		PreparedStatement etat = connect.prepareStatement("update cinema.film set Titre = ?, Annee = ?, Genre = ? where idf = ?");
		
		etat.setString(1, filmModifier.getTitre());
		etat.setString(2, filmModifier.getAnnee());
		etat.setString(3, filmModifier.getGenre());
		etat.setInt(4, filmModifier.getIdf());

		etat.executeUpdate();
		etat.close();
	}

	// DELETE OK
	public static void suppressionFilm(Connection connect, cinema.model.Film filmSupprimer) throws SQLException {
		PreparedStatement etat = connect.prepareStatement("delete from cinema.film where Titre = ? ");
		etat.setString(1, filmSupprimer.getTitre());

		etat.executeUpdate();
		etat.close();
	}
}
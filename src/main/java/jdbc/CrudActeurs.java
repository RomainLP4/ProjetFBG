package jdbc;

import java.sql.*;
import java.text.MessageFormat;

import cinema.model.Acteur;

public class CrudActeurs {
	public final static String ACTEUR_TABLE = "cinema.acteur";
	public final static String FILM_TABLE = "cinema.film";

	// READ ok
	public static void afficherTable(Connection connect) throws SQLException {
		Statement etat = connect.createStatement();
		String requete = "select * from cinema.acteur";

		ResultSet resultat = etat.executeQuery(requete);
		ResultSetMetaData resultAutoReference = resultat.getMetaData();
		int colonneNum = resultAutoReference.getColumnCount();

		while (resultat.next()) {
			for (int ligne = 1; ligne < colonneNum; ligne++) {
				String valeurColonne = resultat.getString(ligne);
				
				System.out.print(MessageFormat.format("<{0}>\t\t", valeurColonne));
			}
			System.out.println();
		}
	}

	// recup l'acteur par son nom dans la DB
	public static Acteur getActeur(Connection connect, String nom) throws SQLException {
		String req = "select * from cinema.acteur where Nom=?";
		PreparedStatement etat = connect.prepareStatement(req);
		etat.setString(1, nom);
		ResultSet resultat = etat.executeQuery();
		Acteur acteur = null;
		while (resultat.next()) {
			int ida = resultat.getInt("Ida");
			String noms = resultat.getString("Nom");
			String dateDeNaissance = resultat.getString("DateDeNaissance");
			String lieuDeNaissance = resultat.getString("lieuDeNaissance");
			String sexe = resultat.getString("Sexe");
			acteur = new Acteur(ida, noms, dateDeNaissance, lieuDeNaissance, sexe);

		}
		etat.close();
		return acteur;
	}

	// CREATE ok
	public static void creationActeur(Connection connect, Acteur nvActeur) {
		PreparedStatement etat;
		String requete = "insert into cinema.acteur values(?, ?, ?, ?, ?)";
		try {
			etat = connect.prepareStatement(requete);

			etat.setInt(1, nvActeur.getIda());
			etat.setString(2, nvActeur.getNoms());
			etat.setString(3, nvActeur.getDateDeNaissance());
			etat.setString(4, nvActeur.getLieuDeNaissance());
			etat.setString(5, nvActeur.getSexe());

			etat.executeUpdate();
			etat.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	// UPDATE ok
	public static void miseAJourTable(Connection connect, cinema.model.Acteur acteurModifier) throws SQLException {
		PreparedStatement etat = connect.prepareStatement(
				"update cinema.acteur set Nom= ?, DateDeNaissance= ?,LieuDeNaissance= ?, Sexe=? where ida=?");
		etat.setString(1, acteurModifier.getNoms());
		etat.setString(2, acteurModifier.getDateDeNaissance());
		etat.setString(3, acteurModifier.getLieuDeNaissance());
		etat.setString(4, acteurModifier.getSexe());
		etat.setInt(5, acteurModifier.getIda());

		etat.executeUpdate();
		etat.close();
	}

	// DELETE OK
	public static void suppressionDonnee(Connection connect, cinema.model.Acteur acteurSupprimer) throws SQLException {
		PreparedStatement etat = connect.prepareStatement("delete from cinema.acteur where Nom = ? ");
		etat.setString(1, acteurSupprimer.getNoms());

		etat.executeUpdate();
		etat.close();
	}
}

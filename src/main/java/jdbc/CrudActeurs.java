package jdbc;
import java.sql.*;
import java.text.MessageFormat;

public class CrudActeurs 
{
	public final static String ACTEUR_TABLE = "cinema.acteurs";
	public final static String  FILM_TABLE = "cinema.films";
	
	public static void afficherTable (Connection connect, String nomTableau) throws SQLException 
	{
		Statement etat = connect.createStatement();
		String requete = "select from " + nomTableau;
		
		ResultSet resultat = etat.executeQuery(requete);
		ResultSetMetaData resultAutoReference = resultat.getMetaData();
		int colonneNum = resultAutoReference.getColumnCount();
		
		while (resultat.next()) 
		{
			for (int ligne = 0; ligne < colonneNum; ligne++) 
			{
				String valeurColonne = resultat.getString(ligne);
				String nomColonne = resultAutoReference.getColumnName(ligne);
				System.out.println(MessageFormat.format("<{0}:{1}>\t\t", valeurColonne, nomColonne));
			}
			System.out.println();
		}		
	}
	public static void creationActeur (Connection connect, cinema.model.Acteur nvActeur) throws SQLException
	{
		PreparedStatement etat = connect.prepareStatement("insert into" + ACTEUR_TABLE + "value IDa = ?, value Noms = ?, value Prenoms = ?, value Age = ?, value Nationalite = ?, value Sexe = ? ");
		etat.setInt(1, nvActeur.getIda());
		etat.setString(2, nvActeur.getNoms());
		etat.setString(3,nvActeur.getPrenoms());
		etat.setInt(4, nvActeur.getAge());
		etat.setString(5, nvActeur.getNationalite());
		etat.setString(6, nvActeur.getSexe());
		
		etat.executeUpdate();
	}
	// update
	public static void miseAJourTable (Connection connect, cinema.model.Acteur acteurModifier ) throws SQLException 
	{
		PreparedStatement etat = connect.prepareStatement("update " + ACTEUR_TABLE + "value IDa = ?, value Noms = ?, value Prenoms = ?, value Age = ?, value Nationalite = ?, value Sexe = ? ");
		etat.setInt(1, acteurModifier.getIda());
		etat.setString(2, acteurModifier.getNoms());
		etat.setString(3,acteurModifier.getPrenoms());
		etat.setInt(4, acteurModifier.getAge());
		etat.setString(5, acteurModifier.getNationalite());
		etat.setString(6, acteurModifier.getSexe());
		
		etat.executeUpdate();
	}
	// delete
	public static void suppressionDonnee (Connection connect, cinema.model.Acteur acteurSupprimer) throws SQLException 
	{
		PreparedStatement etat = connect.prepareStatement("delete " + ACTEUR_TABLE + "where IDa = ? ");
		etat.setInt(1, acteurSupprimer.getIda());
		etat.setString(2, acteurSupprimer.getNoms());
		etat.setString(3,acteurSupprimer.getPrenoms());
		etat.setInt(4, acteurSupprimer.getAge());
		etat.setString(5, acteurSupprimer.getNationalite());
		etat.setString(6, acteurSupprimer.getSexe());
		
		etat.executeUpdate();
	}
}

package jdbc;
import java.sql.*;
import java.text.MessageFormat;

public class CrudActeurs 
{
	public final static String ACTEUR_TABLE = "cinema.acteurs";
	public final static String  FILM_TABLE = "cinema.films";
	
	
	//READ
	public static void afficherTable (Connection connect, String nomTableau) throws SQLException 
	{
		Statement etat = connect.createStatement();
		String requete = "select * from " + nomTableau;
		
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
	
	//CREATE
	public static void creationActeur (Connection connect, cinema.model.Acteur nvActeur) throws SQLException
	{
		PreparedStatement etat = connect.prepareStatement("insert into" + ACTEUR_TABLE + "value IDa = ?, value Noms = ?, value DateDeNaissance = ?, value LieuDeNaissance = ?, value Sexe = ? ");
		etat.setInt(1, nvActeur.getIda());
		etat.setString(2, nvActeur.getNoms());
		etat.setString(3, nvActeur.getDateDeNaissance());
		etat.setString(4, nvActeur.getLieuDeNaissance());
		etat.setString(5, nvActeur.getSexe());
		
		etat.executeUpdate();
		etat.close();
	}
	// UPDATE
	public static void miseAJourTable (Connection connect, cinema.model.Acteur acteurModifier ) throws SQLException 
	{
		PreparedStatement etat = connect.prepareStatement("update " + ACTEUR_TABLE + "value IDa = ?, value Noms = ?, value DateDeNaissance = ?, value LieuDeNaissance = ?, value Sexe = ? ");
		etat.setInt(1, acteurModifier.getIda());
		etat.setString(2, acteurModifier.getNoms());
		etat.setString(3, acteurModifier.getDateDeNaissance());
		etat.setString(4, acteurModifier.getLieuDeNaissance());
		etat.setString(5, acteurModifier.getSexe());
		
		etat.executeUpdate();
		etat.close();
	}
	// DELETE
	public static void suppressionDonnee (Connection connect, cinema.model.Acteur acteurSupprimer) throws SQLException 
	{
		PreparedStatement etat = connect.prepareStatement("delete " + ACTEUR_TABLE + "where IDa = ? ");
		etat.setInt(1, acteurSupprimer.getIda());
		etat.setString(2, acteurSupprimer.getNoms());
		etat.setString(3, acteurSupprimer.getDateDeNaissance());
		etat.setString(4, acteurSupprimer.getLieuDeNaissance());
		etat.setString(5, acteurSupprimer.getSexe());
		
		etat.executeUpdate();
		etat.close();
	}
}

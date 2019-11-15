package jdbc;
import java.sql.*;
import java.text.MessageFormat;

public class CrudActeurs 
{
	public final static String UTILISATEUR_TABLE = "cinema.acteurs";
	
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
	public static void creationTable (Connection connect, cinema.model.Acteur nvActeur) throws SQLException
	{
		PreparedStatement etat = connect.prepareStatement("insert into" + UTILISATEUR_TABLE + "value IDa = ?, value Nom = ?, value Prenom = ?, value Age = ?, value Nationalite = ?, value Sexe = ? ");
		etat.setInt(1, nvActeur.getIda());
		etat.setString(2, nvActeur.getNom());
		etat.setString(3,nvActeur.getPrenom());
		etat.setInt(4, nvActeur.getAge());
		etat.setString(5, nvActeur.getNationalite());
		etat.setString(6, nvActeur.getSex());
		
		etat.executeUpdate();
	}
	public static void miseAJourTable (Connection connect, cinema.model.Acteur acteurModifier ) throws SQLException 
	{
		PreparedStatement etat = connect.prepareStatement("update " + UTILISATEUR_TABLE + "value IDa = ?, value Nom = ?, value Prenom = ?, value Age = ?, value Nationalite = ?, value Sexe = ? ");
		etat.setInt(1, acteurModifier.getIda());
		etat.setString(2, acteurModifier.getNom());
		etat.setString(3,acteurModifier.getPrenom());
		etat.setInt(4, acteurModifier.getAge());
		etat.setString(5, acteurModifier.getNationalite());
		etat.setString(6, acteurModifier.getSex());
		
		etat.executeUpdate();
	}
	// delete
	public static void suppressionDonnee (Connection connect, cinema.model.Acteur acteurSupprimer) throws SQLException 
	{
		PreparedStatement etat = connect.prepareStatement("delete " + UTILISATEUR_TABLE + "value IDa = ?, value Nom = ?, value Prenom = ?, value Age = ?, value Nationalite = ?, value Sexe = ? ");
		etat.setInt(1, acteurSupprimer.getIda());
		etat.setString(2, acteurSupprimer.getNom());
		etat.setString(3,acteurSupprimer.getPrenom());
		etat.setInt(4, acteurSupprimer.getAge());
		etat.setString(5, acteurSupprimer.getNationalite());
		etat.setString(6, acteurSupprimer.getSex());
		
		etat.executeUpdate();
	}
}

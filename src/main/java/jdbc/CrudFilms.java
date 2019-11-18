package jdbc;
import java.sql.*;
import java.text.MessageFormat;


public class CrudFilms {

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
		public static void creationFilm (Connection connect, cinema.model.Film nvFilm) throws SQLException
		{
			PreparedStatement etat = connect.prepareStatement("insert into" + FILM_TABLE + "value Idf = ?, value Titre = ?, value Annee = ?, value Genre = ?");
			etat.setInt(1, nvFilm.getIdf());
			etat.setString(2, nvFilm.getTitre());
			etat.setInt(3,nvFilm.getAnnee());			
			etat.setString(4, nvFilm.getGenre());
			
			etat.executeUpdate();
			etat.close();
		}
		
		
		// UPDATE
		public static void miseAJourTableFilm (Connection connect, cinema.model.Film filmModifier ) throws SQLException 
		{
			PreparedStatement etat = connect.prepareStatement("update " + FILM_TABLE + "value Idf = ?, value Titre = ?, value Annee = ?, value Genre = ?");
			etat.setInt(1, filmModifier.getIdf());
			etat.setString(2, filmModifier.getTitre());
			etat.setInt(3, filmModifier.getAnnee());
			etat.setString(4, filmModifier.getGenre());
			
			etat.executeUpdate();
			etat.close();
		}	
			
		// DELETE
		public static void suppressionDonneeFilm (Connection connect, cinema.model.Film filmSupprimer) throws SQLException 
		{
			PreparedStatement etat = connect.prepareStatement("delete " + FILM_TABLE + "where Idf = ? ");
			etat.setInt(1, filmSupprimer.getIdf());
			etat.setString(2, filmSupprimer.getTitre());
			etat.setInt(3,filmSupprimer.getAnnee());
			etat.setString(4, filmSupprimer.getGenre());	
				
			etat.executeUpdate();
			etat.close();
		}
			
	
	
}

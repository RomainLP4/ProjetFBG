package jdbc;
import java.sql.*;

public class CrudActeurs 
{
	public final static String UTILISATEUR_TABLE = "cinema.acteurs";
	
	public static void creationTable (Connection connect, cinema.model.Acteur nvActeur)
	{
		Statement etat = connect.createStatement();
	}
}

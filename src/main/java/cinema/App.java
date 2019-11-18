package cinema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import cinema.model.Acteur;


public class App {

//	public  static String lieu;
//	public static String name;
//	public static String birth;
//	public static String sexe;
//	public int actorID;

	private static String IMDB_KEY = "0e6260469751f4d597183df49e4810b2";

	public static String jsonFileName = "sample.json";

	public int idFilm(String titre) throws MalformedURLException, IOException 
	{
		String url = "https://api.themoviedb.org/3/search/movie?api_key="+IMDB_KEY+"&query="+titre;
		String jsonText = IOUtils.toString(new URL(url), Charset.forName("UTF-8"));
		writeJson(jsonText);
		
		JSONObject jsonComplet = new JSONObject(jsonText);
		JSONArray main = jsonComplet.getJSONArray("results");

		int filmID = (int) main.getJSONObject(0).get("id");
		return filmID;
	}
	// detail film
	public void detailFilm(int filmID) throws MalformedURLException, IOException 
	{
		String urlDetailFilm = "https://api.themoviedb.org/3/movie/"+filmID+"?api_key="+IMDB_KEY+"&language=en-US";
		
		String jsonText = IOUtils.toString(new URL(urlDetailFilm), Charset.forName("UTF-8"));
		writeJson(jsonText);
		
		JSONObject jsonComplet = new JSONObject(jsonText);
		String date = jsonComplet.getString("release_date");
		JSONArray genre1 = jsonComplet.getJSONArray("genres");
		String genre = (String) genre1.getJSONObject(0).get("name");
		
		System.out.println(date);
		System.out.println(genre);
	}

	public int acteur(String actor) throws MalformedURLException, IOException {
		String urlActorID = "https://api.themoviedb.org/3/search/person?api_key=" + IMDB_KEY + "&language=en-US&query="
				+ actor + "&page=1&include_adult=false\r\n" + "";

		String jsonText = IOUtils.toString(new URL(urlActorID), Charset.forName("UTF-8"));
		writeJson(jsonText);

		JSONObject jsonComplet = new JSONObject(jsonText);
		JSONArray main = jsonComplet.getJSONArray("results");

		int actorID = main.getJSONObject(0).getInt("id");
		System.out.println(actorID);
		return actorID;


	}

	public Acteur actorDetails(int actorID) throws MalformedURLException, IOException {

		String sexe;
		String urlActorDetail = "https://api.themoviedb.org/3/person/" + actorID + "?api_key=" + IMDB_KEY+ "&language=en-US";

		String jsonText = IOUtils.toString(new URL(urlActorDetail), Charset.forName("UTF-8"));
		writeJson(jsonText);

		JSONObject jsonComplet = new JSONObject(jsonText);
		String name = jsonComplet.getString("name");
		String birth = jsonComplet.getString("birthday");
		String lieu = jsonComplet.getString("place_of_birth");
		int gender = jsonComplet.getInt("gender");

		if (gender == 1) {
			sexe = "Femme";
		} else if (gender == 2) {
			sexe = "Homme";
		}

		else {
			 sexe = "Inconnu";
		}
		System.out.println(lieu);
		System.out.println(name);
		System.out.println(birth);
		System.out.println(sexe);
		return new Acteur(actorID, name, birth, lieu, sexe);


	}

		public void actorFilm (int actorID) throws MalformedURLException, IOException {
			String urlActorFilm = "https://api.themoviedb.org/3/person/"+actorID+"/movie_credits?api_key="+IMDB_KEY+"&language=en-US\r\n" + "";
			String jsonText = IOUtils.toString(new URL(urlActorFilm), Charset.forName("UTF-8"));
			writeJson(jsonText);

			
//			String titre = jsonComplet.getString("original_title");
			
			
			JSONObject jsonComplet = new JSONObject(jsonText);
			JSONArray main = jsonComplet.getJSONArray("cast");
			
			int l = jsonComplet.getJSONArray("cast").length();
			for (int i = 0; i < l; i++) {
				
				String titre = main.getJSONObject(i).getString("original_title");
				//System.out.println(titre);
			}

			

		}

	public static void writeJson(String jsonText) {
		BufferedWriter bw;

		try {
			bw = new BufferedWriter(new FileWriter(jsonFileName));
			bw.write(jsonText);
			bw.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		App test = new App();
		//Acteur julia = new Acteur(5,name, birth, lieu, sexe, movies<titre>);
		Acteur julia = test.actorDetails(5);
		System.out.println(">> "+julia.getLieuDeNaissance());
		// film("Star wars");
		// test.acteur("tom cruise");
		// System.out.println("l'id est "+actorID);
		// System.out.println(test.acteur("Tom Cruise"));
		//test.actorDetails(test.acteur("tom cruise"));
		//test.detailFilm(test.idFilm("rocky 2"));
		test.actorFilm(1204);
	}

}

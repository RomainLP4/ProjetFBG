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

public class App {

	public int actorID;

	private static String IMDB_KEY = "0e6260469751f4d597183df49e4810b2";

	public static String jsonFileName = "sample.json";

	public void film(String titre) throws MalformedURLException, IOException {
		// String url = "https://api.themoviedb.org/3/movie/123?api_key="+IMDB_KEY;//id
		// de recherche apres movie/
		String url = "https://api.themoviedb.org/3/search/movie?api_key=" + IMDB_KEY + "&query=" + titre;

		String jsonText = IOUtils.toString(new URL(url), Charset.forName("UTF-8"));
		writeJson(jsonText);

		// JSONObject jsonComplet = new JSONObject(jsonText);
		// JSONObject main = jsonComplet.getJSONObject("main");

	}

	public int acteur(String actor) throws MalformedURLException, IOException {
		String urlActorID = "https://api.themoviedb.org/3/search/person?api_key=" + IMDB_KEY + "&language=en-US&query="
				+ actor + "&page=1&include_adult=false\r\n" + "";

		String jsonText = IOUtils.toString(new URL(urlActorID), Charset.forName("UTF-8"));
		writeJson(jsonText);

		JSONObject jsonComplet = new JSONObject(jsonText);
		JSONArray main = jsonComplet.getJSONArray("results");

		int actorID = (int) main.getJSONObject(0).get("id");
		return actorID;

		// System.out.println(actorID);

	}

	public void actorDetails(int actorID) throws MalformedURLException, IOException {
		String urlActorDetail = "https://api.themoviedb.org/3/person/" + actorID + "?api_key=" + IMDB_KEY
				+ "&language=en-US";

		String jsonText = IOUtils.toString(new URL(urlActorDetail), Charset.forName("UTF-8"));
		writeJson(jsonText);

		JSONObject jsonComplet = new JSONObject(jsonText);
		JSONObject main = jsonComplet.getJSONObject("1");
		// String actorName = (String) main.getJSONObject(jsonText).get("name");
		

		String actorName = (String) main.getJSONObject(0).get("name");

	}

	public static void actorCast(int actorid) throws MalformedURLException, IOException {
		String urlActorCast = "https://api.themoviedb.org/3/person/" + actorid
				+ "/movie_credits?api_key=0e6260469751f4d597183df49e4810b2&language=en-US\r\n" + "";

		String jsonText = IOUtils.toString(new URL(urlActorCast), Charset.forName("UTF-8"));
		writeJson(jsonText);

		// JSONObject jsonComplet = new JSONObject(jsonText);
		// JSONObject main = jsonComplet.getJSONObject("main");

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
		// film("Star wars");
		// test.acteur("tom cruise");
		// System.out.println("l'id est "+actorID);
		// System.out.println(test.acteur("Tom Cruise"));
		test.actorDetails(test.acteur("tom cruise"));
	}

}

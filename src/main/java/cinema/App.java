package cinema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;





public class App {

	private static String IMDB_KEY = "0e6260469751f4d597183df49e4810b2";

	public static String jsonFileName = "sample.json";

	public static void film(String titre) throws MalformedURLException, IOException {
		//String url = "https://api.themoviedb.org/3/movie/123?api_key="+IMDB_KEY;//id de recherche apres movie/
		String url = "https://api.themoviedb.org/3/search/movie?api_key="+IMDB_KEY+"&query="+titre;
		

		
		String jsonText = IOUtils.toString(new URL(url), Charset.forName("UTF-8"));
		writeJson(jsonText);

		//JSONObject jsonComplet = new JSONObject(jsonText);
		//JSONObject main = jsonComplet.getJSONObject("main");

	}
	
	
	public static void acteur(String actor) throws MalformedURLException, IOException {
		String urlactor= "https://api.themoviedb.org/3/search/person?api_key="+IMDB_KEY+"&language=en-US&query="+actor+"&page=1&include_adult=false\r\n" + 
				"";

		
		String jsonText = IOUtils.toString(new URL(urlactor), Charset.forName("UTF-8"));
		writeJson(jsonText);

		//JSONObject jsonComplet = new JSONObject(jsonText);
		//JSONObject main = jsonComplet.getJSONObject("main");

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
		//film("Star wars");
		acteur("Julia Roberts");
	}

}

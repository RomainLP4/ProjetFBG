package cinema.model;

import java.util.ArrayList;

public class Film {

	private int idf;
	private String titre;
	private int annee;
	private String genre;
	public ArrayList <Acteur> Actor = new ArrayList<>();
	

	public Film(int idf, String titre, int annee, String genre, ArrayList<Acteur> actor) {
		super();
		this.idf = idf;
		this.titre = titre;
		this.annee = annee;
		this.genre = genre;
		Actor = actor;
	}


	public int getIdf() {
		return idf;
	}


	public void setIdf(int idf) {
		this.idf = idf;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
}

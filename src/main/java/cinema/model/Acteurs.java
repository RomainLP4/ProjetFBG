package cinema.model;

import java.util.ArrayList;
public class Acteurs {
	
	public int ida;
	public String noms;
	public String dateDeNaissance;
	public String lieuDeNaissance;
	public String sexe;
	public ArrayList<Films> movies = new ArrayList<> ();
	
	
	public Acteurs(int ida, String noms, String dateDeNaissance, String lieuDeNaissance, String sexe,
			ArrayList<Films> movies) {
		super();
		this.ida = ida;
		this.noms = noms;
		this.dateDeNaissance = dateDeNaissance;
		this.lieuDeNaissance = lieuDeNaissance;
		this.sexe = sexe;
		this.movies = movies;
	}


	public int getIda() {
		return ida;
	}


	public void setIda(int ida) {
		this.ida = ida;
	}


	public String getNoms() {
		return noms;
	}


	public void setNoms(String noms) {
		this.noms = noms;
	}


	public String getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}


	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public ArrayList<Films> getMovies() {
		return movies;
	}


	public void setMovies(ArrayList<Films> movies) {
		this.movies = movies;
	}
	
	
	

}

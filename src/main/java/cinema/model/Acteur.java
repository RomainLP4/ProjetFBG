package cinema.model;


import java.util.ArrayList;

public class Acteur {
	
	public int ida;
	public String noms;
	public String dateDeNaissance;
	public String lieuDeNaissance;
	public String sexe;
	public ArrayList<Film> movies = new ArrayList<> ();
	
	
	public Acteur(int ida, String noms, String dateDeNaissance, String lieuDeNaissance, String sexe) {
//			,ArrayList<Film> movies) {
		super();
		this.ida = ida;
		this.noms = noms;
		this.dateDeNaissance = dateDeNaissance;
		this.lieuDeNaissance = lieuDeNaissance;
		this.sexe = sexe;
		this.movies = new ArrayList<Film>();
		
		
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


	public ArrayList<Film> getMovies() {
		return movies;
	}


	public void setMovies(ArrayList<Film> movies) {
		this.movies = movies;
	}
	
	
	

}

package cinema.model;

import java.util.ArrayList;
import java.util.List;
public class Acteurs {
	
	public int ida;
	public String noms;
	public String prenoms;
	public int age;
	public String nationalite;
	public String sexe;
	public ArrayList<Films> movies = new ArrayList<> ();
	
	
	
public Acteurs(int ida, String noms, String prenoms, int age, String nationalite, String sexe, ArrayList<Films> movies) {
		super();
		this.ida = ida;
		this.noms = noms;
		this.prenoms = prenoms;
		this.age = age;
		this.nationalite = nationalite;
		this.sexe = sexe;
		this.movies = movies;
	}


//	public Acteur(int ida, String nom, String prenom, int age, String nationalite, String sex) {
//		super();
//		this.ida = ida;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.age = age;
//		this.nationalite = nationalite;
//		this.sex = sex;
//	}


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


	public String getPrenoms() {
		return prenoms;
	}


	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
}

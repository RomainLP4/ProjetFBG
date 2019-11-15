package cinema.model;

import java.util.ArrayList;
import java.util.List;
public class Acteur {
	
	public int ida;
	public String nom;
	public String prenom;
	public int age;
	public String nationalite;
	public String sex;
	public ArrayList<Film> movies = new ArrayList<> ();
	
	
	
public Acteur(int ida, String nom, String prenom, int age, String nationalite, String sex, ArrayList<Film> movies) {
		super();
		this.ida = ida;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nationalite = nationalite;
		this.sex = sex;
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


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
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


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}

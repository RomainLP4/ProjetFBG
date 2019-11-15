package cinema.model;

public class Acteur {
	
	private int ida;
	private String nom;
	private String prenom;
	private int age;
	private String nationalite;
	private String sex;
	
	
	public Acteur(int ida, String nom, String prenom, int age, String nationalite, String sex) {
		super();
		this.ida = ida;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nationalite = nationalite;
		this.sex = sex;
	}


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

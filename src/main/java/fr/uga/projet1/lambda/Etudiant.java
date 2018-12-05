package fr.uga.projet1.lambda;

import java.util.EnumMap;

public class Etudiant {
	
	private String nom;
	private String prenom;
	private float moyenne;
	
	public enum Mention {
		RECALE, PASSABLE, BIEN, TRES_BIEN
	}
	
	
	public String getNom() {
		return nom;
	}
	public Etudiant() {
		super();
	}
	public Etudiant(String nom, String prenom, float moyenne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.moyenne = moyenne;
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
	public float getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", moyenne=" + moyenne + "]";
	}
	
	
	public Mention getMention() {
		if(moyenne<10) return Mention.RECALE;
		else if (moyenne>=10 && moyenne<12) return Mention.PASSABLE;
		else if (moyenne>=12 && moyenne<14) return Mention.BIEN;
		else return Mention.TRES_BIEN;
			
	}
}




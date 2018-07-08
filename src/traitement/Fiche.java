package traitement;

import java.io.Serializable;

public class Fiche implements Comparable<Object> , Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom,num,adress;
	
	public Fiche(){}

	public Fiche(String nom, String num, String adress) {
		super();
		this.nom = nom;
		this.num = num;
		this.adress = adress;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "[Nom=" + nom + ", Numero=" + num + ", Adress=" + adress + "]";
	}

	
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Fiche)) return -1;
		Fiche f = (Fiche) o;
		
		return f.getNom().compareTo(nom);
	}
	
	
		
}

package MODEL;

import java.util.ArrayList;


public class CategorieI {
	private int idCategorie;
	private String Nom;
	public ArrayList<ChambreI> listeChambre;

	public CategorieI(){
		listeChambre = new ArrayList<>();

	}

	
	
	public int getIdCategorie() {
		return idCategorie;
	}



	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public ArrayList<ChambreI> getListeChambre() {
		return listeChambre;
	}



	
}

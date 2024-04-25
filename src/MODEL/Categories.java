package MODEL;

public class Categories {

	private int idCategorie;
	private String nom;
	
	
	public Categories(int idCategorie, String nom) {
		super();
		this.idCategorie = idCategorie;
		this.nom = nom;
	}

	public Categories() {
		
	}

	public int getIdCategorie() {
		return idCategorie;
	}


	public String getNom() {
		return nom;
	}


	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}

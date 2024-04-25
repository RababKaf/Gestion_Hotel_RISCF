package MODEL;

import java.util.Date;

public class Clients {
 
	private String nom;
	private String prenom;
	private String telephone;

	
	
	
	
	public Clients(String nom, String prenom, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		
	}
	
	


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getTelephone() {
		return telephone;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	
	
	
	
}

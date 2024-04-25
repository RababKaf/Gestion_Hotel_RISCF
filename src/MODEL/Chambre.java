package MODEL;

public class Chambre {
	
	private int NumChambre;
	private int etage;
	private String Etat;
	private int NbLits;
	public Categorie m_Categorie;
	private static int cmp=0;

	public Chambre(){

		NumChambre=cmp;
		cmp++;
	}

	public int getNumChambre() {
		return NumChambre;
	}

	public void setNumChambre(int numChambre) {
		NumChambre = numChambre;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public int getNbLits() {
		return NbLits;
	}

	public void setNbLits(int nbLits) {
		NbLits = nbLits;
	}

	public Categorie getM_Categorie() {
		return m_Categorie;
	}

	public void setM_Categorie(Categorie m_Categorie) {
		this.m_Categorie = m_Categorie;
	}

	public static int getCmp() {
		return cmp;
	}

	public static void setCmp(int cmp) {
		Chambre.cmp = cmp;
	}
	
}
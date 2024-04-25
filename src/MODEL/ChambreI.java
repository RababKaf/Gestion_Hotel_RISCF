package MODEL;

public class ChambreI {
	
	private int etage;
	private String Etat;// l'état par defaut disponible ;
	private int NbLits;
	private int NumChambre;
	private static int cmp=0;
	private int  idCategorie ;

	public static int getCmp() {
		return cmp;
	}

	public static void setCmp(int cmp) {
		ChambreI.cmp = cmp;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public ChambreI(){

		NumChambre=cmp;
		cmp++;
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


	public int getNumChambre() {
		return NumChambre;
	}


	public void setNumChambre(int numChambre) {
		NumChambre = numChambre;
	}


	public void finalize() throws Throwable {

	}
}

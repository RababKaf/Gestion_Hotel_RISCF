package MODEL;

public class Chambres {

	
	private int etage;
	private String Etat;
	private int NbLits;
	private int NumChambre;
	private static int cmp=0;

	public Chambres(){

		
}

	public Chambres(int etage, String etat, int nbLits, int numChambre) {
		super();
		this.etage = etage;
		Etat = etat;
		NbLits = nbLits;
		NumChambre = numChambre;
	}

	public int getEtage() {
		return etage;
	}

	public String getEtat() {
		return Etat;
	}

	public int getNbLits() {
		return NbLits;
	}

	public int getNumChambre() {
		return NumChambre;
	}

	public static int getCmp() {
		return cmp;
	}
	
	
	
}

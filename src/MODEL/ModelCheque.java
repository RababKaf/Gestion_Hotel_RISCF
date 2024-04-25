package MODEL;

public class ModelCheque {
	
	private double montant;
	
	private int numCheque;
	public ModelCheque(/*double m,int n*/) {
//		montant=m;
//		numCheque=n;
	}
	public double getMontant() {
		return montant;
	}
	public int getNumCheque() {
		return numCheque;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public void setNumCheque(int numCheque) {
		this.numCheque = numCheque;
	};
	

}

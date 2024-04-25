package MODEL;

public class ModelFacture {
	private int numReservation;
	private double prixTotal;
	private String typePayement;
	private int numCheque;
	public ModelFacture(/*int n,double p,String t,int nu*/) {
//		numReservation=n;
//		prixTotal=p;
//		typePayement=t;
//		numCheque=nu;
	}
	public int getNumReservation() {
		return numReservation;
	}
	public double getPrixTotal() {
		return prixTotal;
	}
	public String getTypePayement() {
		return typePayement;
	}
	public int getNumCheque() {
		return numCheque;
	}
	public void setNumReservation(int numReservation) {
		this.numReservation = numReservation;
	}
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	public void setTypePayement(String typePayement) {
		this.typePayement = typePayement;
	}
	public void setNumCheque(int numCheque) {
		this.numCheque = numCheque;
	}
	

}

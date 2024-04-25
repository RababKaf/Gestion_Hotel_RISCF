package MODEL;

public class DetailsReservations {

	private int nbrAdultes;
	private int nbrEnfants;
	private Categories catergorie;
	private Reservations reservation;
	
	
	public DetailsReservations() {
		catergorie=new Categories(0, null);
		try {
			reservation=new Reservations(0, null, null,null,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public DetailsReservations(int nbrAdultes, int nbrEnfants, Categories catergorie, Reservations reservation) {
		super();
		this.nbrAdultes = nbrAdultes;
		this.nbrEnfants = nbrEnfants;
		this.catergorie = catergorie;
		this.reservation = reservation;
	}



	public int getNbrAdultes() {
		return nbrAdultes;
	}

	public int getNbrEnfants() {
		return nbrEnfants;
	}



	public Categories getCatergorie() {
		return catergorie;
	}



	public Reservations getReservation() {
		return reservation;
	}



	public void setNbrAdultes(int nbrAdultes) {
		this.nbrAdultes = nbrAdultes;
	}



	public void setNbrEnfants(int nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}



	public void setCatergorie(Categories catergorie) {
		this.catergorie = catergorie;
	}



	public void setReservation(Reservations reservation) {
		this.reservation = reservation;
	}

	
	
}

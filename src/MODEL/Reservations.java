package MODEL;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservations {

	private int numReservation;
	private int nbrChambres;
	private String dateDebut;
	private String dateFin;
	private String etat;
//	private Date dateDebut;
//	private Date dateFin;
	
	
	

	public Reservations(int numReservation, String dateDebut, String dateFin,String etat,int nbrChambres) throws Exception {
		super();
		
		
		this.numReservation = numReservation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat=etat;
		this.nbrChambres=nbrChambres;
	}

	public int getNumReservation() {
		return numReservation;
	}

	public int getNbrChambres() {
		return nbrChambres;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public void setNumReservation(int numReservation) {
		this.numReservation = numReservation;
	}

	public void setNbrChambres(int nbrChambres) {
		this.nbrChambres = nbrChambres;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	
}

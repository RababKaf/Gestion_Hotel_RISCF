package MODEL;

import java.util.Date;

public class ReservationCh {

		private String dateDebut;
		private String dateFin;
		private int nbrChambres;
		private int numReservation;
		public String m_Client;
		public Facture m_Facture;
		
		
		
		public ReservationCh(){
			
		}

		public void setDateDebut(String dateDebut) {
			this.dateDebut = dateDebut;
		}

		public void setDateFin(String dateFin) {
			this.dateFin = dateFin;
		}

		public void setNbrChambres(int nbrChambres) {
			this.nbrChambres = nbrChambres;
		}

		public void setNumReservation(int numReservation) {
			this.numReservation = numReservation;
		}

		public void setM_Client(String m_Client) {
			this.m_Client = m_Client;
		}

		public void setM_Facture(Facture m_Facture) {
			this.m_Facture = m_Facture;
		}

		public String getDateDebut() {
			return dateDebut;
		}

		public String getDateFin() {
			return dateFin;
		}

		public int getNbrChambres() {
			return nbrChambres;
		}

		public int getNumReservation() {
			return numReservation;
		}

		public String getM_Client() {
			return m_Client;
		}

		public Facture getM_Facture() {
			return m_Facture;
		}

		

}

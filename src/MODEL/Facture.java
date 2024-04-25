package MODEL;

import java.util.Date;
import java.util.LinkedList;

public class Facture {
	
	private int numFacture;
	private Date dateFacture;
	private double prixTotal;
	private String typePayement;
	public LinkedList<LigneFacture> m_LigneFacture ;
	private static int cmp=0;

	public Facture(){
		m_LigneFacture =new LinkedList<LigneFacture>() ;
		numFacture=cmp;
		cmp++;
	}
}
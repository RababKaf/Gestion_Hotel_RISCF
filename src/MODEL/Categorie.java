package MODEL;

import java.util.LinkedList;

public class Categorie {

		private int idCategorie;
		private String nom;
		public LinkedList<Chambre> m_Chambre;

		public Categorie(){
			 m_Chambre=new LinkedList<Chambre>();
		}

}

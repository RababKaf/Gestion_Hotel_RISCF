package VIEW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MODEL.Categories;
import MODEL.DetailsReservations;

public class CreerPanel extends JPanel {

	private JLabel nbrAdultesLabel;
	private JTextField nbrAdultes;
	private JLabel nbrEnfantsLabel;
	private JTextField nbrEnfants;
	private JLabel categorieLabel;
	private JComboBox categorietext;
	//private JTextField categorietext;
	private JButton btnMoins;
	
	public CreerPanel(int i) {
		
		this.setBackground(Color.WHITE);
		    this.setBorder(BorderFactory.createTitledBorder("Chambre"+i));
		    //this.setSize(503, 72);
		    this.setLayout(null);
		    
		     nbrAdultesLabel=new JLabel("Nombres d'adultes : ");
		     nbrAdultesLabel.setBounds(20,11,128,14);
		     this.add(nbrAdultesLabel);
		     nbrAdultes=new JTextField(20);
//		     nbrAdultes.setText(" "+detail.getNbrAdultes());
		     nbrAdultes.setBounds(197,8,61, 20);
		     nbrAdultes.setEditable(false);
		     this.add(nbrAdultes);
		     
		     
		    nbrEnfantsLabel=new JLabel("Nombres d'enfants : ");
		    nbrEnfantsLabel.setBounds(20, 36, 128, 14);
		    this.add(nbrEnfantsLabel);
		    nbrEnfants=new JTextField(20);
	        nbrEnfants.setBounds(197, 33, 61, 20);
	        nbrEnfants.setEditable(false);
		    this.add(nbrEnfants);
		    
		    categorieLabel=new JLabel("Catégorie  :");
		    categorieLabel.setBounds(279, 11, 95, 14);
		    this.add(categorieLabel);
		    String[] liste= {"suite","double","simple"};
		    categorietext=new JComboBox(liste);
		  //  categorietext=new JTextField(20);
		   categorietext.setBounds(394, 8, 86, 20);
		   categorietext.setEditable(false);
		    this.add(categorietext);
		    
		    
		    btnMoins=new JButton("-");
		    btnMoins.setBounds(393, 33, 46, 23);
		    btnMoins.setBackground(new Color(0, 0, 204));
			 btnMoins.setFont(new Font("Tahome",Font.BOLD,11));
			 btnMoins.setForeground(Color.WHITE);
		    this.add(btnMoins);
		    btnMoins.setVisible(false);
		    
		    this.setVisible(true);
	}
	
	public void initCreerPanel(Categories categorie,DetailsReservations detail) {
		//this.setVisible(true);
		System.out.println("hhhhhhhh");
		nbrAdultes.setText(" "+detail.getNbrAdultes());
		nbrEnfants.setText(" "+detail.getNbrEnfants());
		categorietext.setSelectedIndex(categorie.getIdCategorie()-1);
		
	}

	public JLabel getNbrAdultesLabel() {
		return nbrAdultesLabel;
	}

	public JTextField getNbrAdultes() {
		return nbrAdultes;
	}

	public JLabel getNbrEnfantsLabel() {
		return nbrEnfantsLabel;
	}

	public JTextField getNbrEnfants() {
		return nbrEnfants;
	}

	public JLabel getCategorieLabel() {
		return categorieLabel;
	}

	public JComboBox getCategorietext() {
		return categorietext;
	}

	public JButton getBtnMoins() {
		return btnMoins;
	}
	
	
}

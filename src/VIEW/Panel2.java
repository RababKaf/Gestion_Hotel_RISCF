package VIEW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import MODEL.Categories;
import MODEL.DetailsReservations;

public class Panel2 extends JPanel {

	private CreerPanel creerPanel1;
	private CreerPanel creerPanel2;
	private CreerPanel creerPanel3;
	private CreerPanel creerPanel4;
	private JButton btnAjouterChambres;
	private JButton btnConfirmer;
	
	
	public Panel2() {
		
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		//System.out.println("appel init "+i);
		creerPanel1=new CreerPanel( 1);
		creerPanel1.setBounds(10, 11, 602, 59);
		
		this.add(creerPanel1);
		creerPanel1.setVisible(false);
		
		
//		System.out.println("appel init "+i);
		creerPanel2=new CreerPanel(2);
		creerPanel2.setBounds(10, 81, 602, 59);
		
		this.add(creerPanel2);
		creerPanel2.setVisible(false);
		
		
		
		//System.out.println("appel init "+i);
		creerPanel3=new CreerPanel( 3);
		creerPanel3.setBounds(10, 151, 602, 59);
		
		this.add(creerPanel3);
		creerPanel3.setVisible(false);
		
		
		//System.out.println("appel init"+i);
		creerPanel4=new CreerPanel( 4);
		creerPanel4.setBounds(10, 221, 602, 59);
		
		this.add(creerPanel4);
		creerPanel4.setVisible(false);
		
		btnAjouterChambres=new JButton("Ajouter chambre");
		btnAjouterChambres.setMnemonic('A');
		btnAjouterChambres.setBounds(400, 280, 130, 19);
		 btnAjouterChambres.setBackground(new Color(0, 0, 204));
		 btnAjouterChambres.setFont(new Font("Tahome",Font.BOLD,11));
		 btnAjouterChambres.setForeground(Color.WHITE);
		btnAjouterChambres.setVisible(false);
		this.add(btnAjouterChambres);
		
		btnConfirmer=new JButton("Verifier");
		btnConfirmer.setMnemonic('V');
		btnConfirmer.setBounds(290, 280, 100, 19);
		 btnConfirmer.setBackground(new Color(0, 0, 204));
		 btnConfirmer.setFont(new Font("Tahome",Font.BOLD,11));
		 btnConfirmer.setForeground(Color.WHITE);
		btnConfirmer.setVisible(false);
		this.add(btnConfirmer);
		
		
	}
	
	public void iniCreerPanel1(Categories cat,DetailsReservations detail ) {
		creerPanel1.setVisible(true);
		creerPanel1.initCreerPanel(cat, detail);
//		creerPanel1.setVisible(false);
	}
	
	
	public void iniCreerPanel2(Categories cat,DetailsReservations detail ) {
		creerPanel2.setVisible(true);
		creerPanel2.initCreerPanel(cat, detail);

	}
	
	
	public void iniCreerPanel3(Categories cat,DetailsReservations detail ) {
		creerPanel3.setVisible(true);
		creerPanel3.initCreerPanel(cat, detail);

	}
	
	public void iniCreerPanel4(Categories cat,DetailsReservations detail ) {
		creerPanel4.setVisible(true);
		creerPanel4.initCreerPanel(cat, detail);

	}


	public CreerPanel getCreerPanel1() {
		return creerPanel1;
	}


	public CreerPanel getCreerPanel2() {
		return creerPanel2;
	}


	public CreerPanel getCreerPanel3() {
		return creerPanel3;
	}


	public CreerPanel getCreerPanel4() {
		return creerPanel4;
	}


	public JButton getBtnAjouterChambres() {
		return btnAjouterChambres;
	}

	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}
	
	
}

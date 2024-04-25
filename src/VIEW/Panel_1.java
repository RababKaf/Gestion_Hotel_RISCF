package VIEW;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



import MODEL.Clients;
import MODEL.Reservations;

public class Panel_1 extends JPanel {

	private JTextField code;
	private JTextField nom;
	private JTextField prenom;
	private JTextField telephone;
	private JTextField dateDebut;
	private JTextField dateFin;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel telLabel;
	private JLabel dateDebutLabel;
	private JLabel dateFinLabel;
	private JLabel etatReservation;
	
	
	public Panel_1() {
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setBorder(new TitledBorder(null, "Informations sur le client ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		
		etatReservation=new JLabel("");
		etatReservation.setBounds(450, 21, 182, 14);
		
		this.add(etatReservation);
		
		 nomLabel = new JLabel("Nom : ");
		nomLabel.setBounds(10, 21, 152, 14);
		this.add(nomLabel);
		
		 prenomLabel = new JLabel("Prenom : ");
		prenomLabel.setBounds(10, 46, 152, 14);
		this.add(prenomLabel);
		
		 telLabel = new JLabel("Télèphone : ");
		telLabel.setBounds(10, 71, 152, 14);
		this.add(telLabel);
		
		 dateDebutLabel = new JLabel("Date déebut : ");
		dateDebutLabel.setBounds(10, 96, 152, 14);
		this.add(dateDebutLabel);
		
		 dateFinLabel = new JLabel("Date Fin : ");
		dateFinLabel.setBounds(10, 121, 152, 14);
		this.add(dateFinLabel);
		
		nom = new JTextField();
		nom.setBounds(191, 21, 193, 20);
		nom.setEditable(false);
		nom.setColumns(10);
		this.add(nom);
		
		
		prenom = new JTextField();
		prenom.setBounds(191, 43, 193, 20);
		prenom.setEditable(false);
		prenom.setColumns(10);
		this.add(prenom);
		
		
		telephone = new JTextField();
		telephone.setBounds(191, 68, 193, 20);
		telephone.setEditable(false);
		telephone.setColumns(10);
		this.add(telephone);
		
		
		dateDebut = new JTextField();
		dateDebut.setBounds(191, 93, 193, 20);
		dateDebut.setEditable(false);
		dateDebut.setColumns(10);
		this.add(dateDebut);
		
		
		dateFin = new JTextField();
		dateFin.setBounds(191, 118, 193, 20);
		dateFin.setEditable(false);
		dateFin.setColumns(10);
		this.add(dateFin);
		

		
		this.setVisible(true);
		
	}


	public JTextField getCode() {
		return code;
	}


	public JTextField getNom() {
		return nom;
	}


	public JTextField getPrenom() {
		return prenom;
	}


	public JTextField getTelephone() {
		return telephone;
	}


	public JTextField getDateDebut() {
		return dateDebut;
	}


	public JTextField getDateFin() {
		return dateFin;
	}


	public JLabel getNomLabel() {
		return nomLabel;
	}


	public JLabel getPrenomLabel() {
		return prenomLabel;
	}


	public JLabel getTelLabel() {
		return telLabel;
	}


	public JLabel getDateDebutLabel() {
		return dateDebutLabel;
	}


	public JLabel getDateFinLabel() {
		return dateFinLabel;
	}


	public JLabel getEtatReservation() {
		return etatReservation;
	}
	
	
}

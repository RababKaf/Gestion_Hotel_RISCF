package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CONTROLLER.Controler;
import CONTROLLER.Manager;
import MODEL.ReservationCh;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAG extends JPanel {

   
	private JButton ajouterBTN;
	private JButton conBTN = new JButton("");
	private JLabel labelConsR;
	private  JLabel ajouterLabelR;
	private JButton btnFacture ;
	private JLabel labelFacture ;

	

				
	public MenuAG() {
		
		
		this.setForeground(new Color(255, 255, 255));
		this.setBackground(new Color(0,0,204));
		this.setBounds(0, 0, 169, 445);
		
		this.setLayout(null);
		
		JLabel Hotellabel = new JLabel("Hôtel RISCF");
		Hotellabel.setBackground(new Color(255, 255, 255));
		Hotellabel.setBounds(-4, 11, 141, 35);
		Hotellabel.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		Hotellabel.setHorizontalAlignment(SwingConstants.CENTER);
		Hotellabel.setForeground(new Color(255, 255, 255));
		this.add(Hotellabel);
		
		JLabel agent = new JLabel("");
		agent.setIcon(new ImageIcon(MenuAG.class.getResource("icons8-insurance-agent-50 (2).png")));
		agent.setBounds(6, 43, 64, 64);
		this.add(agent);
		
		JLabel agentlbl = new JLabel("Agent");
		agentlbl.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		agentlbl.setForeground(new Color(255, 255, 255));
		agentlbl.setBounds(62, 73, 75, 26);
		this.add(agentlbl);
		
		 ajouterBTN = new JButton("");
		ajouterBTN.setIcon(new ImageIcon(MenuAG.class.getResource("adRESEWhite.png")));
		ajouterBTN.setBounds(52, 136, 64, 58);
		ajouterBTN.setBorder(new EmptyBorder(3,3,3,3));
		ajouterBTN.setContentAreaFilled(false);
		this.add(ajouterBTN);
		
		 ajouterLabelR = new JLabel("Ajouter Reservation");
		ajouterLabelR.setHorizontalAlignment(SwingConstants.CENTER);
		ajouterLabelR.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		ajouterLabelR.setForeground(new Color(255, 255, 255));
		ajouterLabelR.setBounds(10, 194, 149, 24);
		this.add(ajouterLabelR);
		
		
		conBTN.setIcon(new ImageIcon(MenuPanAD.class.getResource("CONSULTERWhite.png")));
		conBTN.setBounds(52, 243, 64, 58);
		conBTN.setBorder(new EmptyBorder(3,3,3,3));
		conBTN.setContentAreaFilled(false);
		this.add(conBTN);
		
		 labelConsR = new JLabel("Consulter Reservation");
		 labelConsR.setHorizontalAlignment(SwingConstants.CENTER);
		labelConsR.setForeground(new Color(255, 255, 255));
		labelConsR.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelConsR.setBounds(10, 298, 159, 24);
		this.add(labelConsR);
		
		 btnFacture = new JButton("");
		btnFacture.setIcon(new ImageIcon(MenuAG.class.getResource("facturewhite.png")));
		btnFacture.setBounds(52, 347, 64, 58);
		btnFacture.setBorder(new EmptyBorder(3,3,3,3));
		btnFacture.setContentAreaFilled(false);
		this.add(btnFacture);
		
		labelFacture = new JLabel("Facturation");
		labelFacture.setHorizontalAlignment(SwingConstants.CENTER);
		labelFacture.setForeground(new Color(255, 255, 255));
		labelFacture.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelFacture.setBounds(34, 399, 95, 14);
		this.add(labelFacture);
		this.setVisible(true);
	}
	public JButton getAjouterBTN() {
		return ajouterBTN;
	}


	public void setAjouterBTN(JButton ajouterBTN) {
		this.ajouterBTN = ajouterBTN;
	}


	public JButton getConBTN() {
		return conBTN;
	}


	public void setConBTN(JButton conBTN) {
		this.conBTN = conBTN;
	}


	public JLabel getLabelConsR() {
		return labelConsR;
	}


	public void setLabelConsR(JLabel labelConsR) {
		this.labelConsR = labelConsR;
	}


	public JLabel getAjouterLabelR() {
		return ajouterLabelR;
	}


	public void setAjouterLabelR(JLabel ajouterLabelR) {
		this.ajouterLabelR = ajouterLabelR;
	}


	public JButton getBtnFacture() {
		return btnFacture;
	}


	public void setBtnFacture(JButton btnFacture) {
		this.btnFacture = btnFacture;
	}


	public JLabel getLabelFacture() {
		return labelFacture;
	}


	public void setLabelFacture(JLabel labelFacture) {
		this.labelFacture = labelFacture;
	}
	
}

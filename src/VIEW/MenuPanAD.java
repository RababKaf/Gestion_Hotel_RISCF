package VIEW;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MenuPanAD extends JPanel {

	
	 private JButton ajouterBTN;
	 private JButton conBTNCH = new JButton("");
	  private JLabel labelCons;
	 private  JLabel ajouterLabel;
	 
	public MenuPanAD() {
	
		this.setForeground(new Color(255, 255, 255));
		this.setBackground(new Color(0,0,204));
		this.setBounds(0, 0, 190, 445);
		
		this.setLayout(null);
		
		JLabel Hotellabel = new JLabel("Hôtel RISCF");
		Hotellabel.setBackground(new Color(255, 255, 255));
		Hotellabel.setBounds(0, 11, 141, 50);
		Hotellabel.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		Hotellabel.setHorizontalAlignment(SwingConstants.CENTER);
		Hotellabel.setForeground(new Color(255, 255, 255));
		this.add(Hotellabel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuPanAD.class.getResource("/view/adminWhite.png")));
		lblNewLabel.setBounds(10, 61, 64, 64);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Administrarteur");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(50, 110, 109, 14);
		this.add(lblNewLabel_1);
		
		 ajouterBTN = new JButton("");
		ajouterBTN.setIcon(new ImageIcon(MenuPanAD.class.getResource("/view/ADDWHITE.png")));
		ajouterBTN.setBounds(42, 165, 64, 58);
		ajouterBTN.setBorder(new EmptyBorder(3,3,3,3));
		ajouterBTN.setContentAreaFilled(false);
		this.add(ajouterBTN);
		
		 ajouterLabel = new JLabel("Ajouter chambre");
		ajouterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ajouterLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		ajouterLabel.setForeground(new Color(255, 255, 255));
		ajouterLabel.setBounds(10, 218, 131, 24);
		this.add(ajouterLabel);
		
		
		conBTNCH.setIcon(new ImageIcon(MenuPanAD.class.getResource("/view/CONSULTERWhite.png")));
		conBTNCH.setBounds(42, 274, 64, 58);
		conBTNCH.setBorder(new EmptyBorder(3,3,3,3));
		conBTNCH.setContentAreaFilled(false);
		this.add(conBTNCH);
		
		 labelCons = new JLabel("Consulter chambre");
		 labelCons.setHorizontalAlignment(SwingConstants.CENTER);
		labelCons.setForeground(new Color(255, 255, 255));
		labelCons.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelCons.setBounds(0, 325, 159, 24);
		this.add(labelCons);
		
	}

	
	public JButton getAjouterBTN() {
		return ajouterBTN;
	}

	public void setAjouterBTN(JButton ajouterBTN) {
		this.ajouterBTN = ajouterBTN;
	}

	public JButton getconBTNCH() {
		return conBTNCH;
	}

	public void setconBTNCH(JButton conBTNCH) {
		this.conBTNCH = conBTNCH;
	}

	public JLabel getLabelCons() {
		return labelCons;
	}

	public void setLabelCons(JLabel labelCons) {
		this.labelCons = labelCons;
	}

	public JLabel getAjouterLabel() {
		return ajouterLabel;
	}

	public void setAjouterLabel(JLabel ajouterLabel) {
		this.ajouterLabel = ajouterLabel;
	}
	
}

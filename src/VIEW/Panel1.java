package VIEW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Panel1 extends JPanel {

	private JTextField code;
	private JLabel codeLabel;
	private JButton btnRechercher;
    private JButton btnAnnuler;
    
    public Panel1() {
    	
    	this.setLayout(null);
    	this.setBorder(new TitledBorder(null, "Consulter R\u00E9servation ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    	this.setBackground(Color.WHITE);
    	codeLabel = new JLabel("Saisir le numero e la reservation : ");
		codeLabel.setBounds(10, 11, 306, 27);
		this.add(codeLabel);
		
		code = new JTextField();
		code.setBounds(327, 14, 174, 20);
		
		this.add(code);
		code.setColumns(10);
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setMnemonic('R');
		btnRechercher.setBounds(337, 49, 122, 23);
		 btnRechercher.setBackground(new Color(0, 0, 204));
		 btnRechercher.setFont(new Font("Tahome",Font.BOLD,11));
		 btnRechercher.setForeground(Color.WHITE);
		this.add(btnRechercher);
		
	    btnAnnuler = new JButton("Annuler");
		btnAnnuler.setMnemonic('A');
		btnAnnuler.setBounds(469, 49, 99, 23);
		 btnAnnuler.setBackground(new Color(0, 0, 204));
		 btnAnnuler.setFont(new Font("Tahome",Font.BOLD,11));
		 btnAnnuler.setForeground(Color.WHITE);
		this.add(btnAnnuler);
    }

	public JTextField getCode() {
		return code;
	}

	public JLabel getCodeLabel() {
		return codeLabel;
	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
    
    
}

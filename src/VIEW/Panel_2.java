package VIEW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_2 extends JPanel {

	private JButton btnConfirmer;
	private JButton btnModifier;
	private JButton btnAnnuler;
	
	
	public Panel_2() {
		
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		btnConfirmer=new JButton("Confirmer");
		btnConfirmer.setMnemonic('C');
		btnConfirmer.setBounds(290, 11, 89, 20);
		 btnConfirmer.setBackground(new Color(0, 0, 204));
		 btnConfirmer.setFont(new Font("Tahome",Font.BOLD,11));
		 btnConfirmer.setForeground(Color.WHITE);
		this.add(btnConfirmer);
		
		
		btnModifier=new JButton("Modifier");
		btnModifier.setMnemonic('M');
		btnModifier.setBounds(389, 11, 89, 20);
		 btnModifier.setBackground(new Color(0, 0, 204));
		 btnModifier.setFont(new Font("Tahome",Font.BOLD,11));
		 btnModifier.setForeground(Color.WHITE);
		this.add(btnModifier);
		
		
		btnAnnuler=new JButton("Annuler");
		btnAnnuler.setMnemonic('A');
		btnAnnuler.setBounds(488, 11, 89, 20);
		btnAnnuler.setBackground(new Color(0, 0, 204));
		btnAnnuler.setFont(new Font("Tahome",Font.BOLD,11));
		 btnAnnuler.setForeground(Color.WHITE);
		this.add(btnAnnuler);
		
		this.setVisible(true);
		
		
	}


	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}


	public JButton getBtnModifier() {
		return btnModifier;
	}


	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	
	
}

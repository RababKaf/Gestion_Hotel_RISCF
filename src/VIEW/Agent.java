package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agent {

	private JFrame frame;
	JButton consulterButton;
	JButton btnAjouterR ;
	JButton btnFacture;
				
	public Agent() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JPanel panMenu = new JPanel();
		panMenu.setForeground(new Color(0, 0, 128));
		panMenu.setBackground(new Color(255, 255, 255));
		panMenu.setBounds(99, 117, 441, 272);
		frame.getContentPane().add(panMenu);
		panMenu.setLayout(null);
		
		consulterButton = new JButton("");
		consulterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		consulterButton.setIcon(new ImageIcon(Agent.class.getResource("consulterBlue.png")));
		consulterButton.setBounds(107, 75, 83, 57);
		consulterButton.setBorder(new EmptyBorder(3,3,3,3));
		consulterButton.setContentAreaFilled(false);
		panMenu.add(consulterButton);
		
		 btnAjouterR = new JButton("");
		btnAjouterR.setIcon(new ImageIcon(Agent.class.getResource("ADDreserBLUE.png")));
		btnAjouterR.setBounds(0, 75, 83, 61);
		btnAjouterR.setBorder(new EmptyBorder(3,3,3,3));
		btnAjouterR.setContentAreaFilled(false);
		btnAjouterR.setBorder(new EmptyBorder(3,3,3,3));
		panMenu.add(btnAjouterR);
		
	    btnFacture = new JButton("");
		btnFacture.setIcon(new ImageIcon(Agent.class.getResource("factureBlue.png")));
		btnFacture.setBounds(224, 75, 83, 57);
		btnFacture.setBorder(new EmptyBorder(3,3,3,3));
		btnFacture.setContentAreaFilled(false);
		panMenu.add(btnFacture);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion Reservation");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setBounds(10, 11, 249, 27);
		panMenu.add(lblNewLabel_1);
		
		JLabel ajouter = new JLabel("Ajouter");
		ajouter.setHorizontalAlignment(SwingConstants.CENTER);
		ajouter.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 17));
		ajouter.setForeground(new Color(51,154,240));
		ajouter.setBackground(new Color(0, 0, 128));
		ajouter.setBounds(0, 122, 83, 28);
		panMenu.add(ajouter);
		
		JLabel lblNewLabel_3 = new JLabel("Consulter");
		lblNewLabel_3.setForeground(new Color(51,154,240));
		lblNewLabel_3.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_3.setBounds(107, 126, 83, 21);
		panMenu.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Facturation");
		lblNewLabel_4.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_4.setForeground(new Color(51,154,240));
		lblNewLabel_4.setBounds(219, 123, 119, 27);
		panMenu.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Agent.class.getResource("test2.png")));
		lblNewLabel_2.setBounds(0, 0, 441, 272);
		panMenu.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Agent");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(84, 47, 135, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel iconAgent = new JLabel("");
		iconAgent.setIcon(new ImageIcon(Agent.class.getResource("agent.png")));
		iconAgent.setBounds(24, 32, 50, 50);
		frame.getContentPane().add(iconAgent);
		frame.setBounds(100, 100, 640, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));
		//frame.setVisible(true);
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JButton getConsulterButton() {
		return consulterButton;
	}


	public void setConsulterButton(JButton consulterButton) {
		this.consulterButton = consulterButton;
	}


	public JButton getBtnAjouterR() {
		return btnAjouterR;
	}


	public void setBtnAjouterR(JButton btnAjouterR) {
		this.btnAjouterR = btnAjouterR;
	}


	public JButton getBtnFacture() {
		return btnFacture;
	}


	public void setBtnFacture(JButton btnFacture) {
		this.btnFacture = btnFacture;
	}
	
}

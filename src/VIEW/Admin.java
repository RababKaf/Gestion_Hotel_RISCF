package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Admin {

	private JFrame frame;
	private JButton consulterButtonA;
	private JButton btnAjouterRA ;


				
	public Admin() {
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
		
		consulterButtonA = new JButton("");
		consulterButtonA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		consulterButtonA.setIcon(new ImageIcon(Agent.class.getResource("consulterBlue.png")));
		consulterButtonA.setBounds(145, 79, 83, 63);
		consulterButtonA.setBorder(new EmptyBorder(3,3,3,3));
		consulterButtonA.setContentAreaFilled(false);
		panMenu.add(consulterButtonA);
		
		 btnAjouterRA = new JButton("");
		btnAjouterRA.setIcon(new ImageIcon(Admin.class.getResource("ADDBLUE.png")));
		btnAjouterRA.setBounds(10, 79, 83, 63);
		btnAjouterRA.setBorder(new EmptyBorder(3,3,3,3));
		btnAjouterRA.setContentAreaFilled(false);
		btnAjouterRA.setBorder(new EmptyBorder(3,3,3,3));
		panMenu.add(btnAjouterRA);
		
	   
		JLabel lblNewLabel_1 = new JLabel("Gestion Chambre");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setBounds(10, 0, 249, 27);
		panMenu.add(lblNewLabel_1);
		
		JLabel ajouter = new JLabel("Ajouter");
		ajouter.setHorizontalAlignment(SwingConstants.CENTER);
		ajouter.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 17));
		ajouter.setForeground(new Color(51,154,240));
		ajouter.setBackground(new Color(0, 0, 128));
		ajouter.setBounds(20, 141, 83, 28);
		panMenu.add(ajouter);
		
		JLabel lblNewLabel_3 = new JLabel("Consulter");
		lblNewLabel_3.setForeground(new Color(51,154,240));
		lblNewLabel_3.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_3.setBounds(145, 141, 83, 21);
		panMenu.add(lblNewLabel_3);
		
		JLabel tsiwira = new JLabel("");
		tsiwira.setIcon(new ImageIcon(Admin.class.getResource("test2.png")));
		tsiwira.setBounds(0, 0, 441, 272);
		panMenu.add(tsiwira);
		
		JLabel lblNewLabel = new JLabel("Administrateur");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(85, 42, 163, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel iconAgent = new JLabel("");
		iconAgent.setIcon(new ImageIcon(Admin.class.getResource("iconAdmin.png")));
		iconAgent.setBounds(24, 11, 64, 63);
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


	public JButton getConsulterButtonA() {
		return consulterButtonA;
	}


	public void setConsulterButtonA(JButton consulterButtonA) {
		this.consulterButtonA = consulterButtonA;
	}


	public JButton getBtnAjouterRA() {
		return btnAjouterRA;
	}


	public void setBtnAjouterRA(JButton btnAjouterRA) {
		this.btnAjouterRA = btnAjouterRA;
	}
	

}

package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;

public class View extends JFrame implements KeyListener {

	private JFrame frame;
	JPanel face;
	public JTextField login ;
	JButton suivant;
	private JPasswordField passwordField;
	JButton err2;
	//private JLabel erreur1;
		
	public View() 
	{
		
		frame = new JFrame();
		face = new JPanel();
		suivant = new JButton("Suivant");

		suivant.setMnemonic('S');
		suivant.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		suivant.setBounds(176, 219, 96, 34);
		login = new JTextField(10);
		face.setBackground(new Color(0,0,0,80));
		face.setBounds(98, 220, 300, 280);
		face.setLayout(null);
		login.setBounds(125, 36,131 ,34);
		face.add(login);
		suivant.setBorder(new EmptyBorder(3,3,3,3));
	    //suivant.setEnabled(false);
		face.add(suivant);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 540, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel bag = new JLabel("");
		bag.setIcon(new ImageIcon(View.class.getResource("copy 2.png")));
		bag.setBounds(0, 0, 584, 580);
		bag.add(face);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(24, 36, 91, 33);
		face.add(lblNewLabel);
		//erreur1.setVisible(false);
		JLabel lblNewLabel_1 = new JLabel("PassWord:");
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 95, 105, 34);
		face.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 95, 131, 34);
		face.add(passwordField);
		
		login.addKeyListener(this);
		passwordField.addKeyListener(this);
		/*err2 = new JButton("passWord incorrect !");
		err2.setForeground(new Color(255, 0, 0));
		err2.setBorder(new EmptyBorder(3,3,3,3));
		//err2.setVisible(false);
		err2.setBounds(135, 140, 121, 23);
		face.add(err2);*/
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));
		frame.getContentPane().add(bag);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}



	public JFrame getFrame() {
		return frame;
	}

	
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}



	public JPanel getFace() {
		return face;
	}



	public void setFace(JPanel face) {
		this.face = face;
	}



	public JTextField getLogin() {
		return login;
	}



	public void setLogin(JTextField login) {
		this.login = login;
	}



	public JButton getSuivant() {
		return suivant;
	}



	public void setSuivant(JButton suivant) {
		this.suivant = suivant;
	}



	public JPasswordField getPasswordField() {
		return passwordField;
	}



	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}



	

	public JButton getErr2() {
		return err2;
	}



	public void setErr2(JButton err2) {
		this.err2 = err2;
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
			
		{	passwordField.requestFocus();
		    }
		if(e.getKeyCode()==KeyEvent.VK_UP)
			login.requestFocus();
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			passwordField.requestFocus();
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	



	/*public JLabel getErr2() {
		return err2;
	}



	public void setErr2(JLabel err2) {
		this.err2 = err2;
	}*/
}

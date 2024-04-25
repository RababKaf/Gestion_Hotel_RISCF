package VIEW;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CONFIGURATION.Connexion;





public class Editer extends JFrame{
	JButton btnQuitter;
	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	private JPanel contentPane;
	private JTextField textEtage;
	private JTextField textNbLits;
	private JTextField texEtat;
	private JTextField textType;
	private JTextField textNumCh;
	JButton btnHorsSE ;
	JButton btnDelete ;
	JButton btnModifie;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	public JButton getBtnHorsSE() {
		return btnHorsSE;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnModifie() {
		return btnModifie;
	}

	

	public Editer() {
		ViewListeCh v=new ViewListeCh();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modifier les informations de Chambre:");
		lblNewLabel.setIcon(new ImageIcon(Editer.class.getResource("/view/edit.png")));
		
		lblNewLabel.setBackground(Color.BLUE);
				lblNewLabel.setBounds(73, 0, 306, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Num Etage:");
		lblNewLabel_1.setBounds(69, 102, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		textEtage = new JTextField();
		textEtage.requestFocus();
		textEtage.setBounds(203, 102, 154, 23);
		contentPane.add(textEtage);
		textEtage.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre lits:");
		lblNewLabel_2.setBounds(69, 140, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Etat:");
		lblNewLabel_3.setBounds(71, 178, 31, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type:");
		lblNewLabel_4.setBounds(69, 216, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textNbLits = new JTextField();
		textNbLits.setBounds(203, 140, 154, 23);
		contentPane.add(textNbLits);
		textNbLits.setColumns(10);
		
		texEtat = new JTextField();
		texEtat.setBounds(203, 178, 154, 23);
		contentPane.add(texEtat);
		texEtat.setColumns(10);
		
		textType = new JTextField();
		textType.setBounds(203, 216, 154, 23);
		contentPane.add(textType);
		textType.setColumns(16);
		
		btnHorsSE = new JButton("Hors Service");
		btnHorsSE.setBackground(Color.WHITE);
		btnHorsSE.setMnemonic('H');
		btnHorsSE.setIcon(new ImageIcon(Editer.class.getResource("/view/unavailable (2).png")));
		
		
		btnHorsSE.setBounds(381, 292, 144, 59);
		contentPane.add(btnHorsSE);
		
		btnDelete = new JButton("Supprimer");
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setMnemonic('S');
		btnDelete.setIcon(new ImageIcon(Editer.class.getResource("/view/trash.png")));
		
		
		btnDelete.setBounds(10, 292, 144, 59);
		contentPane.add(btnDelete);
		
		btnModifie = new JButton("Modifier");
		btnModifie.setIcon(new ImageIcon(Editer.class.getResource("/view/updates.png")));
		btnModifie.setMnemonic('M');
		btnModifie.setBackground(Color.WHITE);
		
		
		btnModifie.setBounds(190, 292, 144, 59);
		contentPane.add(btnModifie);
		
		textNumCh = new JTextField();
		textNumCh.setBounds(203, 64, 154, 23);
		contentPane.add(textNumCh);
		textNumCh.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Numéro Chambre:");
		lblNewLabel_5.setBounds(69, 64, 106, 23);
		contentPane.add(lblNewLabel_5);
		
		btnQuitter = new JButton("");
		btnQuitter.setIcon(new ImageIcon(Editer.class.getResource("/view/logout.png")));
		btnQuitter.setBounds(479, 0, 46, 53);
		btnQuitter.setContentAreaFilled(false);
		btnQuitter.setBorder(new EmptyBorder(3, 3,3,3));
		contentPane.add(btnQuitter);
		
		textNumCh.setEditable(false);
		textEtage.setEditable(false);
		texEtat.setEditable(false);
		textNbLits.setEditable(false);
		textType.setEditable(false);
		JPanel panel = new JPanel();
		panel.setBounds(367, 49, 54, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Editer.class.getResource("edit-24.png")));
		btnNewButton_1.setBounds(0, 54, 46, 23);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(new EmptyBorder(3,3,3,3));
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Editer.class.getResource("edit-24.png")));
		btnNewButton_2.setBounds(0, 88, 44, 23);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorder(new EmptyBorder(3,3,3,3));
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Editer.class.getResource("edit-24.png")));
		btnNewButton_3.setBounds(0, 129, 44, 23);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorder(new EmptyBorder(3,3,3,3));
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(Editer.class.getResource("edit-24.png")));
		btnNewButton_4.setBounds(0, 169, 44, 23);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorder(new EmptyBorder(3,3,3,3));
		panel.add(btnNewButton_4);
		
		this.setLocationRelativeTo(null);
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rabab\\Desktop\\E.png"));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));
		
		
		
		this.setVisible(true);
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

	public JButton getBtnNewButton_3() {
		return btnNewButton_3;
	}

	public JButton getBtnNewButton_4() {
		return btnNewButton_4;
	}
	public JTextField getTextEtage() {
		return textEtage;
	}

	public void setTextEtage(JTextField textEtage) {
		this.textEtage = textEtage;
	}

	public JTextField getTextNbLits() {
		return textNbLits;
	}

	public void setTextNbLits(JTextField textNbLits) {
		this.textNbLits = textNbLits;
	}

	public JTextField getTexEtat() {
		return texEtat;
	}

	public void setTexEtat(JTextField texEtat) {
		this.texEtat = texEtat;
	}

	public JTextField getTextType() {
		return textType;
	}

	public void setTextType(JTextField textType) {
		this.textType = textType;
	}

	public JTextField getTextNumCh() {
		return textNumCh;
	}

	public void setTextNumCh(JTextField textNumCh) {
		this.textNumCh = textNumCh;
	}
}

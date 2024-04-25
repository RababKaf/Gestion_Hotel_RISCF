package VIEW;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class FramReservation extends JFrame {
	
	private JPanel contentPane;
	public JPanel panel_2;
	private JDateChooser de;
	private JDateChooser ds;
	public JButton btnNewButton;
	public JTextField textField_2;
	public JTextField textField_3;
	public pannchambre pan2=new pannchambre();
	public pannchambre pan3=new pannchambre();
	public pannchambre pan4=new pannchambre();
	public JPanel panel_3;
	public JTextField textField;
	public JTextField textField_1;
	public JFormattedTextField text;
	public JButton btnNewButton_3;
	public JLabel lblNewLabel_5;
	public JLabel lblNewLabel_6;
	public JButton btnNewButton_2 ;
	public JButton btnNewButton_1;
	public int i=0;
	public JTextField textField_4;
	public MenuAG mm=new MenuAG();
	public 	JLabel lblNewLabel_1 ;
	public JLabel lblNewLabel ;
	
	

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FramReservation() {
		 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
		setBounds(0, 0, 900,700);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 385, 171, -390);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "infos sur sejour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(180, 11, 305, 146);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Date entree: ");
		lblNewLabel_1.setBounds(10, 16, 133, 26);
		panel_1.add(lblNewLabel_1);
		
		 de=new JDateChooser();
		 de.getCalendarButton().addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 de.setBounds(113, 16, 174, 26);
		 panel_1.add(de);
		
		 lblNewLabel = new JLabel("Date sortie:");
		lblNewLabel.setBounds(10, 53, 114, 14);
		panel_1.add(lblNewLabel);
		
		ds=new JDateChooser();
		 ds.setBounds(113, 52, 174, 26);
		 panel_1.add(ds);
		 
		  btnNewButton = new JButton("Suivant:");
		  btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		  btnNewButton.setBackground(new Color(0, 0, 204));
		  btnNewButton.setForeground(new Color(255, 255, 255));
		  btnNewButton.setMnemonic('S');

		 btnNewButton.setBounds(183, 112, 89, 23);
		 panel_1.add(btnNewButton);
		 
		 btnNewButton_1 = new JButton("Enregistrer");
		 btnNewButton_1.setMnemonic('E');
		 btnNewButton_1.setForeground(new Color(255, 255, 255));
		 btnNewButton_1.setBackground(new Color(0, 0, 204));
		 btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		// btnNewButton_1.setColor(0, 0, 204)
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnNewButton_1.setBounds(331, 571, 123, 23);
		 contentPane.add(btnNewButton_1);
		 btnNewButton_1.setVisible(false);
		 
		 textField_2 = new JTextField();
		 textField_2.setBounds(240, 636, 96, 20);
		 contentPane.add(textField_2);
		 textField_2.setColumns(10);
		 
		 textField_3 = new JTextField();
		 textField_3.setBounds(240, 605, 96, 20);
		 contentPane.add(textField_3);
		 textField_3.setColumns(10);
		 
		 panel_2 = new JPanel();
		 panel_2.setBounds(495, 11, 361, 614);
		 contentPane.add(panel_2);
		 panel_2.setLayout(null);
		 pan2.setBounds(0, 0, 351, 159);
		 panel_2.add(pan2);
		 panel_2.setVisible(false);
		 
		 pan3.setBounds(0, 195, 351, 166);
		 panel_2.add(pan3);
		 pan3.setVisible(false);
		 pan4.setBounds(0, 399, 351, 154);
		 panel_2.add(pan4);
		 
		 btnNewButton_3 = new JButton("Verifier");
		 btnNewButton_3.setBounds(23, 165, 112, 23);
		 panel_2.add(btnNewButton_3);
		 btnNewButton_3.setBackground(new Color(0, 0, 204));
		 btnNewButton_3.setForeground(new Color(255, 255, 255));
		 btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		 btnNewButton_3.setMnemonic('V');
		 
		   btnNewButton_2 = new JButton("ajouter chambre");
		   btnNewButton_2.setBounds(142, 165, 182, 23);
		   panel_2.add(btnNewButton_2);
		   btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		   btnNewButton_2.setForeground(new Color(255, 255, 255));
		   btnNewButton_2.setBackground(new Color(0, 0, 204));
		   btnNewButton_2.setMnemonic('A');
		   btnNewButton_2.setVisible(false);
		 btnNewButton_3.setVisible(false);
		 pan4.setVisible(false);
		 
		 panel_3 = new JPanel();
		 panel_3.setBorder(new TitledBorder(null, "infos personnels:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		 panel_3.setBounds(180, 168, 305, 153);
		 contentPane.add(panel_3);
		 panel_3.setLayout(null);
		 panel_3.setVisible(false);
		 
		 JLabel lblNewLabel_2 = new JLabel("nom:");
		 lblNewLabel_2.setBounds(20, 29, 89, 28);
		 panel_3.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel("Prenom:");
		 lblNewLabel_3.setBounds(20, 68, 82, 14);
		 panel_3.add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel("Telephone:");
		 lblNewLabel_4.setBounds(32, 125, 77, 14);
		 panel_3.add(lblNewLabel_4);
		 
		 textField = new JTextField();
		 textField.setBounds(128, 33, 96, 20);
		 panel_3.add(textField);
		 textField.setColumns(10);
		 
		 textField_1 = new JTextField();
		 textField_1.setBounds(128, 65, 96, 20);
		 panel_3.add(textField_1);
		 textField_1.setColumns(10);
			mm.setBounds(0, 11, 171,900);
			this.getContentPane().add(mm);
		 
		 
		 
		 try {
			MaskFormatter formatter=new MaskFormatter("##-##-##-##-##");
				formatter.setPlaceholderCharacter('#');
				text=new JFormattedTextField(formatter);
				text.setText("");
			text.setBounds(128, 122, 96, 20);
			}catch(Exception e) {
				e.printStackTrace();
			}
		 panel_3.add(text);
		 
		 JLabel lblNewLabel_7 = new JLabel("cin:");
		 lblNewLabel_7.setBounds(20, 87, 47, 27);
		 panel_3.add(lblNewLabel_7);
		 
		 textField_4 = new JTextField();
		 textField_4.setBounds(128, 91, 96, 20);
		 panel_3.add(textField_4);
		 textField_4.setColumns(10);
		 
		 lblNewLabel_5 = new JLabel("code:");
		 lblNewLabel_5.setBounds(195, 608, 47, 14);
		 contentPane.add(lblNewLabel_5);
		 
		 lblNewLabel_6 = new JLabel("prix:");
		 lblNewLabel_6.setBounds(195, 636, 77, 14);
		 contentPane.add(lblNewLabel_6);
		textField_2.setVisible(false);
		textField_3.setVisible(false);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_6.setVisible(false);
		this.setLocationRelativeTo(null);
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rabab\\Desktop\\E.png"));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png"))); 
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public JDateChooser getDe() {
		return de;
	}

	public JDateChooser getDs() {
		return ds;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}
	
	public JTextField getTextField_4() {
		return textField_4;
	}


	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JFormattedTextField getText() {
		return text;
	}

	public void setText(JFormattedTextField text) {
		this.text = text;
	}

	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

	public void setBtnNewButton_2(JButton btnNewButton_2) {
		this.btnNewButton_2 = btnNewButton_2;
	}
	
}

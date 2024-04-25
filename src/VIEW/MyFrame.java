package VIEW;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import java.awt.Choice;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class  MyFrame extends JFrame {
	
	//private JFormattedTextField sort;
	//private JDateChooser dateh;
	//private JCalendar sort;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * @wbp.nonvisual location=-30,168
	 */
	private final JPanel panel_2 = new JPanel();
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnNewButton;//suivant
	private JButton btnNewButton_1;//+ adul
	private JButton btnNewButton_2;//-
	private JButton btnNewButton_3;//+ enf
	private JButton btnNewButton_4;//-
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 MyFrame frame = new  MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public  MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "infos sur le sejour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(120, 11, 644, 81);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();//entr
		textField.setBounds(90, 25, 96, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();//sortie
		textField_1.setBounds(353, 25, 96, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date entree:");
		lblNewLabel.setBounds(10, 25, 96, 20);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date sortie:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(268, 28, 96, 14);
		panel_1.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Suivant");
		btnNewButton.setBounds(526, 47, 89, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "infos sur la chambre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(120, 103, 644, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Simple", "Double", "Suite"}));
		comboBox.setBounds(91, 25, 106, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Categorie");
		lblNewLabel_2.setBounds(10, 27, 94, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("nombre d'adultes:");
		lblNewLabel_3.setBounds(248, 40, 160, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("nombre d'enfants:");
		lblNewLabel_4.setBounds(248, 17, 120, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("1");
		lblNewLabel_5.setBounds(489, 17, 47, 14);
		panel.add(lblNewLabel_5);
		
		 btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(518, 13, 47, 23);
		panel.add(btnNewButton_1);
		
		 btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBounds(426, 13, 47, 23);
		panel.add(btnNewButton_2);
		
		textField_2 = new JTextField();
		textField_2.setText("1");
		textField_2.setBounds(609, 40, 19, 18);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		 btnNewButton_3 = new JButton("+");
		btnNewButton_3.setBounds(426, 40, 47, 23);
		panel.add(btnNewButton_3);
		
		 btnNewButton_4 = new JButton("-");
		btnNewButton_4.setBounds(518, 40, 47, 23);
		panel.add(btnNewButton_4);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setBounds(493, 41, 19, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Ajouter ");
		btnNewButton_5.setBounds(530, 103, 89, 23);
		panel.add(btnNewButton_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "infos personnelles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(120, 271, 644, 125);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBounds(112, 20, 96, 20);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nom:");
		lblNewLabel_6.setBounds(29, 23, 73, 14);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Prenom:");
		lblNewLabel_7.setBounds(29, 57, 47, 14);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Telephone");
		lblNewLabel_8.setBounds(29, 92, 73, 14);
		panel_3.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setBounds(112, 51, 96, 20);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(112, 89, 96, 20);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Verifier ");
		btnNewButton_6.setBounds(621, 247, 108, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Enregistrer");
		btnNewButton_7.setBounds(621, 421, 108, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel_9 = new JLabel("code de la reservation:");
		lblNewLabel_9.setBounds(52, 420, 144, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("prix:");
		lblNewLabel_10.setBounds(335, 420, 47, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(200, 421, 96, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(392, 421, 96, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
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

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	
	
	
}

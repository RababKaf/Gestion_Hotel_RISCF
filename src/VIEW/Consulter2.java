package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

//import test.consulter;

public class Consulter2 extends JFrame {

	private JPanel contentPane;
	private JTextField code;
	private JTextField nom;
	private JTextField prenom;
	private JTextField telephone;
	private JTextField dateDebut;
	private JTextField dateFin;
	private JPanel panelMenu;
	private JPanel panelConsulter;
	private JPanel panel1;
    private JLabel codeLabel;
    private JButton btnRechercher;
    private JButton btnAnnuler;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel nomLabel;
    private JLabel prenomLabel;
    private JLabel telLabel;
    private JLabel dateDebutLabel;
    private JLabel dateFinLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					consulter frame = new consulter();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Consulter2() {
		this.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new TitledBorder(null, "Menu : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMenu.setBounds(0, 11, 171, 535);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelConsulter = new JPanel();
		panelConsulter.setBounds(172, 11, 617, 535);
		contentPane.add(panelConsulter);
		panelConsulter.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "Consulter R\u00E9servation ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(20, 11, 590, 78);
		panelConsulter.add(panel1);
		panel1.setLayout(null);
		
		JLabel codeLabel = new JLabel("Saisir le numero e la reservation : ");
		codeLabel.setBounds(10, 11, 332, 27);
		panel1.add(codeLabel);
		
		code = new JTextField();
		code.setBounds(327, 14, 174, 20);
		panel1.add(code);
		code.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(337, 49, 122, 23);
		btnRechercher.setBackground(new Color(0, 0, 204));
		 btnRechercher.setFont(new Font("Tahome",Font.BOLD,11));
		 btnRechercher.setForeground(Color.WHITE);
		 
		panel1.add(btnRechercher);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(469, 49, 99, 23);
		btnAnnuler.setBackground(new Color(0, 0, 204));
		 btnAnnuler.setFont(new Font("Tahome",Font.BOLD,11));
		 btnAnnuler.setForeground(Color.WHITE);
		
		panel1.add(btnAnnuler);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 100, 607, 424);
		panelConsulter.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informations sur le client ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 0, 587, 149);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel nomLabel = new JLabel("Nom : ");
		nomLabel.setBounds(10, 21, 152, 14);
		panel_1.add(nomLabel);
		
		JLabel prenomLabel = new JLabel("Prenom : ");
		prenomLabel.setBounds(10, 46, 152, 14);
		panel_1.add(prenomLabel);
		
		JLabel telLabel = new JLabel("Télèphone : ");
		telLabel.setBounds(10, 71, 152, 14);
		panel_1.add(telLabel);
		
		JLabel dateDebutLabel = new JLabel("Date déebut : ");
		dateDebutLabel.setBounds(10, 96, 152, 14);
		panel_1.add(dateDebutLabel);
		
		JLabel dateFinLabel = new JLabel("Date Fin : ");
		dateFinLabel.setBounds(10, 121, 152, 14);
		panel_1.add(dateFinLabel);
		
		nom = new JTextField();
		nom.setBounds(191, 21, 193, 20);
		panel_1.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(191, 43, 193, 20);
		panel_1.add(prenom);
		prenom.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(191, 68, 193, 20);
		panel_1.add(telephone);
		telephone.setColumns(10);
		
		dateDebut = new JTextField();
		dateDebut.setBounds(191, 93, 193, 20);
		panel_1.add(dateDebut);
		dateDebut.setColumns(10);
		
		dateFin = new JTextField();
		dateFin.setBounds(191, 118, 193, 20);
		panel_1.add(dateFin);
		dateFin.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 357, 600, 56);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(290, 21, 89, 23);
		 btnModifier.setBackground(new Color(0, 0, 204));
		 btnModifier.setFont(new Font("Tahome",Font.BOLD,11));
		 btnModifier.setForeground(Color.WHITE);
		panel_2.add(btnModifier);
		
		//JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(389, 21, 89, 23);
		panel_2.add(btnAnnuler);
		
		JButton btnConfirmer = new JButton("btnConfirmer");
		btnConfirmer.setBounds(488, 21, 89, 23);
		
		panel_2.add(btnConfirmer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 587, 186);
		panel.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
	}
	
}

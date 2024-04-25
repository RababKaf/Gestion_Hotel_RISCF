package VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class RecapReservation extends JFrame {

	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JTable table;
	private JLabel texte;
	private DefaultTableModel model;
	private JButton btnConfirmer;
	private JButton btnAnnuler;
	
	public RecapReservation() {
		this.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 texte = new JLabel("La liste des chambres resérvées");
		texte.setBounds(106, 59, 343, 39);
		contentPane.add(texte);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 116, 375, 228);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//scrollPane.setColumnHeaderView(table);
		
		model=(DefaultTableModel) table.getModel();
		
		
		model.addColumn("numéro de la chambre");
		model.addColumn("étage");
		model.addColumn("Catégorie");
		
		//table.setModel(model);
		contentPane.add(scrollPane);
		
		 btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setMnemonic('C');
		btnConfirmer.setBounds(267, 379, 120, 23);
		 btnConfirmer.setBackground(new Color(0, 0, 204));
		 btnConfirmer.setFont(new Font("Tahome",Font.BOLD,11));
		 btnConfirmer.setForeground(Color.WHITE);
		contentPane.add(btnConfirmer);
		
		 btnAnnuler = new JButton("Annuler");
		btnAnnuler.setMnemonic('A');
		btnAnnuler.setBounds(415, 379, 120, 23);
		 btnAnnuler.setBackground(new Color(0, 0, 204));
		 btnAnnuler.setFont(new Font("Tahome",Font.BOLD,11));
		 btnAnnuler.setForeground(Color.WHITE);
		contentPane.add(btnAnnuler);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTable() {
		return table;
	}

	public JLabel getTexte() {
		return texte;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	
}

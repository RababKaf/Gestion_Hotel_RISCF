package VIEW;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ChambreVacante extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnConfirmer;
	private JButton btnAnnuler;
	private DefaultTableModel model;
	
	public ChambreVacante() {
		
		this.setBackground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setTitle("liste des chambres vacantes");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 414, 205);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(40);//fixer la hauteur de toutes les lignes
		
		for(int i=0;i<table.getColumnModel().getColumnCount();i++)
			table.getColumnModel().getColumn(i).setPreferredWidth(50);
		
		scrollPane.setViewportView(table);
		

		
		 
		 model=(DefaultTableModel) table.getModel();
		 

		 
		 
		 
		    model.addColumn("Numéro de chambre");
			model.addColumn("Etgae");
			model.addColumn("Etat");
			model.addColumn("Categorie");
			model.addColumn("Rendre occupée");
		 
		
		 btnConfirmer = new JButton("Confirmer");
		 btnConfirmer.setBounds(183, 300, 89, 23);
		 btnConfirmer.setBackground(new Color(0, 0, 204));
		 btnConfirmer.setFont(new Font("Tahome",Font.BOLD,11));
		 btnConfirmer.setForeground(Color.WHITE);
		 btnConfirmer.setMnemonic('C');
		 contentPane.add(btnConfirmer);
		
		 btnAnnuler = new JButton("Annuler");
		 btnAnnuler.setBounds(304, 300, 89, 23);
		 btnAnnuler.setBackground(new Color(0, 0, 204));
		 btnAnnuler.setFont(new Font("Tahome",Font.BOLD,11));
		 btnAnnuler.setForeground(Color.WHITE);
		 btnAnnuler.setMnemonic('A');
		 contentPane.add(btnAnnuler);
		 
		 this.setSize(480,400);
	   this.setLocationRelativeTo(null);
		 this.setVisible(true);
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));
		 
		 
	}

	

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public DefaultTableModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	
}

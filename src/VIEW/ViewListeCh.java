package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CONFIGURATION.Connexion;




public class ViewListeCh extends JFrame {
	public MenuPanAD menu=new MenuPanAD();
	private JPanel contentPane;
	private JTable table;
	JPanel panel_1;
	JButton btnConsulter;
	JButton btnchercher;
	private JTextField textField;
	JButton btnSearch;
	JPanel panel_2;
	JButton btnLogout;
	public JPanel getPanel_2() {
		return panel_2;
	}

	public JButton getBtnchercher() {
		return btnchercher;
	}

	public void setBtnConsulter(JButton btnConsulter) {
		this.btnConsulter = btnConsulter;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public ViewListeCh() {
		
		setTitle("Gestion Chambre\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(69, 11, -50, 250);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 187, 439);
		//contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Hotel");
		lblNewLabel.setBackground(new Color(205, 92, 92));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 22, 76, 40);
		
		panel_1.setLayout(null);
		ImageIcon img=new ImageIcon("hotel (2).png");
		lblNewLabel.setIcon(new ImageIcon(ViewListeCh.class.getResource("/view/hotel (2).png")));
		
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Administrateur");
		lblNewLabel_1.setBounds(0, 73, 187, 70);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(ViewListeCh.class.getResource("/view/administrator.png")));
		
		ImageIcon imgC=new ImageIcon("chambre.png");
		
		JButton btnAjouter = new JButton("Ajouter Chambre");
		btnAjouter.setBackground(Color.WHITE);
		btnAjouter.setIcon(new ImageIcon(ViewListeCh.class.getResource("/view/chambre (2).png")));
		btnAjouter.setBounds(0, 164, 187, 56);
		btnAjouter.setMnemonic('A');
		panel_1.add(btnAjouter);
		
		btnConsulter = new JButton("Consulter Chambres");
		
		
		btnConsulter.setBackground(Color.WHITE);
		btnConsulter.setIcon(new ImageIcon(ViewListeCh.class.getResource("/view/list.png")));
		btnConsulter.setBounds(0, 251, 187, 56);
		btnConsulter.setMnemonic('C');
		panel_1.add(btnConsulter);
		
		btnchercher = new JButton("");
		btnchercher.setBackground(Color.WHITE);
		btnchercher.setIcon(new ImageIcon(ViewListeCh.class.getResource("/view/search.png")));
		btnchercher.setBounds(631, 0, 41, 33);
		
		contentPane.add(btnchercher);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 87, 483, 352);
		contentPane.add(scrollPane);
		
		table = new JTable() {
			public boolean isCellEditable(int d,int c) {
				return false;
			}
		};
		
		scrollPane.setViewportView(table);
		panel_2 = new JPanel();
		panel_2.setBounds(436, 0, 194, 33);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(53, 0, 184, 33);
		textField.requestFocus();;
		panel_2.add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("OK");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setForeground(new Color(92,124,250));
		btnSearch.setBounds(0, 0, 53, 33);
		
		panel_2.add(btnSearch);
		panel_2.setVisible(false);
		
		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(ViewListeCh.class.getResource("/view/logout.png")));
		btnLogout.setBounds(188, 0, 31, 33);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(new EmptyBorder(3,3,3 ,3));
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel_2 = new JLabel("Sélectionnez une chambre pour la modifier");
		//lblNewLabel_2.setBackground(new Color(0,0,204));
		lblNewLabel_2.setForeground(new Color(51,154,240 ));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(lblNewLabel_2.getFont().deriveFont(lblNewLabel_2.getFont().getStyle() & ~Font.ITALIC | Font.BOLD));
		lblNewLabel_2.setBounds(299, 44, 248, 33);
		contentPane.add(lblNewLabel_2);
		
		
		contentPane.add(menu);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));
	}
	
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	
	public JTable getTable() {
		return table;
	}


	public JPanel getPanel_1() {
		return panel_1;
	}

	public JButton getBtnConsulter() {
		return btnConsulter;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

}

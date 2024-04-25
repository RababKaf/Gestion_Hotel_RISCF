package VIEW;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class pannchambre extends JPanel {
	
	
	 JButton btnNewButton;
	 JButton btnNewButton_1;
	 JButton btnNewButton_2;
	 JButton btnNewButton_3;
	public JComboBox comboBox;
	public JLabel lblNewLabel_3;
	 public JLabel lblNewLabel_4;
	 PannAge panage1;
	 PannAge panage2;
	 

	/**
	 * Create the panel.
	 */
	public pannchambre() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "infos sur la chambre", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setForeground(new Color(124, 169, 138));
		this.setPreferredSize(new Dimension(357, 180));
		
		panage1=new PannAge();
		panage1.setForeground(new Color(124, 169, 138));
		panage2=new PannAge();
		panage2.setBounds(181, 105, 159, 37);
		panage1.setBounds(10, 105, 174, 37);
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"simple", "double", "suite"}));
		comboBox.setBounds(215, 11, 91, 22);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Categorie:");
		lblNewLabel.setBounds(60, 15, 91, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("nombre d'adultes:");
		lblNewLabel_1.setBounds(30, 55, 121, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("nombre d'enfants:");
		lblNewLabel_2.setBounds(30, 80, 121, 14);
		add(lblNewLabel_2);
		
		 btnNewButton = new JButton("+");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnNewButton_1.setEnabled(true);
		 		int i;
		 		i=Integer.parseInt(lblNewLabel_3.getText());
		 		if(i==1)
		 			{lblNewLabel_3.setText("2");
		 			btnNewButton.setEnabled(false);}
		 			
		 	}
		 });
		
		btnNewButton.setBounds(189, 51, 47, 23);
		add(btnNewButton);
		
		 btnNewButton_1 = new JButton("-");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnNewButton.setEnabled(true);
		 		int i;
		 		i=Integer.parseInt(lblNewLabel_3.getText());
		 		if(i==2)
		 			lblNewLabel_3.setText("1");
		 			btnNewButton_1.setEnabled(false);
		 			
		 	}
		 });
		
		btnNewButton_1.setBounds(293, 51, 47, 23);
		add(btnNewButton_1);
		
		
	
		panage1.setVisible(false);
		add(panage2);
		add(panage1);
		panage2.setLayout(null);
		panage2.setVisible(false);
		panage1.setLayout(null);
		
		 btnNewButton_2 = new JButton(" +");
		 btnNewButton_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnNewButton_3.setEnabled(true);
		 		int i;
		 		
		 		i=Integer.parseInt(lblNewLabel_4.getText());
		 		if(i==0)
		 			{lblNewLabel_4.setText("1");
		 			panage1.setVisible(true);}
		 		if(i==1)
		 			{lblNewLabel_4.setText("2");
		 			panage2.setVisible(true);
		 			btnNewButton_2.setEnabled(false);}
		 		
		 	}
		 });
		btnNewButton_2.setBounds(189, 76, 47, 23);
		add(btnNewButton_2);
		
		 btnNewButton_3 = new JButton("-");
		 btnNewButton_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnNewButton_2.setEnabled(true);
		 		int i;
		 		i=Integer.parseInt(lblNewLabel_4.getText());
		 		if(i==2)
		 			{lblNewLabel_4.setText("1");
		 			panage2.setVisible(false);}
		 		if(i==1)
		 			{lblNewLabel_4.setText("0");
		 			panage1.setVisible(false);
		 			btnNewButton_3.setEnabled(false);}
		 	}
		 });
		 
		btnNewButton_3.setBounds(293, 76, 47, 23);
		add(btnNewButton_3);
		
		 lblNewLabel_3 = new JLabel("1");
		lblNewLabel_3.setBounds(264, 50, 19, 25);
		add(lblNewLabel_3);
		
		 lblNewLabel_4 = new JLabel("0");
		lblNewLabel_4.setBounds(264, 65, 47, 45);
		add(lblNewLabel_4);
		
	}




//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JFrame fen=new JFrame();
//		pannchambre pann;
//		pann=new pannchambre();
//		fen.getContentPane().add(pann);
//		fen.setSize(800,600);
//        fen.setVisible(true);
//	}
	public void actionPerformed(ActionEvent e) {
		
	}
}

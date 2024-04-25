package VIEW;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;







public class ViewChercher  {
	  
	public JFrame frame;
	JButton btnNewButton_1 ;
	JButton btnNewButton_2;
	JButton btnNewButton;
    JComboBox comboBox ;
	JPanel panel;
	JPanel panel_1;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JLabel lblNewLabel ;
	private JTable table;
	private JScrollPane scrollPane;
	JLabel lblNewLabel_3_1 ;
	private JTextField textField_5;
	private JLabel lblCin;
	public MenuAG mm;
	private JLabel lblNewLabel_3_2;
   
	private JLabel cin;
	private JLabel nomC;
	private JLabel lblNewLabel_9;
	public JPanel panel_2;
	 public JLabel c;
	public JLabel n;
	 public JLabel tele;  
	 public JLabel num;



	public ViewChercher() {
		 mm=new MenuAG();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(0, 0, 128));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 845, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	 textField = new JTextField();
		textField.setBounds(411, 42, 306, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Numéro de Réservation :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 204));
		lblNewLabel.setBounds(469, 0, 200, 50);
		frame.getContentPane().add(lblNewLabel);
		
		 btnNewButton = new JButton("Chercher");
		 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		 btnNewButton.setForeground(new Color(255, 255, 255));
		 btnNewButton.setBackground(new Color(0, 0, 204));
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		btnNewButton.setMnemonic('C');
		btnNewButton.setBounds(411, 79, 309, 25);
		frame.getContentPane().add(btnNewButton);

		 btnNewButton_1 = new JButton("Enregistrer");
		 btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		 btnNewButton_1.setBackground(new Color(0, 0, 204));
		btnNewButton_1.setMnemonic('E');
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(694, 608, 100, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Imprimer");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBackground(new Color(0, 0, 204));
		btnNewButton_2.setMnemonic('I');
		btnNewButton_2.setBounds(546, 608,100, 25);
		frame.getContentPane().add(btnNewButton_2);

		
	   
		panel = new JPanel();
	    panel.setBorder(new TitledBorder(null, "Information Facture", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(302, 210, 519, 296);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Types de payement :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(11, 203, 132, 13);
		panel.add(lblNewLabel_3);
		
		
	  String[]  ways ={"Carte Bancaire", "Liquide","Chéque"};
	      comboBox = new JComboBox(ways);
	    //  comboBox.setForeground(new Color(255, 255, 255));
	      comboBox.setToolTipText("");
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(226, 200, 194, 21);
		comboBox.setBackground(new Color(162, 213, 230));
	//	comboBox.selectWithKeyChar((char) 1);
		panel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Prix Total :");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(11, 231, 84, 13);
		panel.add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Prix Réduit :");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(11, 266, 84, 13);
		panel.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 226, 124, 25);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setForeground(new Color(255, 0, 0));
		textField_4.setColumns(10);
		textField_4.setBounds(96, 261, 124, 25);
		panel.add(textField_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 499, 152);
		panel.add(scrollPane);
		
		table = new JTable() {
		public boolean isCellEditable(int d,int c) {return false;}
		};
		table.setBackground(new Color(200, 219, 247));
		scrollPane.setViewportView(table);
		
		lblNewLabel_3_2 = new JLabel("Numéro de Réservation :");
		lblNewLabel_3_2.setForeground(new Color(0, 102, 204));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(173, 18, 155, 13);
		panel.add(lblNewLabel_3_2);
		
		num = new JLabel("0");
		num.setFont(new Font("Tahoma", Font.BOLD, 12));
		num.setBounds(332, 14, 75, 21);
		panel.add(num);

		
		 panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Information Ch\u00E9que", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(302, 508, 525, 89);
		panel_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 32, 124,23);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(364, 32, 124, 25);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(41, 37, 98, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Montant :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(295, 37, 79, 13);
		panel_1.add(lblNewLabel_2);
		
	  lblNewLabel_3_1 = new JLabel("Numéro de Réservation Oublié ?");
		lblNewLabel_3_1.setForeground(new Color(0, 102, 204));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(469, 114, 248, 13);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		textField_5 = new JTextField();
		textField_5.setVisible(false);
		textField_5.setColumns(10);
		textField_5.setBounds(414, 42, 303, 25);
		frame.getContentPane().add(textField_5);
		
		lblCin = new JLabel("Chercher Par CIN :\r\n");
		lblCin.setVisible(false);
		lblCin.setForeground(new Color(0, 0, 204));
		lblCin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCin.setBounds(491, 0, 200, 50);//(349, 25, 200, 50);
		frame.getContentPane().add(lblCin);
		
//		JButton btnNewButton_3 = new JButton("New button");
//		btnNewButton_3.setIcon(new ImageIcon(ViewChercher.class.getResource("0.jpg")));
//		btnNewButton_3.setBounds(789, 0, 42, 39);
//		btnNewButton_3.setContentAreaFilled(false);
//		btnNewButton_3.setBorder(new EmptyBorder(3,3,3,3));
//		frame.getContentPane().add(btnNewButton_3);
		panel_1.setVisible(false);
		panel.setVisible(false);
		mm.setBounds(0, 11, 200,680);
		frame.getContentPane().add(mm);
		
		 panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setForeground(new Color(64, 0, 64));
		panel_2.setBorder(new TitledBorder(null, "Information Personnelle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(302, 137, 519, 69);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		cin = new JLabel("CIN :\r\n\r\n");
		cin.setBounds(10, 30, 66, 15);
		cin.setForeground(Color.BLACK);
		cin.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(cin);
		
		nomC = new JLabel("Nom Complet :\r\n\r\n");
		nomC.setForeground(Color.BLACK);
		nomC.setFont(new Font("Tahoma", Font.BOLD, 12));
		nomC.setBounds(145, 30, 99, 13);
		panel_2.add(nomC);
		
		lblNewLabel_9 = new JLabel("Téléphone :");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(348, 30, 84, 13);
		panel_2.add(lblNewLabel_9);
		
		c = new JLabel("New labelc");
		c.setFont(new Font("Tahoma", Font.PLAIN, 11));
		c.setBounds(44, 30, 84, 15);
		panel_2.add(c);
		
		n= new JLabel("New labeln");
	n.setFont(new Font("Tahoma", Font.PLAIN, 11));
	n.setBounds(242, 30, 110, 13);
		panel_2.add(n);
		
	tele = new JLabel("New label t\r\n");
	tele.setFont(new Font("Tahoma", Font.PLAIN, 10));
	tele.setBounds(425, 30,90, 15);
		panel_2.add(tele);
		panel_2.setVisible(false);
		frame.setLocationRelativeTo(null);
		
		textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textField_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textField_5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));


		}


		// TODO Auto-generated method stub
	
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextField_5() {
		return  textField_5;
	}


	public JLabel getLblCin() {
		return lblCin;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}




	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}




	public JButton getBtnNewButton() {
		return btnNewButton;
	}




	public JComboBox getComboBox() {
		return comboBox;
	}
	

	public JTable getTable() {
		return table;
	}


	public JPanel getPanel() {
		return panel;
	}




	public JPanel getPanel_1() {
		return panel_1;
	}




	public JTextField getTextField() {
		return textField;
	}




	public JTextField getTextField_1() {
		return textField_1;
	}




	public JTextField getTextField_2() {
		return textField_2;
	}



	public JTextField getTextField_3() {
		return textField_3;
	}


	public 	JLabel getLblNewLabel_3_1() {return lblNewLabel_3_1;};

	public JTextField getTextField_4() {
		return textField_4;
	}




	public void setFrame(JFrame frame) {
		this.frame = frame;
	}




	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}


	

	public void setBtnNewButton_2(JButton btnNewButton_2) {
		this.btnNewButton_2 = btnNewButton_2;
	}




	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}




	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}




	public void setPanel(JPanel panel) {
		this.panel = panel;
	}




	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}




	public void setTextField(JTextField textField) {
		this.textField = textField;
	}




	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}




	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}




	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}




	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JLabel getLblNewLabel() {
		// TODO Auto-generated method stub
		return lblNewLabel;
	}




//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object src=e.getSource();
//		
//		if(src==btnNewButton)
//				
//			panel.setVisible(true);
//		if(src==comboBox)
//		{
//			if(((JComboBox) src).getSelectedItem()=="Chéque")
//				panel_1.setVisible(true);
//				
//		}}
		
	
}


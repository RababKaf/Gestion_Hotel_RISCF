package VIEW;

import java.awt.Color;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PanelConsulter extends JPanel {

	private Panel1 panel1;
	private Panel panel;
	
	
	public PanelConsulter() {
		
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		panel1=new Panel1();
		panel1.setBounds(20, 11, 632, 78);
		this.add(panel1);
		
		panel=new Panel();
		panel.setBounds(10, 100, 642, 528);
		this.add(panel);
		panel.setVisible(false);
		
		
		this.setVisible(true);
	}


	public Panel1 getPanel1() {
		return panel1;
	}


	public Panel getPanel() {
		return panel;
	}
	
	
}

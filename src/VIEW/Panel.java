package VIEW;

import java.awt.Color;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Panel extends JPanel {

	private Panel_1 panel_1;
	private Panel_2 panel_2;
	//private Panel2 panel2;
	
	
	
	public Panel() {
		
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		panel_1=new Panel_1();
		panel_1.setBounds(10,0,622,149);
		this.add(panel_1);
		panel_1.setVisible(true);
		
		
		panel_2=new Panel_2();
		panel_2.setBounds(10,474,622,43);
		this.add(panel_2);
		panel_2.setVisible(true);
		
		
//		panel2=new Panel2();
//		panel2.setBounds(10, 160, 622, 303);
//		this.add(panel2);
//		panel2.setVisible(true);
		
		this.setVisible(true);
		
	}




	public Panel_1 getPanel_1() {
		return panel_1;
	}




	public Panel_2 getPanel_2() {
		return panel_2;
	}




//	public Panel2 getPanel2() {
//		return panel2;
//	}
	
	
}

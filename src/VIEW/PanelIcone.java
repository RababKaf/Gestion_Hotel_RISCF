package VIEW;



import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class PanelIcone extends JPanel {

	private JButton btnKey;
	public PanelIcone() {
		setLayout(null);
		
		 btnKey = new JButton("");
		btnKey.setBackground(Color.WHITE);
		btnKey.setIcon(new ImageIcon(PanelIcone.class.getResource("yes.png")));
		btnKey.setBounds(0, 0, 57, 31);
		btnKey.setContentAreaFilled(false);
		btnKey.setBorder(new EmptyBorder(3,3,3,3));
		add(btnKey);

	}
	public JButton getBtnKey() {
		return btnKey;
	}
	
}

package VIEW;



import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PannAge extends JPanel {

	/**
	 * Create the panel.
	 */
	public PannAge() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("age de l'enfant:");
		lblNewLabel.setBounds(10, 11, 119, 14);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "", ""}));
		comboBox.setBounds(112, 7, 38, 22);
		add(comboBox);
		

	}
}

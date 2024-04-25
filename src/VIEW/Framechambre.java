package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VIEW.pannchambre;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JSeparator;

public class Framechambre extends JFrame {

	int i=0;
	private JPanel contentPane;
	pannchambre pan2=new pannchambre();
	pannchambre pan3=new pannchambre();
	pannchambre pan4=new pannchambre();
	private final JSeparator separator = new JSeparator();
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Framechambre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		pan2.setBounds(3, 0, 432, 167);
		getContentPane().add(pan2);
		pan3.setBounds(3, 167, 432, 165);
		contentPane.add(pan3);
		pan3.setVisible(false);
		pan4.setBounds(3, 330, 432, 169);
		contentPane.add(pan4);
		pan4.setVisible(false);
		
		JButton btnNewButton = new JButton("Ajouter chambre");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pan3.setVisible(true);
				
				i++;
				if(i==1) pan3.setVisible(true);
				if(i==2) pan4.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(170, 510, 149, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Verifier");
		btnNewButton_1.setBounds(339, 510, 89, 23);
		contentPane.add(btnNewButton_1);
		separator.setBounds(3, 167, 412, 5);
		contentPane.add(separator);
	}
}

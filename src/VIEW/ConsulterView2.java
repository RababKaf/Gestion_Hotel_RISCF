package VIEW;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import MODEL.Clients;
import MODEL.Reservations;

public class ConsulterView2 extends JFrame {

	
	private JPanel contentPane;
	
	private PanelConsulter panelConsulter;
public	MenuAG mm=new MenuAG();
	
	
	public ConsulterView2() {
		
		//getContentPane().setLayout(null);
	
		
		this.setBackground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 80, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
	
		//panelMenu.setLayout(null);
		
		panelConsulter =  new PanelConsulter();
		panelConsulter.setBounds(172, 11, 662, 639);
		contentPane.add(panelConsulter);
		//panelConsulter.setLayout(null);
		contentPane.setVisible(true);
		this.setVisible(false);
		mm.setBounds(0, 11, 180,639);
		this.getContentPane().add(mm);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));
	}


	public JPanel getContentPane() {	
		return contentPane;
	}



	public PanelConsulter getPanelConsulter() {
		return panelConsulter;
	}
	
	
}

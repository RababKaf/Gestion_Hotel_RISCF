package VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ViewI extends JFrame {
	
	 private JFrame frame;
	 private JLabel lblQuitter;
	 private JPanel panDonn;
	 private JLabel categorieLabel;
	 private JComboBox categorieSelect;
	 private JSpinner txtNbrlit;
	 private JLabel etagelabel ;
	 private JLabel nbrLitLabel;
	 private JButton btnAnnuler;
	 private JButton btnAjouter = new JButton("Ajouter"); 
	 private JLabel ajouterLabel;
	 private JSpinner txtEtage=new JSpinner();
	  public MenuPanAD pan = new MenuPanAD();
;
	 public ViewI()
	 
	 {
		 frame = new JFrame();
				
				pan.setBounds(0, 11, 171, 417);
				frame.getContentPane().setBackground(new Color(255, 255, 255));
				frame.setBounds(100, 100, 659, 484);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.getContentPane().add(pan);
				 lblQuitter = new JLabel("");
				lblQuitter.setBounds(592, 0, 41, 33);
			    lblQuitter.setIcon(new ImageIcon(MenuPanAD.class.getResource("quiiiter.png")));
				frame.getContentPane().add(lblQuitter);
				
				 panDonn = new JPanel();
				 panDonn.setForeground(new Color(232, 247, 253));
				panDonn.setBackground(new Color(255, 255, 255));
				panDonn.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)), "Saisir donnees du chambre", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panDonn.setBounds(195, 82, 438, 293);
				frame.getContentPane().add(panDonn);
				panDonn.setLayout(null);
				
				 categorieLabel = new JLabel("Categorie:");
				categorieLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				categorieLabel.setForeground(new Color(0, 0, 0));
				categorieLabel.setBounds(165, 25, 89, 18);
				panDonn.add(categorieLabel);
				
				
				String[] categorie = {"Suite","Double","Simple"};
				 categorieSelect = new JComboBox(categorie);
				categorieSelect.setSelectedIndex(-1);
				categorieSelect.setBackground(new Color(255, 255, 255));
				categorieSelect.setBounds(287, 24, 122, 22);
				panDonn.add(categorieSelect);
				
				txtEtage.setBounds(287, 93, 122, 20);
				panDonn.add(txtEtage);
				
				 txtNbrlit = new JSpinner();
				txtNbrlit.setBounds(287, 167, 122, 20);
				panDonn.add(txtNbrlit);
				
				 etagelabel = new JLabel("Etage:");
				etagelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				etagelabel.setForeground(new Color(0, 0, 0));
				etagelabel.setBounds(181, 93, 46, 17);
				panDonn.add(etagelabel);
				
				 nbrLitLabel = new JLabel("Nombre de lits:");
				nbrLitLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				nbrLitLabel.setForeground(new Color(0, 0, 0));
				nbrLitLabel.setBounds(129, 168, 114, 14);
				panDonn.add(nbrLitLabel);
				
				 btnAnnuler = new JButton("Annuler");
				 btnAnnuler.setBackground(new Color(0, 0, 255));
				 btnAnnuler.setMnemonic('A');
				btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnAnnuler.setForeground(new Color(255, 255, 255));
				btnAnnuler.setBounds(337, 246, 91, 23);
				panDonn.add(btnAnnuler);
				btnAjouter.setBackground(new Color(0, 0, 255));
				
				
				btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnAjouter.setForeground(new Color(255, 255, 255));
				btnAjouter.setBounds(232, 246, 95, 23);
				btnAjouter.setMnemonic('A');
				panDonn.add(btnAjouter);
				
				ajouterLabel = new JLabel("Ajouter chambre");
				ajouterLabel.setFont(new Font("Swis721 BT", Font.BOLD | Font.ITALIC, 22));
				ajouterLabel.setForeground(new Color(51,154,240));
				ajouterLabel.setBounds(282, 23, 186, 33);
				frame.getContentPane().add(ajouterLabel);
				frame.setLocationRelativeTo(null);
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("E.png")));
				
		
		 
		 
	 }
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JLabel getLblQuitter() {
		return lblQuitter;
	}
	public void setLblQuitter(JLabel lblQuitter) {
		this.lblQuitter = lblQuitter;
	}
	public JPanel getPanDonn() {
		return panDonn;
	}
	public void setPanDonn(JPanel panDonn) {
		this.panDonn = panDonn;
	}
	public JLabel getCategorieLabel() {
		return categorieLabel;
	}
	public void setCategorieLabel(JLabel categorieLabel) {
		this.categorieLabel = categorieLabel;
	}
	public JComboBox getCategorieSelect() {
		return categorieSelect;
	}
	public void setCategorieSelect(JComboBox categorieSelect) {
		this.categorieSelect = categorieSelect;
	}
	public JSpinner getTxtNbrlit() {
		return txtNbrlit;
	}
	public void setTxtNbrlit(JSpinner txtNbrlit) {
		this.txtNbrlit = txtNbrlit;
	}
	public JLabel getEtagelabel() {
		return etagelabel;
	}
	public void setEtagelabel(JLabel etagelabel) {
		this.etagelabel = etagelabel;
	}
	public JLabel getNbrLitLabel() {
		return nbrLitLabel;
	}
	public void setNbrLitLabel(JLabel nbrLitLabel) {
		this.nbrLitLabel = nbrLitLabel;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	public void setBtnAnnuler(JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}
	public JLabel getAjouterLabel() {
		return ajouterLabel;
	}
	public void setAjouterLabel(JLabel ajouterLabel) {
		this.ajouterLabel = ajouterLabel;
	}
	public JSpinner getTxtEtage() {
		return txtEtage;
	}
	public void setTxtEtage(JSpinner txtEtage) {
		this.txtEtage = txtEtage;
	}

}

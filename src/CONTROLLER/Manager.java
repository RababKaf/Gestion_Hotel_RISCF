package CONTROLLER;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import CONFIGURATION.Connexion;
import CONTROLLER.Manager;
import MODEL.ModelCheque;
import MODEL.ModelFacture;
import MODEL.ReservationCh;
import MODEL.CategorieI;
import MODEL.ChambreI;
import VIEW.Admin;
import VIEW.Agent;
import VIEW.ConsulterView2;
import VIEW.FramReservation;
import VIEW.MenuAG;
import VIEW.MenuPanAD;
import VIEW.View;
import VIEW.ViewChercher;
import VIEW.ViewListeCh;
import VIEW.ViewI;

public class Manager 
{
	
	View view ;
	Agent agent = new Agent() ;
	Admin admin = new Admin();
	MenuPanAD panAD=new MenuPanAD();
	MenuAG menuAG=new MenuAG();
	Connexion conx= new Connexion();
	  ViewChercher window=new ViewChercher();
		ViewI v=new ViewI();
		ViewListeCh frame=new ViewListeCh();
		FramReservation fen=new FramReservation();
		ConsulterView2 consulterView= new ConsulterView2();
	
		ControllerS controller;
	public Manager(View view) {
		super();
	
		this.view = view;
	}
	public void initManager()
	{
	window.mm.getAjouterBTN().addActionListener(e ->ajouterReservation());
	window.mm.getConBTN().addActionListener(e ->ConsulterReservation());
	
   
    consulterView.mm.getBtnFacture().addActionListener(e ->Facturation());
    consulterView.mm.getAjouterBTN().addActionListener(e ->ajouterReservation());
    
        fen.mm.getConBTN().addActionListener(e ->ConsulterReservation());
        fen.mm.getBtnFacture().addActionListener(e ->Facturation());
    
		view.getSuivant().addActionListener(e ->suivant());
		
		agent.getBtnAjouterR().addActionListener(e ->ajouterReservation());
		
		frame.menu.getAjouterBTN().addActionListener(e ->AjouterChambre());
	
	     v.pan.getconBTNCH().addActionListener(e ->ConsulterChambre());
		//System.out.println( v.pan.getconBTNCH());
		
		agent.getConsulterButton().addActionListener(e ->ConsulterReservation());
		
		agent.getBtnFacture().addActionListener(e ->Facturation());
		
		admin.getBtnAjouterRA().addActionListener(e ->AjouterChambre());
	
		admin.getConsulterButtonA().addActionListener(e ->ConsulterChambre());
		
		
		
		
		
		view.getPasswordField().addKeyListener(new KeyAdapter()
		{public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
				suivant();
				
			
				
		}});
			
		
		
		
	}
	private void suivant()
	{
		if(view.getLogin().getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Saisir le login !","Authentification",JOptionPane.WARNING_MESSAGE);
			view.getLogin().setBorder(BorderFactory.createLineBorder(Color.RED));
			view.getLogin().requestFocusInWindow();
			//view.getErreur1().setVisible(true);
		}
		else 
		{
			String  email =view.getLogin().getText();
			String login =email.substring(email.length()-5);
			//recupere le password;
			char[] word = view.getPasswordField().getPassword();
			String pass=new String(word);
			int code = Integer.parseInt(pass);
			//System.out.println(code);
			
			if(login.equals("agent") )
			{
				if(code==9090)
				{
					
				//	System.out.println("bienAgent");
				    agent.getFrame().setVisible(true);
					view.getFrame().dispose();
				   
				}
				else 
				//view.getErr2().setVisible(true);
					
			    JOptionPane.showMessageDialog(null, "Mot de passe incorrect!!","Authentification",JOptionPane.WARNING_MESSAGE);
				view.getPasswordField().setBorder(BorderFactory.createLineBorder(Color.RED));
				view.getPasswordField().requestFocusInWindow();
				view.getPasswordField().setText("");
			}
			else {
				
			
			if(login.equals("admin"))
			{
				if(code==1010)
				{
					admin.getFrame().setVisible(true);
					view.getFrame().dispose();
				}
				else 
				{
					//view.getErr2().setVisible(true);
					JOptionPane.showMessageDialog(null, "Mot de passe incorrect!!","Authentification",JOptionPane.WARNING_MESSAGE);
					view.getPasswordField().setBorder(BorderFactory.createLineBorder(Color.RED));
					view.getPasswordField().requestFocusInWindow();
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Login invalide !!","Authentification",JOptionPane.WARNING_MESSAGE);
				view.getLogin().setText("");
				view.getPasswordField().setText("");
				view.getLogin().setBorder(BorderFactory.createLineBorder(Color.RED));
				view.getLogin().requestFocusInWindow();
				
			}
			}
			
		}
		
		
	}
	
	public void ajouterReservation()
	{
		window.getFrame().dispose();
	    view.getFrame().dispose();
		agent.getFrame().dispose();
		consulterView.dispose();
	
			//System.out.println("Chocho");

		ReservationCh  reservation=new ReservationCh();
		fen.setVisible(true);
		fen.lblNewLabel_5.setVisible(false);
		fen.lblNewLabel_6.setVisible(false);
		Controler cntr;
		cntr=new Controler(fen,reservation);
		fen.textField_2.setVisible(false);
		fen.textField_3.setVisible(false);
		fen.lblNewLabel_5.setVisible(false);
		fen.lblNewLabel_6.setVisible(false);
		fen.btnNewButton_1.setVisible(false);
		//vider tous les champs	
		
		fen.getDs().setCalendar(null);
		fen.getDe().setCalendar(null);
		fen.getTextField().setText("");
		fen.getTextField_1().setText("");
		fen.getTextField_4().setText("");
		fen.getText().setText("");
////		
	fen.pan2.setVisible(false);
	fen.pan3.setVisible(false);
	fen.pan4.setVisible(false);
	fen.btnNewButton_3.setVisible(false);
	fen.btnNewButton_2.setVisible(false);
	fen.pan2.lblNewLabel_3.setText("1");
	fen.pan2.lblNewLabel_4.setText("0");
//	
	
	fen.pan3.lblNewLabel_3.setText("1");
	fen.pan3.lblNewLabel_4.setText("0");
	
//	
//	fen.pan4.lblNewLabel_3.setText("1");
//	fen.pan4.lblNewLabel_4.setText("0");
//	
	
	
	
	
	
	fen.panel_3.setVisible(false);
	
//		fen.btnNewButton_2.setVisible(false);
//		fen.btnNewButton_3.setVisible(false);
	fen.panel_2.setVisible(false);
		
		
		
	}
	
	public void ConsulterReservation()
	
	{		
		fen.dispose();
		window.getFrame().dispose();
		agent.getFrame().dispose();
	   consulterView.setVisible(true);
		//System.out.println("Salwa");
		view.getFrame().dispose();

		
		 controller=new ControllerS(consulterView);
		
	}
	
	private void Facturation()
	{
		//System.out.println("Rabab");
		//fen.dispose();
		
		view.getFrame().dispose();
		consulterView.dispose();
		agent.getFrame().dispose();
		fen.dispose();
		ModelFacture m=new ModelFacture();
		ModelCheque ch=new ModelCheque();
		window.getPanel().setVisible(false);
		window.getPanel_1().setVisible(false);
		window.panel_2.setVisible(false);
		window.getBtnNewButton_2().setVisible(false);
		window.getBtnNewButton_1().setVisible(false);
		window.getTextField().setText("");
	
		
	
	   window.frame.setVisible(true);
	   
	   Controller c=new Controller(m,ch,window);
	   c.initController();
		
	}
	private void AjouterChambre()
	{
		//System.out.println("Ilhame");
		frame.dispose();
		admin.getFrame().dispose();
        view.getFrame().dispose();
		ChambreI chambre = new ChambreI();
		v.getFrame().setVisible(true);
		CategorieI categorie = new CategorieI();
		Manager2 manager= new Manager2(chambre , categorie , v);
		manager.initController();
		
	}
	private void ConsulterChambre()
	{
		//System.out.println("Fati");
		v.getFrame().dispose();
		admin.getFrame().dispose();
        view.getFrame().dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Controleur c=new Controleur(frame);
					c.initControleur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public View getView() {
		return view;
	}
	public Agent getAgent() {
		return agent;
	}
	public Admin getAdmin() {
		return admin;
	}
	public MenuPanAD getPanAD() {
		return panAD;
	}
	public MenuAG getMenuAG() {
		return menuAG;
	}
	public Connexion getConx() {
		return conx;
	}
	public void setView(View view) {
		this.view = view;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public void setPanAD(MenuPanAD panAD) {
		this.panAD = panAD;
	}
	public void setMenuAG(MenuAG menuAG) {
		this.menuAG = menuAG;
	}
	public void setConx(Connexion conx) {
		this.conx = conx;
	}
	public ViewChercher getWindow() {
		return window;
	}
	public void setWindow(ViewChercher window) {
		this.window = window;
	}


}


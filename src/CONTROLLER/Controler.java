package CONTROLLER;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;

//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import java.sql.Statement;

import javax.swing.JOptionPane;

import CONFIGURATION.Connexion;
import MODEL.DetailReservationCh;
import MODEL.ClientCh;
import MODEL.ReservationCh;
import VIEW.FramReservation;
import VIEW.Framechambre;
import VIEW.MyFrame;




public class Controler {
	ClientCh client=new ClientCh();
	ReservationCh  reservation;
	DetailReservationCh detailReservation1=new DetailReservationCh();
	DetailReservationCh detailReservation2=new DetailReservationCh();
	DetailReservationCh detailReservation3=new DetailReservationCh();
	FramReservation viewRes;
	
	
	Connexion cnx=new Connexion();
public Controler (FramReservation r,ReservationCh s) {
		//model = m;
	viewRes = r;
	reservation=s;
	initController();
}

public void initController() {
	viewRes.lblNewLabel_1.addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent e) {
		viewRes.getDe().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		viewRes.getDs().setBorder(BorderFactory.createLineBorder(Color.BLACK));

	 }});
	
	viewRes.lblNewLabel.addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent e) {
		viewRes.getDe().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		viewRes.getDs().setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
	 }});
	
	
	
	viewRes.textField.addKeyListener(new KeyAdapter()
	{public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
			viewRes.textField_1.requestFocus();
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			viewRes.textField_1.requestFocus();
			
		
			
	}});
	viewRes.textField_1.addKeyListener(new KeyAdapter()
	{public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
			viewRes.textField_4.requestFocus();
		if(e.getKeyCode()==KeyEvent.VK_UP)
			viewRes.textField.requestFocus();
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			viewRes.textField_4.requestFocus();
			
		
			
	}});
	
	viewRes.textField_4.addKeyListener(new KeyAdapter()
	{public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
			viewRes.text.requestFocus();
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			viewRes.text.requestFocus();
		if(e.getKeyCode()==KeyEvent.VK_UP)
			viewRes.textField_1.requestFocus();
			
	}});
	
	
	viewRes.text.addKeyListener(new KeyAdapter()
	{public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
			viewRes.textField_4.requestFocus();
			
	}});
	
	
	viewRes.getBtnNewButton_1().addActionListener(new ActionListener() { 
	public void actionPerformed (ActionEvent evt){
		
		if(viewRes.textField.getText().isEmpty()||viewRes.textField_1.getText().isEmpty()||viewRes.text.getText().isEmpty()||viewRes.textField_4.getText().isEmpty()) 
			JOptionPane.showMessageDialog(null, "Saisir tous les champs svp");
		EnregisterInfos ();

	}
	 });
	viewRes.getBtnNewButton_2().addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		if(viewRes.i==0) 
		 		viewRes.pan3.setVisible(true);
		 		
		 		
		 		
		 		viewRes.i++;
		 		if(viewRes.i==1) {
		 			viewRes.btnNewButton_3.setBounds(23, 365, 112, 23);
		 			viewRes.btnNewButton_2.setBounds(145, 365, 182, 23);
		 			viewRes.pan3.setVisible(true);
		 			}
		 			
		 		if(viewRes.i==2) { 
		 			viewRes.btnNewButton_3.setBounds(23, 562, 112, 23);
		 			viewRes.btnNewButton_2.setBounds(145, 562, 182, 23);
		 			viewRes.pan4.setVisible(true);
		 		
		 		}
		 	}
		 
		 	});
	

	viewRes.btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Date date1 = viewRes.getDe().getDate();
		  		Date date2 = viewRes.getDs().getDate();
		  		
		  		try {
					
		  			 if (date1.compareTo(date2)<0 && date1.compareTo(new Date())>0) {
				  			viewRes.panel_2.setVisible(true);
				  			viewRes.pan2.setVisible(true);
				  			viewRes.btnNewButton_2.setVisible(true);
					  		viewRes.btnNewButton_3.setVisible(true);
				  		    // date1 est avant date2
				  			 } 
		  			 else  if ( date1.compareTo(new Date())<0) {
		  				JOptionPane.showMessageDialog(null,"Date entree est avant la date d'aujourdhui", "Erreur de saisie",JOptionPane.ERROR_MESSAGE);
		  				viewRes.getDe().setBorder(BorderFactory.createLineBorder(Color.RED));
		  				viewRes.getDs().setBorder(BorderFactory.createLineBorder(Color.RED));
		  			 } else  {
				  		    
		  				viewRes.getDe().setBorder(BorderFactory.createLineBorder(Color.RED));
		  				viewRes.getDs().setBorder(BorderFactory.createLineBorder(Color.RED));		
		  			JOptionPane.showMessageDialog(null,"dates erronees", "Erreur de saisie",JOptionPane.ERROR_MESSAGE);
				  		}
				     }
				   catch(Exception ex) {
					 JOptionPane.showMessageDialog(null,"champs non remplis", "Erreur de saisie",JOptionPane.ERROR_MESSAGE);
				   }
		  		
		  			
		  	}
		  });
	viewRes.btnNewButton_3.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 		
	 		initialiserModel();
	 		
	 		String nomCat1, nomCat2, nomCat3;
	 		int t1 = 0,t2 = 0,t3 = 0;
	 		if(viewRes.i==0) {
	 			int id1;
	 		 nomCat1=(String)viewRes.pan2.comboBox.getSelectedItem();
		 		id1=cnx.chercherIdCategorie(nomCat1);
		 		detailReservation1.setM_Categorie(id1);
		 		detailReservation1.setNbrAdultes(Integer.parseInt(viewRes.pan2.lblNewLabel_3.getText()));
		 		detailReservation1.setNbrEnfants(Integer.parseInt(viewRes.pan2.lblNewLabel_4.getText()));
	
		 		
		 		t1=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation1.getM_Categorie(),1);
		 	
		 		
		 		
		 		if (t1==1) {
	 			viewRes.panel_3.setVisible(true);
			 	viewRes.btnNewButton_1.setVisible(true);
			 	
		 		
		 		}
		 		else {
		 			JOptionPane.showMessageDialog(null, "votre demande n'est pas disponible dans la periode souhaite");
		 			}
		 			
	 		}
	 		if(viewRes.i==1) {
	 			int id1;
	 			 nomCat1=(String)viewRes.pan2.comboBox.getSelectedItem();
			 		id1=cnx.chercherIdCategorie(nomCat1);
			 		detailReservation1.setM_Categorie(id1);
			 		detailReservation1.setNbrAdultes(Integer.parseInt(viewRes.pan2.lblNewLabel_3.getText()));
			 		detailReservation1.setNbrEnfants(Integer.parseInt(viewRes.pan2.lblNewLabel_4.getText()));

			 	
			 	
		 		int id2;
	 			 nomCat2=(String)viewRes.pan3.comboBox.getSelectedItem();
		 		id2=cnx.chercherIdCategorie(nomCat2);
		 		detailReservation2.setM_Categorie(id2);
		 		detailReservation2.setNbrAdultes(Integer.parseInt(viewRes.pan3.lblNewLabel_3.getText()));
		 		detailReservation2.setNbrEnfants(Integer.parseInt(viewRes.pan3.lblNewLabel_4.getText()));
		
		 		
		 		if(id1==id2) { 
		 			t1=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation1.getM_Categorie(),2);
		 			t2=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation2.getM_Categorie(),2);
		 			System.out.println(reservation.getDateDebut()+detailReservation1.getM_Categorie());
		 			System.out.println(reservation.getDateDebut()+detailReservation2.getM_Categorie());
		 		}
		 		else {
		 			t1=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation1.getM_Categorie(),1);
		 			t2=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation2.getM_Categorie(),1);
		 		}
		 		System.out.println(t1);
		 		System.out.println(t2);
		 		if(t1==1 && t2==1) {
		 			viewRes.panel_3.setVisible(true);
			 		viewRes.btnNewButton_1.setVisible(true);
		 		}
		 		else {
		 			JOptionPane.showMessageDialog(null, "votre demande n'est pas disponible dans la periode souhaite");
		 			}	
		 		}
	 		if(viewRes.i==2) {
	 			int id1;
	 			 nomCat1=(String)viewRes.pan2.comboBox.getSelectedItem();
			 		id1=cnx.chercherIdCategorie(nomCat1);
			 		detailReservation1.setM_Categorie(id1);
			 		detailReservation1.setNbrAdultes(Integer.parseInt(viewRes.pan2.lblNewLabel_3.getText()));
			 		detailReservation1.setNbrEnfants(Integer.parseInt(viewRes.pan2.lblNewLabel_4.getText()));
			// 		detailReservation1.setM_Reservation(cnx.recupererNumReservation()+1);
			 		
			 		//System.out.println(t1);
			 		
		 		int id2;
	 			 nomCat2=(String)viewRes.pan3.comboBox.getSelectedItem();
		 		id2=cnx.chercherIdCategorie(nomCat2);
		 		detailReservation2.setM_Categorie(id2);
		 		detailReservation2.setNbrAdultes(Integer.parseInt(viewRes.pan3.lblNewLabel_3.getText()));
		 		detailReservation2.setNbrEnfants(Integer.parseInt(viewRes.pan3.lblNewLabel_4.getText()));
		 	//	detailReservation2.setM_Reservation(cnx.recupererNumReservation()+1);
		 	
		 		
		 		int id3;
	 			 nomCat3=(String)viewRes.pan4.comboBox.getSelectedItem();
		 		id3=cnx.chercherIdCategorie(nomCat3);
		 		detailReservation3.setM_Categorie(id3);
		 		detailReservation3.setNbrAdultes(Integer.parseInt(viewRes.pan4.lblNewLabel_3.getText()));
		 		detailReservation3.setNbrEnfants(Integer.parseInt(viewRes.pan4.lblNewLabel_4.getText()));
		 //		detailReservation3.setM_Reservation(cnx.recupererNumReservation()+1);
		 		
		 		if(id1==id2 && id2==id3)
		 		{
		 			t1=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation1.getM_Categorie(),3);
		 			t2=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation2.getM_Categorie(),3);
		 			t3=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation3.getM_Categorie(),3);
		 			
		 		}
		 		else if(id1==id2 && id2!=id3)
		 		{
		 			t1=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation1.getM_Categorie(),2);
		 			t2=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation2.getM_Categorie(),2);
		 			t3=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation3.getM_Categorie(),1);
		 		}
		 		else if(id3==id2 && id2!=id1)
		 		{
		 			t1=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation1.getM_Categorie(),1);
		 			t2=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation2.getM_Categorie(),2);
		 			t3=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation3.getM_Categorie(),2);
		 		}
		 		else if(id3==id1 && id2!=id3)
		 		{
		 			t1=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation1.getM_Categorie(),2);
		 			t2=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation2.getM_Categorie(),1);
		 			t3=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation3.getM_Categorie(),2);
		 		}
		 		else 
		 		{
		 			t1=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation1.getM_Categorie(),1);
		 			t2=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation2.getM_Categorie(),1);
		 			t3=cnx.verifierDisponibilite(reservation.getDateDebut(),detailReservation3.getM_Categorie(),1);
		 		}
		 		if(t1==1 && t2==1 && t3==1) {
		 			viewRes.panel_3.setVisible(true);
			 		viewRes.btnNewButton_1.setVisible(true);
		 		}
		 		else {
		 			JOptionPane.showMessageDialog(null, "votre demande n'est pas disponible dans la periode souhaite");
		 			}
	 		}
		 		
	 	}
	 });
	
}
private void initialiserModel() {

	client.setNom(viewRes.getTextField().getText());
	client.setPrenom(viewRes.getTextField_1().getText());
	client.setCin(viewRes.getTextField_4().getText());
	client.setNumTel(viewRes.getText().getText());
	
	
	
	Date date1 = viewRes.getDe().getDate();
	Date date2 = viewRes.getDs().getDate();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String formattedDate1 = sdf.format(date1);
	String formattedDate2 = sdf.format(date2);
	
//	System.out.println(cnx.recupererNumReservation());
	detailReservation1.setM_Reservation(cnx.recupererNumReservation()+1);
	detailReservation2.setM_Reservation(cnx.recupererNumReservation()+1);
	detailReservation3.setM_Reservation(cnx.recupererNumReservation()+1);
	int j= viewRes.i+1;
	
	reservation.setDateDebut(formattedDate1);
	reservation.setDateFin(formattedDate2);
	reservation.setNbrChambres(j);
	reservation.setM_Client(viewRes.getTextField_4().getText());
}
	private void EnregisterInfos () {
		initialiserModel();
	cnx.insertClient(client);//System.out.println("bon");
	cnx.insertReservation(reservation);
	if(viewRes.i==0)
		cnx.insertDetailReservation(detailReservation1);
	if(viewRes.i==1)
	{	cnx.insertDetailReservation(detailReservation1);
		cnx.insertDetailReservation(detailReservation2);
	}
	if(viewRes.i==2)
	{	cnx.insertDetailReservation(detailReservation1);
		cnx.insertDetailReservation(detailReservation2);
		cnx.insertDetailReservation(detailReservation3);
	}
	String s1=cnx.recupererNumReservation()+"";
	String s2=cnx.calculerPrixTotal(cnx.recupererNumReservation());
	viewRes.textField_2.setText(s2);
	viewRes.textField_2.setEditable(false);
	viewRes.textField_3.setText(s1);
	viewRes.textField_3.setEditable(false);
	viewRes.textField_2.setVisible(true);
	viewRes.textField_3.setVisible(true);
	viewRes.lblNewLabel_5.setVisible(true);
	viewRes.lblNewLabel_6.setVisible(true);
	
//vider tous les champs	
	
//	viewRes.getDs().setCalendar(null);
//	viewRes.getDe().setCalendar(null);
//	
//	viewRes.getTextField().setText("");
//	viewRes.getTextField_1().setText("");
//	viewRes.getTextField_4().setText("");
//	viewRes.getText().setText("");
//	
//	viewRes.pan2.setVisible(false);
//	viewRes.pan3.setVisible(false);
//	viewRes.pan4.setVisible(false);
//	viewRes.btnNewButton_2.setVisible(false);
//	viewRes.btnNewButton_3.setVisible(false);
//	viewRes.panel_3.setVisible(false);
	
	
	
	
}
	
	
}
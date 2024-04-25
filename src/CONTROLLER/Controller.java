 package CONTROLLER;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import CONFIGURATION.Connexion;
import CONFIGURATION.Divers;
import MODEL.ModelCheque;
import MODEL.ModelFacture;
import VIEW.ViewChercher;

public class Controller{
	ModelFacture modelF;
	ModelCheque modelC;
	ViewChercher view;
	Connexion cn=new Connexion();

	public Controller (ModelFacture m,ModelCheque c ,ViewChercher v) { 
		modelF= m;
		modelC=c;
		view = v;
}

	
	public void initController()  {
		view.getBtnNewButton_1().setVisible(false);
		view.getBtnNewButton_2().setVisible(false);
		view.getTextField().requestFocus();
		
		 
		
		
	view.getBtnNewButton().addActionListener(new ActionListener() { public void actionPerformed (ActionEvent evt){
	//EnregisterInfos();
	try {
		fct();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
		}});
	
	view.getLblNewLabel_3_1().addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent e) {

		fctlabel(); }});
	
	
	view.getTextField_1().addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent e) {
		  view.getTextField_1().setBorder(BorderFactory.createLineBorder(Color.BLACK));
	 }});
	
	view.getTextField().addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent e) {
		  view.getTextField().setBorder(BorderFactory.createLineBorder(Color.BLACK));
	 }});

	view.getTextField().addKeyListener(new KeyAdapter()
			{public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					try {
						fct();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}});
			
	
	view.getTextField_5().addKeyListener(new KeyAdapter()
	{public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
			try {
				fct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}});
	
	
	
	
	view.getBtnNewButton_1().addActionListener(e ->{
		try {
			EnregisterInfos();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}} );
	view.getComboBox().addActionListener(e ->fctComboBox());
	view.getBtnNewButton_2().addActionListener(e ->imprimer());
	
	view.getTextField_5().addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent e) {
		view.getTextField_5().setBorder(BorderFactory.createLineBorder(Color.BLACK));
	 }});
	connecter();

	}

	
	
	
	private void imprimer() {
		String titre="Facture";
		Divers.imprimerJtable(view.getTable(),titre);
		
	}


	public void fctComboBox() {
		
		  
	      modelF.setTypePayement((String) view.getComboBox().getSelectedItem());
	
		if(view.getComboBox().getSelectedItem()=="Chéque")
					{view.getPanel_1().setVisible(true);
					modelC.setMontant(Double.parseDouble(view.getTextField_2().getText()));
					view.getTextField_1().requestFocus();
					view.getTextField_2().setEditable(false);
			
					}
		if(view.getComboBox().getSelectedItem()=="Carte Bancaire")
					view.getPanel_1().setVisible(false);

		if(view.getComboBox().getSelectedItem()=="Liquide")
					view.getPanel_1().setVisible(false);
	
	}
	public void fctlabel() { 
	view.getLblCin().setVisible(true); 
	view.getTextField_5().setVisible(true);
	view.getLblNewLabel().setVisible(false);
	view.getTextField().setVisible(false);
	view.getLblNewLabel_3_1().setVisible(false);

	view.getTextField_5().requestFocusInWindow();
	
	}
	

	

	public void  deconnecter() {
		cn.disconnect();

	}

	public void connecter() {
		
		try {
			cn.connect();
		   } 
		catch (SQLException excpt) {
		
			System.out.println(excpt.getMessage());}
	
	}
	
	
public void fct() throws SQLException  {


 view.getTable().removeAll();

 
 

ResultSet rtrn=null;
if(view.getTextField().isVisible()==true) {
	
	if(view.getTextField().getText().isEmpty())
	{
		 view.getBtnNewButton_1().setVisible(false);
		 view.getBtnNewButton_2().setVisible(false);
		view.getTextField().requestFocusInWindow();
	    view.getTextField().selectAll();
	     view.getPanel().setVisible(false);
	     view.getPanel_1().setVisible(false);
		  view.panel_2.setVisible(false);
	     view.getTextField().setBorder(BorderFactory.createLineBorder(Color.RED));
		JOptionPane.showMessageDialog(null,"LE CHAMP EST VIDE","Erreur",JOptionPane.WARNING_MESSAGE);
	
		}
	else {		
  try {Integer.parseInt(view.getTextField().getText());}
   catch(Exception e) {
	 
	
	view.getTextField().requestFocusInWindow();
	view.getTextField().selectAll();
	
    view.getPanel().setVisible(false);
    view.getPanel_1().setVisible(false);
	  view.panel_2.setVisible(false);
	  view.getBtnNewButton_1().setVisible(false);
	  view.getBtnNewButton_2().setVisible(false);
	 //  System.out.println("Something went wrong.");
	JOptionPane.showMessageDialog(null,"INSERER UN ENTIER","Erreur",JOptionPane.WARNING_MESSAGE);
	
	                   }



 int a=Integer.parseInt(view.getTextField().getText());
 modelF.setNumReservation(a);
 view.num.setText(""+modelF.getNumReservation());
       rtrn=cn.getAllData(a); 
  	 ArrayList<String> R=cn.tabnum(modelF.getNumReservation());
  	 view.c.setText(R.get(0));
  	 view.n.setText(R.get(1));
  	 view.tele.setText(R.get(2));
       view.getPanel().setVisible(true);
 	  view.panel_2.setVisible(true);
       fctcalcule(rtrn);
       
                                          }}
else {

 if(view.getTextField_5().isVisible()==true) {
	if(view.getTextField_5().getText().isEmpty())
	{JOptionPane.showMessageDialog(null,"LE CHAMP EST VIDE","Erreur",JOptionPane.WARNING_MESSAGE);
	   //view.getTextField_5().setBackground(new Color(239, 122, 116));
	
	
view.getTextField_5().setBorder(BorderFactory.createLineBorder(Color.RED));

	view.getTextField_5().requestFocus();
	}
   else {
	String b;

	 b=view.getTextField_5().getText();
	
	modelF.setNumReservation(cn.estNum(b));
	view.num.setText(""+modelF.getNumReservation());
	 ArrayList<String> A=cn.tabnum(modelF.getNumReservation());
	 view.c.setText(A.get(0));
	 view.n.setText(A.get(1));
	 view.tele.setText(A.get(2));
	 
	 

	 rtrn=cn.getAllData1(b);
	 view.getPanel().setVisible(true);
	  view.panel_2.setVisible(true);
     fctcalcule(rtrn);}                        }
	
}
	
}


public void fctcalcule(ResultSet rtrn) {
	
		
	ResultSetMetaData rsmd;
  try { 
	 
	
	//pour afficher les colonnes
	  view.panel_2.setVisible(true);
	 view.getPanel().setVisible(true);
	 view.getBtnNewButton_1().setVisible(true);
	 view.getBtnNewButton_2().setVisible(true);
	 view.getTextField_3().setEditable(false);
	 view.getTextField_4().setEditable(false);
	 ArrayList<Double> liste=new ArrayList<Double>();
	 rsmd = (ResultSetMetaData) rtrn.getMetaData();
     DefaultTableModel m=(DefaultTableModel) view.getTable().getModel();
     m.setRowCount(0);
     int cols=rsmd.getColumnCount();
     String[] colName=new String[cols];
     
     
   for(int i=0;i<cols;i++)
      colName[i]=rsmd.getColumnName(i+1);
      m.setColumnIdentifiers(colName);
      String nom,prixC,nbNuitee,nbenfant,nbadulte,prx;
      double s=0;
      double r=0;
     
    
    /* view.getPanel().setVisible(false);
	  JOptionPane.showMessageDialog(null,"Pas De Reservation Avec Ce Numéro","OPS",JOptionPane.INFORMATION_MESSAGE);
	  view.getTextField_5().requestFocus();
	  view.getTextField().requestFocus();
	  view.getTextField().selectAll();
	  view.getTextField_5().selectAll();*/
 //   else {
  
  while(rtrn.next()) {
     nom=rtrn.getString(1);	
    prixC=rtrn.getString(2);

    nbNuitee=rtrn.getString(3);	
   if(Integer.parseInt(nbNuitee)>=3)
	r=Double.parseDouble(prixC)*(2+(Integer.parseInt(nbNuitee)-2)*0.95);
   else
	r=Integer.parseInt(nbNuitee)*Double.parseDouble(prixC);

    nbenfant=rtrn.getString(4);
    nbadulte=rtrn.getString(5);
    prx=rtrn.getString(6);
    if(Integer.parseInt(nbenfant)==2)

		r=r*(0.5+Integer.parseInt(nbadulte));
   else
	r=r*Integer.parseInt(nbadulte);
   // System.out.print("   "+r);


	liste.add(r);
	r=0;

	
   s=s+Double.parseDouble(prx);
   String[] row={ nom,prixC,nbNuitee,nbenfant,nbadulte,prx};
   m.addRow(row);
   view.getTable().setFocusable(true);
                             }
   double d=0;
   for(int i=0;i<liste.size();i++) {
	//System.out.print("   "+liste.get(i));
    	d=d+liste.get(i);}
	
       view.getTextField_4().setText(""+d);
   //    System.out.println(s);
       view.getTextField_3().setText(""+s);
       view.getTextField_2().setText(""+d);
       modelF.setPrixTotal(Double.parseDouble(view.getTextField_4().getText()));
 if(m.getRowCount()==0)
 { view.getPanel().setVisible(false);
view.getPanel_1().setVisible(false);
view.panel_2.setVisible(false);
 view.getBtnNewButton_1().setVisible(false);
 view.getBtnNewButton_2().setVisible(false);
	view.getTextField().requestFocusInWindow();
    view.getTextField().selectAll();
 JOptionPane.showMessageDialog(null,"Pas De Reservation A Payer Avec Ce Numéro","OPS",JOptionPane.INFORMATION_MESSAGE);}
    
 
   } catch(SQLException e) {
	// TODO Auto-generated catch block
	e.getMessage();}  } // }

	public void EnregisterInfos () throws SQLException {
		if(!view.getPanel_1().isVisible()) {
			JOptionPane.showMessageDialog(null, view.getComboBox().getSelectedItem(), "ERREUR", JOptionPane.WARNING_MESSAGE);
			  modelF.setTypePayement(view.getComboBox().getSelectedItem().toString());
			  
		// if(view.getComboBox().getSelectedItem()!="Chéque" && view.getComboBox().getSelectedItem()!="Carte Bancaire" && view.getComboBox().getSelectedItem()!="Liquide")
//			if(view.getComboBox().getSelectedItem()==null)
//			{JOptionPane.showMessageDialog(null, "Inserer toutes les champs", "ERREUR", JOptionPane.WARNING_MESSAGE);
//			view.getComboBox().setBackground(new Color(239, 122, 116));
//			
//			}
//		else {
		cn.inserer("Facture",modelF);
	 	cn.chambredispo("chambre",modelF);
		cn.reserPayer("reservation",modelF);}
		     
		         
		
		{
			
			
			
		System.out.println(""+modelC.getNumCheque());
			if(view.getTextField_1().getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Inserer toutes les champs", "ERREUR", JOptionPane.WARNING_MESSAGE);
				
				 view.getTextField_1().setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			else 
			{modelC.setNumCheque(Integer.parseInt(view.getTextField_1().getText()));
			modelF.setNumCheque(Integer.parseInt(view.getTextField_1().getText()));
				 try {Integer.parseInt(view.getTextField_1().getText());}
				 catch(Exception e) 
				 {
			     JOptionPane.showMessageDialog(null, "Inserer un entier", "ERREUR", JOptionPane.WARNING_MESSAGE);
			     
				 view.getTextField_1().requestFocus();
				 view.getTextField_1().selectAll();
				 }
				 
			     cn.inserer("cheque",modelC);
			 	cn.inserer("Facture",modelF);
			 	cn.reserPayer("reservation",modelF);
			 	cn.chambredispo("chambre",modelF);
			
		         
		
		    }	
		}
	
	
		
		}

	private void fermer() {
		System.exit(0);
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

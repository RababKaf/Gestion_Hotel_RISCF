package CONTROLLER;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JScrollPane;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import CONFIGURATION.Connexion;
import MODEL.Categories;
import MODEL.Chambres;
import MODEL.Clients;
import MODEL.DetailsReservations;
import MODEL.Reservations;
import VIEW.CelRendrer;
import VIEW.ChambreVacante;


import VIEW.ConsulterView2;
import VIEW.CreerPanel;
import VIEW.Panel2;
import VIEW.RecapReservation;


public class ControllerS {

	//private ConsulterView2 consulterView;
		private Chambres chambre;
		private Clients client;
		private Connexion connexion;
		private Reservations reservation;
		private DetailsReservations detailReservation;
		private Categories categorie;
	    private int i=0;
	    private Panel2 panel2;
	    private ArrayList num=new ArrayList();
		
		
		public ControllerS(ConsulterView2 consulterView) {

			
			connexion=new Connexion();
			//connexion.connect();
			
			//consulterView=new ConsulterView2();
			
			
			chambre=new Chambres();
			//reservationview=new ReservationView(scrollPane);
			
			//consulter.getBtnAnnuler().addActionListener(new ActionListener() {
			consulterView.getPanelConsulter().getPanel1().getBtnAnnuler().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					consulterView.getPanelConsulter().getPanel1().getCode().setText("-");
					consulterView.getPanelConsulter().getPanel1().getCode().requestFocus();
					consulterView.getPanelConsulter().getPanel1().getCode().selectAll();
					consulterView.getPanelConsulter().getPanel1().getBtnAnnuler().setRequestFocusEnabled(true);
					
					consulterView.getPanelConsulter().getPanel().getPanel_1().getNom().setText(" ");
					 consulterView.getPanelConsulter().getPanel().getPanel_1().getPrenom().setText(" ");
					 consulterView.getPanelConsulter().getPanel().getPanel_1().getTelephone().setText(" ");
					 consulterView.getPanelConsulter().getPanel().getPanel_1().getDateDebut().setText(" ");
					 consulterView.getPanelConsulter().getPanel().getPanel_1().getDateFin().setText(" ");
					consulterView.getPanelConsulter().getPanel().remove(panel2);
					consulterView.getPanelConsulter().getPanel().setVisible(false);
					i=0;
				}
			});
			
			consulterView.getPanelConsulter().getPanel1().getBtnRechercher().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					i=0;
					//consulterView.getPanelConsulter().getPanel().getPanel2().removeAll()
					panel2=new Panel2();
				   
					consulterView.getPanelConsulter().getPanel().setVisible(false);
					
					consulterView.getPanelConsulter().revalidate();
					consulterView.getPanelConsulter().repaint();
					try {
						
				
					
						//recuperer les infos sur le client
						int code=Integer.parseInt(consulterView.getPanelConsulter().getPanel1().getCode().getText());
						
						 ResultSet resultat0= connexion.chercher1(code);
						//SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
						if(resultat0.next()) {
							client=new Clients(" "+resultat0.getString(1)," "+resultat0.getString(2)," "+resultat0.getString(3));
							try {
								reservation=new Reservations(code,resultat0.getString(4),resultat0.getString(5),resultat0.getString(6),Integer.parseInt(resultat0.getString(7)));
							} catch (Exception e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}

							
						
						
						 consulterView.getPanelConsulter().getPanel().getPanel_1().getNom().setText(client.getNom());
						 consulterView.getPanelConsulter().getPanel().getPanel_1().getPrenom().setText(client.getPrenom());
						 consulterView.getPanelConsulter().getPanel().getPanel_1().getTelephone().setText(client.getTelephone());
						 consulterView.getPanelConsulter().getPanel().getPanel_1().getDateDebut().setText(" "+reservation.getDateDebut());
						 consulterView.getPanelConsulter().getPanel().getPanel_1().getDateFin().setText(" "+reservation.getDateFin());
						 consulterView.getPanelConsulter().getPanel().getPanel_1().getEtatReservation().setText(reservation.getEtat());
						 
						 if(reservation.getEtat().equals("annuler")) {
							 consulterView.getPanelConsulter().getPanel().getPanel_1().getEtatReservation().setForeground(Color.RED);
						 }
						 
						 consulterView.getPanelConsulter().getPanel().setVisible(true);
						//recuperer les infos sur les chambres
						
						ResultSet resultat1= connexion.chercher2(code);
						
						
						
						
						
						 while(resultat1.next()) {
							 
							 //System.out.println("ufhiushghiugh");
							
//							 if(resultat1.getString(3).equals("suite")) 
								 categorie=new Categories(Integer.parseInt(resultat1.getString(4)),resultat1.getString(3));
								num.add(Integer.parseInt(resultat1.getString(4)));
							    
//							 if(resultat1.getString(3).equals("double"))
//								 categorie=new Categories(2,resultat1.getString(3));
//							 if(resultat1.getString(3).equals("simple"))
//								 categorie=new Categories(3,resultat1.getString(3));
							 
							 
						     detailReservation=new DetailsReservations(Integer.parseInt(resultat1.getString(1)),Integer.parseInt(resultat1.getString(2)),categorie,reservation);
						     
					
						     i++;
						 	
						     if(i==1) {
						    	 
						    	 panel2.getCreerPanel1().setVisible(true);
						    	 panel2.iniCreerPanel1(categorie, detailReservation);
						    	 
						    	// System.out.println("creer "+i);
						     }
						     if(i==2) {
						    	 panel2.getCreerPanel2().setVisible(true);
						    	 panel2.iniCreerPanel2(categorie, detailReservation);
						    	 
						    	// System.out.println("creer "+i);
						     }
						     if(i==3) {
						    	 panel2.getCreerPanel3().setVisible(true);
						    	 panel2.iniCreerPanel3(categorie, detailReservation);
						    	 
						    	// System.out.println("creer "+i);
						     }
						     if(i==4) {
						    	 panel2.getCreerPanel4().setVisible(true);
						    	 panel2.iniCreerPanel4(categorie, detailReservation);
						    	 
						    	// System.out.println("creer "+i);
						     }
						      

						   
						     
						    
						 }
						 panel2.setBounds(10, 160, 622, 303);
						 consulterView.getPanelConsulter().getPanel().add(panel2);
						 
						 consulterView.getPanelConsulter().getPanel().getPanel_2().getBtnModifier().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								// TODO Auto-generated method stub
								ResultSet resultat=connexion.testModifier(code);
								
								try {
									if(resultat.next()) {
//									resultat = connexion.testModifier(code).getString(1);
									if(Integer.parseInt(resultat.getString(1))>1) {
										modifier(i,consulterView);
									}
									else {
										JOptionPane.showMessageDialog(null, "Vous pouvez pas modifier cette reservation ");
									}
								}
								}
									catch (SQLException e1) {
									// TODO Auto-generated catch block
									System.out.println("action modifiier erreur "+e1.getMessage());
								}
							}
						});	
						 //i--;
						 System.out.println("mois"+i);
								panel2.getCreerPanel1().getBtnMoins().addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										
										
										switch(i) {
										case 1:{
											panel2.getCreerPanel1().getNbrAdultes().setText(" ");
											panel2.getCreerPanel1().getNbrEnfants().setText(" ");
											panel2.getCreerPanel1().getCategorietext().setToolTipText(" ");
											panel2.getCreerPanel1().setVisible(false);
											panel2.getCreerPanel2().setBounds(10,11,602,59);
											panel2.add(panel2.getCreerPanel2());
											panel2.getCreerPanel3().setBounds(10,81,602,59);
											panel2.add(panel2.getCreerPanel3());
											panel2.getCreerPanel4().setBounds(10,151,602,59);
											panel2.add(panel2.getCreerPanel4());
											i--;
											//System.out.println("mois 1"+i);
										};break;
										
										case 2:{
											panel2.getCreerPanel1().getNbrAdultes().setText(" ");
											panel2.getCreerPanel1().getNbrEnfants().setText(" ");
											panel2.getCreerPanel1().getCategorietext().setToolTipText(" ");
											panel2.getCreerPanel1().setVisible(false);
											panel2.getCreerPanel2().setBounds(10,11,602,59);
											panel2.add(panel2.getCreerPanel2());
											panel2.getCreerPanel3().setBounds(10,81,602,59);
											panel2.add(panel2.getCreerPanel3());
											panel2.getCreerPanel4().setBounds(10,151,602,59);
											panel2.add(panel2.getCreerPanel4());
											i--;
											//System.out.println("mois 1"+i);
										};break;
										case 3:{
											panel2.getCreerPanel1().getNbrAdultes().setText(" ");
											panel2.getCreerPanel1().getNbrEnfants().setText(" ");
											panel2.getCreerPanel1().getCategorietext().setToolTipText(" ");
											panel2.getCreerPanel1().setVisible(false);
											panel2.getCreerPanel2().setBounds(10,11,602,59);
											panel2.add(panel2.getCreerPanel2());
											panel2.getCreerPanel3().setBounds(10,81,602,59);
											panel2.add(panel2.getCreerPanel3());
											panel2.getCreerPanel4().setBounds(10,151,602,59);
											panel2.add(panel2.getCreerPanel4());
											i--;
											//System.out.println("mois 1"+i);
										};break;
										case 4:{
											panel2.getCreerPanel1().getNbrAdultes().setText(" ");
											panel2.getCreerPanel1().getNbrEnfants().setText(" ");
											panel2.getCreerPanel1().getCategorietext().setToolTipText(" ");
											panel2.getCreerPanel1().setVisible(false);
											panel2.getCreerPanel2().setBounds(10,11,602,59);
											panel2.add(panel2.getCreerPanel2());
											panel2.getCreerPanel3().setBounds(10,81,602,59);
											panel2.add(panel2.getCreerPanel3());
											panel2.getCreerPanel4().setBounds(10,151,602,59);
											panel2.add(panel2.getCreerPanel4());
											i--;
											//System.out.println("mois 1"+i);
										};break;
										}
									}
								});
								
	                panel2.getCreerPanel2().getBtnMoins().addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										
										//System.out.println("mois"+i);
										switch(i) {
										case 2:{
											panel2.getCreerPanel2().getNbrAdultes().setText(" ");
											panel2.getCreerPanel2().getNbrEnfants().setText(" ");
											panel2.getCreerPanel2().getCategorietext().setToolTipText(" ");
											panel2.getCreerPanel2().setVisible(false);
											panel2.getCreerPanel3().setBounds(10,81,602,59);
											panel2.add(panel2.getCreerPanel3());
											panel2.getCreerPanel4().setBounds(10,151,602,59);
											panel2.add(panel2.getCreerPanel4());
											i--;
											//System.out.println("mois 2"+i);
										};break;
										
										case 3:{
											panel2.getCreerPanel2().getNbrAdultes().setText(" ");
											panel2.getCreerPanel2().getNbrEnfants().setText(" ");
											panel2.getCreerPanel2().getCategorietext().setToolTipText(" ");
											panel2.getCreerPanel2().setVisible(false);
											panel2.getCreerPanel3().setBounds(10,81,602,59);
											panel2.add(panel2.getCreerPanel3());
											panel2.getCreerPanel4().setBounds(10,151,602,59);
											panel2.add(panel2.getCreerPanel4());
											i--;
											//System.out.println("mois 2"+i);
										};break;
										case 4:{
											panel2.getCreerPanel2().getNbrAdultes().setText(" ");
											panel2.getCreerPanel2().getNbrEnfants().setText(" ");
											panel2.getCreerPanel2().getCategorietext().setToolTipText(" ");
											panel2.getCreerPanel2().setVisible(false);
											panel2.getCreerPanel3().setBounds(10,81,602,59);
											panel2.add(panel2.getCreerPanel3());
											panel2.getCreerPanel4().setBounds(10,151,602,59);
											panel2.add(panel2.getCreerPanel4());
											i--;
											//System.out.println("mois 2"+i);
										};break;
										
										}
									}
								});
								
							
	                
	                panel2.getCreerPanel3().getBtnMoins().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							//i--;
							//System.out.println("mois"+i);
							switch(i) {
							case 3:{
								panel2.getCreerPanel3().getNbrAdultes().setText(" ");
								panel2.getCreerPanel3().getNbrEnfants().setText(" ");
								panel2.getCreerPanel3().getCategorietext().setToolTipText(" ");
								panel2.getCreerPanel3().setVisible(false);
								panel2.getCreerPanel4().setBounds(10,151,602,59);
								panel2.add(panel2.getCreerPanel4());
								i--;
								//System.out.println("mois 3"+i);
							};break;
							
							case 4:{
								panel2.getCreerPanel3().getNbrAdultes().setText(" ");
								panel2.getCreerPanel3().getNbrEnfants().setText(" ");
								panel2.getCreerPanel3().getCategorietext().setToolTipText(" ");
								panel2.getCreerPanel3().setVisible(false);
								panel2.getCreerPanel4().setBounds(10,151,602,59);
								panel2.add(panel2.getCreerPanel4());
								i
								--;
								//System.out.println("mois 3"+i);
							};break;
							
							
							}
						}
					});
	                
	          panel2.getCreerPanel4().getBtnMoins().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							//i--;
							//System.out.println("mois"+i);
							switch(i) {
							case 4:{
								panel2.getCreerPanel4().getNbrAdultes().setText(" ");
								panel2.getCreerPanel4().getNbrEnfants().setText(" ");
								panel2.getCreerPanel4().getCategorietext().setToolTipText(" ");
								panel2.getCreerPanel4().setVisible(false);
								i--;
								//System.out.println("mois 4"+i);
							};break;
							
							
							
							
							}
						}
					});
							
	          //i--;
	          panel2.getBtnAjouterChambres().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					//System.out.println("avant + "+i);
					switch(i) {
					case 0:{
						panel2.getCreerPanel1().setBounds(10, 11, 602, 59);
						panel2.getCreerPanel1().setVisible(true);
						panel2.add(panel2.getCreerPanel1());
						
						panel2.getCreerPanel1().getNbrAdultes().setEditable(true);
						panel2.getCreerPanel1().getNbrEnfants().setEditable(true);
						panel2.getCreerPanel1().getCategorietext().setEditable(true);
						panel2.getCreerPanel1().getBtnMoins().setVisible(true);
						i++;
					}
					case 1:{
						panel2.getCreerPanel1().setBounds(10, 11, 602, 59);
						panel2.getCreerPanel1().setVisible(true);
						panel2.getCreerPanel2().setBounds(10,81,602,59);
						panel2.getCreerPanel2().setVisible(true);
						panel2.add(panel2.getCreerPanel2());
						
						panel2.getCreerPanel2().getNbrAdultes().setEditable(true);
						panel2.getCreerPanel2().getNbrEnfants().setEditable(true);
						panel2.getCreerPanel2().getCategorietext().setEditable(true);
						panel2.getCreerPanel2().getBtnMoins().setVisible(true);
						i++;
						//System.out.println("mois"+i);
					};break;
					case 2:{
						panel2.getCreerPanel1().setBounds(10, 11, 602, 59);
						panel2.getCreerPanel1().setVisible(true);
						panel2.getCreerPanel2().setBounds(10,81,602,59);
						panel2.getCreerPanel2().setVisible(true);
						panel2.getCreerPanel3().setBounds(10,151,602, 59);
						panel2.getCreerPanel3().setVisible(true);
						panel2.add(panel2.getCreerPanel3());
						
						panel2.getCreerPanel3().getNbrAdultes().setEditable(true);
						panel2.getCreerPanel3().getNbrEnfants().setEditable(true);
						panel2.getCreerPanel3().getCategorietext().setEditable(true);
						panel2.getCreerPanel3().getBtnMoins().setVisible(true);
						i++;
						//System.out.println("mois"+i);
					};break;
					case 3:{
						panel2.getCreerPanel1().setBounds(10, 11, 602, 59);
						panel2.getCreerPanel1().setVisible(true);
						panel2.getCreerPanel2().setBounds(10,81,602,59);
						panel2.getCreerPanel2().setVisible(true);
						panel2.getCreerPanel3().setBounds(10,151,602, 59);
						panel2.getCreerPanel3().setVisible(true);
						panel2.getCreerPanel4().setBounds(10,221, 602, 59);
						panel2.getCreerPanel4().setVisible(true);
						panel2.add(panel2.getCreerPanel4());
						
						panel2.getCreerPanel4().getNbrAdultes().setEditable(true);
						panel2.getCreerPanel4().getNbrEnfants().setEditable(true);
						panel2.getCreerPanel4().getCategorietext().setEditable(true);
						panel2.getCreerPanel4().getBtnMoins().setVisible(true);
						i++;
						//System.out.println("mois"+i);
					};break;
					}
				}
			});
						
						 panel2.getBtnConfirmer().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								// TODO Auto-generated method stub
								//System.out.println("sss");
								modifierReservation(i,code,consulterView);
							}
						});
						 
						 consulterView.getPanelConsulter().getPanel().getPanel_2().getBtnConfirmer().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								if(reservation.getEtat().equals("annuler") || reservation.getEtat().equals("payer"))
									JOptionPane.showMessageDialog(null, "Reservation "+ reservation.getEtat()+" vous pouvez pas la confirmer .");
								else {
								ResultSet resultat=connexion.getData();
								ChambreVacante chambreVacante=new ChambreVacante();
								//consulterView.dispose();
								
								try {
									while(resultat.next()) {
										String[] row= {resultat.getString(1),resultat.getString(2),resultat.getString(3),resultat.getString(4)};
										chambreVacante.getModel().addRow(row);
										
										chambreVacante.getTable().getColumnModel().getColumn(4).setCellRenderer(new CelRendrer());
									}
									
									//pour stocker les info sur les chambres reserve
									// ArrayList<ArrayList> listeChambreReserv=new ArrayList<ArrayList>();
									 RecapReservation recap=new RecapReservation();
									 recap.setVisible(false);
									chambreVacante.getTable().addMouseListener(new MouseAdapter() {
										
										public void mouseClicked(MouseEvent e) {
											int row=chambreVacante.getTable().getSelectedRow();
											
											//ArrayList<String> listeChambre=new ArrayList<String>();
											
											DefaultTableModel model=(DefaultTableModel) chambreVacante.getTable().getModel();
											
//											int numChambre=Integer.parseInt((String) model.getValueAt(row, 0));
//											int etage=Integer.parseInt((String) model.getValueAt(row, 1));
											String numChambre=(String) model.getValueAt(row, 0);
											String etage=(String) model.getValueAt(row, 1);
											String categorie=(String) model.getValueAt(row, 3);
											
											
											String[] row2= {numChambre,etage,categorie};
											recap.getModel().addRow(row2);
//												 listeChambre.add(" "+numChambre);
//												 listeChambre.add(" "+etage);
//												 listeChambre.add(categorie);
//												 
//												 listeChambreReserv.add(listeChambre);
										
											
										}
									});
	                              chambreVacante.getBtnAnnuler().addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub
											chambreVacante.dispose();
										}
									})		;
	                             chambreVacante.addWindowListener(
	                            		  new WindowAdapter() { 
	                            		  public void windowClosing( 
	                            		  WindowEvent e) {
	                            			  JOptionPane.showMessageDialog(null, "ssssss");
	                            		chambreVacante.dispose();
	                            		  } 
	                            		  } 
	                            		  );
	                              
										chambreVacante.getBtnConfirmer().addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												
												chambreVacante.dispose();
												recap.setVisible(true);
												
													recap.getBtnConfirmer().addActionListener(new ActionListener() {
														
														@Override
														public void actionPerformed(ActionEvent e) {
															// TODO Auto-generated method stub
															int rep=JOptionPane.showConfirmDialog(null, "voulez-vous reserves les chambres selectionnées ?");
															if(rep==JOptionPane.YES_OPTION ) 
															{
																for(int i=0;i<recap.getTable().getRowCount();i++) 
																{
																	int numch=Integer.parseInt((String) recap.getModel().getValueAt(i, 0));
																    connexion.changeStat(code,numch);
																}
																JOptionPane.showMessageDialog(null, "Chambres bien reserves");
																//System.exit(0);
																recap.dispose(); 
																
														    }
														                                            }});
													recap.addWindowListener(
															new WindowAdapter() { 
															public void windowClosing( 
															WindowEvent e) {
															recap.dispose(); 
															} 
															} 
															);
													
												recap.getBtnAnnuler().addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														recap.dispose();
													}
												})	;
												
											
									
							 				
								     }});
										
									
									
									
								} 
								catch (SQLException e1) {
									// TODO Auto-generated catch block
									//e1.printStackTrace();
								}
							}
							}
						});
						 
						 
						 consulterView.getPanelConsulter().getPanel().getPanel_2().getBtnAnnuler().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								if(reservation.getEtat().equals("payer") || reservation.getEtat().equals("confirmer"))
									JOptionPane.showMessageDialog(null, "Reservation "+reservation.getEtat()+"vous pouvez pas l'annuler !");
								else {
									if(reservation.getEtat().equals("annuler"))
										JOptionPane.showMessageDialog(null, "Reservation déja annuler !");
								else {
								// TODO Auto-generated method stub
								//consulterView.dispose();
								int j=JOptionPane.showConfirmDialog(null, "voulez-vouz vraiment annuler la reservation?");
								if(j== JOptionPane.YES_OPTION) {
									int code=Integer.parseInt(consulterView.getPanelConsulter().getPanel1().getCode().getText());
									connexion.annulerReservation(code);
									JOptionPane.showMessageDialog(null, "La reservation est annuler");
								}
								else {
									
								}
								}
								}		
							}
								
						});
						}
						
						else {
							consulterView.getPanelConsulter().getPanel1().getCode().setBorder(BorderFactory.createLineBorder(Color.RED));
							JOptionPane.showMessageDialog(null, "Aucune reservation n'est enregistrer avec ce numero");
							consulterView.getPanelConsulter().getPanel1().getCode().setText(" ");
							consulterView.getPanelConsulter().getPanel1().getCode().requestFocus();
							consulterView.getPanelConsulter().getPanel1().getCode().selectAll();
							//consulterView.getPanelConsulter().getPanel().getPanel_1().getCode().setText(" ");	
							}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//JOptionPane.showMessageDialog(null, "consulter erreur  "+e1.getMessage());
					}
					
		     
					
				}
			});
			
		}
		
		public void modifier(int i,ConsulterView2 consulterView) {
			//i++;
			String etat=consulterView.getPanelConsulter().getPanel().getPanel_1().getEtatReservation().getText();
			if( !etat.equals("annuler") && !etat.equals("payer")) {
			
			panel2.getBtnAjouterChambres().setVisible(true);
			panel2.getBtnConfirmer().setVisible(true);
			consulterView.getPanelConsulter().getPanel().getPanel_1().getNom().setEditable(true);
			consulterView.getPanelConsulter().getPanel().getPanel_1().getPrenom().setEditable(true);
			consulterView.getPanelConsulter().getPanel().getPanel_1().getTelephone().setEditable(true);
			consulterView.getPanelConsulter().getPanel().getPanel_1().getDateDebut().setEditable(true);
			consulterView.getPanelConsulter().getPanel().getPanel_1().getDateFin().setEditable(true);
			
			switch(i) {
			case 1:{
				panel2.getCreerPanel1().getBtnMoins().setVisible(true);
				panel2.getCreerPanel1().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel1().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel1().getCategorietext().setEditable(true);
			};break;
			
			case 2:{
				panel2.getCreerPanel1().getBtnMoins().setVisible(true);
				panel2.getCreerPanel1().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel1().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel1().getCategorietext().setEditable(true);
				panel2.getCreerPanel2().getBtnMoins().setVisible(true);
				panel2.getCreerPanel2().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel2().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel2().getCategorietext().setEditable(true);
			};break;
			case 3:{
				panel2.getCreerPanel1().getBtnMoins().setVisible(true);
				panel2.getCreerPanel1().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel1().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel1().getCategorietext().setEditable(true);
				panel2.getCreerPanel2().getBtnMoins().setVisible(true);
				panel2.getCreerPanel2().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel2().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel2().getCategorietext().setEditable(true);
				panel2.getCreerPanel3().getBtnMoins().setVisible(true);
				panel2.getCreerPanel3().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel3().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel3().getCategorietext().setEditable(true);
			};break;
			case 4:{
				panel2.getCreerPanel1().getBtnMoins().setVisible(true);
				panel2.getCreerPanel1().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel1().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel1().getCategorietext().setEditable(true);
				panel2.getCreerPanel2().getBtnMoins().setVisible(true);
				panel2.getCreerPanel2().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel2().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel2().getCategorietext().setEditable(true);
				panel2.getCreerPanel3().getBtnMoins().setVisible(true);
				panel2.getCreerPanel3().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel3().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel3().getCategorietext().setEditable(true);
				panel2.getCreerPanel4().getBtnMoins().setVisible(true);
				panel2.getCreerPanel4().getNbrAdultes().setEditable(true);
				panel2.getCreerPanel4().getNbrEnfants().setEditable(true);
				panel2.getCreerPanel4().getCategorietext().setEditable(true);
			};break;
			}
			}
			else {
				JOptionPane.showMessageDialog(null, "Reservation "+ etat+" vous pouvez pas la modifier .");
			}
			
		}
		
	   
		
		public void modifierReservation(int i,int code, ConsulterView2 consulterView) {
			int s=1;
			//SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			client.setNom(consulterView.getPanelConsulter().getPanel().getPanel_1().getNom().getText());
			client.setPrenom(consulterView.getPanelConsulter().getPanel().getPanel_1().getPrenom().getText());
			client.setTelephone(consulterView.getPanelConsulter().getPanel().getPanel_1().getTelephone().getText());
			
			reservation.setNumReservation(code);
			reservation.setDateDebut(consulterView.getPanelConsulter().getPanel().getPanel_1().getDateDebut().getText());
			reservation.setDateFin(consulterView.getPanelConsulter().getPanel().getPanel_1().getDateFin().getText());
			
			String d1;
			String d2;

			         d1=reservation.getDateDebut();
			         d2=reservation.getDateFin();
			
			

			if(i==3) {
			
			
				DetailsReservations detail1=new DetailsReservations();
				Categories cat1= new Categories();
				DetailsReservations detail2=new DetailsReservations();
				Categories cat2= new Categories();
				DetailsReservations detail3=new DetailsReservations();
				Categories cat3= new Categories();
				
				int catSuite=0;
				int catDouble=0;
				int catSimple=0;
				
			if(panel2.getCreerPanel1().getCategorietext().getSelectedIndex()==0) {
				
				catSuite++;
				cat1.setIdCategorie(1);
				cat1.setNom("suite");

				detail1.setNbrAdultes(1);
				detail1.setNbrEnfants(2);
				detail1.setCatergorie(cat1);
				detail1.setReservation(reservation);
			}
			if(panel2.getCreerPanel1().getCategorietext().getSelectedIndex()==1) {
			    catDouble++;
				cat1.setIdCategorie(2);
				cat1.setNom("double");
				detail1.setNbrAdultes(1);
				detail1.setNbrEnfants(2);
				detail1.setCatergorie(cat1);
				detail1.setReservation(reservation);
			}
			if(panel2.getCreerPanel1().getCategorietext().getSelectedIndex()==2) {
				catSimple++;
				cat1.setIdCategorie(3);
				cat1.setNom("simple");
				detail1.setNbrAdultes(1);
				detail1.setNbrEnfants(1);
				detail1.setCatergorie(cat1);
				detail1.setReservation(reservation);
			}
			if(panel2.getCreerPanel2().getCategorietext().getSelectedIndex()==0) {
				catSuite++;
				cat2.setIdCategorie(1);
				cat2.setNom("suite");
				detail2.setNbrAdultes(2);
				detail2.setNbrEnfants(1);
				detail2.setCatergorie(cat2);
				detail2.setReservation(reservation);
			}
			if(panel2.getCreerPanel2().getCategorietext().getSelectedIndex()==1) {
				
				catDouble++;
				cat2.setIdCategorie(2);
				cat2.setNom("double");
				detail2.setNbrAdultes(1);
				detail2.setNbrEnfants(1);
				detail2.setCatergorie(cat2);
				detail2.setReservation(reservation);
			}
			if(panel2.getCreerPanel2().getCategorietext().getSelectedIndex()==2) {
				
				catSimple++;
				cat2.setIdCategorie(3);
				cat2.setNom("simple");
				
				
				detail2.setNbrAdultes(2);
				detail2.setNbrEnfants(1);
				detail2.setCatergorie(cat2);
				detail2.setReservation(reservation);
			
				
			}
	       if(panel2.getCreerPanel3().getCategorietext().getSelectedIndex()==0) {
				catSuite++;
				cat3.setIdCategorie(1);
				cat3.setNom("suite");
				detail3.setNbrAdultes(1);
				detail3.setNbrEnfants(2);
				detail3.setCatergorie(cat3);
				detail3.setReservation(reservation);
			}
			if(panel2.getCreerPanel3().getCategorietext().getSelectedIndex()==1) {
				
				catDouble++;
				cat3.setIdCategorie(2);
				cat3.setNom("double");
				detail3.setNbrAdultes(1);
				detail3.setNbrEnfants(2);
				detail3.setCatergorie(cat3);
				detail3.setReservation(reservation);
			}
			if(panel2.getCreerPanel3().getCategorietext().getSelectedIndex()==2) {
				
				catSimple++;
				cat3.setIdCategorie(3);
				cat3.setNom("simple");
				
				
				detail3.setNbrAdultes(2);
				detail3.setNbrEnfants(1);
				detail3.setCatergorie(cat3);
				detail3.setReservation(reservation);
			
				
			}
			int j1=0;
			int j2=0;
			int j3=0;
			if(cat1.getIdCategorie()==1)
				  j1=connexion.verifierDisponibilite(d1,cat1.getIdCategorie(), catSuite);
			else {
			if(cat1.getIdCategorie()==2)
				  j1=connexion.verifierDisponibilite(d1,cat1.getIdCategorie(),  catDouble);
			else {
			if(cat1.getIdCategorie()==3)
				 j1=connexion.verifierDisponibilite(d1,cat1.getIdCategorie(),  catSimple);
			}
			}
			
			if(cat2.getIdCategorie()==1)
				  j2=connexion.verifierDisponibilite(d1,cat2.getIdCategorie(),  catSuite);
			else {
			if(cat2.getIdCategorie()==2)
				  j2=connexion.verifierDisponibilite(d1,cat2.getIdCategorie(),  catDouble);
			else {
			if(cat2.getIdCategorie()==3)
				 j2=connexion.verifierDisponibilite(d1,cat2.getIdCategorie(), catSimple);
			}
			}
			
			if(cat3.getIdCategorie()==1)
				  j3=connexion.verifierDisponibilite(d1,cat3.getIdCategorie(),  catSuite);
			else {
			if(cat3.getIdCategorie()==2)
				  j3=connexion.verifierDisponibilite(d1,cat3.getIdCategorie(),  catDouble);
			else {
			if(cat3.getIdCategorie()==3)
				 j3=connexion.verifierDisponibilite(d1,cat3.getIdCategorie(),  catSimple);
			}
			}
				//System.out.println("j1 "+catSuite+" j2 "+catDouble+" j3 "+catSimple);
				if(j1==1 && j2==1 && j3==1) {
					 connexion.modifierReservation(detail1, reservation,i,(int) num.get(0));
					 connexion.modifierReservation(detail2, reservation,i,(int) num.get(1));
					 connexion.ajouterChambreSalwa(detail3);
	                 JOptionPane.showMessageDialog(null, "bien enregistre");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "non disponible ");
				}
			
			}

		}
		
		
}

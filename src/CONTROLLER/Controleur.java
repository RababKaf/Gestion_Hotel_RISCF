package CONTROLLER;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import CONFIGURATION.Connexion;
import VIEW.Editer;
import VIEW.ViewListeCh;

public class Controleur {
	private ViewListeCh view;
	private Editer edit;
	private Connexion myBd;
	public Controleur(ViewListeCh view) {
		super();
		this.view = view;
		myBd=new Connexion();
		try {
			myBd.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		edit=new Editer();
		edit.setVisible(false);
	}
	
	public void initControleur() {
		
		Afficher();
		view.getTextField().addKeyListener(new KeyAdapter()
		{public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
				AfficherRecherche();
				
			
				
		}});
		
		
		Afficher();
		
	
		view.getBtnConsulter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Afficher();
				
			}
		});
		view.getBtnLogout().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getPanel_2().setVisible(false);
				view.getTextField().setText("");
				edit.dispose();
				
			}
		});
		
		view.getBtnchercher().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getPanel_2().setVisible(true);	
				view.getTextField().requestFocus();
				
			}
		});
		view.getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherRecherche();
			}
		});
		
		view.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				edit=new Editer();
				
				int i=view.getTable().getSelectedRow();
				DefaultTableModel model=(DefaultTableModel) view.getTable().getModel();
				edit.getTextNumCh().setText((String) model.getValueAt(i, 0));
				edit.getTextEtage().setText((String) model.getValueAt(i, 1));
				edit.getTextNbLits().setText((String) model.getValueAt(i, 2));
				edit.getTexEtat().setText((String) model.getValueAt(i, 3));
				edit.getTextType().setText((String) model.getValueAt(i, 4));
				
				view.setVisible(false);
				edit.getBtnDelete().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ExecuterDelete();
						view.setVisible(true);
						Afficher();
						
						
						
				}
				});
				edit.getBtnNewButton_1().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								
						edit.getTextEtage().setEditable(true);
				}
				});
				edit.getBtnNewButton_2().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								
						edit.getTextNbLits().setEditable(true);
				}
				});
				edit.getBtnNewButton_3().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						edit.getTexEtat().setEditable(true);	
						
				}
				});
				edit.getBtnNewButton_4().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						edit.getTextType().setEditable(true);		
						
				}
				});
				edit.getBtnQuitter().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setVisible(true);
						Afficher();
						edit.dispose();
					}
				});
				
				edit.getBtnModifie().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ExecuterModifier();
						view.setVisible(true);
						Afficher();
					}
				});
				edit.getBtnHorsSE().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						ExecuterHorsService();	
						view.setVisible(true);
						Afficher();
						
					}
				});
				edit.getTextEtage().addKeyListener(new KeyAdapter()
				{public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_DELETE)
						ExecuterDelete();
					
						
				}});	
				
			}
		});
		
	
	}

	public void chercher(JTable table) {
		String id;
		id=view.getTextField().getText();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
	    TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
	    table.setRowSorter(rowSorter);
	     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + id, 0));
	}
			

	
	
	public void ExecuterHorsService() {
		String nu,etat;
		nu=edit.getTextNumCh().getText();
		etat=edit.getTexEtat().getText();
		if(etat.trim().equals("disponible")) {
			int i=JOptionPane.showConfirmDialog(null, "Vous voulez rendre la chambre hors service ! ","confirmation",JOptionPane.YES_NO_OPTION);
			if(i==JOptionPane.YES_OPTION) {
				int i1=myBd.HorsService(nu);
				if(i1>0) {
					JOptionPane.showMessageDialog(null,"vous avez  rendre l'etat de chambre "+nu+" hors service");
						
			    }
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Vous ne pouvez pas rendre la chambre: "+nu+", hors service car elle indisponible");
			view.setVisible(true);
			Afficher();
			edit.dispose();
		}
			
		
	}
	
	
	
	
	public void ExecuterDelete() {
		
		String nu,etat;
		 nu=edit.getTextNumCh().getText();
		 etat=edit.getTexEtat().getText();
		if(etat.trim().equals("disponible")) {	
				int i=JOptionPane.showConfirmDialog(null, "Vous voulez supprimer cette Chambre ?","confirmation",JOptionPane.YES_NO_OPTION);
				if(i==JOptionPane.YES_OPTION) {
					int i1=myBd.delete(nu);
					if(i1>0) {
						JOptionPane.showMessageDialog(null,"vous avez bien supprimer la chambre :"+nu);
								//v. getBtnConsulter().doClick();
				    }
		}
		}				
		else {
				JOptionPane.showMessageDialog(null,"Vous ne pouvez pas supprimer la chambre: "+nu+", car elle indisponible");
				view.setVisible(true);
				Afficher();
				edit.dispose();
		}	
			
		
		
	}
	public void ExecuterModifier() {
		String nu,etat,type,Li,etage;
		nu=edit.getTextNumCh().getText();
		etat=edit.getTexEtat().getText();
		type=edit.getTextType().getText();
		Li=edit.getTextNbLits().getText();
		etage=edit.getTextEtage().getText();
		
		int id ;
		
		if(etat.trim().equals("disponible")) {
			if(type.trim().equals("suite"))
				id= 1 ;
			else if(type.trim().equals("double"))
				id=2;
			else 
				id=3;
	        								
				int i=JOptionPane.showConfirmDialog(null, "Vous voulez modifier cette ligne ","confirmation",JOptionPane.YES_NO_OPTION);
				if(i==JOptionPane.YES_OPTION) {

				int i1=myBd.Update9(nu,etat,type,Li,etage,id);
					if(i1>0) {
						JOptionPane.showMessageDialog(null,"vous avez bien Modifier la chambre:"+nu);
					
				    }
				}
		}
		else {
			JOptionPane.showMessageDialog(null,"Vous ne pouvez pas modifier la chambre: "+nu+", car elle indisponible");
			view.setVisible(true);
			Afficher();
			edit.dispose();
	    }
			
		
	}
	
	public void Afficher() {
				   String numc,etage,nbl,type,etat;
					DefaultTableModel model=(DefaultTableModel) view.getTable().getModel();
					model.setColumnCount(0);	
					model.setRowCount(0);
					model.addColumn("Num Chambre");
					model.addColumn("Etage");
					model.addColumn("Nb Lits");
					model.addColumn("Etat");
					model.addColumn("Categorie");
					
					ResultSet  rs=myBd.select(); 
					try {
						while(rs.next()) {
							numc=rs.getString(1);
							etage=rs.getString(2);
							nbl=rs.getString(3);
							etat=rs.getString(4);
							type=rs.getString(5);
							String[] row={numc,etage,nbl,etat,type};
							model.addRow(row);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					view.getTable().setModel(model);
		}
	public void AfficherRecherche() {
		String numc,etage,nbl,type,etat;
		DefaultTableModel model=(DefaultTableModel) view.getTable().getModel();
		model.setColumnCount(0);	
		model.setRowCount(0);
		model.addColumn("Num Chambre");
		model.addColumn("Etage");
		model.addColumn("Nb Lits");
		model.addColumn("Etat");
		model.addColumn("Categorie");
		String id;
		id=view.getTextField().getText();
		ResultSet  rs=myBd.RechercheBD(id); 
		try {
			while(rs.next()) {
				numc=rs.getString(1);
				etage=rs.getString(2);
				nbl=rs.getString(3);
				etat=rs.getString(4);
				type=rs.getString(5);
				String[] row={numc,etage,nbl,etat,type};
				model.addRow(row);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		view.getTable().setModel(model);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


       
}

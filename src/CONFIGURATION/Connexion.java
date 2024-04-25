package CONFIGURATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import MODEL.ModelCheque;
import MODEL.ModelFacture;
import VIEW.ViewChercher;
import MODEL.ClientCh;
import MODEL.DetailReservationCh;
import MODEL.DetailsReservations;
import MODEL.ReservationCh;
import MODEL.Reservations;
import MODEL.ChambreI;



public class Connexion {

		static Connection myCnx;
		String url,pilote;
		ViewChercher view=new ViewChercher(); 
		public Connexion()  {
		try {

			pilote=new String("com.mysql.cj.jdbc.Driver");
			Class.forName(pilote);
			url = new String("jdbc:mysql://127.0.0.1/hotel?serverTimezone=UTC");
			 try {
				connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} 
		catch( ClassNotFoundException excpt) {
				System.err.println("Erreur du chargement du pilote : " + excpt.getMessage()); 
			                             }
		
		    }
		
		
		public void connect() throws SQLException {
			try {
				myCnx = DriverManager.getConnection(url,"root","");
				//JOptionPane.showMessageDialog(null, "CONNEXION ETABLIE","Connextion",JOptionPane.INFORMATION_MESSAGE);
		
			} catch (SQLException excpt) {
				System.err.println("Erreur produise :" + excpt);
			} 		
		}
		
		public void disconnect() 
		{
		
			try {
				myCnx.close();
				JOptionPane.showMessageDialog(null, "Deconexion avec succes","Deconnextion",JOptionPane.INFORMATION_MESSAGE);
		        } 
			catch (SQLException excpt) {
			     excpt.printStackTrace();
			                            }
		}
		
		public ResultSet getAllData(int a) {
			ResultSet resultat=null;
			String requette="select distinct(c.nom) as 'Nom Categorie',prixchambre*1 'Prix Categorie',DATEDIFF(re.datefin, re.datedebut) 'Nombre Nuitées',r.nbrenfants*1 'Nombre Enfants',r.nbradultes*1 'Nombre Adulte',prixchambre*DATEDIFF(re.datefin, re.datedebut)*r.nbrenfants+prixchambre*DATEDIFF(re.datefin, re.datedebut)*r.nbradultes prix from saison s,categorie c,chambrereservee ch , detailreservation r,detailchambre d,reservation re where re.etat='confirmer'  and   re.numReservation="+a+" and re.numreservation=r.numReservation and d.idcategorie=r.idcategorie and  c.idcategorie=r.idcategorie and s.idsaison=d.idsaison and re.datedebut between s.datedebut and s.datefin;";
			//JOptionPane.showMessageDialog(null, requette);
			try {
				
				Statement st=myCnx.createStatement();	
				resultat=st.executeQuery(requette);	
			
			
			     } 
			

			catch (SQLException excpt) {
				// TODO Auto-generated catch block
				excpt.printStackTrace();}
			
			return resultat;
		}



	public ResultSet getAllData1(String b) {
		ResultSet resultat=null;
		//and re.datefin=CURRENT_DATE 
        String requette="select distinct(c.nom) as NomCategorie,prixchambre*1 'Prix Categorie',DATEDIFF(re.datefin, re.datedebut)*1 'Nombre Nuitées',r.nbrenfants*1 'Nombre Enfants',r.nbradultes*1 'Nombre Adulte',prixchambre*DATEDIFF(re.datefin, re.datedebut)*r.nbrenfants+prixchambre*DATEDIFF(re.datefin, re.datedebut)*r.nbradultes prix from saison s,categorie c,chambrereservee ch , detailreservation r,detailchambre d,reservation re where re.etat='confirmer' and re.cin='"+b+"' and re.numreservation=r.numReservation and d.idcategorie=r.idcategorie and c.idcategorie=r.idcategorie and s.idsaison=d.idsaison and re.datedebut between s.datedebut and s.datefin;";
      //JOptionPane.showMessageDialog(null, requette);
        
       try {
	
	    Statement st=myCnx.createStatement();
	    resultat=st.executeQuery(requette);			 

     } 


catch (SQLException excpt) {
	// TODO Auto-generated catch block
	excpt.printStackTrace();
                            }


return resultat;
}


	public int estNum(String b) {
		ResultSet resultat=null;
		int nbr=0;
        String requette="select numReservation from reservation where cin='"+b+"';";
       // JOptionPane.showMessageDialog(null, requette);
        
       try {
	
	    Statement st=myCnx.createStatement();
	    resultat=st.executeQuery(requette);	
	    int i;
	    while(resultat.next())
	    { 
	    i=resultat.getInt(1);
	    nbr=i;
	       }}
       catch (SQLException excpt) {
    		// TODO Auto-generated catch block
    		excpt.printStackTrace();
    	                            }
  //     System.out.println(nbr);
      
       return nbr;
      
}
	
	public ArrayList<String> tabnum(int num){
		
		 ResultSet resultat=null;
		 ArrayList<String> A=new ArrayList<String>() ;
		
	
			
	        String requette="select c.cin,concat(prenom,' ',nom),numTel from reservation r, client c where r.cin=c.cin and numreservation="+num ;
	       // JOptionPane.showMessageDialog(null, requette);
	        
	       try {
		
		    Statement st=myCnx.createStatement();
		    resultat=st.executeQuery(requette);	
		    
		    while(resultat.next())
		    { 
		  
		 
		    A.add(resultat.getString(1));
		    A.add(resultat.getString(2));
		    A.add(resultat.getString(3));
		
		  
		       }}
	       catch (SQLException excpt) {
	    		// TODO Auto-generated catch block
	    		excpt.printStackTrace();
	    	                            }
	   	A.add(" ");
		A.add(" ");
		A.add(" ");
	       return A;
		
		
	}
	

	
	public void inserer(String table,ModelFacture m) {
		int resultat;
		String requette;
		if(m.getNumCheque()==0)
		requette="INSERT INTO "+table+" (prixTotal,typePayement,numReservation,numCheque) VALUES ("+m.getPrixTotal()+",'"+m.getTypePayement()+"',"+m.getNumReservation()+","+null+");";
		else
			 requette="INSERT INTO "+table+" (prixTotal,typePayement,numReservation,numCheque) VALUES ("+m.getPrixTotal()+",'"+m.getTypePayement()+"',"+m.getNumReservation()+","+m.getNumCheque()+");";
		//JOptionPane.showMessageDialog(null, requette);
		try {
			Statement st=Connexion.myCnx.createStatement();
			resultat=st.executeUpdate(requette);
		     }    
		catch (SQLException excpt) {
			// TODO Auto-generated catch block
			excpt.printStackTrace();}
		 JOptionPane.showMessageDialog(null, "Enregisté avec succes", "Info", JOptionPane.INFORMATION_MESSAGE);
		
	}
	public void inserer(String table, ModelCheque m) {
		int resultat;
		String requette="INSERT INTO "+table+" (numCheque,montant) VALUES ("+m.getNumCheque()+","+m.getMontant()+")";
		//JOptionPane.showMessageDialog(null, requette);
		try {
			Statement st=Connexion.myCnx.createStatement();
			resultat=st.executeUpdate(requette);
		     }    
		catch (SQLException excpt) {
			// TODO Auto-generated catch block
			excpt.printStackTrace();}
	
	}
	
	
	public  ArrayList<Integer> recupererNumChambre(ModelFacture mf){
		 ArrayList<Integer> A=new ArrayList<Integer>();
		 
		 ResultSet resultat=null;
		
	        String requette="select numchambre from chambrereservee where numReservation="+mf.getNumReservation()+";";
	     //   JOptionPane.showMessageDialog(null, requette);
	        
	       try {
		
		    Statement st=myCnx.createStatement();
		    resultat=st.executeQuery(requette);	
		    int i1;
		    while(resultat.next())
		    { 
		    i1=resultat.getInt(1);
		 
		    A.add(i1);
		  
		       }}
	       catch (SQLException excpt) {
	    		// TODO Auto-generated catch block
	    		excpt.printStackTrace();
	    	                            }
		 
	
return A;
		
		
	};


	public void chambredispo(String table, ModelFacture m) {
		int resultat;
		String requette;
		ArrayList<Integer> l=recupererNumChambre(m);
		for(int i=0;i<l.size();i++ ) {
		 requette="update "+table+" set etat='disponible' where numchambre="+l.get(i);
		// JOptionPane.showMessageDialog(null, requette);
		try {
			Statement st=Connexion.myCnx.createStatement();
			resultat=st.executeUpdate(requette);
		     }    
		catch (SQLException excpt) {
			// TODO Auto-generated catch block
			excpt.printStackTrace();}}
		
		
	}


	public void reserPayer(String table, ModelFacture modelF) {
		int resultat;
		String requette;

		 requette="update "+table+" set etat='payer' where numreservation="+modelF.getNumReservation();
		//JOptionPane.showMessageDialog(null, requette);
		try {
			Statement st=Connexion.myCnx.createStatement();
			resultat=st.executeUpdate(requette);
		     }    
		catch (SQLException excpt) {
			// TODO Auto-generated catch block
			excpt.printStackTrace();}
		 
		 

		
	}


	public ResultSet select() {
		String numc,etage,nbl,type,etat;
		String query=new String("Select c.NumChambre,c.etage,c.NbLits,c.etat,cat.Nom from chambre c,categorie cat where c.idCategorie=cat.idCategorie  ");
		Statement stm;
		try {
			stm = myCnx.createStatement();
			ResultSet rs=stm.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public ResultSet RechercheBD(String id){
		
		String query=new String("Select c.NumChambre,c.etage,c.NbLits,c.etat,cat.Nom from chambre c,categorie cat where c.idCategorie=cat.idCategorie and c.NumChambre='"+id+"'");
		Statement stm;
		try {
			stm = myCnx.createStatement();
			ResultSet rs=stm.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int delete(String nu) {
		String query=new String("delete from chambre where NumChambre= "+nu+"");
		try {
			Statement stm=myCnx.createStatement();
			return stm.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
	public int Update9(String nu,String etat,String type,String li,String etage,int id) {
		
		String query=new String("Update chambre set etage= '"+etage+"', NbLits= '"+li+"', etat= '"+etat+"',idCategorie='"+id+ "' where NumChambre="+nu+"");
		Statement stm;
		try {
			stm = myCnx.createStatement();
			return stm.executeUpdate(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	public int HorsService(String nu) {
		String query=new String("Update chambre set etat='hors service' where NumChambre= "+nu+"");
		try {
			Statement stm=myCnx.createStatement();
			return stm.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public ResultSet getAllData(String table) {
		ResultSet res=null;
		String req="SELECT * FROM "+table;
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return res;
	}
	public void insertClient(ClientCh client) {
		String sql="INSERT INTO `client`(`cin`, `nom`, `prenom`,`numtel`) "
				+ "VALUES ('" +client.getCin()+"','" +client.getNom() +"','"+client.getPrenom() +"','"+client.getNumTel()+ "')";
//		JOptionPane.showMessageDialog(null, sql);
		try {
			Statement st=myCnx.createStatement(); 
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
	}
	public void insertReservation(ReservationCh reservation) {
		int id=recupererNumReservation()+1;
		String sql="INSERT INTO `reservation`(`numReservation`, `cin`, `nbrChambres`,`dateFin`,`dateDebut`) "
				+ "VALUES ('" +id+"','" +reservation.getM_Client() +"','"+reservation.getNbrChambres() +"','"+reservation.getDateFin() +"','"+reservation.getDateDebut()+ "')";
//		JOptionPane.showMessageDialog(null, sql);
		try {
			Statement st=myCnx.createStatement(); 
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
	}
	
	public void insertDetailReservation(DetailReservationCh detailReservation) {
		String sql="INSERT INTO `detailreservation`(`numReservation`, `nbrAdultes`, `nbrEnfants`,`idCategorie`) "
				+ "VALUES ('" +detailReservation.m_Reservation  +"','" +detailReservation.getNbrAdultes() +"','"+detailReservation.getNbrEnfants() +"','"+detailReservation.getM_Categorie() +"')";
		//JOptionPane.showMessageDialog(null, sql);
		try {
			Statement st=myCnx.createStatement(); 
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
	}

	public int chercherIdCategorie(String cate) {
		ResultSet res=null;
		
		String req="select idCategorie from Categorie where Nom= '"+cate+"'";
		//JOptionPane.showMessageDialog( null, req);
		Statement st;
		int id=0;
		
		try {
			 st=myCnx.createStatement(); 
			 res=st.executeQuery(req);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println("uhgyg");
		}	
		try {
			if(res.next())
			{
				// id=Integer.parseInt(res.getString(1));
				try {
					id=res.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
	}
	public int verifierDisponibilite(String date,int id,int n) {
		ResultSet res=null;
		int i=0;//nombre non disp
		int j=0;//nbr tot
		Statement st;
		String req1 = "SELECT COUNT(idCategorie) FROM detailreservation d, reservation r WHERE d.numReservation=r.numReservation AND idCategorie='" + id + "' AND '" + date + "' BETWEEN r.dateDebut AND r.dateFin and r.etat!='annuler' and r.etat!='payer'";
		//JOptionPane.showMessageDialog( null, req1);
		try {
			 st=myCnx.createStatement(); 
			 res=st.executeQuery(req1);
			 try {
				 if(res.next())
					i=res.getInt(1);
				// System.out.println("non disp"+i);
				 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}	
		 
		String req2 = "SELECT COUNT(numchambre) FROM chambre WHERE etat != 'hors service' AND idcategorie = '" + id + "'";
		//JOptionPane.showMessageDialog( null, req2);
		ResultSet res2=null;
		try {
			 st=myCnx.createStatement(); 
			 res2=st.executeQuery(req2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}	
		try {
			if(res2.next())
			{
				
				try {
					j=res2.getInt(1);
					 //System.out.println("tot"+j);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(n+"x7al mn chambre");
//		System.out.println(j+"tot");
//		System.out.println(i+"3amra");
		if(j-i>=n) //tot kbr strict mn non disp
			return 1;//possi
		return 0;//non possi
			
	}
	
	public String calculerPrixTotal(int id)
	{
		//String req="select prixchambre*DATEDIFF(re.datefin, re.datedebut)*r.nbrenfants+prixchambre*DATEDIFF(re.datefin, re.datedebut)*r.nbradultes prix from categorie c,chambrereservee ch , detailreservation r,detailchambre d,reservation re and re.numreservation=r.numReservationand d.idcategorie=r.idcategorie and  c.idcategorie=r.idcategorie and  re.numReservation= '" + id + "'";
		
		ResultSet rs ;
		String prix="";
		String sql = "SELECT sum(prixchambre * DATEDIFF(re.datefin, re.datedebut) * (r.nbrenfants + r.nbradultes)) FROM saison s,categorie c,detailreservation r, detailchambre d, reservation re WHERE re.numreservation=r.numreservation AND d.idcategorie = r.idcategorie AND c.idcategorie=r.idcategorie and d.idsaison=s.idsaison and re.datedebut between s.datedebut and s.datefin AND re.numreservation="+id+";";
//	     JOptionPane.showMessageDialog(null, sql);
		try {
			
		Statement stmt =myCnx.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			     prix=rs.getString(1);
			   //  System.out.println(prix);
			    // Utilisation de la valeur de prix récupérée
			}
		} catch (SQLException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		
		}
		return prix;
	}

	public int recupererNumReservation() {
	    ResultSet res = null;
	    String req = "SELECT numReservation FROM reservation ORDER BY numReservation DESC LIMIT 1";
	    Statement st = null;
	    int id = 0;

	    try {
	        st = myCnx.createStatement();
	        res = st.executeQuery(req);
	        if (res.next()) {
	            id = res.getInt(1);
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, e.getMessage());
	    } finally {
	        try {
	            if (res != null) {
	                res.close();
	            }
	            if (st != null) {
	                st.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return id;
	}
	
public ResultSet chercher1(int code) {
		
		String requete1="select `nom`,`prenom`,`numtel`,`datedebut`,`datefin`,`etat`,`nbrchambres` from `client` c, `reservation` r where c.`cin`=r.`cin` "
				+ "and r.`numreservation`="+code;

		
		try {
			Statement st= myCnx.createStatement();

			
			
			 
			
			ResultSet resultat=st.executeQuery(requete1);

			return resultat;
		}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, "chercher erreur "+e.getMessage());
		}
		return null;
		
	}
	
public ResultSet chercher2(int code) {
	
	String requete2="select `nbradultes`,`nbrenfants`,`nom`,c.`idcategorie`,d.`num` from `categorie` c, `detailreservation` d where c.`idcategorie`=d.`idcategorie` "
			+ "and d.`numreservation`="+code;
	
	try {
		Statement st= myCnx.createStatement();
		ResultSet resultat=st.executeQuery(requete2);
		return resultat;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	
	
	return null;
	
}
	
	
	public ResultSet getData() {
		
		String requete="select `numchambre`,`etage`,`etat`,`nom` from `chambre` ch,`categorie` c where "
				+ "`etat`='disponible' and ch.`idcategorie`=c.`idcategorie`";
		Statement st;
		try {
			st = myCnx.createStatement();
			ResultSet rs=st.executeQuery(requete);
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public void annulerReservation(int code) {
		
		String requete="update `reservation` set `etat`='annuler' where `numreservation`="+code;
		
		try {
			Statement st=myCnx.createStatement();
		        st.executeUpdate(requete);
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
	      // JOptionPane.showMessageDialog(null, "annuler reservation erreur "+e.getMessage());
		}
		
	}
	
	public void changeStat(int code,int numCh) {
		String requete="update `chambre` set `etat`='indisponible' where `numChambre`="+numCh;
		String requete2="insert into `chambrereservee` values ("+code+","+numCh+")";
		String requete3="update reservation set etat='confirmer' where numreservation="+code;
		
		try {
			Statement st=myCnx.createStatement();
			st.executeUpdate(requete);
			st.executeUpdate(requete2);
			st.executeUpdate(requete3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 //JOptionPane.showMessageDialog(null, "change stat erreur  "+e.getMessage());
		}
	}
	
	public ResultSet testModifier(int code) {
		
		String requete="select DateDiff(`datedebut`,now()) from `reservation` where `numreservation`="+code;
		
		
		try {
			Statement st=myCnx.createStatement();
			ResultSet resultat=st.executeQuery(requete);
			return resultat;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, "testModifier erreur  "+e.getMessage());
		}
		return null;
	}
	
	
	
	
	public void modifierReservation(DetailsReservations detail,Reservations reser,int i,int numm) {
		System.out.println("d "+detail.getCatergorie().getIdCategorie());
	
		String req1="update `detailreservation` set `nbradultes`="+detail.getNbrAdultes()+" , `nbrenfants`="+detail.getNbrEnfants()+","
				+ "`idcategorie`="+detail.getCatergorie().getIdCategorie()+" where `numreservation`="+reser.getNumReservation()+" and "
						+ "`num`="+numm;
		String req2="update `reservation` set `datedebut`="+reser.getDateDebut()+", `datefin`="+reser.getDateFin()+" , `nbrchambres`="
				+ i+" where `numreservation`="+reser.getNumReservation();
		
		try {
			Statement st=myCnx.createStatement();
			     st.executeUpdate(req1);
			     st.executeUpdate(req2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("modifierReservation erreur "+e.getMessage());
		}
	}
	
	public void ajouterChambreSalwa(DetailsReservations d) {
		String requete="insert into detailReservation(nbradultes,nbrenfants,numreservation,idcategorie) values("+d.getNbrAdultes()+","+d.getNbrEnfants()+","+d.getReservation().getNumReservation()+""
				+ ","+d.getCatergorie().getIdCategorie()+")";
		
		try {
			Statement st=myCnx.createStatement();
			st.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("ajoutersalwa  erreur "+e.getMessage());
		}
	}
	public  void InsererChambre(ChambreI ch,String nomcat)
	{
		String reqid = "select idCategorie from categorie where nom ='"+nomcat+"'";
		
		  Statement st = null;
		  Statement st2 = null;
		  Statement st3 = null;
		  
		
		try {
			
		  st =myCnx.createStatement(); 
		  st2=myCnx.createStatement();
		  st3=myCnx.createStatement();
		 
		
		}catch(SQLException e )
		{
			System.err.println("problem de statement:" + e.getMessage());
		}
		
		try {
			ResultSet rs=st.executeQuery(reqid);
			
			int id=0;
			if(rs.next())
			{
				id=rs.getInt(1);
			}
			String req = "insert into chambre(idcategorie,etage,nblits) Values('"+id+"','"+ch.getEtage()+"','"+ch.getNbLits()+"')";
            st2.executeUpdate(req);
             
              String req3="select numChambre from chambre order by numchambre desc limit 1";
              ResultSet rs2 = st3.executeQuery(req3);
    		   int num =0;
    		   if(rs2.next())
    		   {
    			   num=rs2.getInt(1);
    		   }
    		   JOptionPane.showMessageDialog(null,"Le numéro de chambre que vous avez ajouter est :"+num, "numéro de chambre",JOptionPane.INFORMATION_MESSAGE);
			
		    }
		catch(Exception exp )
		{
			System.err.println("problem de Requete :" + exp.getMessage());
		}
		
		
	}

}

package VIEW;

	import java.awt.EventQueue;

	import VIEW.ViewChercher;
	import CONTROLLER.Controller;
	import MODEL.ModelCheque;
	import MODEL.ModelFacture;

	public class Menu {
		
		
		public static void main(String[] args) {
			ModelFacture m=new ModelFacture();
			ModelCheque ch=new ModelCheque();
			
		
		   ViewChercher window = new ViewChercher();
		   window.frame.setVisible(true);
		   
		   Controller c=new Controller(m,ch,window);
		   c.initController();
		}

	}



package MENU;

import CONTROLLER.Manager;
import VIEW.View;

	public class Main {
	public static void main(String[] args) {
		View view = new View();

		Manager manager = new Manager(view);
		manager.initManager();
		//MenuAG agent = new MenuAG();
		//new AjouterCH();
		
		
	}

}

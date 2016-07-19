package application;

import controller.ControllerMenu;
import model.CollectionImage;
import presenter.PresenterMenu;
import view.ViewMenu;

public class MainClass {
	public static void main(String[] args) {
		ViewMenu viewMenu = new ViewMenu();
        PresenterMenu modelMenu = new PresenterMenu();
        new ControllerMenu(viewMenu, modelMenu);
		
		//CollectionImage c = new CollectionImage("C:\\Users\\Sam\\Desktop\\LOG121\\Lab4\\Images");
		//c.loadFile();
	}
}

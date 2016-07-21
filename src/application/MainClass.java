package application;

import presenter.PresenterMenu;
import view.ViewMenu;
import viewInterface.ViewInterfaceMenu;

public class MainClass {
	public static void main(String[] args) {
		ViewMenu viewMenu = new ViewMenu();
        PresenterMenu presenterMenu = new PresenterMenu();
        new ViewInterfaceMenu(viewMenu, presenterMenu);
	}
}

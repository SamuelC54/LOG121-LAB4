/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  01
Projet: Laboratoire #4
Étudiant(e)s: 
              Philippe Torres-Brisebois
              Laurent Theroux-Bombardier
              Samuel Croteau
              Nelson Chao
Professeur : Francis Cardinal
Nom du fichier: MainClass.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package application;

import presenter.PresenterMenu;
import view.ViewMenu;
import viewInterface.ViewInterfaceMenu;

//The main class to run the application
public class MainClass {
	public static void main(String[] args) {
		ViewMenu viewMenu = new ViewMenu();
        PresenterMenu presenterMenu = new PresenterMenu();
        new ViewInterfaceMenu(viewMenu, presenterMenu);
	}
}

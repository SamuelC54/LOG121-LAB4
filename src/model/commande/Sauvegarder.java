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
Nom du fichier: Sauvegarder.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model.commande;

import presenter.PresenterPerspective;

public class Sauvegarder implements Commande {

	private PresenterPerspective presenterPerspective;
	
	/**
	 * Constructeur
	 * 
	 * @param aPresenterPerspective the presenter used in the command
	 */
	public Sauvegarder(PresenterPerspective aPresenterPerspective) {
		this.presenterPerspective = aPresenterPerspective;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Execute the Save command
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		presenterPerspective.savePerspective();
	}

}

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
Nom du fichier: Undo.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model.commande;

import presenter.PresenterPerspective;

public class Undo implements Commande {

	PresenterPerspective presenterPerspective;
	
	/**
	 * Constructor
	 * 
	 * @param presenterPerspective the used perspective
	 */
	public Undo (PresenterPerspective presenterPerspective) {
		this.presenterPerspective = presenterPerspective;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		presenterPerspective.undoAction();
	}

}

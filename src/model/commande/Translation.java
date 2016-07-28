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
Nom du fichier: Translation.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model.commande;

import java.awt.Point;
import java.awt.event.MouseEvent;

import presenter.PresenterPerspective;

public class Translation implements Commande {
	private PresenterPerspective presenter;
	private MouseEvent mouseEvent;
	private Point mouselocation;

	/**
	 * Constructor
	 * 
	 * @param presenter the presenter used for the command
	 * @param mouseEvent the mouse event
	 * @param mouselocation the current mouse location
	 */
	public Translation(PresenterPerspective presenter, MouseEvent mouseEvent, Point mouselocation) {
		this.presenter = presenter;
		this.mouseEvent = mouseEvent;
		this.mouselocation = mouselocation;
	}

	/**
	 * Execute the translation
	 */
	public void execute() {
		int translationHorizontal = (int) (mouselocation.getX() - mouseEvent.getX());
		int translationVertical = (int) (mouselocation.getY() - mouseEvent.getY());

		presenter.changeTranslation(-translationHorizontal, -translationVertical);
	}
}

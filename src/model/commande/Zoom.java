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
Nom du fichier: Zoom.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model.commande;

import java.awt.event.MouseWheelEvent;

import presenter.PresenterPerspective;

public class Zoom implements Commande {
	private PresenterPerspective presenter;
	private MouseWheelEvent mouseWheelEvent;

	/**
	 * Constructor
	 * 
	 * @param presenter the presenter of the perspective
	 * @param mouseWheelEvent a mousewheel event
	 */
	public Zoom(PresenterPerspective presenter, MouseWheelEvent mouseWheelEvent) {
		this.presenter = presenter;
		this.mouseWheelEvent = mouseWheelEvent;
	}

	/**
	 * Execute the command
	 */
	public void execute() {
		int wheelRotation = mouseWheelEvent.getWheelRotation();
		 double zoomPerScroll = 0.1;
		 
		 if(wheelRotation<0){
			 presenter.changeZoom(zoomPerScroll);
		 }else{
			 presenter.changeZoom(-zoomPerScroll);
		 }
	}
}

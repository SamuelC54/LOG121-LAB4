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
Nom du fichier: Close.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model.commande;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Close implements Commande {
	private JFrame frame;
	
	/**
	 * Constructor
	 * 
	 * @param frame the frame to close
	 */
	public Close(JFrame frame){
		this.frame = frame;
	}

	/**
	 * Close the current frame
	 */
	public void execute() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}

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
Nom du fichier: Perspective.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model;

import java.awt.image.BufferedImage;

public class Perspective {
	BufferedImage bufferedImage;
	VisualTransformState vtState = new VisualTransformState();
	
	/**
	 * Constructor
	 * 
	 * @param img the image in the perspective
	 */
	public Perspective(BufferedImage img){
		this.bufferedImage = img;
	}
	//getter/setter
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
	public VisualTransformState getVtState() {
		return vtState;
	}
	public void setVtState(VisualTransformState vtState) {
		this.vtState = vtState;
	}
	
}

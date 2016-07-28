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
Nom du fichier: VisualTransformState.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model;

public class VisualTransformState implements Cloneable{
	//attributes
	private int horizontalTranslation;
	private int verticalTranslation;
	private double zoomPercentage;
	
	/**
	 * Constructor
	 */
	public VisualTransformState(){
		reset();
	}

	/**
	 * Return a copy of the class
	 * 
	 * @return the copy of the class
	 */
	public VisualTransformState getCopy() {
		try {
			return (VisualTransformState) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//getter/setter
	public int getHorizontalTranslation() {
		return horizontalTranslation;
	}
	public void setHorizontalTranslation(int horizontalTranslation) {
		this.horizontalTranslation = horizontalTranslation;
	}
	public int getVerticalTranslation() {
		return verticalTranslation;
	}
	public void setVerticalTranslation(int verticalTranslation) {
		this.verticalTranslation = verticalTranslation;
	}
	public double getZoomPercentage() {
		return zoomPercentage;
	}
	public void setZoomPercentage(double zoomPercentage) {
		this.zoomPercentage = zoomPercentage;
	}
	
	/**
	 * Reset the parameter of the visual transform
	 */
	public void reset() {
		this.horizontalTranslation = 0;
		this.verticalTranslation = 0;
		this.zoomPercentage = 1;
	}
}

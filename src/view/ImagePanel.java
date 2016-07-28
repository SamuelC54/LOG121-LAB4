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
Nom du fichier: ImagePanel.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.Perspective;
import model.VisualTransformState;

public class ImagePanel extends JPanel {

	private Perspective perspective;
	private int newImageWidth;
	private int newImageHeight;

	/**
	 * Paint the panel
	 */
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		BufferedImage image = perspective.getBufferedImage();
		VisualTransformState vtState = perspective.getVtState();

		newImageWidth = (int) (image.getWidth() * vtState.getZoomPercentage());
		newImageHeight = (int) (image.getHeight() * vtState.getZoomPercentage());
		int horizontalTranslation = vtState.getHorizontalTranslation();
		int verticalTranslation = vtState.getVerticalTranslation();

		super.paintComponent(g);

		// http://stackoverflow.com/questions/690871/affinetransform-scaling-a-shape-from-its-center

		AffineTransform transform = g2d.getTransform();

		transform.translate((image.getWidth() / 2) - newImageWidth / 2, (image.getHeight() / 2) - newImageHeight / 2);

		transform.scale(vtState.getZoomPercentage(), vtState.getZoomPercentage());

		g2d.setTransform(transform);
		g2d.drawImage(image, horizontalTranslation, verticalTranslation, newImageWidth, newImageHeight, null);
	}

	public void setPerspective(Perspective perspective) {
		this.perspective = perspective;
	}

	public int getNewImageWidth() {
		return newImageWidth;
	}

	public int getNewImageHeight() {
		return newImageHeight;
	}
}

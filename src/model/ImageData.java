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
Nom du fichier: ImageData.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import model.memento.GestionnaireSauvegarde;
import presenter.PresenterImage;
import presenter.PresenterPerspective;
import view.ViewImage;
import view.ViewPerspective;
import viewInterface.ViewInterfaceImage;
import viewInterface.ViewInterfacePerspective;

public class ImageData {
	private BufferedImage bufferedImage;
	private ImageIcon imageIcon;
	private String name;
	private Perspective[] perspective = new Perspective[2];
	private List<ViewImage> viewImages = new ArrayList<ViewImage>();
	private List<ViewPerspective> viewPerspectives = new ArrayList<ViewPerspective>();

	/**
	 * Constructor
	 * 
	 * @param img the image of the image data
	 * @param imgName the name of the image
	 */
	public ImageData(BufferedImage img, String imgName) {
		this.bufferedImage = img;
		this.name = imgName;
		// image Icon
		imageIcon = new ImageIcon(bufferedImage.getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		// Perspectives
		perspective[0] = new Perspective(img);
		perspective[1] = new Perspective(img);
	}

	/**
	 * Generate a perspective for the mvp
	 * 
	 * @param perspectiveIndex the perspective index
	 */
	public void generatePerspectiveMVP(int perspectiveIndex) {
		ViewPerspective viewPerspective = new ViewPerspective(perspectiveIndex);
		GestionnaireSauvegarde saves = new GestionnaireSauvegarde();
		viewPerspectives.add(viewPerspective);

		PresenterPerspective presenterPerspective = new PresenterPerspective(perspective[perspectiveIndex]);
		
		new ViewInterfacePerspective(viewPerspective, presenterPerspective,viewImages.get(0));
	}

	/**
	 * Generate the thumbnail image of the image
	 */
	public void generateImageMVP() {
		ViewImage viewImage = new ViewImage();
		viewImages.add(viewImage);
		PresenterImage presenterImage = new PresenterImage(this);
		new ViewInterfaceImage(viewImage, presenterImage);
	}

	/**
	 * Dispose all the current image and perspectives views
	 */
	public void disposeAllViews() {

		for (ViewImage viewIm : this.viewImages) {
			viewIm.dispose();
		}
		viewImages.clear();
		for (ViewPerspective viewPerspect : this.viewPerspectives) {
			viewPerspect.dispatchEvent(new WindowEvent(viewPerspect, WindowEvent.WINDOW_CLOSING));
		}
		viewPerspectives.clear();
		
	}

	// getter/setter
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
	public String getName() {
		return name;
	}
	public ImageIcon getImageIcon() {
		return imageIcon;
	}
	public Perspective getPerspective(int index){
		return perspective[index];
	}
}

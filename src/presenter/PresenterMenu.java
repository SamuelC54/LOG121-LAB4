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
Nom du fichier: PresenterMenu.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package presenter;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.SwingPropertyChangeSupport;

import model.CollectionImage;
import model.ImageData;

//Cette classe a ete inspirer du site suivant:
//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing
public class PresenterMenu {

	private final int FIRST_VIEW = 0;
	private final int SECOND_VIEW = 1;
	private boolean viewActive = false;
	private ImageData imgData;
	private List<ImageData> listImgData = new ArrayList<ImageData>();

	// Attributes
	private SwingPropertyChangeSupport propChangeFirer;
	private CollectionImage collectionImage = CollectionImage.getInstance();

	// Methods
	// presenter methods
	public PresenterMenu() {
		propChangeFirer = new SwingPropertyChangeSupport(this);
	}

	public void addListener(PropertyChangeListener prop) {
		propChangeFirer.addPropertyChangeListener(prop);
	}

	/**
	 * Generate an image perspective
	 * 
	 * @param index
	 *            the index of the image
	 */
	public void generateImagePerspectiveMVP(int index) {
		this.imgData = collectionImage.getImageList().get(index);

		listImgData.add(this.imgData);

		imgData.generateImageMVP();

		imgData.generatePerspectiveMVP(FIRST_VIEW);
		imgData.generatePerspectiveMVP(SECOND_VIEW);		
		
		viewActive = true;
	}

	// getter/setter
	public CollectionImage getCollectionImage() {
		return collectionImage;
	}

	public SwingPropertyChangeSupport getPropChangeFirer() {
		return propChangeFirer;
	}

	/**
	 * Close all views
	 */
	public void closeAllViews() {

		if (viewActive == true) {
			for (ImageData imageData : listImgData) {
				imageData.disposeAllViews();
			}
			listImgData.clear();
			viewActive = false;
		}
	}

}

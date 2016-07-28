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
Nom du fichier: PresenterImage.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package presenter;

import java.beans.PropertyChangeListener;

import javax.swing.event.SwingPropertyChangeSupport;

import model.ImageData;

//Cette classe a ete inspirer du site suivant:
//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing
public class PresenterImage {
	// Attributes
	private SwingPropertyChangeSupport propChangeFirer;
	private ImageData image;

	/**
	 * Constructor
	 * 
	 * @param image the image used in the presenter
	 */
	public PresenterImage(ImageData image) {
		this.image = image;
		propChangeFirer = new SwingPropertyChangeSupport(this);
	}

	/**
	 * Add a property change listener to a Swing Property Change Support
	 * 
	 * @param prop
	 *            the listener
	 */
	public void addListener(PropertyChangeListener prop) {
		propChangeFirer.addPropertyChangeListener(prop);
	}

	/**
	 * Fire a property change
	 */
	public void setImage() {
		// after executing this, the viewInterface will be notified that the new
		// address has been set. Its then the viewInterface
		// task to decide what to do when the address in the model has changed.
		// Ideally, the viewInterface will update the view about this
		propChangeFirer.firePropertyChange("setImage", -1, image);
	}
}

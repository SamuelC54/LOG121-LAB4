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
Nom du fichier: PresenterPerspective.java
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

import model.Perspective;
import model.VisualTransformState;
import model.memento.GestionnaireSauvegarde;

//Cette classe a ete inspirer du site suivant:
//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing
public class PresenterPerspective {
	// Attributes
	private SwingPropertyChangeSupport propChangeFirer;
	private Perspective perspective;
	private GestionnaireSauvegarde saves;

	/**
	 * Constructor
	 * 
	 * @param perspective
	 *            the perspective used in the presenter
	 */
	public PresenterPerspective(Perspective perspective) {
		this.perspective = perspective;

		propChangeFirer = new SwingPropertyChangeSupport(this);
	}

	/**
	 * Add a listener to the presenter
	 * 
	 * @param prop
	 *            the listener to add
	 */
	public void addListener(PropertyChangeListener prop) {
		propChangeFirer.addPropertyChangeListener(prop);
	}

	/**
	 * Adjust the zoom of the image
	 * 
	 * @param Delta
	 *            the value of zoom to adjust
	 */
	public void changeZoom(double Delta) {
		double initialZoom = perspective.getVtState().getZoomPercentage();

		perspective.getVtState().setZoomPercentage(initialZoom + Delta);

		setPerspective();
	}

	/**
	 * Adjust the translation of the image
	 * 
	 * @param DeltaX
	 *            adjust the x coordinate of the translation
	 * @param DeltaY
	 *            adjust the y coordinate of the translation
	 */
	public void changeTranslation(int DeltaX, int DeltaY) {
		int initialTX = perspective.getVtState().getHorizontalTranslation();
		int initialTY = perspective.getVtState().getVerticalTranslation();

		perspective.getVtState().setHorizontalTranslation(initialTX + DeltaX);
		perspective.getVtState().setVerticalTranslation(initialTY + DeltaY);

		setPerspective();
	}

	public GestionnaireSauvegarde getSaves() {
		return saves;
	}

	public void setSaves(GestionnaireSauvegarde saves) {
		this.saves = saves;
	}

	/**
	 * Reset the virtual state transform
	 */
	public void resetVTState() {
		if (perspective.getVtState() != null) {
			perspective.getVtState().reset();
		}

	}

	/**
	 * Save the perspective
	 */
	public void savePerspective() {
		saves.saveState(perspective.getVtState());
		propChangeFirer.firePropertyChange("savePerspective", -1, saves);
	}

	/**
	 * Get the current save state of the caretaker of saves
	 * 
	 * @return the current state
	 */
	public VisualTransformState getCurrentSaveSate() {
		return saves.getCurrentState();
	}

	/**
	 * Undo the last action
	 */
	public void undoAction() {
		setPerspective();
	}

	public Perspective getPerspective() {
		return this.perspective;
	}

	public void setPerspective() {
		// after executing this, the viewInterface will be notified that the new
		// address has been set. Its then the viewInterface
		// task to decide what to do when the address in the model has changed.
		// Ideally, the viewInterface will update the view about this
		propChangeFirer.firePropertyChange("setPerspective", -1, perspective);
	}
}

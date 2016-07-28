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
Nom du fichier: GestionnaireSauvegarde.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model.memento;

import java.util.ArrayList;
import java.util.List;

import model.VisualTransformState;

public class GestionnaireSauvegarde {

	private List<VisualTransformState> imageSavedState = new ArrayList<VisualTransformState>();
	private boolean removed = false;

	/**
	 * Save a memento state.
	 * 
	 * @param state
	 *            the desired state to save.
	 */
	public void saveState(VisualTransformState state) {
		VisualTransformState copyState = state.getCopy();
		imageSavedState.add(copyState);
		this.removed = false;
	}

	/**
	 * Get the size of the saved elements
	 * 
	 * @return the number of saved element in the list
	 */
	public int size() {
		return imageSavedState.size();
	}

	/**
	 * Get the curent state of the memento.
	 * 
	 * @return the current state.
	 */
	public VisualTransformState getCurrentState() {
		if (!imageSavedState.isEmpty()) {
			return imageSavedState.get(imageSavedState.size() - 1);
		}
		return null;
	}

	/**
	 * Get the previous state of the state
	 * 
	 * @return the previous state
	 */
	public VisualTransformState getPreviousState() {
		if (!this.removed) {
			imageSavedState.remove(imageSavedState.size() - 1);
			this.removed = true;
		}

		if (imageSavedState.size() == 1) {
			return imageSavedState.get(0);
		}

		return imageSavedState.remove(imageSavedState.size() - 1);
	}

	/**
	 * Check to see if there are some saves.
	 * 
	 * @return true if there are saves, false if it doesnt
	 */
	public boolean hasSaves() {
		return !imageSavedState.isEmpty();
	}

}

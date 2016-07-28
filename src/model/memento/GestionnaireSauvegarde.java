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
		System.out.println("Added" + imageSavedState.size());
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

	public VisualTransformState getPreviousState() {
		System.out.println(imageSavedState.size());
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

package model.memento;

import java.util.ArrayList;
import java.util.List;

import model.VisualTransformState;

public class GestionnaireSauvegarde {

	private List<VisualTransformState> imageSavedState = new ArrayList<VisualTransformState>();
	private int cursor = -1;

	/**
	 * Save a memento state.
	 * 
	 * @param state
	 *            the desired state to save.
	 */
	public void saveState(VisualTransformState state) {
		imageSavedState.add(state);
	}

	/**
	 * Get the curent state of the memento.
	 * 
	 * @return the current state.
	 */
	public VisualTransformState getCurrentState() {
		if (!imageSavedState.isEmpty()) {
			return imageSavedState.get(cursor+1);
		}
		return null;
	}

	public VisualTransformState getPreviousState() {
		if (cursor > 0) {
			cursor--;
		}
		
		return imageSavedState.get(cursor);
	}
	
	public VisualTransformState getNextState() {
		if (cursor + 1 < imageSavedState.size()) {
			cursor++;
		}
		return imageSavedState.get(cursor);
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

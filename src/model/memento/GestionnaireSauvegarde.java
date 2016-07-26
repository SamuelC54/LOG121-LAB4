package model.memento;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireSauvegarde {

	private List<StateMemento> mementoList = new ArrayList<StateMemento>();

	/**
	 * Save a memento state.
	 * 
	 * @param state the desired state to save.
	 */
	public void saveState(StateMemento state) {
		mementoList.add(state);
	}

	/**
	 * Get the desired state of the memento.
	 * 
	 * @param index the index of the state.
	 * @return the desired state.
	 */
	public StateMemento getState(int index) {
		return mementoList.get(index);
	}
}

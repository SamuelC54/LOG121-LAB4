package model.memento;

public class PerspectiveOriginator {

	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	/**
	 * Save the state to a memento.
	 * 
	 * @return
	 */
	public StateMemento saveStateToMemento() {
		return new StateMemento(state);
	}

	/**
	 * Get the current state of the memento.
	 * 
	 * @param Memento the memento save.
	 */
	public void getStateFromMemento(StateMemento memento) {
		state = memento.getState();
	}
}

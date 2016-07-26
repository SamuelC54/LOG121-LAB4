package model.memento;

public class StateMemento {

	private String state;

	/**
	 * Default constructor.
	 * 
	 * @param state
	 */
	public StateMemento(final String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}

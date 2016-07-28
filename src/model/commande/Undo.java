package model.commande;

import presenter.PresenterPerspective;

public class Undo implements Commande {

	PresenterPerspective presenterPerspective;
	
	public Undo (PresenterPerspective presenterPerspective) {
		this.presenterPerspective = presenterPerspective;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		presenterPerspective.undoAction();
	}

}

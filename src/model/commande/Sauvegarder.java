package model.commande;

import presenter.PresenterPerspective;

public class Sauvegarder implements Commande {

	private PresenterPerspective presenterPerspective;
	
	public Sauvegarder(PresenterPerspective aPresenterPerspective) {
		this.presenterPerspective = aPresenterPerspective;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		presenterPerspective.savePerspective();
	}

}

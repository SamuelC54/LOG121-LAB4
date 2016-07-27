package model.commande;

import java.awt.Point;
import java.awt.event.MouseEvent;

import presenter.PresenterPerspective;

public class Translation implements Commande {
	private PresenterPerspective presenter;
	private MouseEvent mouseEvent;
	private Point mouselocation;

	public Translation(PresenterPerspective presenter, MouseEvent mouseEvent, Point mouselocation) {
		this.presenter = presenter;
		this.mouseEvent = mouseEvent;
		this.mouselocation = mouselocation;
	}

	public void execute() {
		int translationHorizontal = (int) (mouselocation.getX() - mouseEvent.getX());
		int translationVertical = (int) (mouselocation.getY() - mouseEvent.getY());

		presenter.changeTranslation(-translationHorizontal, -translationVertical);
	}
}

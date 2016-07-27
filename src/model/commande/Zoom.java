package model.commande;

import java.awt.event.MouseWheelEvent;

import presenter.PresenterPerspective;

public class Zoom implements Commande {
	private PresenterPerspective presenter;
	private MouseWheelEvent mouseWheelEvent;

	public Zoom(PresenterPerspective presenter, MouseWheelEvent mouseWheelEvent) {
		this.presenter = presenter;
		this.mouseWheelEvent = mouseWheelEvent;
	}

	public void execute() {
		int wheelRotation = mouseWheelEvent.getWheelRotation();
		 double zoomPerScroll = 0.1;
		 
		 if(wheelRotation<0){
			 presenter.changeZoom(zoomPerScroll);
		 }else{
			 presenter.changeZoom(-zoomPerScroll);
		 }
	}
}

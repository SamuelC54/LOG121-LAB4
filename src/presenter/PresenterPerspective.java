//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package presenter;

import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;
import model.Perspective;

public class PresenterPerspective{
	//Attributes
	private SwingPropertyChangeSupport propChangeFirer;
	private Perspective perspective;
	//Methods
	public PresenterPerspective(Perspective perspective) {
		this.perspective = perspective;
        propChangeFirer = new SwingPropertyChangeSupport(this);
    }
	public void addListener(PropertyChangeListener prop) {
        propChangeFirer.addPropertyChangeListener(prop);
    }
	public void changeZoom(double Delta){
		double initialZoom = perspective.getVtState().getZoomPercentage();
		
		perspective.getVtState().setZoomPercentage(initialZoom + Delta);
		
		setPerspective();
	}
	public void changeTranslation(int DeltaX,int DeltaY){
		int initialTX = perspective.getVtState().getHorizontalTranslation();
		int initialTY = perspective.getVtState().getVerticalTranslation();
		
		perspective.getVtState().setHorizontalTranslation(initialTX + DeltaX);
		perspective.getVtState().setVerticalTranslation(initialTY + DeltaY);
		
		setPerspective();
	}
	
	public void savePerspective() {
		
	}
	public void undoAction() {
		//Undo action
	}
	
	public void setPerspective(){
        //after executing this, the viewInterface will be notified that the new address has been set. Its then the viewInterface
        //task to decide what to do when the address in the model has changed. Ideally, the viewInterface will update the view about this
        propChangeFirer.firePropertyChange("setPerspective", -1, perspective);
    }
}

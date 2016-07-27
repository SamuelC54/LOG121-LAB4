//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package presenter;

import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;
import model.Perspective;
import model.VisualTransformState;
import model.memento.GestionnaireSauvegarde;

public class PresenterPerspective{
	//Attributes
	private SwingPropertyChangeSupport propChangeFirer;
	private Perspective perspective;
	private GestionnaireSauvegarde saves;
	//Methods
	public PresenterPerspective(Perspective perspective, GestionnaireSauvegarde aSaves) {
		this.perspective = perspective;
		this.saves = aSaves;
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
	
	public GestionnaireSauvegarde getSaves() {
		return saves;
	}
	public void setSaves(GestionnaireSauvegarde saves) {
		this.saves = saves;
	}
	public void resetVTState() {
		if (perspective.getVtState() != null) {
			perspective.getVtState().reset();
		}
		
	}
	
	public void savePerspective() {
		saves.saveState(perspective.getVtState());
		propChangeFirer.firePropertyChange("savePerspective", -1, saves);
	}
	
	public VisualTransformState getCurrentSaveSate() {
		return saves.getCurrentState();
	}
	
	public void undoAction() {
		//Undo action
	}
	
	public Perspective getPerspective() {
		return this.perspective;
	}
	public void setPerspective(){
        //after executing this, the viewInterface will be notified that the new address has been set. Its then the viewInterface
        //task to decide what to do when the address in the model has changed. Ideally, the viewInterface will update the view about this
        propChangeFirer.firePropertyChange("setPerspective", -1, perspective);
    }
}

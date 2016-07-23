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
	
	public void setPerspective(){
        //after executing this, the viewInterface will be notified that the new address has been set. Its then the viewInterface
        //task to decide what to do when the address in the model has changed. Ideally, the viewInterface will update the view about this
        propChangeFirer.firePropertyChange("setPerspective", -1, perspective);
    }
}

//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package presenter;

import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

import model.ImageData;

public class PresenterImage{
	//Attributes
	private SwingPropertyChangeSupport propChangeFirer;
	private ImageData image;
	//Methods
	public PresenterImage(ImageData image) {
		this.image = image;
        propChangeFirer = new SwingPropertyChangeSupport(this);
    }
	
	/**
	 * Add a property change listener to a Swing Property Change Support
	 * 
	 * @param prop the listener
	 */
	public void addListener(PropertyChangeListener prop) {
        propChangeFirer.addPropertyChangeListener(prop);
    }
	
	/**
	 * Fire a property change
	 */
	public void setImage(){
        //after executing this, the viewInterface will be notified that the new address has been set. Its then the viewInterface
        //task to decide what to do when the address in the model has changed. Ideally, the viewInterface will update the view about this
        propChangeFirer.firePropertyChange("setImage", -1, image);
    }
}

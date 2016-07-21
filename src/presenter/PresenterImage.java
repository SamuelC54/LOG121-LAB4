//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package presenter;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class PresenterImage{
	//Attributes
	private SwingPropertyChangeSupport propChangeFirer;
	private BufferedImage image;
	//Methods
	public PresenterImage(BufferedImage image) {
		this.image = image;
        propChangeFirer = new SwingPropertyChangeSupport(this);
    }
	public void addListener(PropertyChangeListener prop) {
        propChangeFirer.addPropertyChangeListener(prop);
    }
	
	public void setImage(){
        //after executing this, the viewInterface will be notified that the new address has been set. Its then the viewInterface
        //task to decide what to do when the address in the model has changed. Ideally, the viewInterface will update the view about this
        propChangeFirer.firePropertyChange("setImage", -1, image);
    }
    
}

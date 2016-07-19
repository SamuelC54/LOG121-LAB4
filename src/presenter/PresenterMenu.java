package presenter;

import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing
public class PresenterMenu{
	private SwingPropertyChangeSupport propChangeFirer;
	private String variableX;
	
	public PresenterMenu() {
        propChangeFirer = new SwingPropertyChangeSupport(this);
    }
	public void addListener(PropertyChangeListener prop) {
        propChangeFirer.addPropertyChangeListener(prop);
    }
	public void setAddress(String address){
        String oldVal = this.variableX;
        this.variableX = address;

        //after executing this, the controller will be notified that the new address has been set. Its then the controller's
        //task to decide what to do when the address in the model has changed. Ideally, the controller will update the view about this
        propChangeFirer.firePropertyChange("variableX", oldVal, address);
    }
}

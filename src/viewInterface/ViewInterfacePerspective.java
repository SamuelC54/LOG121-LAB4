package viewInterface;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import model.ImageData;
import model.Perspective;
import presenter.PresenterPerspective;
import view.ViewPerspective;

public class ViewInterfacePerspective implements PropertyChangeListener{
	//Attributes
    private ViewPerspective view;
    private PresenterPerspective presenter;
    //Methods
    public ViewInterfacePerspective(ViewPerspective viewPerspective, PresenterPerspective presenterPerspective){
        this.view = viewPerspective;
        this.presenter = presenterPerspective;

        //register the controller as the listener of the model
        this.presenter.addListener(this);

        setUpViewInteraction();
        
        presenter.setPerspective();
    }
    private void setUpViewInteraction(){
    	view.getbCloseView().setAction(new AbstractAction("Close View") { 
            public void actionPerformed(ActionEvent arg0) {
            	view.dispose();
            }
        });
    }
    public void propertyChange(PropertyChangeEvent evt){
        String propName = evt.getPropertyName();
        Object newVal = evt.getNewValue();
        if("setPerspective".equalsIgnoreCase(propName)){
            view.setImageInPanel(((Perspective)newVal).getBufferedImage());
        }
    }
}

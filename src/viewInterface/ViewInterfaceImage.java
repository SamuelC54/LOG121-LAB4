package viewInterface;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import model.ImageData;
import presenter.PresenterImage;
import view.ViewImage;

public class ViewInterfaceImage implements PropertyChangeListener{
	//Attributes
    private ViewImage view;
    private PresenterImage presenter;
    //Methods
    public ViewInterfaceImage(ViewImage view, PresenterImage presenter){
        this.view = view;
        this.presenter = presenter;

        //register the controller as the listener of the model
        this.presenter.addListener(this);

        setUpViewInteraction();
        
        presenter.setImage();
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
        if("setImage".equalsIgnoreCase(propName)){
            view.setImageInPanel(((ImageData)newVal).getBufferedImage());
        }
    }
}

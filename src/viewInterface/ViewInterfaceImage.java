package viewInterface;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;

import model.CollectionImage;
import presenter.PresenterImage;
import presenter.PresenterMenu;
import view.ViewImage;
import view.ViewMenu;

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
            view.setImageInPanel((BufferedImage)newVal);
        }
    }
}

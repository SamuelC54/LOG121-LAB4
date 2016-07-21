//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package presenter;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.event.SwingPropertyChangeSupport;

import model.CollectionImage;
import view.ViewImage;
import view.ViewMenu;
import viewInterface.ViewInterfaceImage;
import viewInterface.ViewInterfaceMenu;

public class PresenterMenu{
	//Attributes
	private SwingPropertyChangeSupport propChangeFirer;
	private CollectionImage collectionImage = CollectionImage.getInstance();
	//Methods
	//presenter methods
	public PresenterMenu() {
        propChangeFirer = new SwingPropertyChangeSupport(this);
    }
	public void addListener(PropertyChangeListener prop) {
        propChangeFirer.addPropertyChangeListener(prop);
    }
	//
	public void loadCollectionImage(){
		File selectedFile = null;
		JFileChooser fileChooser = new JFileChooser("C:\\Users\\Sam\\Desktop\\LOG121\\Lab4");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	selectedFile = fileChooser.getSelectedFile();
        }
        
        collectionImage.loadFile(selectedFile);
        
        propChangeFirer.firePropertyChange("loadFile", 0, 1); //0,1 for simulating change
	}
	public void showImageView(int index){
		BufferedImage img = collectionImage.getImageList().get(index);
		
		ViewImage viewImage = new ViewImage();
        PresenterImage presenterImage = new PresenterImage(img);
        new ViewInterfaceImage(viewImage, presenterImage);
	}
	
	/**
	public void setAddress(String address){
        String oldVal = this.variableX;
        this.variableX = address;

        //after executing this, the viewInterface will be notified that the new address has been set. Its then the viewInterface
        //task to decide what to do when the address in the model has changed. Ideally, the viewInterface will update the view about this
        propChangeFirer.firePropertyChange("variableX", oldVal, address);
    }
    **/
}

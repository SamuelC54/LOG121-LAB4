//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package presenter;

import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.event.SwingPropertyChangeSupport;

import model.CollectionImage;
import model.ImageData;
import view.ViewImage;
import viewInterface.ViewInterfaceImage;

public class PresenterMenu{
	
	private final int FIRST_VIEW = 0;
	private final int SECOND_VIEW = 1;
	
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
	
	/**
	 * Load the collection of image
	 */
	public void loadCollectionImage(){
		File selectedFile = null;
		
		//http://stackoverflow.com/questions/22486230/how-to-change-jfilechooser-start-directory-to-desktop
		
		String currentFileName = System.getProperty("user.home");
		JFileChooser fileChooser = new JFileChooser(currentFileName + "/git/LOG121-LAB4/FolderImages");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		//-------------------------------------------------------------------------------------------------
		
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	selectedFile = fileChooser.getSelectedFile();
        }
        
        if (selectedFile != null) {
        	collectionImage.loadFile(selectedFile);
        }
        
        
        propChangeFirer.firePropertyChange("loadFile", 0, 1); //0,1 for simulating change
	}
	
	/**
	 * Generate an image perspective
	 * 
	 * @param index the index of the image
	 */
	public void generateImagePerspectiveMVP(int index){
		ImageData imgData = collectionImage.getImageList().get(index);
		
		imgData.generateImageMVP();
        
        imgData.generatePerspectiveMVP(FIRST_VIEW);
        imgData.generatePerspectiveMVP(SECOND_VIEW);
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

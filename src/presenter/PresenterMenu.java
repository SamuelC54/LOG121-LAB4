//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package presenter;

import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;
import model.CollectionImage;
import model.ImageData;

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
	//getter/setter
	public CollectionImage getCollectionImage() {
		return collectionImage;
	}
	public SwingPropertyChangeSupport getPropChangeFirer() {
		return propChangeFirer;
	}
	
}

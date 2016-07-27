package model.commande;

import java.io.File;

import javax.swing.JFileChooser;

import presenter.PresenterMenu;

public class Load implements Commande {
	PresenterMenu presenter = new PresenterMenu();
	
	public Load(PresenterMenu presenter) {
		this.presenter = presenter;
	}

	/**
	 * Load the collection of image
	 */
	public void execute() {
		File selectedFile = null;
		
		//http://stackoverflow.com/questions/22486230/how-to-change-jfilechooser-start-directory-to-desktop
		
		String currentFileName = System.getProperty("user.dir");
		JFileChooser fileChooser = new JFileChooser(currentFileName + "/FolderImages");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		//-------------------------------------------------------------------------------------------------
		
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	selectedFile = fileChooser.getSelectedFile();
        }
        
        if (selectedFile != null) {
        	presenter.getCollectionImage().loadFile(selectedFile);
        }
        
        
        presenter.getPropChangeFirer().firePropertyChange("loadFile", 0, 1); //0,1 for simulating change
	}
}

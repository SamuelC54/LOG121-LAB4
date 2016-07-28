/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  01
Projet: Laboratoire #4
Étudiant(e)s: 
              Philippe Torres-Brisebois
              Laurent Theroux-Bombardier
              Samuel Croteau
              Nelson Chao
Professeur : Francis Cardinal
Nom du fichier: Load.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model.commande;

import java.io.File;

import javax.swing.JFileChooser;

import presenter.PresenterMenu;

public class Load implements Commande {
	PresenterMenu presenter = new PresenterMenu();
	
	/**
	 * Constructor
	 * 
	 * @param presenter the presenter used in the command
	 */
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

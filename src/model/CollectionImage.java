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
Nom du fichier: CollectionImage.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Cette classe a ete inspirer du site suivant:
//http://stackoverflow.com/questions/11300847/load-and-display-all-the-images-from-a-folder
public class CollectionImage {
	// Attributes
	private static CollectionImage instance = null;
	private File fileDirectory;
	private ArrayList<ImageData> imageList = new ArrayList<ImageData>();
	private ArrayList<File> fileList = new ArrayList<File>();

	/**
	 * Constructor used for the singleton
	 */
	private CollectionImage() {
		// to block constructor
	}

	/**
	 * Get the instance of the class
	 * 
	 * @return an instance of the class
	 */
	public static CollectionImage getInstance() {
		if (instance == null) {
			instance = new CollectionImage();
		}
		return instance;
	}

	public void loadFile(File fileSelected) {
		this.fileDirectory = fileSelected;

		this.clearAll();
		int count = 0;
		for (File f : fileDirectory.listFiles()) {
			BufferedImage img = null;

			try {
				img = ImageIO.read(f);
				imageList.add(new ImageData(img, f.getName()));
				fileList.add(f);

			} catch (final IOException e) {
			}
		}
	}

	/**
	 * Empty all list
	 */
	public void clearAll() {
		imageList.clear();
		fileList.clear();
	}

	// getter/setter
	public ArrayList<File> getFileList() {
		return fileList;
	}

	public ArrayList<ImageData> getImageList() {
		return imageList;
	}
}

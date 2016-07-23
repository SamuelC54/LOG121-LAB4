package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//singleton
public class CollectionImage {
	//Attributes
	private static CollectionImage instance = null;
	private File fileDirectory;
	private ArrayList<ImageData> imageList = new ArrayList<ImageData>();
	private ArrayList<File> fileList = new ArrayList<File>();
	//Method
	//singleton
	private CollectionImage(){
		//to block constructor
	}
	public static CollectionImage getInstance() {
		if (instance == null) {
			instance = new CollectionImage();
		}
		return instance;
	}
	//-
	//inspired by http://stackoverflow.com/questions/11300847/load-and-display-all-the-images-from-a-folder
	public void loadFile(File fileSelected){
		this.fileDirectory = fileSelected;
		
		this.clearAll();
		
		for (File f : fileDirectory.listFiles()) {
            BufferedImage img = null;

            try {
                img = ImageIO.read(f);
                imageList.add(new ImageData(img));
                fileList.add(f);
                // you probably want something more involved here
                // to display in your UI
                //System.out.println("image: " + f.getName());
                //System.out.println(" width : " + img.getWidth());
                //System.out.println(" height: " + img.getHeight());
                //System.out.println(" size  : " + f.length());
            } catch (final IOException e) {
                // handle errors here
            }
        }
	}
	public void clearAll(){
		imageList.clear();
		fileList.clear();
	}
	//getter/setter
	public ArrayList<File> getFileList(){
		return fileList;
	}
	public ArrayList<ImageData> getImageList(){
		return imageList;
	}
}

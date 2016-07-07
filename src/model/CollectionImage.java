package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class CollectionImage {
	private File fileDirectory;
	private ArrayList<Image> imageCollection;
	
	public CollectionImage(String fileLocation) {
		imageCollection = new ArrayList<Image>();
		fileDirectory = new File(fileLocation);
	}
	
	//inspired by http://stackoverflow.com/questions/11300847/load-and-display-all-the-images-from-a-folder
	public void loadFile(){
		for (File f : fileDirectory.listFiles()) {
            BufferedImage img = null;

            try {
                img = ImageIO.read(f);

                // you probably want something more involved here
                // to display in your UI
                System.out.println("image: " + f.getName());
                System.out.println(" width : " + img.getWidth());
                System.out.println(" height: " + img.getHeight());
                System.out.println(" size  : " + f.length());
            } catch (final IOException e) {
                // handle errors here
            }
        }
	}
}

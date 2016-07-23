package model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import presenter.PresenterImage;
import presenter.PresenterPerspective;
import view.ViewImage;
import view.ViewPerspective;
import viewInterface.ViewInterfaceImage;
import viewInterface.ViewInterfacePerspective;

public class ImageData {
	BufferedImage bufferedImage;
	ImageIcon imageIcon;
	Perspective[] perspective = new Perspective[2];
	//Methods
	public ImageData(BufferedImage img){
		this.bufferedImage = img;
		//image Icon
		imageIcon = new ImageIcon(bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		//Perspectives
		perspective[0] = new Perspective(img);
		perspective[1] = new Perspective(img);
	}
	public void generatePerspectiveMVP(int perspectiveIndex){
		ViewPerspective viewPerspective = new ViewPerspective(perspectiveIndex);
        PresenterPerspective  presenterPerspective = new PresenterPerspective(perspective[perspectiveIndex]);
        new ViewInterfacePerspective(viewPerspective, presenterPerspective);
	}
	public void generateImageMVP(){
		ViewImage viewImage = new ViewImage();
        PresenterImage presenterImage = new PresenterImage(this);
        new ViewInterfaceImage(viewImage, presenterImage);
	}
	//getter/setter
	public BufferedImage getBufferedImage(){
		return bufferedImage;
	}
	public ImageIcon getImageIcon(){
		return imageIcon;
	}
}

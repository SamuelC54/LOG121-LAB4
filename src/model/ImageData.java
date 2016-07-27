package model;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

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
	String name;
	Perspective[] perspective = new Perspective[2];
	ViewImage viewImage;
	List<ViewPerspective> viewPerspectives = new ArrayList<ViewPerspective>();

	// Methods
	public ImageData(BufferedImage img, String imgName) {
		this.bufferedImage = img;
		this.name = imgName;
		// image Icon
		imageIcon = new ImageIcon(bufferedImage.getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		// Perspectives
		perspective[0] = new Perspective(img);
		perspective[1] = new Perspective(img);
	}

	public void generatePerspectiveMVP(int perspectiveIndex) {
		ViewPerspective viewPerspective = new ViewPerspective(perspectiveIndex);

		viewPerspectives.add(viewPerspective);

		PresenterPerspective presenterPerspective = new PresenterPerspective(perspective[perspectiveIndex]);
		new ViewInterfacePerspective(viewPerspective, presenterPerspective);
	}

	public void generateImageMVP() {
		this.viewImage = new ViewImage();
		PresenterImage presenterImage = new PresenterImage(this);
		new ViewInterfaceImage(viewImage, presenterImage);
	}

	/**
	 * Dispose all the current image and perspectives views
	 */
	public void disposeAllViews() {

		this.viewImage.dispose();

		for (ViewPerspective viewPerspect : this.viewPerspectives) {
			viewPerspect.dispatchEvent(new WindowEvent(viewPerspect, WindowEvent.WINDOW_CLOSING));
		}
		viewPerspectives.clear();
	}

	// getter/setter
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	
	public String getName() {
		return name;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}
	public Perspective getPerspective(int index){
		return perspective[index];
	}
}

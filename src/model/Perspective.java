package model;

import java.awt.image.BufferedImage;

public class Perspective {
	BufferedImage bufferedImage;
	VisualTransformState vtState = new VisualTransformState();
	
	public Perspective(BufferedImage img){
		this.bufferedImage = img;
	}
	//getter/setter
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
	public VisualTransformState getVtState() {
		return vtState;
	}
	public void setVtState(VisualTransformState vtState) {
		this.vtState = vtState;
	}
	
}

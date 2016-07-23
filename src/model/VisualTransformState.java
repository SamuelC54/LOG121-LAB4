package model;

public class VisualTransformState {
	//attributes
	private int horizontalTranslation;
	private int verticalTranslation;
	private double zoomPercentage;
	//Methods
	public VisualTransformState(){
		this.horizontalTranslation = 0;
		this.verticalTranslation = 0;
		this.zoomPercentage = 1;
	}
	//getter/setter
	public int getHorizontalTranslation() {
		return horizontalTranslation;
	}
	public void setHorizontalTranslation(int horizontalTranslation) {
		this.horizontalTranslation = horizontalTranslation;
	}
	public int getVerticalTranslation() {
		return verticalTranslation;
	}
	public void setVerticalTranslation(int verticalTranslation) {
		this.verticalTranslation = verticalTranslation;
	}
	public double getZoomPercentage() {
		return zoomPercentage;
	}
	public void setZoomPercentage(double zoomPercentage) {
		this.zoomPercentage = zoomPercentage;
	}
}

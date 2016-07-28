package model;

public class VisualTransformState implements Cloneable{
	//attributes
	private int horizontalTranslation;
	private int verticalTranslation;
	private double zoomPercentage;
	//Methods
	public VisualTransformState(){
		reset();
	}

	public VisualTransformState getCopy() {
		try {
			return (VisualTransformState) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	
	public void reset() {
		this.horizontalTranslation = 0;
		this.verticalTranslation = 0;
		this.zoomPercentage = 1;
	}
}

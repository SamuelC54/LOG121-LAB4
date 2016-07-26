//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Perspective;
import model.VisualTransformState;

public class ViewPerspective extends JFrame{
	//Constants
	//Attributes
	private JPanel panneauPrincipal;
	private ImagePanel imagePanel;
	private JButton bCloseView;
	//Method
	public ViewPerspective(int index) {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		panneauPrincipal = (JPanel)this.getContentPane();
		
		imagePanel = new ImagePanel();
		bCloseView = new JButton();
		
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
		
		imagePanel.setAlignmentX(CENTER_ALIGNMENT);
		bCloseView.setAlignmentX(CENTER_ALIGNMENT);
		
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0,20)));
		panneauPrincipal.add(imagePanel);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0,10)));
		panneauPrincipal.add(bCloseView);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0,10)));
		
		this.setSize(new Dimension(400,600));
		if(index==0){
			this.setLocation((int)(screenDimension.width/1.75)-this.getSize().width/2, screenDimension.height/2-this.getSize().height/2);
		}else{
			this.setLocation((int)(screenDimension.width/1.25)-this.getSize().width/2, screenDimension.height/2-this.getSize().height/2);
		}
        setResizable(false);
        setTitle("View Persective " + index);
        setVisible(true);
	}
	//
	public void setPerspectiveInPanel(Perspective perspective) {
		imagePanel.setPerspective(perspective);
	}
	//getter/setter
	public JButton getbCloseView() {
		return bCloseView;
	}
	public ImagePanel getImagePanel() {
		return imagePanel;
	}
	public JPanel getPanneauPrincipal() {
		return panneauPrincipal;
	}

	//private class
	public class ImagePanel extends JPanel{
		private Perspective perspective;
		private int newImageWidth;
		private int newImageHeight;
		
		protected void paintComponent(Graphics g) {
			BufferedImage image = perspective.getBufferedImage();
			VisualTransformState vtState = perspective.getVtState();
			
			newImageWidth = (int) (image.getWidth() * vtState.getZoomPercentage());
			newImageHeight = (int) (image.getHeight() * vtState.getZoomPercentage());
			int horizontalTranslation = vtState.getHorizontalTranslation();
			int verticalTranslation = vtState.getVerticalTranslation();
			
	        super.paintComponent(g);
	        g.drawImage(image, horizontalTranslation, verticalTranslation, newImageWidth , newImageHeight , null);   
	    }
		public void setPerspective(Perspective perspective){
			this.perspective = perspective;
		}
		public int getNewImageWidth() {
			return newImageWidth;
		}
		public int getNewImageHeight() {
			return newImageHeight;
		}
		
	}
}

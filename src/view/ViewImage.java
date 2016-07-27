//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.ImageData;
import model.Perspective;

public class ViewImage extends JFrame{
	//Constants
	//Attributes
	private JPanel panneauPrincipal;
	private viewImageImagePanel imagePanel;
	private JButton bCloseView;
	//Method
	public ViewImage() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		panneauPrincipal = (JPanel)this.getContentPane();
		
		imagePanel = new viewImageImagePanel();
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
		this.setLocation(screenDimension.width/10-this.getSize().width/2, screenDimension.height/2-this.getSize().height/2);
        setResizable(false);
        setTitle("View Image");
        setVisible(true);
	}
	/**
	 * Set an image in a panel
	 * 
	 * @param image the desired image
	 */
	public void setImageInPanel(ImageData image) {
		imagePanel.setImage(image);
		this.setSize(new Dimension(image.getBufferedImage().getWidth(),image.getBufferedImage().getHeight()));
		if(this.getWidth() > 1000){
			this.setSize(1000, this.getHeight());
		}
		if(this.getHeight() > 1000){
			this.setSize(this.getWidth(),1000);
		}
	}
	//getter/setter
	public JButton getbCloseView() {
		return bCloseView;
	}
	//private class
	private class viewImageImagePanel extends JPanel{
		private ImageData image;
		
		protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image.getBufferedImage(), 0, 0, null);     
	        g.setColor(Color.GREEN);
	        Perspective perspective0 = image.getPerspective(0);
	        int x = perspective0.getVtState().getHorizontalTranslation();
	        int y = perspective0.getVtState().getVerticalTranslation();
	        double zoom = perspective0.getVtState().getZoomPercentage();
	        int width = (int) (perspective0.getBufferedImage().getWidth() * zoom);
	        int height = (int) (perspective0.getBufferedImage().getHeight() * zoom);
	        
	        g.drawRect(x, y, width, height);
	    }
		
		public void setImage(ImageData image){
			this.image = image;
		}
	}
}

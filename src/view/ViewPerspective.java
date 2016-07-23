//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	public void setImageInPanel(BufferedImage image) {
		imagePanel.setImage(image);
	}
	//getter/setter
	public JButton getbCloseView() {
		return bCloseView;
	}
	//private class
	private class ImagePanel extends JPanel{
		private BufferedImage image;
		
		protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, null);        
	    }
		
		public void setImage(BufferedImage image){
			this.image = image;
		}
	}
}

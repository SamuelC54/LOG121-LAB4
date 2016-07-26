package viewInterface;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.event.MouseInputAdapter;

import model.Perspective;
import presenter.PresenterPerspective;
import view.ViewPerspective;

public class ViewInterfacePerspective implements PropertyChangeListener{
	//Attributes
    private ViewPerspective view;
    private PresenterPerspective presenter;
    
    private int mouseX;
    private int mouseY;
    //Methods
    public ViewInterfacePerspective(ViewPerspective viewPerspective, PresenterPerspective presenterPerspective){
        this.view = viewPerspective;
        this.presenter = presenterPerspective;

        //register the controller as the listener of the model
        this.presenter.addListener(this);

        setUpViewInteraction();
        
        presenter.setPerspective();
    }
    private void setUpViewInteraction(){
    	view.getbCloseView().setAction(new AbstractAction("Close View") { 
            public void actionPerformed(ActionEvent arg0) {
            	view.dispose();
            }
        });
    	view.getImagePanel().addMouseWheelListener(new MouseAdapter () { 
    		 public void mouseWheelMoved(MouseWheelEvent e) {
    			 int wheelRotation = e.getWheelRotation();
    			 double zoomPerScroll = 0.1;
    			 
    			 if(wheelRotation<0){
    				 presenter.changeZoom(zoomPerScroll);
    				 
    				 double translateScale = zoomPerScroll;
    				 int translationX = (int) (-view.getImagePanel().getNewImageWidth()/2*translateScale);
        			 int translationY = (int) (-view.getImagePanel().getNewImageHeight()/2*translateScale);

        			 //presenter.changeTranslation(translationX, translationY);
    			 }else{
    				 presenter.changeZoom(-zoomPerScroll);
    				 
    				 int translationX = e.getX()-view.getPanneauPrincipal().getWidth()/2;
        			 int translationY = e.getY()-view.getPanneauPrincipal().getHeight()/2;
        			 double translateScale = -zoomPerScroll;
        			 //presenter.changeTranslation((int)(translationX*translateScale), (int)(translationY*translateScale));
    			 }
    			 
    			 view.repaint();
    		 }
        });
    	view.getImagePanel().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		view.getImagePanel().addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				int translationHorizontal = mouseX - e.getX();
				int translationVertical = mouseY - e.getY();

				presenter.changeTranslation(-translationHorizontal, -translationVertical);
				
				mouseX = e.getX();
				mouseY = e.getY();
				
				view.repaint();
			}
		});
    }
    public void propertyChange(PropertyChangeEvent evt){
        String propName = evt.getPropertyName();
        Object newVal = evt.getNewValue();
        if("setPerspective".equalsIgnoreCase(propName)){
            view.setPerspectiveInPanel(((Perspective)newVal));
        }
    }
}

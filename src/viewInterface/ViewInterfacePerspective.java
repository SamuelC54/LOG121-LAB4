package viewInterface;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.event.MouseInputAdapter;

import model.Perspective;
import model.commande.Close;
import model.commande.GestionnaireCommande;
import model.commande.Translation;
import model.commande.Zoom;
import presenter.PresenterPerspective;
import view.ViewPerspective;

public class ViewInterfacePerspective implements PropertyChangeListener{
	//Attributes
    private ViewPerspective view;
    private PresenterPerspective presenter;
    
    private Point mouseLocation;
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
            	GestionnaireCommande gestCmd = new GestionnaireCommande();
            	
            	gestCmd.add(new Close(view));
            	gestCmd.executeAll();
            }
        });
    	view.getImagePanel().addMouseWheelListener(new MouseAdapter () { 
    		 public void mouseWheelMoved(MouseWheelEvent event) {
    			 GestionnaireCommande gestCmd = new GestionnaireCommande();
             	
    			 gestCmd.add(new Zoom(presenter,event));
    			 gestCmd.executeAll();
             	
    			 view.repaint();
    		 }
        });
    	view.getImagePanel().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseLocation.setLocation(e.getX(), e.getY());
			}
		});
		view.getImagePanel().addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent event) {
				GestionnaireCommande gestCmd = new GestionnaireCommande();
             	
   			 	gestCmd.add(new Translation(presenter,event,mouseLocation));
   			 	gestCmd.executeAll();
				
   			 	mouseLocation.setLocation(event.getX(), event.getY());
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

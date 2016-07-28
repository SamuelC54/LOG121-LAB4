/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  01
Projet: Laboratoire #4
Étudiant(e)s: 
              Philippe Torres-Brisebois
              Laurent Theroux-Bombardier
              Samuel Croteau
              Nelson Chao
Professeur : Francis Cardinal
Nom du fichier: ViewInterfaceImage.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/
package viewInterface;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import model.ImageData;
import model.commande.Close;
import model.commande.GestionnaireCommande;
import presenter.PresenterImage;
import view.ViewImage;

public class ViewInterfaceImage implements PropertyChangeListener{
	//Attributes
    private ViewImage view;
    private PresenterImage presenter;
    private GestionnaireCommande gestCmd  = GestionnaireCommande.getInstance();
    //Methods
    public ViewInterfaceImage(ViewImage view, PresenterImage presenter){
        this.view = view;
        this.presenter = presenter;

        //register the controller as the listener of the model
        this.presenter.addListener(this);

        setUpViewInteraction();
        
        presenter.setImage();
    }
    /**
     * Setup the interaction for the view
     */
    private void setUpViewInteraction(){
    	view.getbCloseView().setAction(new AbstractAction("Close View") { 
            public void actionPerformed(ActionEvent arg0) {
            	
            	gestCmd.add(new Close(view));
            	gestCmd.executeAll();
            }
        });
    }
    /**
     * Detect and do action corresponding to the event
     */
    public void propertyChange(PropertyChangeEvent evt){
        String propName = evt.getPropertyName();
        Object newVal = evt.getNewValue();
        if("setImage".equalsIgnoreCase(propName)){
            view.setImageInPanel(((ImageData)newVal));
        }
    }
}

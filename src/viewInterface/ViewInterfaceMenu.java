//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package viewInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JLabel;

import model.CollectionImage;
import model.ImageData;
import model.commande.Close;
import model.commande.GestionnaireCommande;
import model.commande.Load;
import presenter.PresenterMenu;
import view.ViewMenu;

public class ViewInterfaceMenu implements PropertyChangeListener {
	// Attributes
	private ViewMenu viewMenu;
	private PresenterMenu presenterMenu;

	// Methods
	public ViewInterfaceMenu(ViewMenu view, PresenterMenu presenter) {
		this.viewMenu = view;
		this.presenterMenu = presenter;

		// register the controller as the listener of the model
		this.presenterMenu.addListener(this);

        setUpViewInteraction();
    }
    private void setUpViewInteraction(){
    	viewMenu.getbLoadFile().setAction(new AbstractAction("Choose Folder") { 
            public void actionPerformed(ActionEvent arg0) {
            	GestionnaireCommande gestCmd = new GestionnaireCommande();
            	
            	gestCmd.add(new Load(presenterMenu));
            	gestCmd.executeAll();
            }
        });
        
    	viewMenu.getbOpenImage().setAction(new AbstractAction("Open Image") { 
            public void actionPerformed(ActionEvent arg0) {
            	presenterMenu.generateImagePerspectiveMVP(viewMenu.getSelectedListIndex());
            }
        });
        
        viewMenu.getbCloseViews().setAction(new AbstractAction("Close Views") {
			public void actionPerformed(ActionEvent arg0) {
				presenterMenu.closeAllViews();
			}
		});
    }



	public void propertyChange(PropertyChangeEvent evt) {
		String propName = evt.getPropertyName();

		if ("loadFile".equalsIgnoreCase(propName)) {
			CollectionImage c = CollectionImage.getInstance();
			DefaultListModel<JLabel> listModel = viewMenu.getListModel();
			listModel.clear();
			
			for (ImageData imgdata : c.getImageList()) {
				JLabel label = new JLabel();
				label.setIcon((Icon) imgdata.getImageIcon());
				label.setText(imgdata.getName());
				
				listModel.addElement(label);
			}
		}
	}

}
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
Nom du fichier: ViewInterfaceMenu.java
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
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JLabel;

import model.CollectionImage;
import model.ImageData;
import model.commande.GestionnaireCommande;
import model.commande.Load;
import presenter.PresenterMenu;
import view.ViewMenu;

//Cette classe a ete inspirer du site suivant
//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing
public class ViewInterfaceMenu implements PropertyChangeListener {
	// Attributes
	private ViewMenu viewMenu;
	private PresenterMenu presenterMenu;
	private GestionnaireCommande gestCmd = GestionnaireCommande.getInstance();

	// Methods
	public ViewInterfaceMenu(ViewMenu view, PresenterMenu presenter) {
		this.viewMenu = view;
		this.presenterMenu = presenter;

		// register the controller as the listener of the model
		this.presenterMenu.addListener(this);

		setUpViewInteraction();
	}

	/**
	 * Setup the view interaction for the view
	 */
	private void setUpViewInteraction() {
		viewMenu.getbLoadFile().setAction(new AbstractAction("Choose Folder") {
			public void actionPerformed(ActionEvent arg0) {

				gestCmd.add(new Load(presenterMenu));
				gestCmd.executeAll();
			}
		});

		viewMenu.getbOpenImage().setAction(new AbstractAction("Open Image") {
			public void actionPerformed(ActionEvent arg0) {
				if (viewMenu.getSelectedListIndex() > -1) {
					presenterMenu.generateImagePerspectiveMVP(viewMenu.getSelectedListIndex());
				}
			}
		});

		viewMenu.getbCloseViews().setAction(new AbstractAction("Close Views") {
			public void actionPerformed(ActionEvent arg0) {
				presenterMenu.closeAllViews();
			}
		});
	}

	//Read a command from an event
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
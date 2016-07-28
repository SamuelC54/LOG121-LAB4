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
Nom du fichier: ViewInterfacePerspective.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/
package viewInterface;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import model.Perspective;
import model.commande.Close;
import model.commande.GestionnaireCommande;
import model.commande.Sauvegarder;
import model.commande.Translation;
import model.commande.Undo;
import model.commande.Zoom;
import model.memento.GestionnaireSauvegarde;
import presenter.PresenterPerspective;
import view.ViewImage;
import view.ViewPerspective;

public class ViewInterfacePerspective implements PropertyChangeListener {
	// Attributes
	private ViewPerspective viewPerspective;
	private PresenterPerspective presenterPerspective;
	private GestionnaireCommande gestCmd = GestionnaireCommande.getInstance();
	private Point mouseLocation = new Point();
	private GestionnaireSauvegarde listActions = new GestionnaireSauvegarde();
	private ViewImage viewImage;

	/**
	 * Constructor
	 * 
	 * @param viewPerspective the view of the interface
	 * @param presenterPerspective the presenter of the interface
	 * @param viewImage the view image used in this interface
	 */
	public ViewInterfacePerspective(ViewPerspective viewPerspective, PresenterPerspective presenterPerspective,
			ViewImage viewImage) {
		this.viewPerspective = viewPerspective;
		this.presenterPerspective = presenterPerspective;
		this.viewImage = viewImage;

		listActions.saveState(presenterPerspective.getPerspective().getVtState());
		// register the controller as the listener of the model
		this.presenterPerspective.addListener(this);
		this.viewPerspective.addListener(this);

		setUpViewInteraction();

		presenterPerspective.setPerspective();
	}

	/**
	 * Setup the view interaction
	 */
	private void setUpViewInteraction() {
		viewPerspective.getbSave().setAction(new AbstractAction("Save") {
			public void actionPerformed(ActionEvent arg0) {
				// Save
				gestCmd.add(new Sauvegarder(presenterPerspective));
				gestCmd.executeAll();
			}
		});
		viewPerspective.getbUndo().setAction(new AbstractAction("Undo") {
			public void actionPerformed(ActionEvent arg0) {
				// Undo
				presenterPerspective.getPerspective().setVtState(listActions.getPreviousState());
				presenterPerspective.setPerspective();
				gestCmd.add(new Undo(presenterPerspective));
				gestCmd.executeAll();

				viewPerspective.repaint();
			}
		});
		viewPerspective.getbCloseView().setAction(new AbstractAction("Close View") {
			public void actionPerformed(ActionEvent arg0) {

				gestCmd.add(new Close(viewPerspective));
				gestCmd.executeAll();
			}
		});
		viewPerspective.getImagePanel().addMouseWheelListener(new MouseAdapter() {
			public void mouseWheelMoved(MouseWheelEvent event) {

				listActions.saveState(presenterPerspective.getPerspective().getVtState());
				gestCmd.add(new Zoom(presenterPerspective, event));
				gestCmd.executeAll();

				viewPerspective.repaint();
				viewImage.repaint();
			}
		});
		viewPerspective.getImagePanel().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseLocation.setLocation(e.getX(), e.getY());
			}

			public void mouseReleased(MouseEvent e) {
				listActions.saveState(presenterPerspective.getPerspective().getVtState());
			}
		});
		viewPerspective.getImagePanel().addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent event) {

				gestCmd.add(new Translation(presenterPerspective, event, mouseLocation));
				gestCmd.executeAll();

				mouseLocation.setLocation(event.getX(), event.getY());
				viewPerspective.repaint();
				viewImage.repaint();
			}
		});
	}

	/**
	 * Detect and do action corresponding to the event
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String propName = evt.getPropertyName();
		Object newVal = evt.getNewValue();
		if ("setPerspective".equalsIgnoreCase(propName)) {
			viewPerspective.setPerspectiveInPanel(((Perspective) newVal));
		}
		if ("resetPerspective".equalsIgnoreCase(propName)) {

			if (presenterPerspective.getSaves().hasSaves()) {
				presenterPerspective.getPerspective().setVtState(presenterPerspective.getSaves().getCurrentState());
			} else {
				presenterPerspective.resetVTState();
			}

		}

	}
}

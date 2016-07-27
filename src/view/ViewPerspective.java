//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Perspective;

public class ViewPerspective extends JFrame {
	// Constants
	// Attributes
	private JPanel panneauPrincipal;
	private ImagePanel imagePanel;
	private JButton bCloseView;
	private JButton bSave;
	private JButton bUndo;

	// Method
	public ViewPerspective(int index) {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		panneauPrincipal = (JPanel) this.getContentPane();

		imagePanel = new ImagePanel();
		bCloseView = new JButton();
		bSave = new JButton();
		bUndo = new JButton();

		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));

		imagePanel.setAlignmentX(CENTER_ALIGNMENT);
		bCloseView.setAlignmentX(CENTER_ALIGNMENT);
		bSave.setAlignmentX(CENTER_ALIGNMENT);
		bUndo.setAlignmentX(CENTER_ALIGNMENT);

		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
		panneauPrincipal.add(imagePanel);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
		panneauPrincipal.add(bSave);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
		panneauPrincipal.add(bUndo);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
		panneauPrincipal.add(bCloseView);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));

		this.setSize(new Dimension(400, 600));
		if (index == 0) {
			this.setLocation((int) (screenDimension.width / 1.75) - this.getSize().width / 2,
					screenDimension.height / 2 - this.getSize().height / 2);
		} else {
			this.setLocation((int) (screenDimension.width / 1.25) - this.getSize().width / 2,
					screenDimension.height / 2 - this.getSize().height / 2);
		}
		setResizable(false);
		setTitle("View Persective " + (index + 1));
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				//Reset
				
			}
		});
	}

	//
	public void setPerspectiveInPanel(Perspective perspective) {
		imagePanel.setPerspective(perspective);
	}

	// getter/setter
	public JButton getbCloseView() {
		return bCloseView;
	}

	public ImagePanel getImagePanel() {
		return imagePanel;
	}

	public JButton getbSave() {
		return bSave;
	}

	public JButton getbUndo() {
		return bUndo;
	}

	public JPanel getPanneauPrincipal() {
		return panneauPrincipal;
	}
}

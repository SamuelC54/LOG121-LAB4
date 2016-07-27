//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ViewMenu extends JFrame {
	// Constants
	// Attributes
	private JPanel panneauPrincipal;
	private JButton bLoadFile;
	private JButton bOpenImage;
	private JButton bCloseViews;
	private JList<JLabel> listImages;
	private DefaultListModel<JLabel> listModel;
	private JScrollPane scrollPane;

	// Method
	public ViewMenu() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		panneauPrincipal = (JPanel) this.getContentPane();

		listModel = new DefaultListModel<JLabel>();
		listImages = new JList<JLabel>(listModel);
		scrollPane = new JScrollPane(listImages);
		bLoadFile = new JButton();
		bOpenImage = new JButton();
		bCloseViews = new JButton();

		listImages.setCellRenderer(new CustomCellRenderer());
		
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));

		bLoadFile.setAlignmentX(CENTER_ALIGNMENT);
		scrollPane.setAlignmentX(CENTER_ALIGNMENT);
		bOpenImage.setAlignmentX(CENTER_ALIGNMENT);
		bCloseViews.setAlignmentX(CENTER_ALIGNMENT);

		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
		panneauPrincipal.add(scrollPane);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
		panneauPrincipal.add(bLoadFile);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
		panneauPrincipal.add(bOpenImage);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
		panneauPrincipal.add(bCloseViews);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));

		this.setSize(new Dimension(600, 600));
		this.setLocation(screenDimension.width / 2 - this.getSize().width / 2,
				screenDimension.height / 2 - this.getSize().height / 2);
		setResizable(false);
		setTitle("View Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// getter/setter
	public JButton getbLoadFile() {
		return bLoadFile;
	}

	public JButton getbOpenImage() {
		return bOpenImage;
	}

	public JButton getbCloseViews() {
		return bCloseViews;
	}

	public DefaultListModel<JLabel> getListModel() {
		return this.listModel;
	}

	public int getSelectedListIndex() {
		return listImages.getSelectedIndex();
	}
}

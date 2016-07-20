//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ViewMenu extends JFrame{
	//Constants
	//Attributes
	private JPanel panneauPrincipal;
	protected JButton bLoadFile;
	protected JButton bOpenImage;
	private JList<String> ListImages;
	private DefaultListModel<String> listModel;
	private JScrollPane scrollPane;
	//Method
	public ViewMenu() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		panneauPrincipal = (JPanel)this.getContentPane();
		
		listModel = new DefaultListModel<String>();
		ListImages = new JList<String>(listModel);
		scrollPane = new JScrollPane(ListImages);
		bLoadFile = new JButton();
		bOpenImage = new JButton();
		
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
		
		bLoadFile.setAlignmentX(CENTER_ALIGNMENT);
		scrollPane.setAlignmentX(CENTER_ALIGNMENT);
		bOpenImage.setAlignmentX(CENTER_ALIGNMENT);
		
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0,20)));
		panneauPrincipal.add(scrollPane);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0,10)));
		panneauPrincipal.add(bLoadFile);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0,10)));
		panneauPrincipal.add(bOpenImage);
		panneauPrincipal.add(Box.createRigidArea(new Dimension(0,10)));
		
		this.setSize(new Dimension(400,600));
		this.setLocation(screenDimension.width/2-this.getSize().width/2, screenDimension.height/2-this.getSize().height/2);
        setResizable(false);
        setTitle("View Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	//getter/setter
	public JButton getbLoadFile() {
		return bLoadFile;
	}
	public JButton getbOpenImage() {
		return bOpenImage;
	}
	public DefaultListModel<String> getListModel(){
		return this.listModel;
	}
}

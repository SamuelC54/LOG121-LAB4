package model.commande;

import javax.swing.JFrame;

public class Close implements Commande {
	private JFrame frame;
	
	public Close(JFrame frame){
		this.frame = frame;
	}

	public void execute() {
		frame.dispose();
	}
}

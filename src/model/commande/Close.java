package model.commande;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Close implements Commande {
	private JFrame frame;
	
	public Close(JFrame frame){
		this.frame = frame;
	}

	public void execute() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}

package view;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CustomCellRenderer extends JLabel implements ListCellRenderer {
	 
	
	//http://esus.com/how-do-i-create-a-jlist-with-icons-and-text/
	   
	    public Component getListCellRendererComponent(JList list, Object value,
	                                                  int index, boolean isSelected,
	                                                  boolean cellHasFocus) {
	   
	    	JLabel label = (JLabel) value;
	   
	       setText(label.getText());
	       setIcon(label.getIcon());
	    
	       if (isSelected) {
	          setBackground(list.getSelectionBackground());
	          setForeground(list.getSelectionForeground());
	       }
	       else {
	          setBackground(list.getBackground());
	          setForeground(list.getForeground());
	       }
	   
	       setEnabled(list.isEnabled());
	       setFont(list.getFont());
	       setOpaque(true);
	   
	       return this;
	    }
}

//MVP inspirer de Bnrdo - http://stackoverflow.com/questions/5217611/the-mvc-pattern-and-swing

package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import presenter.PresenterMenu;
import view.ViewMenu;

public class ControllerMenu implements PropertyChangeListener{

    private ViewMenu view;
    private PresenterMenu model;

    public ControllerMenu(ViewMenu view, PresenterMenu model){
        this.view = view;
        this.model = model;

        //register the controller as the listener of the model
        this.model.addListener(this);

        setUpViewInteraction();
    }

    private void setUpViewInteraction(){
        view.getbLoadFile().setAction(new AbstractAction("Load") { 
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("LOAD!");
            }
        });
    }

    public void propertyChange(PropertyChangeEvent evt){
        String propName = evt.getPropertyName();
        Object newVal = evt.getNewValue();

        if("variableX".equalsIgnoreCase(propName)){
            //view.getVariableX().setText((String)newVal);
        }
    }
}
package controllers;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficController implements PropertyChangeListener {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return pcs;
    }

    public void propertyChange(PropertyChangeEvent event) {
        System.out.println("Traffic control detected change in: " + event.getPropertyName() +
                ": " + event.getNewValue());
    }

}

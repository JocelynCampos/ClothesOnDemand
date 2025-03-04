package controllers;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrafficController implements PropertyChangeListener {
     public void propertyChange(PropertyChangeEvent event) {
         System.out.println("Traffic control detected in: " + event.getPropertyName() + ": " + event.getNewValue());
     }

}

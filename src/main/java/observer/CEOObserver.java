package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observer;

public class CEOObserver implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "GarmentInProduction" -> System.out.println("CEO: Production started - " + evt.getNewValue());
            case "GarmentProduced" -> System.out.println("CEO: Production finished - " + evt.getNewValue());
            default -> System.out.println("CEO: Unknown property " + evt.getPropertyName());
        }
    }

}

package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observer;

public class CEOObserver implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("Order Created")) {
            System.out.println(" *** ORDER INFORMATION *** ");
        }

        switch (evt.getPropertyName()) {
            case "Placed Order" -> System.out.println("Production started - " + evt.getNewValue());
            case "Finished Order" -> System.out.println("Production finished - " + evt.getNewValue());
            default -> System.out.println("Unknown property " + evt.getPropertyName());
        }
    }

}

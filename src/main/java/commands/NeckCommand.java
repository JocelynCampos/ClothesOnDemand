package commands;

import enums.Neck;
import interfaces.GarmentCommand;
import interfaces.TshirtOptions;
import models.Garments;
import org.jetbrains.annotations.Nullable;

import java.beans.PropertyChangeSupport;

//For T-Shirt
public class NeckCommand implements GarmentCommand {
    private final Neck neck;
    private PropertyChangeSupport pcs;

    public NeckCommand(Neck neck, @Nullable PropertyChangeSupport pcs) {
        this.neck = neck;
        this.pcs = pcs;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof TshirtOptions tshirtOptions) {
            tshirtOptions.setNeck(neck);
            garment.printAttribute("Neck", neck);
            if (pcs != null) {
                pcs.firePropertyChange("GarmentInProduction", null, garment);
            }
        }
    }
}

package commands;

import enums.Fit;
import interfaces.GarmentCommand;
import interfaces.PantsOptions;
import models.Garments;
import org.jetbrains.annotations.Nullable;

import java.beans.PropertyChangeSupport;

//For Pants
public class FitCommand implements GarmentCommand {
    private final Fit fit;
    private final PropertyChangeSupport pcs;

    public FitCommand(Fit fit, @Nullable PropertyChangeSupport pcs) {
        this.fit = fit;
        this.pcs = pcs;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof PantsOptions pantsOptions) {
            if (pcs != null) {
                pcs.firePropertyChange("GarmentInProduction", null, garment);
            }
            pantsOptions.setFit(fit);
            garment.printAttribute("Fit", fit);
            if (pcs != null) {
                pcs.firePropertyChange("GarmentProduced", null, garment);
            }
        }
    }

}

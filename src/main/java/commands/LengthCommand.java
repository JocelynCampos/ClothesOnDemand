package commands;

import enums.Fit;
import enums.Length;
import interfaces.GarmentCommand;
import interfaces.PantsOptions;
import models.Garments;
import org.jetbrains.annotations.Nullable;

import java.beans.PropertyChangeSupport;

//For Pants
public class LengthCommand implements GarmentCommand {
    private final Length length;
    private final PropertyChangeSupport pcs;

    public LengthCommand(Length length, @Nullable PropertyChangeSupport pcs) {
        this.length = length;
        this.pcs = pcs;
    }
    @Override
    public void execute(Garments garment) {

        if (garment instanceof PantsOptions pantsOptions) {
            if (pcs != null) {
                pcs.firePropertyChange("GarmentInProduction", null, garment);
            }

            pantsOptions.setLength(length);
            garment.printAttribute("Length", length);
            if (pcs != null) {
                pcs.firePropertyChange("GarmentProduced", null, garment);
            }
        }
    }
}

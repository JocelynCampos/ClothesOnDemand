package commands;

import enums.Waistline;
import interfaces.GarmentCommand;
import interfaces.SkirtOptions;
import models.Garments;
import org.jetbrains.annotations.Nullable;

import java.beans.PropertyChangeSupport;

//For Skirt
public class WaistlineCommand implements GarmentCommand {

    private final Waistline waistline;
    private final PropertyChangeSupport pcs;

    public WaistlineCommand(Waistline waistline, @Nullable PropertyChangeSupport pcs) {
        this.waistline = waistline;
        this.pcs = pcs;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof SkirtOptions skirtOptions) {
            if (pcs != null) {
                pcs.firePropertyChange("GarmentInProduction", null, garment);
            }
            skirtOptions.setWaistline(waistline);
            garment.printAttribute("Waistline", waistline);
            if (pcs != null) {
                pcs.firePropertyChange("GarmentProduced", null, garment);
            }
        }
    }
}

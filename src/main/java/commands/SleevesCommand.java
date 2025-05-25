package commands;

import enums.Sleeves;
import interfaces.GarmentCommand;
import interfaces.TshirtOptions;
import models.Garments;
import org.jetbrains.annotations.Nullable;

import java.beans.PropertyChangeSupport;

//For T-Shirt
public class SleevesCommand implements GarmentCommand {
    private final Sleeves sleeves;
    private final PropertyChangeSupport pcs;

    public SleevesCommand(Sleeves sleeves, @Nullable PropertyChangeSupport pcs) {
        this.sleeves = sleeves;
        this.pcs = pcs;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof TshirtOptions tshirtOptions) {
            tshirtOptions.setSleeves(sleeves);
            garment.printAttribute("Sleeves", sleeves);
            if (pcs != null) {
                pcs.firePropertyChange("GarmentProduced", null, garment);
            }
        }
    }
}

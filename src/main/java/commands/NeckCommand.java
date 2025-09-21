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

    public NeckCommand(Neck neck) {
        this.neck = neck;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof TshirtOptions tshirtOptions) {
           tshirtOptions.setNeck(neck);
        }
    }
}

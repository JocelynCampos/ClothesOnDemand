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

    public LengthCommand(Length length) {
        this.length = length;
    }
    @Override
    public void execute(Garments garment) {

        if (garment instanceof PantsOptions pantsOptions) {
            pantsOptions.setLength(length);
        }
    }
}

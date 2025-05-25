package commands;

import enums.Pattern;
import interfaces.GarmentCommand;
import interfaces.SkirtOptions;
import models.Garments;
import org.jetbrains.annotations.Nullable;

import java.beans.PropertyChangeSupport;

//For Skirt
public class PatternCommand implements GarmentCommand {
    private final Pattern pattern;
    private final PropertyChangeSupport pcs;

    public PatternCommand(Pattern pattern, @Nullable PropertyChangeSupport pcs) {
        this.pattern = pattern;
        this.pcs = pcs;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof SkirtOptions skirtOptions) {
            skirtOptions.setPattern(pattern);
            garment.printAttribute("Pattern", pattern);
            if (pcs != null) {
                pcs.firePropertyChange("GarmentInProduction", null, garment);
            }
        }
    }
}

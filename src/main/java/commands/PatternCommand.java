package commands;

import enums.Pattern;
import interfaces.SkirtOptions;
import models.Garments;

//For Skirt
public class PatternCommand {
    private final Pattern pattern;

    public PatternCommand(Pattern pattern) {
        this.pattern = pattern;
    }
    public void execute(Garments garments) {
        if (garments instanceof SkirtOptions skirtOptions) {
            skirtOptions.setPattern(pattern);
            garments.printAttribute("Pattern", pattern);
        }
    }
}

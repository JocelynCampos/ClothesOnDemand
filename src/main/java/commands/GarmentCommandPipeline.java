package commands;

import interfaces.GarmentCommand;
import models.Garments;

import java.util.ArrayList;
import java.util.List;

public class GarmentCommandPipeline {
    private final List<GarmentCommand> commands = new ArrayList<>();

    public void addCommand(GarmentCommand command) {
        this.commands.add(command);
    }

    public void executeAll(Garments garments) {
        for (GarmentCommand command : commands) {
            command.execute(garments);
        }
    }

    public void clear() {
        commands.clear();
    }

}

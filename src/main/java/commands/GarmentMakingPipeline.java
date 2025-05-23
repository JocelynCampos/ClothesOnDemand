package commands;

import interfaces.GarmentCommand;

import java.util.List;

public class GarmentMakingPipeline {
    private final List<GarmentCommand> commandPipeline = new List<>() {
    };

    public void addCommand(GarmentCommand command) {
        commandPipeline.add(command);
    }

    }
}

package commandsAndInstructions;

import robs.Rob;
import simulation.*;

public interface InstructionInterface {
    void applyCommand(Rob rob, World world);
}

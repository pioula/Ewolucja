package commandsAndInstructions;

import robs.Rob;
import simulation.World;

public abstract class Instruction{
    public abstract void applyCommand(Rob rob, World world);
}

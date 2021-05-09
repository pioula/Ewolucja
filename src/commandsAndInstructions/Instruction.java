package commandsAndInstructions;

import robs.Rob;
import simulation.World;

public abstract class Instruction{
    public abstract void applyInstruction(Rob rob, World world);

    @Override
    public abstract String toString();
}

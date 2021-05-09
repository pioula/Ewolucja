package commandsAndInstructions;

import robs.Directions;
import robs.Rob;
import simulation.World;

public class InstructionLeft extends Instruction {
    private static InstructionLeft INSTANCE = new InstructionLeft();

    private InstructionLeft() {}

    public static InstructionLeft getInstance() {
        return INSTANCE;
    }

    @Override
    public void applyInstruction(Rob rob, World world) {
        rob.setDirection(Directions.LEFT);
        rob.useEnergyForInstruction();
    }

    @Override
    public String toString() {
        return "l";
    }
}

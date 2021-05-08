package commandsAndInstructions;

import robs.Directions;
import robs.Rob;
import simulation.World;

public class InstructionRight extends Instruction {
    private static InstructionRight INSTANCE = new InstructionRight();

    private InstructionRight() {};

    public static InstructionRight getInstance() {
        return INSTANCE;
    }

    @Override
    public void applyInstruction(Rob rob, World world) {
        rob.setDirection(Directions.RIGHT);
        rob.useEnergyForInstruction();
    }
}

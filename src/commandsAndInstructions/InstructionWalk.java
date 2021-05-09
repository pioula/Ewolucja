package commandsAndInstructions;

import robs.Rob;
import simulation.World;

public class InstructionWalk extends Instruction {
    private static InstructionWalk INSTANCE = new InstructionWalk();

    private InstructionWalk() {};

    public static InstructionWalk getInstance() {
        return INSTANCE;
    }

    @Override
    public void applyInstruction(Rob rob, World world) {
        switch(rob.getDirection()) {
            case UP -> {
                if (rob.eatFood(
                        world.getBoard().getField(rob.getPosition().getRow() - 1, rob.getPosition().getCol()))) {
                            world.getBoard().remFoodField();
                        }
            }
            case DOWN -> {
                if (rob.eatFood(
                        world.getBoard().getField(rob.getPosition().getRow() + 1, rob.getPosition().getCol()))) {
                    world.getBoard().remFoodField();
                }
            }
            case LEFT -> {
                if(rob.eatFood(
                    world.getBoard().getField(rob.getPosition().getRow(), rob.getPosition().getCol() - 1))) {
                    world.getBoard().remFoodField();
                }
            }
            case RIGHT -> {
                if(rob.eatFood(
                        world.getBoard().getField(rob.getPosition().getRow(), rob.getPosition().getCol() + 1))) {
                    world.getBoard().remFoodField();
                }
            }
        }

        rob.useEnergyForInstruction();
    }
}

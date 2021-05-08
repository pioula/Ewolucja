package commandsAndInstructions;

import simulation.World;

public class Command {
    protected final Commands command;
    protected final Parameter parameter;

    public Command(Commands command, Parameter parameter) {
        this.command = command;
        this.parameter = parameter;
    }

    public void applyCommand(World world) {
        switch (command) {
            case NR_ROUNDS -> world.setNrRounds(parameter.getIntParam());
            case BOARD_SIZE_X -> world.getBoard().setNumberOfCols(parameter.getIntParam());
            case BOARD_SIZE_Y -> world.getBoard().setNumberOfRows(parameter.getIntParam());
            case BEGIN_ENERGY -> world.setBeginEnergy(parameter.getIntParam());
            case BEGIN_NR_ROBS -> world.createRobs(parameter.getIntParam());
            case BEGIN_PROGR -> world.setBaseProgram(parameter.getEnumParam());
            case FOOD_QUALITY -> world.getBoard().setFoodQuality(parameter.getIntParam());
            case FOOD_GROWTH -> world.getBoard().setFoodGrowth(parameter.getIntParam());
            case ROUND_COST -> world.setRoundCost(parameter.getIntParam());
            case PROB_MULTIPLY -> world.setProbMultiply(parameter.getDoubleParam());
            case PART_OF_PARENT_ENERGY -> world.setPartOfParentEnergy(parameter.getDoubleParam());
            case MULTIPLY_LIMIT -> world.setMultiplyLimit(parameter.getIntParam());
            case PROB_REM_COMMAND -> world.setProbRem(parameter.getDoubleParam());
            case PROB_ADD_COMMAND -> world.setProbAdd(parameter.getDoubleParam());
            case INSTRUCTIONS -> world.setInstructions(parameter.getEnumParam());
            case PROB_CHANGE_COMMAND -> world.setProbChangeCommand(parameter.getDoubleParam());
            case OUTPUT_FREQ -> world.setOutputFreq(parameter.getIntParam());
        }
    }

    public Commands getCommand() {
        return command;
    }
}

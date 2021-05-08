package simulation;

import board.Board;
import commandsAndInstructions.*;
import robs.Rob;

import java.util.ArrayList;
import java.util.Comparator;

public class World {
    private static final int numberOfCommands = 14;
    private int nrRounds, roundCost, multiplyLimit, outputFreq, beginEnergy;
    private double probMultiply, partOfParentEnergy, probRem, probAdd, probChangeCommand;
    private final Board board;
    private final ArrayList<Command> commands;
    private ArrayList<Instruction> baseProgram, instructions;
    private ArrayList<Rob> robs;

    private static boolean areCommandsCorrect(ArrayList<Command> commands) {
        commands.sort(Comparator.comparing(o -> o.getCommand().toString()));

        int commandsSize = commands.size();
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getCommand() == Commands.BOARD_SIZE_X ||
                commands.get(i).getCommand() == Commands.BOARD_SIZE_Y) {
                commandsSize--;
            }
            else if (i + 1 < commands.size() &&
                    commands.get(i).getCommand() == commands.get(i+1).getCommand()) {
                return false;
            }
        }

        return commandsSize == numberOfCommands;
    }

    public World(Board board, ArrayList<Command> commands) {
        assert areCommandsCorrect(commands) : "ERROR WRONG COMMANDS!";
        this.board = board;
        this.commands = commands;
    }

    public void createRobs(int numberOfRobs) {

    }

    public void setBeginEnergy(int beginEnergy) {
        this.beginEnergy = beginEnergy;
    }

    public void setNrRounds(int nrRounds) {
        this.nrRounds = nrRounds;
    }

    public void setBaseProgram(ArrayList<Instruction> baseProgram) {
        this.baseProgram = baseProgram;
    }

    public void setRoundCost(int roundCost) {
        this.roundCost = roundCost;
    }

    public void setProbMultiply(double probMultiply) {
        this.probMultiply = probMultiply;
    }

    public void setPartOfParentEnergy(double partOfParentEnergy) {
        this.partOfParentEnergy = partOfParentEnergy;
    }

    public void setMultiplyLimit(int multiplyLimit) {
        this.multiplyLimit = multiplyLimit;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void setOutputFreq(int outputFreq) {
        this.outputFreq = outputFreq;
    }

    public void setProbAdd(double probAdd) {
        this.probAdd = probAdd;
    }

    public void setProbRem(double probRem) {
        this.probRem = probRem;
    }

    public void setProbChangeCommand(double probChangeCommand) {
        this.probChangeCommand = probChangeCommand;
    }

    public Board getBoard() {
        return board;
    }
}

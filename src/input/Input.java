package input;

import board.Board;
import commandsAndInstructions.Command;
import commandsAndInstructions.Commands;
import commandsAndInstructions.Instructions;
import commandsAndInstructions.Parameter;
import simulation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private static final int numberOfCommands = 17;
    private static final Pattern boardPattern = Pattern.compile("^[ x]+$");

    private Pattern[] patterns;
    private Map<String, Commands> commands;
    private Map<Character, Instructions> instructions;

    public Input() {
        patterns = new Pattern[numberOfCommands];
        commands = new HashMap<String, Commands>();
        instructions = new HashMap<Character, Instructions>();
        Init.inputInit(patterns, commands, instructions);
    }

    private Board readBoard(String boardPath) {
        try {
            Scanner sc = new Scanner(new File(boardPath));

            int numberOfCols = 0;
            ArrayList<String> rows = new ArrayList<String>();

            while(sc.hasNextLine()) {
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter("\n");
                String row = lineSc.next();

                assert !(row.length() == 0 ||
                        !boardPattern.matcher(row).matches() ||
                        (row.length() != numberOfCols && numberOfCols != 0)) : "ERROR WRONG BOARD!";

                numberOfCols = row.length();
                rows.add(row);
            }

            sc.close();
            return new Board(rows);
        }
        catch (FileNotFoundException e) {
            assert false : "ERROR BOARD NOT FOUND";
            return null;
        }
    }

    private ArrayList<Instructions> recognizeInstructions(String instructionsString) {
        ArrayList<Instructions> instructionList = new ArrayList<Instructions>();
        for (int i = 0; i < instructionsString.length(); i++) {
            Instructions instr = instructions.get(instructionsString.charAt(i));

            assert instr != null : "ERROR WRONG INSTRUCTIONS!";

            instructionList.add(instr);
        }
        return instructionList;
    }

    private ArrayList<Command> readParameters(String parametersPath) {
        try {
            Scanner sc = new Scanner(new File(parametersPath));

            ArrayList<Command> commandLines = new ArrayList<Command>();

            while(sc.hasNextLine()) {
                Scanner isCorrect = new Scanner(sc.nextLine());
                isCorrect.useDelimiter("\n");
                String commandLine = isCorrect.next();
                boolean matched = false;

                for (Pattern pattern : patterns) {
                    matched |= pattern.matcher(commandLine).matches();
                }

                assert matched : "ERROR WRONG COMMAND!";

                Scanner lineSc = new Scanner(commandLine);
                lineSc.useDelimiter(" ");

                Commands command = commands.get(lineSc.next());
                Parameter arg = null;

                if (lineSc.hasNext())
                    arg = new Parameter(recognizeInstructions(lineSc.next()));

                if (lineSc.hasNextDouble())
                    arg = new Parameter(lineSc.nextDouble());

                if (lineSc.hasNextInt())
                    arg = new Parameter(lineSc.nextInt());

                if (arg == null)
                    return null;

                commandLines.add(new Command(command, arg));
            }

            sc.close();
            return commandLines;
        }
        catch (FileNotFoundException e) {
            assert false : "ERROR COMMAND NOT FOUND!";
            return null;
        }
    }

    public World readInput(String boardPath, String parametersPath) {
        Board board = readBoard(boardPath);
        if (board == null)
            return null;

        ArrayList<Command> parameters = readParameters(parametersPath);
        if (parameters == null)
            return null;

        return new World(board, parameters);
    }
}

package input;

import commandsAndInstructions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static commandsAndInstructions.Commands.*;

public abstract class Init {
    private static void patternsInit(Pattern[] patterns) throws Exception {
        File file = new File("./patterns/commands_patterns.txt");
        try {
            Scanner sc = new Scanner(file);
            int patternCounter = 0;

            while(sc.hasNextLine()) {
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter("\n");
                patterns[patternCounter] = Pattern.compile(lineSc.next());
                patternCounter++;
            }

            sc.close();
        }
        catch (FileNotFoundException e) {
            throw new Exception("commands_patterns.txt not found!");
        }
    }

    private static void mapCommandsInit(Map<String, Commands> commands) {
        commands.put("ile_tur", NR_ROUNDS);
        commands.put("rozmiar_planszy_x", BOARD_SIZE_X);
        commands.put("rozmiar_planszy_y", BOARD_SIZE_Y);
        commands.put("pocz_ile_robów", BEGIN_NR_ROBS);
        commands.put("pocz_progr", BEGIN_PROGR);
        commands.put("pocz_energia", BEGIN_ENERGY);
        commands.put("ile_daje_jedzenie", FOOD_QUALITY);
        commands.put("ile_rośnie_jedzenie", FOOD_GROWTH);
        commands.put("koszt_tury", ROUND_COST);
        commands.put("pr_powielenia", PROB_MULTIPLY);
        commands.put("ułamek_energii_rodzica", PART_OF_PARENT_ENERGY);
        commands.put("limit_powielenia", MULTIPLY_LIMIT);
        commands.put("pr_usunięcia_instr", PROB_REM_COMMAND);
        commands.put("pr_dodania_instr", PROB_ADD_COMMAND);
        commands.put("pr_zmiany_instr", PROB_CHANGE_COMMAND);
        commands.put("spis_instr", INSTRUCTIONS);
        commands.put("co_ile_wypisz", OUTPUT_FREQ);
    }

    private static void mapInstructionsInit(Map<Character, Instruction> instructions) {
        instructions.put('l', InstructionLeft.getInstance());
        instructions.put('p', InstructionRight.getInstance());
        instructions.put('i', InstructionWalk.getInstance());
        instructions.put('j', InstructionEat.getInstance());
        instructions.put('w', InstructionSniff.getInstance());
    }

    protected static void inputInit(Pattern[] patterns,
                                  Map<String, Commands> commands,
                                  Map<Character, Instruction> instructions) throws Exception{
        patternsInit(patterns);
        mapCommandsInit(commands);
        mapInstructionsInit(instructions);
    }
}

package input;

import commandsAndInstructions.Commands;
import commandsAndInstructions.Instructions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static commandsAndInstructions.Commands.*;
import static commandsAndInstructions.Instructions.*;

public abstract class Init {
    private static void patternsInit(Pattern[] patterns) {
        File file = new File("./patterns/commands_patterns.txt");
        try {
            Scanner sc = new Scanner(file);
            int patternCounter = 0;

            while(sc.hasNextLine()) {
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter("\n");
                patterns[patternCounter] = Pattern.compile(lineSc.next());
            }

            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR commands_patterns.txt NOT FOUND");
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

    private static void mapInstructionsInit(Map<Character, Instructions> instructions) {
        instructions.put('l', LEFT);
        instructions.put('r', RIGHT);
        instructions.put('i', WALK);
        instructions.put('j', EAT);
        instructions.put('w', SNIFF);
    }

    protected static void inputInit(Pattern[] patterns,
                                  Map<String, Commands> commands,
                                  Map<Character, Instructions> instructions) {
        patternsInit(patterns);
        mapCommandsInit(commands);
        mapInstructionsInit(instructions);
    }
}

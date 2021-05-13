import input.*;
import simulation.World;

public class Symulacja {
    public static void main(String[] args) throws Exception {
        Input input = new Input();
        World world = input.readInput(args[0], args[1]);
        world.simulation();
    }
}

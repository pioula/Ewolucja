package board;

public interface FieldInterface {
    boolean isThereFood();

    void eatFood(int foodGrowth);

    void nextRound();
}

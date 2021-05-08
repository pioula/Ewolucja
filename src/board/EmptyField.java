package board;

public class EmptyField extends Field{
    public EmptyField(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isThereFood() {
        return false;
    }

    @Override
    public void nextRound() {}

    @Override
    public void eatFood(int foodGrowth) {
        assert false : "THERE IS NO FOOD!";
    }
}
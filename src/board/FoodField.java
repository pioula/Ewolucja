package board;

import simulation.World;

public class FoodField extends Field{
    private int timeToGrowFood;

    public FoodField(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isThereFood() {
        return timeToGrowFood == 0;
    }

    @Override
    public void nextRound() {
        timeToGrowFood = Math.max(0, timeToGrowFood - 1);
    }

    @Override
    public void eatFood(int foodGrowth) {
        assert timeToGrowFood != 0 : "THERE IS NO FOOD YET!";
        timeToGrowFood = foodGrowth;
    }

}

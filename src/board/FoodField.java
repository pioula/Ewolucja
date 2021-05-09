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
    public boolean nextRound() {
        if (timeToGrowFood - 1 == 0) {
            timeToGrowFood = 0;
            return true;
        }
        else {
            timeToGrowFood = Math.max(0, timeToGrowFood - 1);
            return false;
        }
    }

    @Override
    public void clearFood() {
        assert timeToGrowFood != 0 : "THERE IS NO FOOD YET!";
        timeToGrowFood = foodGrowth;
    }

}

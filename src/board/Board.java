package board;

import robs.Directions;

import java.util.ArrayList;

public class Board {
    private final int numberOfCols;
    private final int numberOfRows;
    private final Field[][] board;
    private int numberOfFoodFields;

    public Board(ArrayList<String> rows) {
        numberOfCols = rows.get(0).length();
        numberOfRows = rows.size();
        board = new Field[numberOfRows][numberOfCols];
        numberOfFoodFields = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                if (rows.get(i).charAt(j) == 'x') {
                    board[i][j] = new FoodField(i, j);
                    numberOfFoodFields++;
                }
                else {
                    board[i][j] = new EmptyField(i, j);
                }
            }
        }
    }

    public void remFoodField() {
        numberOfFoodFields--;
    }

    public int getNumberOfFoodFields() {
        return numberOfFoodFields;
    }

    public void nextRound() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                if (board[i][j].nextRound())
                    numberOfFoodFields++;
            }
        }
    }

    public Field findFood(Field p) {
        if (getField(p.getRow() + 1, p.getCol() + 1).isThereFood())
            return getField(p.getRow() + 1, p.getCol() + 1);

        if (getField(p.getRow() + 1, p.getCol()).isThereFood())
            return getField(p.getRow() + 1, p.getCol());

        if (getField(p.getRow(), p.getCol() + 1).isThereFood())
            return getField(p.getRow(), p.getCol() + 1);

        if (getField(p.getRow() - 1, p.getCol() + 1).isThereFood())
            return getField(p.getRow() - 1, p.getCol() + 1);

        if (getField(p.getRow() - 1, p.getCol()).isThereFood())
            return getField(p.getRow() - 1, p.getCol());

        if (getField(p.getRow() + 1, p.getCol() - 1).isThereFood())
            return getField(p.getRow() + 1, p.getCol() - 1);

        if (getField(p.getRow(), p.getCol() - 1).isThereFood())
            return getField(p.getRow(), p.getCol() - 1);

        if (getField(p.getRow() - 1, p.getCol() - 1).isThereFood())
            return getField(p.getRow() - 1, p.getCol() - 1);

        return new EmptyField(-1, -1); //There is no food anywhere nearby
    }

    public Directions findFoodCross(Field p) {
        if (getField(p.getRow() + 1, p.getCol()).isThereFood())
            return Directions.DOWN;

        if (getField(p.getRow() - 1, p.getCol()).isThereFood())
            return Directions.UP;

        if (getField(p.getRow(), p.getCol() + 1).isThereFood())
            return Directions.RIGHT;

        if (getField(p.getRow(), p.getCol() - 1).isThereFood())
            return Directions.LEFT;

        return null;
    }

    public void setFoodQuality(int foodQuality) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                board[i][j].setFoodQuality(foodQuality);
            }
        }
    }

    public void setFoodGrowth(int foodGrowth) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                board[i][j].setFoodGrowth(foodGrowth);
            }
        }
    }

    public void setNumberOfCols(int numberOfCols) {
        assert numberOfCols == this.numberOfCols : "WRONG BOARD SIZE X";
    }

    public void setNumberOfRows(int numberOfRows) {
        assert numberOfRows == this.numberOfRows : "WRONG BOARD SIZE X";
    }

    public Field getField(int row, int col) {
        row = row % numberOfRows;
        col = col % numberOfCols;
        return board[row][col];
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfCols() {
        return numberOfCols;
    }
}

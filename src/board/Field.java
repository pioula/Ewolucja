package board;

public abstract class Field implements FieldInterface{
    protected int col;
    protected int row;

    public Field(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

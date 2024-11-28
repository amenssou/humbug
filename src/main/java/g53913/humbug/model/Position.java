
package g53913.humbug.model;

/**
 * Position on the board. The row and column of a square.
 *
 * @author aymanmensso
 */
public class Position {

    private final int row;
    private final int column;

    /**
     * Constructor of a Position on board.
     *
     * @param row the row on the board
     * @param column the column on the board
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter of row.
     *
     * @return row of Position
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter of column.
     *
     * @return column of Position
     */
    public int getColumn() {
        return column;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.row;
        hash = 29 * hash + this.column;
        return hash;
    }

    /**
     * Compares the current object with an object "obj".
     *
     * @param obj an object
     * @return true if the 2 objects are equals, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string of the position(row and column)
     *
     * @return a string of the position
     */
    @Override
    public String toString() {
        return "Position{" + "row=" + row + ", column=" + column + '}';
    }
    /**
     * moves to the next position 
     * @param direction an enum 
     * @return the next position of the animal
     */
    public Position next(Direction direction) {
        int deltaRow = direction.getDeltaRow();
        int deltaColumn = direction.getDeltaColumn();
        return new Position(row+deltaRow,column+deltaColumn);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbug.model;

/**
 *
 * @author aymanmensso
 */
public enum Direction {
    /**
     * Cardinal points, move of the animals.
     */
    NORTH(-1, 0), SOUTH(1, 0), EAST(0, 1), WEST(0, -1);

    private int deltaRow;
    private int deltaColumn;

    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }
    
    
    /**
     * Getter of deltaRow.
     *
     * @return deltaRow
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Getter of deltaColumn.
     *
     * @return deltaColumn
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    
    /**
     * returns the opposite of a direction
     * @return the opposite of a direction 
     */
    public Direction opposite(){
        if (this.equals(NORTH)){
            return this.SOUTH;
        }
        if (this.equals(SOUTH)){
            return this.NORTH;
        }
        if (this.equals(WEST)){
            return this.EAST;
        }
        if (this.equals(EAST)){
            return this.WEST;
        }
        return null;

    }
    
    

    

}

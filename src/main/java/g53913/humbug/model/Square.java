package g53913.humbug.model;

/**
 *
 * @author aymanmensso
 */
/**
 * Square on the board. A square has a type grass or star and it's all. A square
 * doesn't know where it is on the board.
 *
 * @author aymanmensso
 */
public class Square {

    private SquareType type;
    private boolean northWall;
    private boolean southWall;
    private boolean westWall;
    private boolean eastWall;

    /**
     * Constructor of Square on board.
     *
     * @param type Square is grass or star
     */
    public Square(SquareType type) {
        this.type = type;
        this.eastWall = false;
        this.northWall = false;
        this.southWall = false;
        this.westWall = false;
    }

    /**
     * Simple getter of type.
     *
     * @return type Square
     */
    public SquareType getType() {
        return type;
    }

    /**
     * Setter of type.
     *
     * @param type
     */

    public void setType(SquareType type) {
        this.type = type;
    }

    /**
     * setter of northWall
     *
     * @param northWall
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    /**
     * setter of southWall
     *
     * @param southWall
     */

    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * setter of setWestWall
     *
     * @param westWall
     */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    /**
     * setter of setEastWall
     *
     * @param eastWall
     */

    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    public boolean hasWall(Direction direction) {
        if (direction.equals(direction.EAST)) {
            this.setEastWall(true);
            return this.eastWall;

        }
        if (direction.equals(direction.NORTH)) {
            this.setNorthWall(true);
            return this.northWall;

        }
        if (direction.equals(direction.SOUTH)) {
            this.setSouthWall(true);
            return this.southWall;

        }
        if (direction.equals(direction.WEST)) {
            this.setWestWall(true);
            return this.westWall;

        }
        
        return false;

    }

}

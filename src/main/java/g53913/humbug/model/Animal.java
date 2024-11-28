package g53913.humbug.model;

/**
 *
 * @author aymanmensso
 * Abstract class Animal, the animals move on the board to reach the case star,
 * they also have a position on the board at the begining of the game
 */
public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar;
    
    /**
     * Constructor of the class Animal.
     * @param positionOnBoard 
     */
    public Animal(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
        this.onStar = false;
    }
    /**
     * getter of positionOnBoard.
     * @return positionBoard
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }
    /**
     * getter of onStar(false).
     * @return onStar
     */
    public boolean isOnStar() {
        return onStar;
    }
    /**
     * setter of PositionOnBoard
     * @param positionOnBoard 
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }
    /**
     * setter of onStar
     * @param onStar
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }
    /**
     * Returns the next position of an animal
     * @param board the board of the game
     * @param direction a direction (NORTH, SOUTH ,EAST, WEST)
     * @param animals an animal (snail or spider)
     * @return the next Position
     */
    public abstract Position move(Board board, Direction direction, Animal... animals);
    
    protected abstract Position moveOneCrawling(Board board,Direction direction, Animal... animals) ;
    protected abstract Position moveOneFlying(Board board,Direction direction, Animal... animals) ;
    protected abstract Position moveOneJumping(Board board,Direction direction, Animal... animals) ;

}


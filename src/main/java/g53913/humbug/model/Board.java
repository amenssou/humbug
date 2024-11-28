package g53913.humbug.model;

import static g53913.humbug.model.SquareType.*;

/**
 * Board of the game.
 *
 * @author aymanmensso
 */
public class Board {

    private Square[][] squares;

    Board(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * The first board of the game.
     *
     * @return a board
     */
    public static Board getInitialBoard() {
        Board board;
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}});

        return board;

    }

    /**
     * return true if position is in the board, an exception if not
     *
     * @param position
     * @return true if the position exists
     */
    public boolean isInside(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("This case is void");
        }

        return !(position.getRow() < 0
                || position.getColumn() < 0
                || position.getColumn() > squares[0].length
                || position.getRow() > squares.length
                || squares[position.getRow()][position.getColumn()] == null);
    }

    /**
     * returns the type of the case in position
     *
     * @param position the position of the case
     * @return the type of the case
     */
    public SquareType getSquareType(Position position) {
        if (squares[position.getRow()][position.getColumn()] == null) {
            throw new IllegalArgumentException("This case is void");
        }
        if (this.isInside(position)) {

            return squares[position.getRow()][position.getColumn()].getType();
        }
        return null;
    }

    /**
     * returns the number of rows
     *
     * @return number of rows
     */
    public int getNbRow() {
        return squares.length;

    }

    /**
     * returns the number of columns
     *
     * @return number of columns
     */
    public int getNbColumn() {
        return squares[0].length;
    }

    /**
     * setter of squares
     *
     * @param squares
     */
    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * getter of squares
     *
     * @return
     */
    public Square[][] getSquares() {
        return squares;
    }

}

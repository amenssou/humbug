/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbug.model;

import static g53913.humbug.model.SquareType.GRASS;

/**
 * inherits from Animal
 *
 * @author aymanmensso
 */
public class Snail extends Animal {

    /**
     * Constructor of the class Snail
     *
     * @param positionOnBoard
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * this method moves to the next position of an animal, in this case snail.
     *
     * @param board the board of the game
     * @param direction the next direction
     * @param animals an animal (snail)
     * @return the next position
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return moveOneCrawling(board, direction, animals);
    }

    @Override
    protected Position moveOneCrawling(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        if (!board.isInside(pos.next(direction))) {
            return null;
        }
        for (Animal animal : animals) {

            if (!this.equals(animal) && animal.getPositionOnBoard().equals(pos.next(direction))) {
                return super.getPositionOnBoard();
            }
        }

        if (board.getSquareType(pos.next(direction)).equals(SquareType.STAR)) {
            super.setOnStar(true);
            super.setPositionOnBoard(null);
            board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
            return pos next(direction);

        }


        return pos.next(direction);

    }

    @Override
    protected Position moveOneFlying(Board board, Direction direction, Animal... animals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Position moveOneJumping(Board board, Direction direction, Animal... animals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

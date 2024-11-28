/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbug.model;

import static g53913.humbug.model.SquareType.GRASS;

/**
 *inherits from Animal
 * @author aymanmensso
 */
public class Spider extends Animal {
    /**
     * Constructor of the class Spider.
     * @param positionOnBoard 
     */
    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }
    /**
     * this method move to the next position of an animal, in this case spider.
     * @param board the board of the game
     * @param direction the next direction
     * @param animals an animal (spider)
     * @return the next position
     */

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return moveOneCrawling(board,direction,animals);
    }

    @Override
    protected Position moveOneCrawling(Board board, Direction direction, Animal... animals) {
               Position pos = this.getPositionOnBoard();
        Position next_pos = pos.next(direction);
        if (next_pos.getRow() > board.getNbRow() || next_pos.getColumn() > board.getNbColumn()) {
            return null;
        }

        while (next_pos.getRow() <= board.getNbRow() - 1 && next_pos.getColumn() <= board.getNbColumn() - 1) {

            for (Animal animal : animals) {
                if (!board.isInside(next_pos)) {
                    return null;
                }
                if (!this.equals(animal) && animal.getPositionOnBoard().equals(pos.next(direction))) {

                    if (board.getSquareType(pos).equals(SquareType.STAR) && animal.getPositionOnBoard().equals(next_pos)) {
                        this.setOnStar(true);
                        this.setPositionOnBoard(null);
                        board.getSquares()[pos.getRow()][pos.getColumn()].setType(GRASS);
                        return pos;

                    }
                    if (animal.getPositionOnBoard().equals(next_pos.next(direction))) {
                        return this.getPositionOnBoard().next(direction);

                    }

                    return pos;
                }

            }

            pos = next_pos;
            next_pos = next_pos.next(direction);

        }
        if (next_pos.getRow() == board.getNbRow() || next_pos.getColumn() == board.getNbColumn()){
        return null;
    }

        return next_pos;
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

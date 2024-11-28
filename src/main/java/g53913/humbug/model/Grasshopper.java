/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbug.model;

import static g53913.humbug.model.SquareType.GRASS;

/**
 *
 * @author aymanmensso
 */
public class Grasshopper extends Animal {

    public Grasshopper(Position positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return moveOneJumping(board, direction, animals);
    }

    @Override
    protected Position moveOneCrawling(Board board, Direction direction, Animal... animals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Position moveOneFlying(Board board, Direction direction, Animal... animals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Position moveOneJumping(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();

        if (!board.isInside(pos.next(direction))) {
            return null;
        }
        for (Animal animal : animals) {
            if (!this.equals(animal) && animal.getPositionOnBoard().equals(pos.next(direction)) && board.getSquareType(pos.next(direction).next(direction)).equals(null)) {
                return null;
            }
            if (!this.equals(animal) && animal.getPositionOnBoard().equals(pos.next(direction)) && board.getSquareType(pos.next(direction).next(direction)).equals(SquareType.GRASS)) {
                return animal.getPositionOnBoard().next(direction);

            }
            if (!this.equals(animal) && animal.getPositionOnBoard().equals(pos.next(direction)) && board.getSquareType(pos.next(direction).next(direction)).equals(SquareType.STAR)) {
                super.setOnStar(true);
                super.setPositionOnBoard(null);
                board.getSquares()[pos.next(direction).next(direction).getRow()][pos.next(direction).next(direction).getColumn()].setType(GRASS);
                return pos.next(direction).next(direction);
            }

        }

        if (board.getSquareType(pos.next(direction)).equals(SquareType.STAR)) {
            super.setOnStar(true);
            super.setPositionOnBoard(null);
            board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
            return pos.next(direction);
        }

        return pos.next(direction);
    }

}

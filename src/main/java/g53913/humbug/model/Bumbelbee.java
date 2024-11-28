/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbug.model;

import static g53913.humbug.model.SquareType.GRASS;
import static g53913.humbug.model.SquareType.STAR;

/**
 *
 * @author aymanmensso
 */
public class Bumbelbee extends Animal {

    public Bumbelbee(Position positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return moveOneFlying(board,direction,animals);
    }

    @Override
    protected Position moveOneCrawling(Board board, Direction direction, Animal... animals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Position moveOneFlying(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        Position nextPos = super.getPositionOnBoard().next(direction);
        if (!board.isInside(nextPos)) {
            return null;

        }
        for (Animal animal : animals){
            
            if (!this.equals(animal) && animal.getPositionOnBoard().equals(nextPos.next(direction))&& board.getSquareType(nextPos.next(direction).next(direction)).equals(GRASS)){
                return nextPos.next(direction).next(direction);
                
            }
            
            if (!this.equals(animal)&& animal.getPositionOnBoard().equals(nextPos.next(direction)) && board.getSquareType(nextPos.next(direction).next(direction)).equals(STAR)){
                super.setOnStar(true);
                super.setPositionOnBoard(null);
                board.getSquares()[nextPos.next(direction).next(direction).getRow()][nextPos.next(direction).next(direction).getColumn()].setType(GRASS);
                return nextPos.next(direction).next(direction);
            }

            if (board.getSquareType(nextPos.next(direction)).equals(SquareType.STAR)){
                super.setOnStar(true);
                super.setPositionOnBoard(null);
                board.getSquares()[nextPos.next(direction).getRow()][nextPos.next(direction).getColumn()].setType(GRASS);
                return nextPos.next(direction);
            }

            
        }
        
        return nextPos.next(direction);
    }

    @Override
    protected Position moveOneJumping(Board board, Direction direction, Animal... animals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

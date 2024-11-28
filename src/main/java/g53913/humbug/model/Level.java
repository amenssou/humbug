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
public class Level {

    private Board board;
    private Animal[] animals;
    private int nMoves;

    public Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }
    

    public static Level getLevel(int level) {
        Board board = null;
        Animal[] animals =null;
        int nMoves=0;
        if (level == 1) {
            board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
                {null, new Square(GRASS), new Square(GRASS), null},
                {null, null, new Square(STAR), null}
            });
            animals = new Animal[]{
                new Snail(new Position(0, 0)),};
            nMoves = 4;
        }
        if (level == 2) {
            board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS),null},
                {null,new Square(STAR),null},
                {new Square(STAR),new Square(GRASS), new Square(STAR)},
                {null, new Square(GRASS), null}
            });
            animals = new Animal[]{
                new Snail(new Position(0, 0)),
                new Snail(new Position(2, 1)),
                new Snail(new Position(3, 1))
            };
            nMoves = 5;
        }
        if (level == 2) {
            board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS),null},
                {null,new Square(STAR),null},
                {new Square(STAR),new Square(GRASS), new Square(STAR)},
                {null, new Square(GRASS), null}
            });
            animals = new Animal[]{
                new Snail(new Position(0, 0)),
                new Snail(new Position(2, 1)),
                new Snail(new Position(3, 1))
            };
            nMoves = 5;
 (level == 3) {
            Square Sqn = new Square(SquareType.GRASS);
            Sqn.setNorthWall(true);
            Square Sqw = new Square(SquareType.GRASS);
            Sqw.setWestWall(true);
            Square Sqe = new Square(SquareType.GRASS);
            Sqe.setEastWall(true);
            Square Sqs = new Square(SquareType.GRASS);
            Sqs.setSouthWall(true);
            Square Sqws = new Square(SquareType.STAR);
            Sqws.setWestWall(true);
            board = new Board(new Square[][]{
                {Sqn , new Square(GRASS),Sqe},
                {new Square(GRASS), null, new Square(GRASS)},
                {new Square(GRASS), null, new Square(GRASS)},
                {Sqws, new Square(GRASS), Sqs}
            });
            animals = new Animal[]{
                new Spider(new Position(2, 0)),};
            nMoves = 4;
        }
        Level niveau = new Level (board,animals,nMoves);
        return niveau;
    }

    public Board getBoard() {
        return board;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public int getnMoves() {
        return nMoves;
    }
    
    

}

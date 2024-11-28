/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbug.model;

import static g53913.humbug.model.LevelStatus.NOT_STARTED;

/**
 * bring togheter all the elements for the game.
 *
 * @author aymanmensso
 */
public class Game implements Model {

    private Board board;
    private Animal[] animals;
    private int remainingMoves;
    private int currentLevel;

    /**
     * getter of board
     *
     * @return board
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * getter of animals
     *
     * @return animals
     */
    @Override
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * initialise the board of the game for the first level
     *
     * @param level the level of the game
     */
    @Override
    public void startLevel(int level) {
        if (level == 1) {
            this.board = Board.getInitialBoard();
            Position pos = new Position(0, 0);
            this.animals = new Animal[]{(new Snail(pos))};

        }

    }

    /**
     * if the level is over returns true, the level is over when all animals are
     * in star
     *
     * @return true if the animals arrive to the stars
     */
  
    public boolean levelIsOver() {
        boolean verif = false;
        int cpt = 0;
        for (Animal animal : animals) {
            if (animal.isOnStar()) {
                cpt++;
            }

        }
        if (cpt == animals.length) {
            verif = true;
        }
        return verif;
    }

    /**
     * do the moves if it's allowed
     *
     * @param position the position of the animal
     * @param direction the direction of the animal
     */
    @Override
    public void move(Position position, Direction direction) {
        int pos = 0;
        while(){
            
        }
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getPositionOnBoard().equals(position)) {
                pos = i;
            }
        }
        this.animals[pos].setPositionOnBoard(animals[pos].move(board, direction, animals));
    }

    @Override
    public int getRemainingMoves() {
       return this.remainingMoves;
    }

    @Override
    public LevelStatus getLevelStatus() {
        LevelStatus stat = NOT_STARTED;
       if(levelIsOver()){
           return stat.WIN;
       }
       
       return stat;
        
    }

}

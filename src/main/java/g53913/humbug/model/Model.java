/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbug.model;

/**
 * interface Model for the class Game
 * @author aymanmensso
 */
public interface Model {
    Board getBoard();
    Animal[] getAnimals();
    int getRemainingMoves();
    void startLevel(int level);
    LevelStatus getLevelStatus();
    void move (Position position, Direction direction);
    
    
}

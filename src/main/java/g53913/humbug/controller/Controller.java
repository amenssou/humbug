/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbug.controller;

import g53913.humbug.model.Model;
import g53913.humbug.view.text.InterfaceView;

/**
 * Controller of the game.
 *
 * @author aymanmensso
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    /**
     * Constructor of the class Controller
     *
     * @param game
     * @param view
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }


    /**
     * This method brings what we need to start the game.
     */
    public void startGame() {
        game.startLevel(1);
        while (!game.levelIsOver()) {
            view.displayBoard(game.getBoard(), game.getAnimals());
            System.out.println("");

            try {
                game.move(view.askPosition(), view.askDirection());
            } catch (Exception e) {
                view.displayError("The animal is out of the board");
            }
            System.out.println("");

        }
        view.displayBoard(game.getBoard(), game.getAnimals());
        System.out.println(" ");
        if (game.levelIsOver()) {
            System.out.println("Congratulations! You've won!");
        }

    }

}

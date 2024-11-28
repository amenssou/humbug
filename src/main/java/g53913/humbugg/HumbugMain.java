/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53913.humbugg;

import g53913.humbug.controller.Controller;
import g53913.humbug.model.Game;
import g53913.humbug.view.text.View;

/**
 *
 * @author aymanmensso
 */
public class HumbugMain {
    public static void main(String[] args) {
        Controller controller = new Controller (new Game(), new View());
        controller.startGame();
    }
    
}

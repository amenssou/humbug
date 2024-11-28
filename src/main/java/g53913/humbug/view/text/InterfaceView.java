
package g53913.humbug.view.text;

import g53913.humbug.model.Animal;
import g53913.humbug.model.Board;
import g53913.humbug.model.Direction;
import g53913.humbug.model.Position;



/**
 *Interface of the class View
 * @author aymanmensso
 */
public interface InterfaceView {
    void displayBoard (Board board, Animal... animals) ;
    Position askPosition();
    Direction askDirection();
    void displayError(String message);
    
    
    
}

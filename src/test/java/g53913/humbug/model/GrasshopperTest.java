
package g53913.humbug.model;

import static g53913.humbug.model.SquareType.GRASS;
import static g53913.humbug.model.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author aymanmensso
 */
public class GrasshopperTest {
    
    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[] {
            new Grasshopper(new Position(0, 0)),
            new Grasshopper(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_notfree() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        System.out.println("move next case not free");
        Grasshopper instance = (Grasshopper) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0,2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

  
    
    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        Grasshopper instance = (Grasshopper) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_notinside_2() {
        System.out.println("move next case null");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_toanimal_notinside() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[] {
            new Grasshopper(new Position(1,1)),
            new Snail(new Position(1, 2))
        };
        System.out.println("move next case null and animal before null case");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
     /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_animal_nextstar() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(STAR), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[] {
            new Grasshopper(new Position(0,0)),
            new Snail(new Position(0, 1))
        };
        System.out.println("move next animal then star");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }
    
    
    
   
    
    
   

    
}

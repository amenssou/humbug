
package g53913.humbug.model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static g53913.humbug.model.SquareType.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aymanmensso
 */
public class BoardTest {

    private Board board;

    public BoardTest() {

    }

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_general_true() {
        System.out.println("isInside general");
        Position position = new Position(0, 0);
        boolean expResult = true;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_false_null() {
        System.out.println("isInside false null");
        Position position = new Position(1, 0);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_false_outbound_negative() {
        System.out.println("isInside false out of bound");
        Position position = new Position(-1, 0);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_false_outbound_positive_row() {
        System.out.println("isInside false out of bound");
        Position position = new Position(10, 1);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_false_outbound_positive_column() {
        System.out.println("isInside false out of bound");
        Position position = new Position(2, 23);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_exist() {
        System.out.println("get square type exist");
        SquareType expResult = SquareType.GRASS;
        SquareType result = board.getSquareType(new Position(0, 0));
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_exist_star() {
        System.out.println("get square type exist");
        SquareType expResult = SquareType.STAR;
        SquareType result = board.getSquareType(new Position(2, 2));
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_null() {
        System.out.println("get case type illegal argument");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    board.getSquareType(new Position(1, 0));
                });

    }
}

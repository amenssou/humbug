package g53913.humbug.view.text;

import g53913.humbug.model.Animal;
import java.util.Scanner;
import g53913.humbug.model.Board;
import g53913.humbug.model.Direction;
import g53913.humbug.model.Position;
import g53913.humbug.model.Snail;
import g53913.humbug.model.Spider;
import g53913.humbug.model.SquareType;

/**
 *
 * @author aymanmensso the view of the game, takes care of the interaction with
 * the user.
 */
public class View implements InterfaceView {

    /**
     * prints the board of the game
     *
     * @param board a board
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] gameBoard = new String[board.getNbRow()][board.getNbColumn()];
        Position pos;
        for (int i = 0; i < board.getSquares().length; i++) {
            System.out.println();
            for (int j = 0; j < board.getSquares()[0].length; j++) {

                if (board.getSquares()[i][j] != null && board.getSquares()[i][j].getType().equals(SquareType.GRASS)) {
                    gameBoard[i][j] =  "\033[41;30m" +"|     |";

                    for (Animal animal : animals) {
                        if (!animal.isOnStar() && animal.getPositionOnBoard() != null) {
                            if (animal instanceof Snail) {
                                gameBoard[animal.getPositionOnBoard().getRow()][animal.getPositionOnBoard().getColumn()] =   "\033[41;30m" +"| Sna |";
                            } else if (animal instanceof Spider) {
                                gameBoard[animal.getPositionOnBoard().getRow()][animal.getPositionOnBoard().getColumn()] = "\033[41;30m" + "| Spi |";
                            }
                        }

                    }

                } else if (board.getSquares()[i][j] != null && board.getSquares()[i][j].getType().equals(SquareType.STAR)) {
                    gameBoard[i][j] = "\033[41;30m" + "|  *  |";

                } else {
                    gameBoard[i][j] = "\033[0;0m" + "       ";

                }
                System.out.print(gameBoard[i][j]);

            }

        }

    }

    /**
     * prints an error message
     *
     * @param message
     */
    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

    /**
     * Ask a position(row,column) to the user, while the row and column aren't
     * integers ask again to the user.
     *
     * @return a position
     */
    @Override
    public Position askPosition() {
        Scanner sc = new Scanner(System.in);
        int row = 0;
        int column = 0;
        System.out.println("Please enter the row of the position:");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("This is not an integral.");
            System.out.println("Please enter the row of the position:");
        }
        row = sc.nextInt();

        System.out.println("Please enter the column of the position:");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("This is not an integral.");
            System.out.println("Please enter the column of the position:");
        }

        column = sc.nextInt();
        return new Position(row, column);

    }

    /**
     * Ask to the user a direction (NORTH, SOUTH, WEST, EAST), while the
     * direction isn't an integer ask again to the user.
     *
     * @return a direction
     */
    @Override
    public Direction askDirection() {
        Direction direction = null;
        Scanner sc = new Scanner(System.in);
        int dir = 0;
        System.out.println("Please enter a direction (1 for NORTH, 2 for SOUTH, 3 for EAST, 4 for WEST):");

        while (!sc.hasNextInt() && dir != 1 && dir != 2 && dir != 3 && dir != 4) {
            sc.next();
            System.out.println("It's not a number between 1 and 4");
            System.out.println("Please enter a direction (1 for NORTH, 2 for SOUTH, 3 for EAST, 4 for WEST):");
        }
        dir = sc.nextInt();

        switch (dir) {
            case 1:
                direction = Direction.NORTH;
                break;
            case 2:
                direction = Direction.SOUTH;
                break;
            case 3:
                direction = Direction.EAST;
                break;
            case 4:
                direction = Direction.WEST;
                break;

        }

        return direction;
    }


}

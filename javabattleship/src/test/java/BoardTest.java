import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;

public class BoardTest {
    
    @Test
    public void testConstructor() {
        GameBoard board = new GameBoard();
        Cell cell = board.cellAt(9, 9);

        Assert.assertEquals("none", cell.getState());
        Assert.assertEquals("99", cell.getCoordinates());
    }

    @Test
    public void testCellAt() {
        GameBoard board = new GameBoard();

        Cell cell = board.cellAt(3, 4);
        Assert.assertEquals("34", cell.getCoordinates());


        cell = board.cellAt("56");
        Assert.assertEquals("56", cell.getCoordinates());
    }

    @Test
    public void testGetCellArray() {
        GameBoard board = new GameBoard();
        Cell[] testArray = new Cell[1];
        testArray[0] = new Cell("00");
        Cell[] resultArray = board.getCellArrayAt(0, 0, 1, 'r');
        Assert.assertEquals(1, resultArray.length);
        Assert.assertTrue(testArray[0].equals(resultArray[0]));

        testArray = new Cell[5];
        for (int i = 0; i < 5; i++) {
            testArray[i] = new Cell(i, 0);
        }
        resultArray = board.getCellArrayAt(0, 0, 5, 'd');
        Assert.assertEquals(5, resultArray.length);
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(Integer.toString(i) + Integer.toString(0), resultArray[i].getCoordinates());
        }

        for (int i = 0; i < 5; i++) {
            testArray[i] = new Cell(0, i);
        }
        resultArray = board.getCellArrayAt(0, 0, 5, 'r');
        Assert.assertEquals(5, resultArray.length);

        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(Integer.toString(0) + Integer.toString(i), resultArray[i].getCoordinates());
        }

        for (int i = 0; i < 5; i++) {
            testArray[i] = new Cell(4-i, 0);
        }
        resultArray = board.getCellArrayAt(4, 0, 5, 'u');
        Assert.assertEquals(5, resultArray.length);

        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(Integer.toString(4-i) + Integer.toString(0), resultArray[i].getCoordinates());
        }

        for (int i = 0; i < 5; i++) {
            testArray[i] = new Cell(0, 4-i);
        }
        resultArray = board.getCellArrayAt(0, 4, 5, 'l');
        Assert.assertEquals(5, resultArray.length);

        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(Integer.toString(0) + Integer.toString(4-i), resultArray[i].getCoordinates());
        }
    }

    @Test
    public void testRandomShipPlacement() {
        GameBoard gameBoard = new GameBoard();
        Ship[] ships = gameBoard.getShipsRandomized();

        Assert.assertEquals(5, ships.length);
        Assert.assertEquals(5, ships[0].getSize());
        Assert.assertEquals(4, ships[1].getSize());
        Assert.assertEquals(3, ships[2].getSize());
        Assert.assertEquals(3, ships[3].getSize());
        Assert.assertEquals(2, ships[4].getSize());
    }

    @Test
    public void testRowToString() {
        GameBoard gameBoard = new GameBoard();

        String actual = gameBoard.rowToString(0);
        String expected = ". . . . . . . . . . ";
        Assert.assertEquals(expected, actual);

        gameBoard = new UserGameBoard();
        Cell[] carrierCells = gameBoard.getCellArrayAt(0, 1, 5, 'r');
        Cell[] destroyerCells = gameBoard.getCellArrayAt(0, 7, 2, 'r');

        try {
            Ship carrier = new Ship(carrierCells);
            Ship destroyer = new Ship(destroyerCells);
        } catch (Exception e) {
            fail("Ship constructor threw unexpected exception");
        }
        
        actual = gameBoard.rowToString(0);
        expected = ". C C C C C . D D . ";
        Assert.assertEquals(expected, actual);

        gameBoard.attackCellAndGetHitType("00");
        gameBoard.attackCellAndGetHitType("01");

        actual = gameBoard.rowToString(0);
        expected = ". x C C C C . D D . ";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAttack() {
        GameBoard gameBoard = new GameBoard();
        String expected = "miss";
        String actual = gameBoard.attackCellAndGetHitType("00");
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetCells() {
        GameBoard gameBoard = new GameBoard();
        Cell[][] cells = gameBoard.getCells();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Assert.assertEquals(gameBoard.cellAt(i, j), cells[i][j]);
            }
        }
    }

    @Test
    public void testMaxShipSizeAt() {
        Assert.assertEquals(5, GameBoard.maxShipSizeAt(5, 5, 'l'));
        Assert.assertEquals(5, GameBoard.maxShipSizeAt(5, 5, 'r'));
        Assert.assertEquals(5, GameBoard.maxShipSizeAt(5, 5, 'u'));
        Assert.assertEquals(5, GameBoard.maxShipSizeAt(5, 5, 'd'));

        Assert.assertEquals(4, GameBoard.maxShipSizeAt(5, 3, 'l'));
        Assert.assertEquals(4, GameBoard.maxShipSizeAt(5, 6, 'r'));
        Assert.assertEquals(4, GameBoard.maxShipSizeAt(3, 5, 'u'));
        Assert.assertEquals(4, GameBoard.maxShipSizeAt(6, 5, 'd'));

        Assert.assertEquals(3, GameBoard.maxShipSizeAt(5, 2, 'l'));
        Assert.assertEquals(3, GameBoard.maxShipSizeAt(5, 7, 'r'));
        Assert.assertEquals(3, GameBoard.maxShipSizeAt(2, 5, 'u'));
        Assert.assertEquals(3, GameBoard.maxShipSizeAt(7, 5, 'd'));

        Assert.assertEquals(2, GameBoard.maxShipSizeAt(5, 1, 'l'));
        Assert.assertEquals(2, GameBoard.maxShipSizeAt(5, 8, 'r'));
        Assert.assertEquals(2, GameBoard.maxShipSizeAt(1, 5, 'u'));
        Assert.assertEquals(2, GameBoard.maxShipSizeAt(8, 5, 'd'));

        Assert.assertEquals(1, GameBoard.maxShipSizeAt(5, 0, 'l'));
        Assert.assertEquals(1, GameBoard.maxShipSizeAt(5, 9, 'r'));
        Assert.assertEquals(1, GameBoard.maxShipSizeAt(0, 5, 'u'));
        Assert.assertEquals(1, GameBoard.maxShipSizeAt(9, 5, 'd'));

        Assert.assertEquals(5, GameBoard.maxShipSizeAt(5, 7, 'l'));
        Assert.assertEquals(5, GameBoard.maxShipSizeAt(5, 3, 'r'));
        Assert.assertEquals(5, GameBoard.maxShipSizeAt(7, 5, 'u'));
        Assert.assertEquals(5, GameBoard.maxShipSizeAt(3, 5, 'd'));
    }
}

import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;

public class BoardTest {
    
    @Test
    public void testConstructor() {
        GameBoard board = new GameBoard();
        Cell cell = board.cellAt(9, 9);

        Assert.assertEquals(cell.getState(), "none");
        Assert.assertEquals(cell.getCoordinates(), "99");
    }

    @Test
    public void testCellAt() {
        GameBoard board = new GameBoard();

        Cell cell = board.cellAt(3, 4);
        Assert.assertEquals(cell.getCoordinates(), "34");


        cell = board.cellAt("56");
        Assert.assertEquals(cell.getCoordinates(), "56");
    }

    @Test
    public void testGetCellArray() {
        GameBoard board = new GameBoard();
        Cell[] testArray = new Cell[1];
        testArray[0] = new Cell("00");
        Cell[] resultArray = board.getCellArrayAt(0, 0, 1, 'r');
        Assert.assertEquals(resultArray.length, 1);
        Assert.assertTrue(testArray[0].equals(resultArray[0]));

        testArray = new Cell[5];
        for (int i = 0; i < 5; i++) {
            testArray[i] = new Cell(i, 0);
        }
        resultArray = board.getCellArrayAt(0, 0, 5, 'd');
        Assert.assertEquals(resultArray.length, 5);
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(resultArray[i].getCoordinates(), Integer.toString(i) + Integer.toString(0));
        }

        for (int i = 0; i < 5; i++) {
            testArray[i] = new Cell(0, i);
        }
        resultArray = board.getCellArrayAt(0, 0, 5, 'r');
        Assert.assertEquals(resultArray.length, 5);

        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(resultArray[i].getCoordinates(), Integer.toString(0) + Integer.toString(i));
        }

        for (int i = 0; i < 5; i++) {
            testArray[i] = new Cell(4-i, 0);
        }
        resultArray = board.getCellArrayAt(4, 0, 5, 'u');
        Assert.assertEquals(resultArray.length, 5);

        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(resultArray[i].getCoordinates(), Integer.toString(4-i) + Integer.toString(0));
        }

        for (int i = 0; i < 5; i++) {
            testArray[i] = new Cell(0, 4-i);
        }
        resultArray = board.getCellArrayAt(0, 4, 5, 'l');
        Assert.assertEquals(resultArray.length, 5);

        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(resultArray[i].getCoordinates(), Integer.toString(0) + Integer.toString(4-i));
        }
    }
}

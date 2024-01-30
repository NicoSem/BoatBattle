import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;
import org.junit.Assert;

public class CellTest {

    @Test
    public void testConstructor() {
        Cell cell = new Cell("00");

        Assert.assertEquals(cell.getState(), "none");
    }

    @Test
    public void testIllegalArgumentException() {
        try {
            Cell cell = new Cell("010");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testToString() {
        Cell cell = new Cell("00");

        Assert.assertEquals(cell.toString(), ".");

        cell.attackAndGetHitType();
        Assert.assertEquals(cell.toString(), "o");

        Cell cell1 = new Cell("00");
        Cell cell2 = new Cell("01");
        Cell[] cells = {cell1, cell2};

        Ship ship = new Ship(cells);

        cell1.attackAndGetHitType();
        Assert.assertEquals(cell1.toString(), "x");

    }

    @Test
    public void testAttack() {
        Cell cell1 = new Cell("00");
        Cell cell2 = new Cell("01");
        Cell cell3 = new Cell("02");
        Cell[] cells = {cell1, cell2};

        Ship ship = new Ship(cells);

        Assert.assertEquals(cell1.attackAndGetHitType(), "hit");
        Assert.assertEquals(cell2.attackAndGetHitType(), "hit");
        Assert.assertEquals(cell3.attackAndGetHitType(), "miss");
    }

    @Test
    public void testSetters() {
        Cell cell1 = new Cell("00");
        Cell cell2 = new Cell("01");
        Cell[] cells = {cell1, cell2};

        Ship ship = new Ship(cells);

        Assert.assertEquals(cell1.getShip(), ship);
        Assert.assertEquals(cell2.getShip(), ship);
    }

    @Test
    public void testGetters() {
        Cell cell = new Cell("00");

        Assert.assertEquals(cell.getState(), "none");
        Assert.assertEquals(cell.getCoordinates(), "00");

    }
}
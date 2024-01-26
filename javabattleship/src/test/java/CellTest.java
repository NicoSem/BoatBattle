import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;
import org.junit.Assert;

public class CellTest {

    @Test
    public void testConstructor() {
        Cell cell = new Cell("A0");

        Assert.assertEquals(cell.getState(), "none");
    }

    @Test
    public void testIllegalArgumentException() {
        try {
            Cell cell = new Cell("A10");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testToString() {
        Cell cell = new Cell("A0");

        Assert.assertEquals(cell.toString(), ".");

        cell.attackCell();
        Assert.assertEquals(cell.toString(), "o");

    }

    @Test
    public void testAttack() {
        Cell cell = new Cell("A0");
        Assert.assertFalse(cell.attackCell());
        Assert.assertEquals(cell.getState(), "miss");
    }

    @Test
    public void testGetters() {
        Cell cell = new Cell("A0");

        Assert.assertEquals(cell.getState(), "none");
        Assert.assertEquals(cell.getCoordinates(), "A0");
    }
}
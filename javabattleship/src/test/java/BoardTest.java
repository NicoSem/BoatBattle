import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;

public class BoardTest {
    
    @Test
    public void testConstructor() {
        GameBoard board = new GameBoard();
        Cell cell = board.cellAt(0, 0);

        Assert.assertEquals(cell.getState(), "none");
    }
}

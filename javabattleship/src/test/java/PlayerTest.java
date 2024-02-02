import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;
import org.junit.Assert;

public class PlayerTest {

    @Test
    public void TestLocalPlayerConstructor() {
        Player localPlayer = new LocalPlayer();

        GameBoard gameBoard = localPlayer.getBoard();
        Assert.assertNotNull(gameBoard);

        Ship[] ships = localPlayer.getShips();
        Assert.assertEquals(ships.length, 5);

        Assert.assertEquals(ships[0].getSize(), 5);
        Assert.assertEquals(ships[1].getSize(), 4);
        Assert.assertEquals(ships[2].getSize(), 3);
        Assert.assertEquals(ships[3].getSize(), 3);
        Assert.assertEquals(ships[4].getSize(), 2);
    }
}

import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;
import org.junit.Assert;

public class GameControllerTest {

    @Test
    public void SinglePlayerStartGame() {
        GameController gameController = new SinglePlayerGameController();
    }

}

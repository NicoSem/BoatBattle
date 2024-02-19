import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;

public class GameControllerTest {

    @Test
    public void SinglePlayerStartGame() {
        Player player1 = new LocalPlayer();
        Player player2 = new BotPlayer();
        GameController gameController = new GameController(player1, player2);
    }

    @Test(timeout = 1000)
    public void GameTerminates() {
        Player player1 = new BotPlayer();
        Player player2 = new BotPlayer();
        GameController gameController = new GameController(player1, player2);

        gameController.startGame();

    }
}

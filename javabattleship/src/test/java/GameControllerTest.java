import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;

public class GameControllerTest {

    @Test
    public void SinglePlayerInit() {
        Player player1 = new LocalPlayer();
        Player player2 = new BotPlayer(new EasyAttackStrategy());
        GameController gameController = new GameController(player1, player2);
    }

    @Test(timeout = 1000)
    public void GameTerminates() {
        Player player1 = new BotPlayer(new EasyAttackStrategy());
        Player player2 = new BotPlayer(new EasyAttackStrategy());

        GameController gameController = new GameController(player1, player2);

        gameController.startGame();

    }
}

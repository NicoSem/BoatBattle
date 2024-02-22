import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;

public class GameControllerTest {

    @Test
    public void SinglePlayerStartGame() {
        Player player1 = new LocalPlayer();
        Player player2 = new BotPlayer(new EasyAttackStrategy(player1.getBoard()));
        GameController gameController = new GameController(player1, player2);
    }

    @Test(timeout = 1000)
    public void GameTerminates() {
        GameBoard player2Gameboard = new GameBoard();
        Player player1 = new BotPlayer(new EasyAttackStrategy(player2Gameboard));
        Player player2 = new BotPlayer(new EasyAttackStrategy(player1.getBoard()));
        player2.setBoard(player2Gameboard);
        GameController gameController = new GameController(player1, player2);

        gameController.startGame();

    }
}

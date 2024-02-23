import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;

public class AttackStrategyTest {

    @Test
    public void TestEasyBoardCoverage() {
        GameBoard gameBoard = new GameBoard();
        EasyAttackStrategy attackStrategy = new EasyAttackStrategy();

        for (int i = 0; i < 100; i++) {
            gameBoard.attackCellAndGetHitType(attackStrategy.getCoordinates(""));
        }

        List<Cell> cells = gameBoard.getCellsList();
        for (Cell cell : cells) {
            Assert.assertFalse(cell.getState().equals("none"));
        }
    }
}

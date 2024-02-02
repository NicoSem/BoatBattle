import com.battleship.*;

import org.junit.*;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;

public class AttackStrategyTest {

    @Test
    public void TestEasyConstructor() {
        GameBoard gameBoard = new GameBoard();
        EasyAttackStrategy attackStrategy = new EasyAttackStrategy(gameBoard);
        List<Cell> attackStrategyList = attackStrategy.getCellList();

        Assert.assertEquals(attackStrategyList.size(), 100);
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(Integer.parseInt(attackStrategyList.get(i).getCoordinates()), i);
        }
    }

    @Test
    public void TestEasyBoardCoverage() {
        GameBoard gameBoard = new GameBoard();
        EasyAttackStrategy attackStrategy = new EasyAttackStrategy(gameBoard);
        List<Cell> attackStrategyList = attackStrategy.getCellList();

        for (int i = 0; i < 100; i++) {
            attackStrategy.getCoordinates();
        }

        Assert.assertTrue(attackStrategyList.isEmpty());
    }
}

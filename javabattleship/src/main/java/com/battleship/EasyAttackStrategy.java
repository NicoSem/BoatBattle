package com.battleship;

import java.util.ArrayList;
import java.util.List;

public class EasyAttackStrategy implements AttackStrategy {
    private List<Cell> cellsToAttack;

    public EasyAttackStrategy(GameBoard gameBoard) {
        cellsToAttack = gameBoard.getCellsList();
    }

    @Override
    public String getCoordinates() {
        int randIndex = (int) (Math.random() * cellsToAttack.size());
        Cell attackedCell = cellsToAttack.remove(randIndex);
        return attackedCell.getCoordinates();
    }

    public List<Cell> getCellList() {
        return cellsToAttack;
    }

}

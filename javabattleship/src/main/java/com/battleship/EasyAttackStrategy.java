package com.battleship;

import java.util.ArrayList;
import java.util.List;

public class EasyAttackStrategy implements AttackStrategy {
    private List<Cell> cellsToAttack;

    public EasyAttackStrategy(GameBoard gameBoard) {
        cellsToAttack = new ArrayList<Cell>();
        Cell[][] cells = gameBoard.getCells();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cellsToAttack.add(cells[i][j]);
            }
        }
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

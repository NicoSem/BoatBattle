package com.battleship;

import java.util.ArrayList;
import java.util.List;

public class EasyAttackStrategy implements AttackStrategy {
    private List<Cell> cellsToAttack;
    private List<Cell> priorityCellsToAttack;
    private GameBoard gameBoard;
    private String lastAttackResult;
    private String attackResult;
    private int shipsLeftBefore;
    private char[] directions;

    public EasyAttackStrategy(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        cellsToAttack = gameBoard.getCellsList();
        lastAttackResult = "";
        attackResult = "";
        shipsLeftBefore = 5;
        char[] directions = {'u', 'd', 'l', 'r'};
    }

    @Override
    public String getCoordinates(int shipsLeft) {
        Cell attackCell = null;
        if (priorityCellsToAttack.size() > 0) {
            attackCell = priorityCellsToAttack.remove(0);
            attackResult = gameBoard.attackCellAndGetHitType(attackCell.getCoordinates());
            if(attackResult.equals("miss")) {
                priorityCellsToAttack.clear();
            }
        } else {
            int randIndex = (int) (Math.random() * cellsToAttack.size());
            attackCell = cellsToAttack.remove(randIndex);
            attackResult = gameBoard.attackCellAndGetHitType(attackCell.getCoordinates());
            if (attackResult.equals("hit")) {
                updatePriorityCellList(attackCell);
            }
        }

        return attackCell.getCoordinates();
    }

    public List<Cell> getCellList() {
        return cellsToAttack;
    }

    private void updatePriorityCellList (Cell startCell) {
        priorityCellsToAttack.clear();
        int[] coordinates = startCell.getIntegerCoordinates();
    }

    

}

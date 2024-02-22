package com.battleship;

import java.util.ArrayList;
import java.util.List;

public class EasyAttackStrategy implements AttackStrategy {
    private List<Cell> cellsToAttack;
    private List<Cell> priorityCellsToAttack;
    private GameBoard gameBoard;
    private String attackResult;
    private int shipsLeftBefore;
    private final char[] DIRECTIONS = {'u', 'd', 'l', 'r'};
    private int directionIndex;

    public EasyAttackStrategy(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        cellsToAttack = gameBoard.getCellsList();
        attackResult = "";
        shipsLeftBefore = 5;
        directionIndex = 0;
        priorityCellsToAttack = new ArrayList<Cell>();
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
            cellsToAttack.remove(attackCell);
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

        for(int i = 0; i < 4; i++) {
            int maxSize = GameBoard.maxShipSizeAt(coordinates[0], coordinates[1], DIRECTIONS[i]);
            Cell[] cells = gameBoard.getCellArrayAt(coordinates[0], coordinates[1], maxSize, DIRECTIONS[i]);
            for (Cell cell : cells) {
                priorityCellsToAttack.add(cell);
            }

            priorityCellsToAttack.remove(0);

            if (priorityCellsToAttack.size() > 0 && priorityCellsToAttack.get(0).getState().equals("none")) {
                break;
            }
        }

    }

    

}

package com.battleship;

public abstract class Player {
    private GameBoard gameBoard;
    private Ship[] ships;

    public abstract String getAttackCoordinates();

    public String attackAtAndGetHitType(String coordinates) {
        return gameBoard.attackCellAndGetHitType(coordinates);
    }

    public GameBoard getBoard(){
        return gameBoard;
    }

    public void setBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        setShipsRandom();
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }

    public void setShipsRandom() {
        ships = gameBoard.getShipsRandomized();
    }

    public Ship[] getShips() {
        return ships;
    }

    public int numberOfShipsLeft() {
        int shipsLeft = 5;
        for (Ship ship : ships) {
            if (ship.isSunk()) {
                shipsLeft--;
            }
        }

        return shipsLeft;
    }

    public boolean isDefeated() {
        if (numberOfShipsLeft() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
package com.battleship;

public class BotPlayer implements Player {
    private GameBoard gameBoard;
    private Ship[] ships;
    private AttackStrategy attackStrategy;

    public BotPlayer() {
        gameBoard = new GameBoard();
        attackStrategy = new EasyAttackStrategy(gameBoard);

        ships = gameBoard.getShipsRandomized();
    }

    @Override
    public String getAttackCoordinates() {
        return attackStrategy.getCoordinates();
    }

    @Override
    public String attackAtAndGetHitType(String coordinates) {
        return gameBoard.attackCellAndGetHitType(coordinates);
    }

    @Override
    public GameBoard getBoard() {
        return gameBoard;
    }

    @Override
    public Ship[] getShips() {
        return ships;
    }
}

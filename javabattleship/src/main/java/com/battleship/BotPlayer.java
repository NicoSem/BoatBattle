package com.battleship;

public class BotPlayer implements Player {
    private GameBoard gameBoard;
    private Ship[] ships;
    private AttackStrategy attackStrategy;

    public BotPlayer() {
        gameBoard = new GameBoard();
        attackStrategy = new EasyAttackStrategy(gameBoard);

        ships = new Ship[5];
        ships[0] = new Ship(gameBoard.getCellArrayAt(0, 0, 5, 'd'));
        ships[1] = new Ship(gameBoard.getCellArrayAt(0, 1, 4, 'd'));
        ships[2] = new Ship(gameBoard.getCellArrayAt(0, 2, 3, 'd'));
        ships[3] = new Ship(gameBoard.getCellArrayAt(0, 3, 3, 'd'));
        ships[4] = new Ship(gameBoard.getCellArrayAt(0, 4, 2, 'd'));
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

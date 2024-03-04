package com.battleship;

public class LanPlayer extends Player {
    private GameServer gameServer;
    private GameBoard enemyBoard;

    public LanPlayer(GameBoard gameBoard) {
        super();
        this.setBoard(new GameBoard());
        enemyBoard = gameBoard;

        gameServer = new GameServer();
        gameServer.start(6000);
    }

    @Override
    public String getAttackCoordinates() {
        String coordinates = gameServer.getCoordinates();
        String attackResult = enemyBoard.attackCellAndGetHitType(coordinates);
        gameServer.sendAttackResult(attackResult);
        return coordinates;
    }

    @Override
    public String attackAtAndGetHitType(String coordinates) {
        String result = gameServer.sendCoordinatesAndGetResult(coordinates);
        this.getBoard().cellAt(coordinates).setState(result);
        return result;
    }

    public void sendAttackResult(String result) {
        gameServer.sendAttackResult(result);
    }

    public void stopServer() {
        gameServer.stop();
    }

}
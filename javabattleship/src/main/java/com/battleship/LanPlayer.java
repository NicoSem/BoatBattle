package com.battleship;

public class LanPlayer extends Player {
    private GameServer gameServer;

    public LanPlayer() {
        super();
        this.setBoard(new GameBoard());

        gameServer = new GameServer();
        gameServer.start(6000);
    }

    @Override
    public String getAttackCoordinates() {
        return gameServer.getCoordinates();
    }

    @Override
    public String attackAtAndGetHitType(String coordinates) {
        // TODO Auto-generated method stub
        return "miss";
    }

}
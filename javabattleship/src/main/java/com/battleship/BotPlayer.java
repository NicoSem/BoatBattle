package com.battleship;

public class BotPlayer extends Player {
    private AttackStrategy attackStrategy;

    public BotPlayer() {
        super();
        this.setBoard(new GameBoard());
        attackStrategy = new EasyAttackStrategy(super.getBoard());
    }

    public String getAttackCoordinates() {
        return attackStrategy.getCoordinates(this.numberOfShipsLeft());
    }
}

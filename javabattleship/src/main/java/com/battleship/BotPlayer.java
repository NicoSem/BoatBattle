package com.battleship;

public class BotPlayer extends Player {
    private AttackStrategy attackStrategy;

    public BotPlayer(AttackStrategy attackStrategy) {
        super();
        this.setBoard(new GameBoard());
        this.attackStrategy = attackStrategy;
    }

    public String getAttackCoordinates() {
        return attackStrategy.getCoordinates(this.numberOfShipsLeft());
    }
}

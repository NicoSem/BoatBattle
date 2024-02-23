package com.battleship;

public class BotPlayer extends Player {
    private AttackStrategy attackStrategy;

    public BotPlayer(AttackStrategy attackStrategy) {
        super();
        this.setBoard(new GameBoard());
        this.attackStrategy = attackStrategy;
    }

    @Override
    public String getAttackCoordinates() {
        return attackStrategy.getCoordinates("");
    }

    @Override
    public String attackAtAndGetHitType(String coordinates) {
        return this.getBoard().attackCellAndGetHitType(coordinates);
    }
}

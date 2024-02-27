package com.battleship;

public class LanPlayer extends Player {

    public LanPlayer() {
        super();
        this.setBoard(new GameBoard());
    }

    @Override
    public String getAttackCoordinates() {
        return "00";
    }

    @Override
    public String attackAtAndGetHitType(String coordinates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attackAtAndGetHitType'");
    }

}
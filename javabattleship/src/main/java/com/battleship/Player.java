package com.battleship;

public interface Player {
    public String getAttackCoordinates();

    public String attackAtAndGetHitType(String coordinates);

    public GameBoard getBoard();

    public Ship[] getShips();
}
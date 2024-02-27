package com.battleship;

public interface Game {
    public void startGame();
    public String playAttackAndGetResult(Player attackingPlayer, Player defendingPlayer);
}
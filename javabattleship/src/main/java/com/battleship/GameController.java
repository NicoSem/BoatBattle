package com.battleship;

public class GameController {
    private static ScreenWriter screenWriter;
    private Player attackingPlayer;
    private Player defendingPlayer;
    private GameBoard board1;
    private GameBoard board2;

    public GameController(Player player1, Player player2) {
        screenWriter = new ScreenWriter();

        attackingPlayer = player1;
        defendingPlayer = player2;

        board1 = player1.getBoard();
        board2 = player2.getBoard();
    }

    public void startGame() {
        boolean gameFinished = false;

        while (!gameFinished) {
            screenWriter.printTurnResult(board1, board2);

            playTurn(attackingPlayer, defendingPlayer);

            if (attackingPlayer.isDefeated() || defendingPlayer.isDefeated()) {
                gameFinished = true;
            }

            swapPlayers();
        }
    }

    private void playTurn(Player attackingPlayer, Player enemyPlayer) {
        String attackCoordinates = attackingPlayer.getAttackCoordinates();
        defendingPlayer.attackAtAndGetHitType(attackCoordinates);
    }

    private void swapPlayers() {
        Player tmp = attackingPlayer;
        attackingPlayer = defendingPlayer;
        defendingPlayer = tmp;
    }
}

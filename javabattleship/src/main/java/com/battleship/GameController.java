package com.battleship;

public class GameController {
    private static ScreenWriter screenWriter;
    private Player player1;
    private Player player2;
    private GameBoard board1;
    private GameBoard board2;

    public GameController(Player player1, Player player2) {
        screenWriter = new ScreenWriter();
        this.player1 = player1;
        this.player2 = player2;

        board1 = player1.getBoard();
        board2 = player2.getBoard();
    }

    public void startGame() {
        boolean gameFinished = false;
        String player1AttackResult = "";
        String player2AttackResult = "";

        while (!gameFinished) {
            screenWriter.printTurnResult(board1, player1.numberOfShipsLeft(), player2AttackResult, board2, player2.numberOfShipsLeft(), player1AttackResult);

            player1AttackResult = playAttackAndGetResult(player1, player2);
            player2AttackResult = playAttackAndGetResult(player2, player1);
            if (player1.isDefeated() || player2.isDefeated()) {
                gameFinished = true;
            }
        }
    }

    private String playAttackAndGetResult(Player attackingPlayer, Player defendingPlayer) {
        String attackCoordinates = attackingPlayer.getAttackCoordinates();
        String attackResult = defendingPlayer.attackAtAndGetHitType(attackCoordinates);
        return " | " + attackResult + " at " + attackCoordinates;
    }
}

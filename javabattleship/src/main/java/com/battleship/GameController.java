package com.battleship;

public class GameController {
    private static ScreenWriter screenWriter;
    private Player player1;
    private Player player2;
    private GameBoard board1;
    private GameBoard board2;
    private Game game;

    public GameController(Player player1, Player player2) {
        screenWriter = new ScreenWriter();
        this.player1 = player1;
        this.player2 = player2;

        board1 = player1.getBoard();
        board2 = player2.getBoard();

        if (player1.getClass() == LanPlayer.class || player2.getClass() == LanPlayer.class) {
            game = new MultiPlayerGame();
            throw new UnsupportedOperationException("Multiplayer unimplemented");
        } else {
            game = new SinglePlayerGame(player1, player2);
        }
    }

    public void startGame() {
        game.startGame();
    }
}

package com.battleship;

public class SinglePlayerGameController implements GameController {
    private static ScreenWriter screenWriter;
    private static UserInput userInput;
    private Player attackingPlayer;
    private Player defendingPlayer;

    public SinglePlayerGameController() {
        screenWriter = new ScreenWriter();
        userInput = new UserInput();
    }

    @Override
    public void startGame() {
        LocalPlayer localPlayer = new LocalPlayer();
        BotPlayer botPlayer = new BotPlayer();
        attackingPlayer = localPlayer;
        defendingPlayer = botPlayer;

        while (true) {
            playTurn(attackingPlayer, defendingPlayer);

            screenWriter.printTurnResult(localPlayer.getBoard(), botPlayer.getBoard());

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

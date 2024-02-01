package com.battleship;

public class SinglePlayerGameController implements GameController {
    private static ScreenWriter screenWriter;
    private static UserInput userInput;

    public SinglePlayerGameController() {
        screenWriter = new ScreenWriter();
        userInput = new UserInput();
    }

    @Override
    public void startGame() {
        LocalPlayer localPlayer = new LocalPlayer();
        BotPlayer botPlayer = new BotPlayer();
        screenWriter.printBoard(botPlayer.getBoard());

        while (true) {
            System.out.println("Enter coordinates");
            String attackCoordinates = localPlayer.getAttackCoordinates();
            if (attackCoordinates.equals("exit")) {
                break;
            }
            botPlayer.attackAtAndGetHitType(attackCoordinates);

            attackCoordinates = botPlayer.getAttackCoordinates();
            localPlayer.attackAtAndGetHitType(attackCoordinates);
            screenWriter.clearConsole();

            System.out.println("Enemy Board");
            screenWriter.printBoard(botPlayer.getBoard());

            System.out.println("Your Board");
            screenWriter.printBoard(localPlayer.getBoard());
        }

    }
}

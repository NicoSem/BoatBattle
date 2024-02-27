package com.battleship;

public class Main {
    private static ScreenWriter screenWriter;
    private static UserInput userInput;

    public static void main(String[] args) throws Exception {
        screenWriter = new ScreenWriter();
        screenWriter.printStartMenu();
        
        Player player1 = null;
        Player player2 = null;

        userInput = new UserInput();
        int numberOfPlayers = userInput.getIntegerInput();
        
        if (numberOfPlayers == 1) {
            player1 = new LocalPlayer();
            player2 = new BotPlayer(new EasyAttackStrategy());
        }
        else if (numberOfPlayers == 2) {
            player1 = new LocalPlayer();
            player2 = new LanPlayer();
        }

        GameController gameController = new GameController(player1, player2);
        
        screenWriter.clearConsole();

        gameController.startGame();
        
    }
}
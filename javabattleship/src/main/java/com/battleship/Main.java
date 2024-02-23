package com.battleship;

public class Main {
    private static ScreenWriter screenWriter;
    private static UserInput userInput;
    public static void main(String[] args) throws Exception {
        screenWriter = new ScreenWriter();
        screenWriter.printStartMenu();
        
        userInput = new UserInput();
        int numberOfPlayers = userInput.getIntegerInput();
        GameController gameController = null;
        if (numberOfPlayers == 1) {
            Player player1 = new LocalPlayer();
            Player player2 = new BotPlayer(new EasyAttackStrategy());
            gameController = new GameController(player1, player2);
        }
        else if (numberOfPlayers == 2) {
            // TODO local multiplayer game
        }
        
        screenWriter.clearConsole();

        gameController.startGame();
        
    }
}
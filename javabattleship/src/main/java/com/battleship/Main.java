package com.battleship;

public class Main {
    private static ScreenWriter screenWriter;
    private static UserInput userInput;
    public static void main(String[] args) throws Exception {
        screenWriter = new ScreenWriter();
        screenWriter.printStartMenu();
        
        userInput = new UserInput();
        int numberOfPlayers = userInput.getIntegerInput();
        Player player1 = new LocalPlayer();
        Player player2 = new BotPlayer(new EasyAttackStrategy(player1.getBoard()));
        GameController gameController = new GameController(player1, player2);
        screenWriter.clearConsole();

        gameController.startGame();
        
    }
}
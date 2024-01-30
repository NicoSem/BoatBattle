package com.battleship;

public class Main {
    private static ScreenWriter screenWriter;
    private static UserInput userInput;
    public static void main(String[] args) throws Exception {
        screenWriter = new ScreenWriter();
        screenWriter.printStartMenu();
        
        userInput = new UserInput();
        int numberOfPlayers = userInput.getIntegerInput();
        GameController gameController = new SinglePlayerGameController();
        screenWriter.clearConsole();

        gameController.startGame();

        
    }
}
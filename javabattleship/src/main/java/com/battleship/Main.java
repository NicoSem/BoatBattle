package com.battleship;

public class Main {
    private static ScreenWriter screenWriter;
    private static UserInput screenReader;
    public static void main(String[] args) throws Exception {
        screenWriter = new ScreenWriter();
        screenWriter.printStartMenu();
        
        screenReader = new UserInput();
        int numberOfPlayers = screenReader.getIntegerInput();
        screenWriter.clearConsole();
    }
}
package com.battleship;

public class SinglePlayerGameController implements GameController{
    private static ScreenWriter screenWriter;
    private static UserInput userInput;

    public SinglePlayerGameController() {
        screenWriter = new ScreenWriter();
        userInput = new UserInput();
    }

    @Override
    public void startGame() {
        GameBoard gameBoard = new GameBoard();
        screenWriter.printBoard(gameBoard);

        System.out.println("Enter coordinates");
        Cell cell = gameBoard.cellAt(userInput.getCoordinateInput());
        
        cell.attackAndGetHitType();
        screenWriter.clearConsole();
        screenWriter.printBoard(gameBoard);
    }

    
}

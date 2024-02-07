package com.battleship;

public class LocalPlayer implements Player {
    private GameBoard gameBoard;
    private Ship[] ships;
    private UserInput userInput;

    public LocalPlayer() {
        gameBoard = new UserGameBoard();
        userInput = new UserInput();

        ships = gameBoard.getShipsRandomized();
    }

    @Override
    public String getAttackCoordinates() {
        System.out.println("Enter coordinates");
        return userInput.getStringInput();
    }

    @Override
    public String attackAtAndGetHitType(String coordinates) {
        return gameBoard.attackCellAndGetHitType(coordinates);
    }

    @Override
    public GameBoard getBoard() {
        return gameBoard;
    }

    @Override
    public Ship[] getShips() {
        return ships;
    }

}

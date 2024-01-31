package com.battleship;

public class LocalPlayer implements Player {
    private GameBoard gameBoard;
    private Ship[] ships;

    public LocalPlayer(){
        gameBoard = new GameBoard();

        ships = new Ship[5];
        ships[0] = new Ship(gameBoard.getCellArrayAt(0, 0, 5, 'd'));
        ships[1] = new Ship(gameBoard.getCellArrayAt(0, 1, 4, 'd'));
        ships[2] = new Ship(gameBoard.getCellArrayAt(0, 2, 3, 'd'));
        ships[3] = new Ship(gameBoard.getCellArrayAt(0, 3, 3, 'd'));
        ships[4] = new Ship(gameBoard.getCellArrayAt(0, 4, 2, 'd'));
    }

    @Override
    public String getAttackCoordinates() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAttackCoordinates'");
    }

    @Override
    public String attackAtAndGetHitType(String coordinates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attackAtAndGetHitType'");
    }

    @Override
    public GameBoard getBoard(){
        return gameBoard;
    }

}

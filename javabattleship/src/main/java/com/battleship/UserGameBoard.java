package com.battleship;

public class UserGameBoard extends GameBoard {
    public UserGameBoard() {
        Cell[][] cells = new Cell[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                cells[row][col] = new UserCell(row, col);
            }
        }
        this.setCells(cells);
    }
}

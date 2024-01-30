package com.battleship;

public class GameBoard {
    private Cell[][] cells;

    public GameBoard() {
        cells = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell(Integer.toString(i) + Integer.toString(j));
            }
        }
    }

    public Cell cellAt(int i, int j) {
        return cells[i][j];
    }

    public Cell cellAt(String coordinates) {
        int i = Character.getNumericValue(coordinates.charAt(0));
        int j = Character.getNumericValue(coordinates.charAt(1));
        return cells[i][j];
    }

    public String rowToString(int row) {
        String rowString = "";
        Cell[] cellRow = cells[row];
        for (Cell cell : cellRow) {
            rowString += cell + " ";
        }

        return rowString;
    }

    public Cell[] getCellArrayAt(int i, int j, int size, char direction) {
        Cell[] cellArray;
        try {
            if (direction == 'u') {
                if (i + 1 - size < 0) {
                    throw new Exception();
                } else {
                    cellArray = CellArrayAt(i, j, size, direction);
                }
            } else if (direction == 'd') {
                if (i + 1 + size > 10) {
                    throw new Exception();
                } else {
                    cellArray = CellArrayAt(i, j, size, direction);
                }
            } else if (direction == 'l') {
                if (j + 1 - size < 0) {
                    throw new Exception();
                } else {
                    cellArray = CellArrayAt(i, j, size, direction);
                }
            } else if (direction == 'r') {
                if (i + 1 + size > 10) {
                    throw new Exception();
                } else {
                    cellArray = CellArrayAt(i, j, size, direction);
                }
            } else {
                throw new Exception();
            }
        } catch(Exception e) {

        }
        
        return cellArray;
    }

    private Cell[] CellArrayAt(int i, int j, int size, char direction) {
        Cell[] cellArray = new Cell[size];
        for (int )

        return cellArray;
    }
}

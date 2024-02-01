package com.battleship;

public class GameBoard {
    private Cell[][] cells;

    public GameBoard() {
        cells = new Cell[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public Cell cellAt(int row, int col) {
        return cells[row][col];
    }

    public Cell cellAt(String coordinates) {
        int i = Character.getNumericValue(coordinates.charAt(0));
        int j = Character.getNumericValue(coordinates.charAt(1));
        return cells[i][j];
    }

    public String attackCellAndGetHitType(String coordinates) {
        return cellAt(coordinates).attackAndGetHitType();
    }

    public String rowToString(int row) {
        String rowString = "";
        Cell[] cellRow = cells[row];
        for (Cell cell : cellRow) {
            rowString += cell + " ";
        }

        return rowString;
    }

    public Cell[] getCellArrayAt(int row, int col, int size, char direction) {
        Cell[] cellArray = new Cell[0];
        try {
            if (direction == 'u') {
                if (row + 1 - size >= 0) {
                    cellArray = cellArrayAt(row, col, size, direction);
                } else {
                    throw new Exception();
                }
            } else if (direction == 'd') {
                if (row + size < 10) {
                    cellArray = cellArrayAt(row, col, size, direction);
                } else {
                    throw new Exception();
                }
            } else if (direction == 'l') {
                if (col + 1 - size <= 0) {
                    cellArray = cellArrayAt(row, col, size, direction);
                } else {
                    throw new Exception();
                }
            } else if (direction == 'r') {
                if (col + size < 10) {
                    cellArray = cellArrayAt(row, col, size, direction);
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {

        }

        return cellArray;
    }

    private Cell[] cellArrayAt(int row, int col, int size, char direction) {
        Cell[] cellArray = new Cell[size];
        for (int i = 0; i < size; i++) {
            if (direction == 'u') {
                cellArray[i] = cells[row - i][col];
            } else if (direction == 'd') {
                cellArray[i] = cells[row + i][col];
            } else if (direction == 'l') {
                cellArray[i] = cells[row][col - i];
            } else if (direction == 'r') {
                cellArray[i] = cells[row][col + i];
            }
        }

        return cellArray;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}

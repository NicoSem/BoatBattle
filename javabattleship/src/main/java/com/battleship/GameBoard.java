package com.battleship;

import java.util.ArrayList;
import java.util.List;

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
            if (GameBoard.maxShipSizeAt(row, col, direction) >= size) {
                return cellArrayAt(row, col, size, direction);
            } else {
                throw new Exception("Cell array out of bounds");
            }
        } catch (Exception e) {
            System.out.println(e);
            return cellArray;
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public ArrayList<Cell> getCellsList() {
        ArrayList<Cell> cellList = new ArrayList<Cell>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cellList.add(cells[i][j]);
            }
        }

        return cellList;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Ship[] getShipsRandomized() {
        ArrayList<Cell> possibleShipLocations = getCellsList();
        boolean placed = false;
        int[] shipSizes = {5, 4, 3, 3, 2};
        int shipIndex = 0;
        char direction = randomDirection();
        Ship[] ships = new Ship[5];

        for (int shipSize : shipSizes) {
            placed = false;
            while(!placed) {
                int randIndex = (int) (Math.random() * possibleShipLocations.size());
                Cell randomCell = possibleShipLocations.get(randIndex);
                int[] cellIntCoordintes = randomCell.getIntegerCoordinates();
                try {
                    Ship ship = new Ship(getCellArrayAt(cellIntCoordintes[0], cellIntCoordintes[1], shipSize, direction));
                    placed = true;
                    possibleShipLocations.remove(randIndex);
                    possibleShipLocations = Cell.removeCellsFromList(possibleShipLocations, ship.getCells());
                    ships[shipIndex] = ship;
                    shipIndex++;
                } catch (Exception e1) {
                    if (direction == 'r'){
                        direction = 'd';
                    } else {
                        direction = 'r';
                    }
                    try{
                        Ship ship = new Ship(getCellArrayAt(cellIntCoordintes[0], cellIntCoordintes[1], shipSize, direction));
                        placed = true;
                        possibleShipLocations.remove(randIndex);
                        possibleShipLocations = Cell.removeCellsFromList(possibleShipLocations, ship.getCells());
                        ships[shipIndex] = ship;
                        shipIndex++;
                    } catch (Exception e2) {
                        possibleShipLocations.remove(randIndex);
                        direction = randomDirection();
                    }
                }
            }
        }

        return ships;
    }

    public static int maxShipSizeAt(int row, int col, char direction) {
        if (direction == 'u') {
            if (row > 3) {
                return 5;
            } else {
                return row + 1;
            }
        } else if (direction == 'd') {
            if (row < 6) {
                return 5;
            } else {
                return 10 - row;
            }
        } else if (direction == 'l') {
            if (col > 3) {
                return 5;
            } else {
                return col + 1;
            }
        } else if (direction == 'r') {
            if (col < 6) {
                return 5;
            } else {
                return 10 - col;
            }
        } else {
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }
    

    

    private char randomDirection() {
        if (Math.random() < 0.5) {
            return 'd';
        } else {
            return 'r';
        }
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


}

package com.battleship;

public class Ship {
    private int size;
    private Cell[] cells;

    public Ship(Cell[] cells) throws Exception {
        size = cells.length;
        if (size < 1 || size > 5) {
            throw new IllegalArgumentException("Ship of cell count " + size + " cannot be created");
        } else {
            this.cells = cells;
        }

        for (Cell cell : this.cells) {
            if (cell.getShip() != null) {
                throw new Exception("A ship already exists on cell " + cell.getCoordinates());
            }
            cell.setShip(this);
        }
    }

    public int getSize() {
        return size;
    }

    public Cell[] getCells() {
        return cells;
    };

    public boolean isSunk() {
        for (Cell cell : cells) {
            if (cell.getState() != "hit") {
                return false;
            }
        }
        
        return true;
    }
}

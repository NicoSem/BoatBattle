package com.battleship;

public class Ship {
    private int size;
    private Cell[] cells;

    public Ship(Cell[] cells) {
        size = cells.length;
        if (size < 1 || size > 5) {
            throw new IllegalArgumentException("Ship of cell count " + size + " cannot be created");
        } else {
            this.cells = cells;
        }

        for (Cell cell : this.cells) {
            cell.setShip(this);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isSunk() {
        for (Cell cell : cells) {
            if (cell.getState() != "hit") {
                return false;
            }
        }
        
        return true;
    }
}

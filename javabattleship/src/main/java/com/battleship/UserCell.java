package com.battleship;

public class UserCell extends Cell {

    public UserCell(int row, int col) {
        super(row, col);
    }

    public UserCell(String coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        if (super.getState().equals("hit")) {
            return "x";
        } else if (super.getShip() == null) {
            return ".";
        } else {
            if (super.getShip().getSize() == 5) {
                return "C";
            } else if (super.getShip().getSize() == 4) {
                return "B";
            } else if (super.getShip().getSize() == 3) {
                return "S";
            } else if (super.getShip().getSize() == 2) {
                return "D";
            }
        }
        return "";
    }
}

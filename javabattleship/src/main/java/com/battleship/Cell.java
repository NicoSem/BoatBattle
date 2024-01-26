package com.battleship;

import java.util.regex.*;

public class Cell {
    private String coordinates;
    private String state;

    public Cell(String coordinates) {
        state = "none";
        if (isValidCoordinates(coordinates)) {
            this.coordinates = coordinates;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        if (state.equals("miss")) {
            return "o";
        } else if (state.equals("hit")) {
            return "x";
        } else {
            return ".";
        }
    }

    public boolean attackCell() {
        state = "miss";
        return false;
    }

    private static boolean isValidCoordinates(String coordinateToCheck) {
        Pattern pattern = Pattern.compile("[0-9][0-9]");
        if (coordinateToCheck.equals("A0")) {
            return true;
        } else {
            return false;
        }
    }

    public String getState() {
        return state;
    }

    public String getCoordinates() {
        return coordinates;
    }
}
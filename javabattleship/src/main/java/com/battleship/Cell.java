package com.battleship;

import java.util.regex.*;

public class Cell {
    private String coordinates;
    private String state;
    private Ship ship;

    public Cell(String coordinates) {
        state = "none";
        ship = null;
        if (isValidCoordinates(coordinates)) {
            this.coordinates = coordinates;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Cell(int row, int col) {
        state = "none";
        ship = null;
        String coordinates = Integer.toString(row) + Integer.toString(col);
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

    public String attackAndGetHitType() {
        if (ship == null) {
            state = "miss";
            return "miss";
        } else {
            state = "hit";
            return "hit";
        }
    }

    private static boolean isValidCoordinates(String coordinateToCheck) {
        Pattern pattern = Pattern.compile("\\b[0-9][0-9]\\b");
        Matcher matcher = pattern.matcher(coordinateToCheck);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public String getState() {
        return state;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public int[] getIntegerCoordinates() {
        int[] intCoordinates = new int[2];
        intCoordinates[0] = Character.getNumericValue(coordinates.charAt(0));
        intCoordinates[1] = Character.getNumericValue(coordinates.charAt(0));
        return intCoordinates;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean equals(Cell otherCell) {
        return this.getCoordinates().equals(otherCell.getCoordinates());
    }
}
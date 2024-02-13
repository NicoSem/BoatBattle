package com.battleship;

public class LocalPlayer extends Player {

    private UserInput userInput;

    public LocalPlayer() {
        super();
        this.setBoard(new UserGameBoard());
        userInput = new UserInput();
    }

    public String getAttackCoordinates() {
        System.out.println("Enter coordinates");
        return userInput.getStringInput();
    }

}

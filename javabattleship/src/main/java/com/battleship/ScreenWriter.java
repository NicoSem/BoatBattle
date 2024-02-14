package com.battleship;

public class ScreenWriter {

    public void printStartMenu() {
        System.out.println("######     #    ####### ####### #       #######  #####  #     # ### ######  \r\n" + //
                "#     #   # #      #       #    #       #       #     # #     #  #  #     # \r\n" + //
                "#     #  #   #     #       #    #       #       #       #     #  #  #     # \r\n" + //
                "######  #     #    #       #    #       #####    #####  #######  #  ######  \r\n" + //
                "#     # #######    #       #    #       #             # #     #  #  #       \r\n" + //
                "#     # #     #    #       #    #       #       #     # #     #  #  #       \r\n" + //
                "######  #     #    #       #    ####### #######  #####  #     # ### #       \r\n");

        System.out.println("Select number of players (1, 2)");
    };

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

    public void printBoard(GameBoard gameBoard) {
        for (int i = 0; i < 10; i++) {
            System.out.println(gameBoard.rowToString(i));
        }
    }

    public void printTurnResult(GameBoard friendlyBoard, int friendlyShipsLeft, String friendlyResult, GameBoard enemyBoard, int enemyShipsLeft, String enemyResult) {
        clearConsole();

        System.out.println("Enemy Board | Ships left: " + enemyShipsLeft + enemyResult);
        printBoard(enemyBoard);

        System.out.println("Your Board | Ships left: " + friendlyShipsLeft + friendlyResult);
        printBoard(friendlyBoard);
    }
}

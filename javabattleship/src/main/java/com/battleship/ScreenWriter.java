package com.battleship;

public class ScreenWriter {

    public void printStartMenu() {
        System.out.println( "######     #    ####### ####### #       #######  #####  #     # ### ######  \r\n" + //
                            "#     #   # #      #       #    #       #       #     # #     #  #  #     # \r\n" + //
                            "#     #  #   #     #       #    #       #       #       #     #  #  #     # \r\n" + //
                            "######  #     #    #       #    #       #####    #####  #######  #  ######  \r\n" + //
                            "#     # #######    #       #    #       #             # #     #  #  #       \r\n" + //
                            "#     # #     #    #       #    #       #       #     # #     #  #  #       \r\n" + //
                            "######  #     #    #       #    ####### #######  #####  #     # ### #       \r\n"
        );

        System.out.println("Select number of players (1, 2)");
    };

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
    }
}

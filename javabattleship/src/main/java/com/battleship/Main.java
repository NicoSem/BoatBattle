package com.battleship;

public class Main {
    private static ScreenWriter screenWriter;
    private static UserInput userInput;

    public static void main(String[] args) throws Exception {
        screenWriter = new ScreenWriter();
        screenWriter.printStartMenu();
        
        Player player1 = null;
        Player player2 = null;

        userInput = new UserInput();
        int numberOfPlayers = userInput.getIntegerInput();
        
        if (numberOfPlayers == 1) {
            player1 = new LocalPlayer();
            player2 = new BotPlayer(new EasyAttackStrategy());
            createAndStartGame(player1, player2);
        }
        else if (numberOfPlayers == 2) {
            System.out.println("Enter host or join");
            String connectionType = userInput.getStringInput();
            if (connectionType.equals("host")){
                System.out.println("Waiting for player2...");
                player1 = new LocalPlayer();
                player2 = new LanPlayer(player1.getBoard());
                createAndStartGame(player1, player2);
            } else {
                LocalPlayer player = new LocalPlayer();
                GameClient gameClient = new GameClient(player);
                gameClient.startConnection("127.0.0.1", 6000);
            }
        }
    }

    private static void createAndStartGame(Player player1, Player player2) {
        GameController gameController = new GameController(player1, player2);
        
        screenWriter.clearConsole();

        gameController.startGame();
    }
}
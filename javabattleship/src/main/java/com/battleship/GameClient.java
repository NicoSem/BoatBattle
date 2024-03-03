package com.battleship;

import java.net.*;
import java.util.concurrent.Semaphore;
import java.io.*;

public class GameClient {
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private LocalPlayer localPlayer;
    private GameBoard friendlyBoard;
    private GameBoard enemyBoard;
    private Semaphore turnSemaphore;
    private ScreenWriter screenWriter;
    private String coordinates;

    public GameClient(String ip, int port, LocalPlayer player) {
        localPlayer = player;
        friendlyBoard = localPlayer.getBoard();
        enemyBoard = new GameBoard();
        screenWriter = new ScreenWriter();
        try {
            clientSocket = new Socket(ip, port);
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            localPlayer = player;
            turnSemaphore = new Semaphore(0);
            screenWriter.printTurnResult(friendlyBoard, 5, "", enemyBoard, 5, "");

            
            Thread sender = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            screenWriter.printTurnResult(friendlyBoard, 5, "", enemyBoard, 5, "");
                            turnSemaphore.acquire();
                            coordinates = localPlayer.getAttackCoordinates();
                            out.writeUTF(coordinates);
                            out.flush();
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                }
            });

            Thread receiver = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    try {
                        msg = "";
                        coordinates = "";
                        while(!msg.equals("done")) {   
                            msg = in.readUTF();
                            if (Cell.isValidCoordinates(msg)){
                                String attackResult = localPlayer.attackAtAndGetHitType(msg);
                                out.writeUTF(attackResult);
                                out.flush();
                                turnSemaphore.release();
                            } else {
                                enemyBoard.cellAt(coordinates).setState(msg);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("error");
                    }
                }
            });

            sender.start();
            receiver.start();
        } catch (Exception e) {
            // TODO: handle exception
        }

        
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public boolean isConnected() {
        return clientSocket.isConnected();
    }
}
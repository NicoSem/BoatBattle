package com.battleship;

import java.net.*;
import java.util.concurrent.Semaphore;
import java.io.*;

public class GameClient {
    private Socket clientSocket;

    private DataOutputStream out;
    private DataInputStream in;

    private Thread sender;
    private Thread receiver;

    private Player player;

    private GameBoard playerBoard;
    private GameBoard enemyBoard;

    private Semaphore turnSemaphore;

    private ScreenWriter screenWriter;

    private String coordinates;

    private boolean isGameRunning;

    public GameClient(Player player) {
        this.player = player;
        playerBoard = player.getBoard();
        enemyBoard = new GameBoard();
        screenWriter = new ScreenWriter();
        turnSemaphore = new Semaphore(0);
        isGameRunning = false;
    }

    public void startConnection(String ip, int port) {
        
        isGameRunning = true;

        try {
            clientSocket = new Socket(ip, port);
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            screenWriter.printTurnResult(playerBoard, 5, "", enemyBoard, 5, "");

            
            sender = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isGameRunning) {
                        try {
                            screenWriter.printTurnResult(playerBoard, 5, "", enemyBoard, 5, "");
                            turnSemaphore.acquire();
                            coordinates = player.getAttackCoordinates();
                            out.writeUTF(coordinates);
                            out.flush();
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                }
            });

            receiver = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    try {
                        msg = "";
                        coordinates = "";
                        while(isGameRunning && !msg.equals("done")) {   
                            msg = in.readUTF();
                            if (Cell.isValidCoordinates(msg)){
                                String attackResult = player.attackAtAndGetHitType(msg);
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
            stopThreads();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void stopThreads() {
        isGameRunning = false;
        turnSemaphore.release();
    }

    public boolean isConnected() {
        return clientSocket.isConnected();
    }
}
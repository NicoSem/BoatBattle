package com.battleship;

import java.net.*;
import java.io.*;

public class GameClient {
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private LocalPlayer localPlayer;

    public GameClient(String ip, int port, LocalPlayer player) {
        try {
            clientSocket = new Socket(ip, port);
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            localPlayer = player;

            Thread sender = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while (true) {
                        try {
                            msg = localPlayer.getAttackCoordinates();
                            out.writeUTF(msg);
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
                        while(!msg.equals("done")) {
                            System.out.println(msg);
                            msg = in.readUTF();
                            out.writeUTF(localPlayer.attackAtAndGetHitType(msg));
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
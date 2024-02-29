package com.battleship;

import java.net.*;
import java.io.*;

public class GameClient {
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            while(!in.readUTF().equals("done")){
                System.out.println(in.readUTF());
                out.writeUTF("55");
            }
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
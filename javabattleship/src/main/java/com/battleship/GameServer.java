package com.battleship;

import java.net.*;
import java.io.*;

public class GameServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public String getCoordinates() {
        try {
            return in.readUTF();
        } catch (Exception e) {
            System.out.println(e);
            return "00";
        }
        
    }

    public String sendCoordinatesAndGetResult(String coordinates) {
        try {
            out.writeUTF(coordinates);
            out.flush();
            return "miss";
        } catch (Exception e) {
            System.out.println(e);
            return "miss";
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.start(6000);
    }
}

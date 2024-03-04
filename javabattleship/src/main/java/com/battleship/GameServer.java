package com.battleship;

import java.net.*;
import java.io.*;

public class GameServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    private DataOutputStream out;
    private DataInputStream in;

    private String serverStatus;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            serverStatus = "OK";
        } catch (Exception e) {
            serverStatus = "FAILED TO INITIALIZE";
            System.out.println("Server status: " + serverStatus + " | " + e);
        }
    }

    public String getCoordinates() {
        try {
            String receivedCoordinates = in.readUTF();
            if (Cell.isValidCoordinates(receivedCoordinates)) {
                return receivedCoordinates;
            } else {
                return "00";
            }
        } catch (Exception e) {
            System.out.println("Server status: " + serverStatus + " | " + e);
            return "00";
        }
    }

    public void sendAttackResult(String result) {
        try {
            out.writeUTF(result);
            out.flush();
        } catch (Exception e) {
            System.out.println("Server status: " + serverStatus + " | " + e);
        }
    }

    public String sendCoordinatesAndGetResult(String coordinates) {
        try {
            out.writeUTF(coordinates);
            out.flush();
            return in.readUTF();
        } catch (Exception e) {
            System.out.println("Server status: " + serverStatus + " | " + e);
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
            serverStatus = "FAILED TO CLOSE";
            System.out.println("Server status: " + serverStatus + " | " + e);
        }
        
    }
}

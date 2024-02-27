package com.battleship;

import java.net.*;
import java.io.*;

public class GameServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public String getCoordinates() {
        try {
            out.println("enter coordinates");
            return in.readLine();
        } catch (Exception e) {
            return "00";
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
        server.start(6666);
    }
}

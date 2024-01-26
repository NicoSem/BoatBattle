package com.battleship;

import java.io.*;

public class UserInput {
    private BufferedReader bufferedReader;
    
    public UserInput() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getIntegerInput() {
        try {
            int integerInput = Integer.parseInt(bufferedReader.readLine());
            return integerInput;
        } 
        catch (IOException e) {
            System.out.println(e);
            return 0;
        }
        
    }

}

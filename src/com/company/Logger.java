package com.company;

import java.io.*;

public class Logger {
    private static Logger instance;

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public static void addLog(String log) {
        BufferedWriter z;
        try {
            z = new BufferedWriter(new FileWriter(new File("C:/Users/21091/Downloads/Laba2/sotrudnik.txt"),true));

            z.newLine();
            z.write(log + "\n");

            z.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

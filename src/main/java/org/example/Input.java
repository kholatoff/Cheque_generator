package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public ArrayList<String> getInput(String fileName){
        ArrayList<String> res = new ArrayList<>();

        try {
            File inFile = new File(fileName);
            Scanner Reader = new Scanner(inFile);
            while (Reader.hasNext()) {
                String data = Reader.next();
                res.add(data);
            }
            Reader.close();
        }
        catch(FileNotFoundException err){
            System.out.println("Reading error! File not found!");
        }
        return res;
    }
}

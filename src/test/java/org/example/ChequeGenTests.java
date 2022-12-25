package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChequeGenTests {
    private ChequeFileGen chequeGen = new ChequeFileGen();
    private static ArrayList<String> testData;

    @BeforeAll
    public static void setTestData(){
        testData = new ArrayList<>();
        testData.add("2   Milk                 12,30   24,60\n" +
                "5   Nutella              53,10   265,50\n" +
                "    10% discount applied!\n" +
                "3   Bread                 7,10   21,30\n" +
                "\n" +
                "Discount card applied!\n" +
                "\n" +
                "Your grand total is 256,36");
    }
    @Test
    public void chequeGen_generateFile_test() {
        ArrayList<String> expectedResult = new ArrayList<>();
        try {
            File inFile = new File("test_cheque.txt");
            Scanner Reader = new Scanner(inFile);
            while (Reader.hasNext()) {
                String data = Reader.next();
                expectedResult.add(data);
            }
            Reader.close();
        }
        catch(FileNotFoundException err){
            System.out.println("Reading error! File not found!");
        }
        chequeGen.generateFile(testData);
        ArrayList<String> actualResult = new ArrayList<>();
        try {
            File inFile = new File(chequeGen.getChequeFileName());
            Scanner Reader = new Scanner(inFile);
            while (Reader.hasNext()) {
                String data = Reader.next();
                actualResult.add(data);
            }
            Reader.close();
        }
        catch(FileNotFoundException err){
            System.out.println("Reading error! File not found!");
        }
        Assertions.assertEquals(expectedResult, actualResult);
    }
}

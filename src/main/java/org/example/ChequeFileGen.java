package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class ChequeFileGen {
    private String chequeFileName;

    public String getChequeFileName(){
        return chequeFileName;
    }

    public void setChequeFileName(String fileName) {
        chequeFileName = fileName;
    }
    public void generateFile(ArrayList<String> chequeStrings)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = new String("cheque_"+ dtf.format(now) + ".txt");

        setChequeFileName(fileName);

        File File = new File(fileName);
        try {
            if (File.createNewFile()) {
                System.out.println("File successfully created.");
            } else {
                System.out.println("File already exists.");
            }
            FileWriter Writer = new FileWriter(fileName);
            Writer.write(String.format("\n" +
                    " ██████╗██╗  ██╗███████╗ ██████╗ ██╗   ██╗███████╗\n" +
                    "██╔════╝██║  ██║██╔════╝██╔═══██╗██║   ██║██╔════╝\n" +
                    "██║     ███████║█████╗  ██║   ██║██║   ██║█████╗  \n" +
                    "██║     ██╔══██║██╔══╝  ██║▄▄ ██║██║   ██║██╔══╝  \n" +
                    "╚██████╗██║  ██║███████╗╚██████╔╝╚██████╔╝███████╗\n" +
                    " ╚═════╝╚═╝  ╚═╝╚══════╝ ╚══▀▀═╝  ╚═════╝ ╚══════╝\n" +
                    "                                                  \n" +
                    "QTY Description          Price   Total\n\n"));
            for(String Line : chequeStrings) {
                Writer.write(Line);
            }
            Writer.close();
            System.out.println("Cheque successfully generated.");
        }
        catch (IOException err) {
            System.out.println("Writing error!");
        }
    }
}

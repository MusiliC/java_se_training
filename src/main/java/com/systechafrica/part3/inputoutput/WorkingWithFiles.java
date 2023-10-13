package com.systechafrica.part3.inputoutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkingWithFiles {
    public static void main(String[] args) throws IOException {
        //workingWithFiles();
       // workingWithFileStreams();
       
    }

    public static void workingWithFiles() throws IOException {
        String fileSeparator = System.getProperty("file.separator");
        String absolutePath = "E:\\java\\Java Training\\java_se_training\\src\\main\\java\\com\\systechafrica\\part3\\inputoutput\\WorkingWithFiles.jaav";
        String relativePath = "src\\main\\java\\com\\systechafrica\\part3\\inputoutput\\WorkingWithFiles.java";

        File logFile = new File("E:\\java\\Java Training\\java_se_training\\log.txt");

        // System.out.println(logFile.exists());
        // System.out.println(logFile.isFile());
        // System.out.println(logFile.isDirectory());

        File baseDirectory = new File("E:\\java\\Java Training\\java_se_training\\");
        File tmpFile = new File(baseDirectory, "tmp");
        tmpFile.mkdir();
        File log = new File(tmpFile, "log.pdf");
        log.createNewFile();
        if (baseDirectory.exists() && baseDirectory.isDirectory()) {
            File[] listFiles = baseDirectory.listFiles();
            for (File file : listFiles) {
                System.out.println(file.getName());
            }
        }
    }

    private static void workingWithFileStreams() throws IOException{
         String fileSeparator = System.getProperty("file.separator");

         File quoteFile = new File("put.txt");

         if (quoteFile.exists() && quoteFile.isFile()) {
            FileReader fileReader = new FileReader(quoteFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            List<String> lines = new ArrayList<String>();
            while ((line = bufferedReader.readLine()) != null) {                
                lines.add(line);

            }  
            fileReader.close();
            bufferedReader.close();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number between 1-9: ");
            int quoteIndex = scanner.nextInt();
            System.out.println(lines.get(quoteIndex - 1));
         }

         
    }
}

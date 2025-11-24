//Write a Java program that reads the contents of a text file and writes it into a new file. 
// If the source file does not exist, display an appropriate message.

import java.io.*;

public class ReadWriteTextFile {
    public static void main(String[] args) {

        String sourceFile = "input.txt";      
        String destFile = "output.txt";       

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourceFile);

            fos = new FileOutputStream(destFile);

            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully!");

        } 
        catch (FileNotFoundException e) {
            System.out.println("Source file not found! Please create 'input.txt' first.");
        } 
        catch (IOException e) {
            System.out.println("An error occurred while reading/writing the file.");
        } 
        finally {
            
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing the files.");
            }
        }
    }
}

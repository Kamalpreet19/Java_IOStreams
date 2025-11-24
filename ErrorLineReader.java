//Problem 9. Read a Large File Line by Line


import java.io.*;

public class ErrorLineReader {

    public static void main(String[] args) {

        String fileName = "largefile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }

            System.out.println("\nFinished scanning the file.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
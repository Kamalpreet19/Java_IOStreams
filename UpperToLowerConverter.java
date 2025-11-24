//Problem 6. Filter Streams - Convert Uppercase to Lowercase

import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
      
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {

            int ch;
            while ((ch = br.read()) != -1) {
               
                char lowerChar = Character.toLowerCase((char) ch);
                bw.write(lowerChar);
            }

            System.out.println("Conversion Completed! Check output.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

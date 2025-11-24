//Write a Java program that converts an image file into a byte array and then writes it back to another image file.

import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream("original.jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }

            byte[] imageBytes = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream("copy.jpg");

            while ((data = bais.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            baos.close();
            fos.close();
            bais.close();

            System.out.println("Image copied successfully as copy.jpg");
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: original.jpg not found.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

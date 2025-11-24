//Problem 7. Data Streams - Store and Retrieve Primitive Data

import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {

        String fileName = "student.dat";

        try (
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos)
        ) {

            dos.writeInt(101);             
            dos.writeUTF("Amandeep Kaur"); 
            dos.writeFloat(8.75f);         

            System.out.println("Data written to student.dat successfully!");

        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }

        try (
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis)
        ) {

            int roll = dis.readInt();
            String name = dis.readUTF();
            float gpa = dis.readFloat();

            System.out.println("\nRetrieved Student Details:");
            System.out.println("Roll Number: " + roll);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}


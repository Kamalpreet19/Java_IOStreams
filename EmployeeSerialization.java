//Design a Java program that allows a user to store a list of employees in a file using Object Serialization and later retrieve the data from the file

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void showEmployee() {
        System.out.println(id + " | " + name + " | " + department + " | " + salary);
    }
}

public class EmployeeSerialization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> employeeList = new ArrayList<>();

        System.out.print("How many employees you want to enter? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Employee " + (i + 1));

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employeeList.add(new Employee(id, name, dept, salary));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(employeeList);
            System.out.println("\nEmployees successfully saved to employees.dat");
        } catch (IOException e) {
            System.out.println("Error while saving file: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {

            ArrayList<Employee> savedEmployees = (ArrayList<Employee>) ois.readObject();

            System.out.println("\nRetrieved Employees from file:");
            for (Employee emp : savedEmployees) {
                emp.showEmployee();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }

        sc.close();
    }
}


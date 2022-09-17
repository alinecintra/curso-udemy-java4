package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int employeesQuantity = sc.nextInt();

        for (int i = 1; i <= employeesQuantity; i++) {
            System.out.println("Employee #" + i + " data");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHours = sc.nextDouble();

            if(ch == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                Employee employee = new OutsourcedEmployee(name, hours, valuePerHours, additionalCharge);
                list.add(employee);
            }
            else {
                Employee employee = new Employee(name, hours, valuePerHours);
                list.add(employee);
            }
        }

        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee employee : list) {
            System.out.println(employee.getName() + " -  $ " + String.format("%.2f", employee.payment()));
        }
    }
}

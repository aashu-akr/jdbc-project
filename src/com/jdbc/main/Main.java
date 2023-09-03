package com.jdbc.main;
import com.jdbc.model.Employee;
import com.jdbc.service.DatabaseService;
//name of the table created is employee_info - use command : desc employee_info to see the table
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        DatabaseService databaseService = new DatabaseService();

        try(Scanner sc = new Scanner(System.in);) {

            boolean isRunning = true;

            while(isRunning){
                System.out.println("Enter choice: ");
                System.out.println("1. Insert: ");
                System.out.println("2. Select all: ");
                System.out.println("3. Select employee by id: ");
                System.out.println("4. Delete employee:  ");
                System.out.println("5. Update employee:  ");
                System.out.println("6. Exit  ");

                int choice = Integer.parseInt(sc.nextLine());

                switch(choice){
                    case 1:
                        System.out.println("Enter name, address, salary");
                        databaseService.insertEmployee(new Employee(sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine())));
                        break;

                    case 2:
                        databaseService.getAllEmployees();
                        break;

                    case 3:
                        System.out.println("enter the id: ");
                        databaseService.getById((Integer.parseInt(sc.nextLine())));
                        break;
                    case 4:
                        System.out.println("enter the id to delete the record: ");
                        databaseService.deleteById(Integer.parseInt(sc.nextLine()));
                        break;
                    case 5:
                        System.out.println("enter the id to update the record: ");
                        int updateId = Integer.parseInt(sc.nextLine());
                        boolean isFound = databaseService.getById(updateId);

                        if(isFound){
                            System.out.println("Enter name, address, salary");
                            Employee employee = new Employee(updateId,sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()));
                            databaseService.updateById(employee);
                        }
                        else System.out.println("record cannot be updated...");
                        break;
                    case 6:
                        System.out.println("thank you, visit again...");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("incorrect choice");

                        break;
                }
            }
        }
        catch(Exception e){
            throw  new RuntimeException("something went wring..." + e);
        }
    }
}
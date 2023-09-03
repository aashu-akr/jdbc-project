package com.jdbc.service;

import com.jdbc.model.Employee;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;

import java.sql.*;

public class DatabaseService {

    DatabaseUtil databaseutil = new DatabaseUtil();
    public void insertEmployee(Employee employee) throws SQLException {

        try(Connection con = databaseutil.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(QueryUtil.insertEmployeeQuery());){

            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeAddress());
            preparedStatement.setDouble(3,employee.getEmployeeSalary());

            int rows = preparedStatement.executeUpdate();

            if(rows>0) System.out.println("record updated..");
            else System.out.println("record not updated");
        }
    }//end of insertEmployee()


    public void getAllEmployees() throws SQLException{

        try(Connection con = databaseutil.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllEmployeeQuery());) {

            while(resultSet.next()){
                printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
                        resultSet.getString("EMPLOYEE_NAME"),
                        resultSet.getString("EMPLOYEE_ADDRESS"),
                        resultSet.getDouble("EMPLOYEE_SALARY")
                ));
            }
        }
    }//end of selectAll()
    public boolean getById(int id) throws SQLException{

        boolean isFound = false;

        try(Connection con = databaseutil.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(QueryUtil.selectByIdQuery(id));
        ) {
            if(resultSet.next()){
                isFound = true;
                printEmployee(new Employee((resultSet.getInt("employee_id")),resultSet.getString("employee_name"),resultSet.getString("employee_address"),resultSet.getDouble("employee_salary")));
            }
            else{
                System.out.println("Record not found for given "+ id);
            }

        }
        return isFound;
    }//end

    public void deleteById(int employeeId) throws SQLException{

        try(Connection con = databaseutil.getConnection();
        Statement statement = con.createStatement();
        ){
            int rows = statement.executeUpdate(QueryUtil.deleteById(employeeId));
            if(rows > 0 ) System.out.println("record deleted successfully...");
            else System.out.println("Something went wrong...");
        }

    }//end

    public void updateById(Employee employee) throws SQLException{


        try(Connection con = databaseutil.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(QueryUtil.updateById(employee.getEmployeeId()));
        ) {
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeAddress());
            preparedStatement.setDouble(3,employee.getEmployeeSalary());

            int rows = preparedStatement.executeUpdate();

            if(rows>0) System.out.println("record updated..");
            else System.out.println("record not updated...");
        }
    }//end

    private void printEmployee(Employee employee){
        System.out.println("Employee Id: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getEmployeeName());
        System.out.println("Employee Address: " + employee.getEmployeeAddress());
        System.out.println("Employee Salary: " + employee.getEmployeeSalary());
        System.out.println("------------------------------------------------------------------");
    }
}

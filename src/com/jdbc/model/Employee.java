package com.jdbc.model;

public class Employee {

        private int employeeId;
        private String employeeName;
        private String employeeAddress;
        private double employeeSalary;

    public Employee(String employeeName, String employeeAddress, double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
    }

    public Employee(int employeeId, String employeeName, String employeeAddress, double employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
    }


    //getter
        public int getEmployeeId() {
            return employeeId;
        }
        //setter
        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }
        //getter
        public String getEmployeeName() {
            return employeeName;
        }
        //setter
        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }
        //getter
        public String getEmployeeAddress() {
            return employeeAddress;
        }
        //setter
        public void setEmployeeAddress(String employeeAddress) {
            this.employeeAddress = employeeAddress;
        }
        //getter
        public double getEmployeeSalary() {
            return employeeSalary;
        }
        //setter
        public void setEmployeeSalary(double employeeSalary) {
            this.employeeSalary = employeeSalary;
        }
}

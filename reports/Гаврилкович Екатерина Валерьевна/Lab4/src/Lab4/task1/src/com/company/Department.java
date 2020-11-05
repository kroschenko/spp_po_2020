package com.company;

import java.util.ArrayList;

public class Department{
    private String name;
    private int count;
    private class Position{
        String title;
        int salary;
        @Override
        public String toString() {
            return "Position: " + title +
                    "\nSalary: " + salary + "$\n" ;
        }
    }
    private class Employee{
        String name;
        String surname;
        int age;
        String employeePosition;
        int employeeSalary;
        @Override
        public String toString() {
            return "Name " + name +
                    "\nSurname: " + surname +
                    "\nAge: " + age +
                    "\nPosition: " + employeePosition +
                    "\nSalary: " + employeeSalary + "\n";
        }

    }
    ArrayList<Position> positions = new ArrayList<>();
    public void AddPosition (String _title, int _salary) {
        Position pos = new Position();
        pos.title = _title;
        pos.salary = _salary;
        positions.add(pos);
    }
    public void show () {
        System.out.println("All positions: ");
        System.out.println();
        for (Position pos : positions) {
            System.out.println(pos.toString());
        }
        System.out.println("All employees: ");
        System.out.println();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
    ArrayList<Employee> employees = new ArrayList<>();
    public void AddEmployee (String _name, String _surname, int _age, String _employeePosition) {
        for (Position pos : positions){
            if((pos.title).equals(_employeePosition)){
                Employee employee = new Employee();
                employee.name = _name;
                employee.surname = _surname;
                employee.age = _age;
                employee.employeePosition = _employeePosition;
                employee.employeeSalary = pos.salary;
                employees.add(employee);
            }
        }
    }
}

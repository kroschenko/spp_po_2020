package com.company;

public class Main {

    public static void main(String[] args) {
        Department department = new Department();
        department.AddPosition("programmer", 2000);
        department.AddPosition("HR", 1000);
        department.AddEmployee("Katya", "Gavrilkovich", 23, "programmer");
        department.AddEmployee("Ivan", "Petrov", 30, "HR");
        department.AddEmployee("Ivan", "Serggev", 30, "Manager");
        department.AddEmployee("Dmitriy", "Petrov", 30, "HR");
        department.show();
    }
}

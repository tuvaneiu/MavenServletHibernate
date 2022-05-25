package com.entities;

public interface ComputeSalary {
    double payPerHourManager = 100000;
    double payPerHourEngineer = 50000;
    double payPerHourGuard = 75000;

    default double getPayPerHour(Position position){
        if (position.toString().equals("Manager")){ return payPerHourManager; }

        if (position.toString().equals("Engineer")){ return payPerHourEngineer; }

        return payPerHourGuard;
    }

    double computeSalary(Salary salary);
}

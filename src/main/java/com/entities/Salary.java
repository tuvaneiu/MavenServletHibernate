package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "salary_hiber")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int salaryId;
    private double taxRate;
    private double numOfWorkingDay;
    private double allowance;
    @OneToOne(targetEntity=Employee.class)
    private Employee employee;

    public Salary(double taxRate, double numOfWorkingDay, double allowance) {
        this.taxRate = taxRate;
        this.numOfWorkingDay = numOfWorkingDay;
        this.allowance = allowance;
    }

    public Salary() {
        super();
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getNumOfWorkingDay() {
        return numOfWorkingDay;
    }

    public void setNumOfWorkingDay(double numOfWorkingDay) {
        this.numOfWorkingDay = numOfWorkingDay;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", taxRate=" + taxRate +
                ", numOfWorkingDay=" + numOfWorkingDay +
                ", allowance=" + allowance +
                '}';
    }
}

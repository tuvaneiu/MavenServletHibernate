package com.entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "employee_hiber")
public class Employee implements ComputeSalary{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	@Column(length = 20)
	private String employeeId;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 20)
	private String phone;
	@Column(length = 50)
	private String email;
	private Date dateOfBirth;
	@Enumerated(EnumType.STRING)
	private Position position;
	@OneToOne(targetEntity=Salary.class, cascade=CascadeType.ALL)
	private Salary salary;

	public Employee(String employeeId, String firstName, String lastName, String phone, String email, Date dateOfBirth,
					Position position) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.position = position;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", employeeId='" + employeeId + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", position=" + position +
				", salary=" + salary.toString() +
				'}';
	}

	@Override
	public double computeSalary(Salary salary) {
		Employee employee = salary.getEmployee();

		return (getPayPerHour(employee.getPosition()) * salary.getNumOfWorkingDay() * 8.0 + salary.getAllowance())
				* (1 - salary.getTaxRate());
	}
}

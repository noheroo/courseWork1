package ru.skypro;

public class Employee {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private int department;
    private int salary;
    private final int id;
    static int counter = 1;


    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.id = getCounter();
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        counter++;

    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    private static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Работник: " + id + ", ФИО: " + lastName + " " + firstName + " " + middleName +
                ", Отдел: " + department + ", Зарплата: " + salary;
    }
}


package ru.skypro;

public class Main {



    public static void main(String[] args) {

        Employee employee1 = new Employee("Иванов", "Иван", "Иванович", 3, 59_000);
        Employee employee2 = new Employee("Карпов", "Петр", "Васильевич", 2, 35_000);
        Employee employee3 = new Employee("Афанасьев", "Василий", "Сергеевич", 5, 140_000);
        Employee employee4 = new Employee("Круглов", "Дмитрий", "Петрович", 4, 170_000);
        Employee employee5 = new Employee("Квадратный", "Павел", "Алексеевич", 1, 40_000);
        Employee employee6 = new Employee("Треуголов", "Валера", "Павлович", 3, 110_000);
        Employee employee7 = new Employee("Малов", "Данила", "Андреевич", 2, 74_000);
        Employee employee8 = new Employee("Моторный", "Ринат", "Алексеевич", 5, 240_000);


        EmployeeBook employeeBook1 = new EmployeeBook();

        employeeBook1.addEmployee(employee1);
        employeeBook1.addEmployee(employee2);
        employeeBook1.addEmployee(employee3);
        employeeBook1.addEmployee(employee4);
        employeeBook1.addEmployee(employee5);
        employeeBook1.addEmployee(employee6);
        employeeBook1.addEmployee(employee7);

        employeeBook1.printAll();

        System.out.printf("%nСумма затрат на зарплаты в месяц %d %n", employeeBook1.getSum());
        System.out.printf("Cреднее значение зарплат %.2f %n", employeeBook1.getAverageSalary());
        System.out.printf("%nМаксимальная зарплата у %s %n", employeeBook1.getEmployeeMaxSalary());
        System.out.printf("Минимальная зарплата у %s %n", employeeBook1.getEmployeeMinSalary());

        employeeBook1.printFIO();

        employeeBook1.salaryIndexing(20);

        employeeBook1.searchSalaryLess(100_000);
        employeeBook1.searchSalaryMore(100_000);

        System.out.printf("%nМаксимальная зарплата в отделе у %s %n", employeeBook1.getEmployeeInDepartmentMaxSalary(3));
        System.out.printf("Минимальная зарплата в отделе у %s %n", employeeBook1.getEmployeeInDepartmentMinSalary(3));

        System.out.printf("%nСумма затрат на зарплаты в месяц, в отделе %d %n", employeeBook1.getSumInDepartment(3));
        System.out.printf("Cреднее значение зарплат,в отделе %.2f %n", employeeBook1.getAverageSalaryInDepartment(3));
        employeeBook1.salaryIndexingInDepartment(3,10);
        employeeBook1.printDepartment(3);
        employeeBook1.printAll();

        employeeBook1.deleteEmployeeViaId(9);
        employeeBook1.deleteEmployeeViaFIO("КаарпОВ", "ПетР", "ВасиЛьевич");
        employeeBook1.deleteEmployeeViaIdAndFIO(6,"Круглов","ДмиТрий", "петрович");


        employeeBook1.addEmployee(employee8);
        employeeBook1.printAll();

        employeeBook1.changeSalary("КарпОВ", "ПетР", "ВасиЛьевич",85_000);
        employeeBook1.changeDepartment("КарпОВ", "ПетР", "ВасиЛьевич",8);

        employeeBook1.printAllEmployeeInDepartments();
    }


}
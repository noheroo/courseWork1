package ru.skypro;

public class Main {

    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        Employee employee1 = new Employee("Иванов", "Иван", "Иванович", 3, 59_000);
        Employee employee2 = new Employee("Карпов", "Петр", "Васильевич", 2, 35_000);
        Employee employee3 = new Employee("Афанасьев", "Василий", "Сергеевич", 5, 140_000);
        Employee employee4 = new Employee("Круглов", "Дмитрий", "Петрович", 4, 170_000);
        Employee employee5 = new Employee("Квадратный", "Павел", "Алексеевич", 1, 40_000);
        Employee employee6 = new Employee("Треуголов", "Валера", "Павлович", 3, 110_000);
        Employee employee7 = new Employee("Малов", "Данила", "Андреевич", 3, 74_000);

        addEmployee(employee1);
        addEmployee(employee2);
        addEmployee(employee3);
        addEmployee(employee4);
        addEmployee(employee5);
        addEmployee(employee6);
        addEmployee(employee7);

        printAll();

        System.out.printf("%nСумма затрат на зарплаты в месяц %d %n", getSum());
        System.out.printf("Cреднее значение зарплат %.2f %n", getAverageSalary());
        System.out.printf("%nМаксимальная зарплата у %s %n", getEmployeeMaxSalary());
        System.out.printf("Минимальная зарплата у %s %n", getEmployeeMinSalary());

        printFIO();

        salaryIndexing(20);

        searchSalaryLess(100_000);
        searchSalaryMore(100_000);

        System.out.printf("%nМаксимальная зарплата в отделе у %s %n", getEmployeeInDepartmentMaxSalary(3));
        System.out.printf("Минимальная зарплата в отделе у %s %n", getEmployeeInDepartmentMinSalary(3));

        System.out.printf("%nСумма затрат на зарплаты в месяц, в отделе %d %n", getSumInDepartment(3));
        System.out.printf("Cреднее значение зарплат,в отделе %.2f %n", getAverageSalaryInDepartment(3));
        salaryIndexingInDepartment(3,10);
        printDepartment(3);
        printAll();
    }

    //добавление нового сотрудника в массив
    private static void addEmployee(Employee Employee) {
        if (isFull()) {
            System.out.println("Невозможно добавить сотрудника, ID, которого " + Employee.getId() + ", нет места");
            return;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = Employee;
                return;
            }
        }
    }

    //проверка полный массив или нет
    public static boolean isFull() {
        for (Employee employee : employees) {
            if (employee == null) {
                return false;
            }
        }
        return true;
    }

    //сумма всех зарплат
    public static int getSum() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    //определение количества сотрудников
    public static int getQuantityEmployee() {
        int quantity = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                quantity++;
            }
        }
        return quantity;
    }

    //расчет средней зарплаты
    public static float getAverageSalary() {
        return (float) getSum() / getQuantityEmployee();
    }

    //Определение сотрудника с минимальной зарплатой
    public static StringBuilder getEmployeeMinSalary() {
        int minSalary = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    index = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(employees[index].getLastName() + " "
                + employees[index].getFirstName() + " "
                + employees[index].getMiddleName());

    }

    //Определение сотрудника с максисмальной зарплатой
    public static StringBuilder getEmployeeMaxSalary() {
        int maxSalary = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    index = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(employees[index].getLastName() + " "
                + employees[index].getFirstName() + " "
                + employees[index].getMiddleName());
    }

    //вывод списка всех сотрудников со всеми данными
    public static void printAll() {
        System.out.println("Список всех сотрудников");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    //вывод списка ФИО всех сотрудников
    public static void printFIO() {
        System.out.printf("%nСписок ФИО всех сотрудников%n");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
            }
        }
    }

    // индексация зарплаты
    public static void salaryIndexing(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (percent + 100) / 100);
            }
        }
    }

    //поиск сотрудников с зарплатой меньше, чем...
    public static void searchSalaryLess(int salaryLess) {
        System.out.println("\nСотрудники, с зарплатой меньше " + salaryLess);
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salaryLess) {
                System.out.println("id: " + employee.getId() + ". ФИО: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() +
                        ". Зарплата: " + employee.getSalary());
            }
        }
    }

    //поиск сотрудников с зарплатой больше, чем...
    public static void searchSalaryMore(int salaryMore) {
        System.out.println("\nСотрудники, с зарплатой больше " + salaryMore);
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salaryMore) {
                System.out.println("id: " + employee.getId() + ". ФИО: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() +
                        ". Зарплата: " + employee.getSalary());
            }
        }
    }

    //Определение сотрудника, в отделе, с минимальной зарплатой
    public static StringBuilder getEmployeeInDepartmentMinSalary(int department) {
        int minSalary = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(employees[index].getLastName() + " "
                + employees[index].getFirstName() + " "
                + employees[index].getMiddleName());

    }

    //Определение сотрудника, в отделе, с максисмальной зарплатой
    public static StringBuilder getEmployeeInDepartmentMaxSalary(int department) {
        int maxSalary = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(employees[index].getLastName() + " "
                + employees[index].getFirstName() + " "
                + employees[index].getMiddleName());
    }

    //сумма затрат на зарплату по отделу
    public static int getSumInDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    //расчет средней зарплаты по отделу
    public static float getAverageSalaryInDepartment(int department) {
        int quantity = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                quantity++;
            }
        }
        return (float) getSumInDepartment(department) / quantity;
    }


    //индексация зарплаты в отделе
    public static void salaryIndexingInDepartment(int department, int percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * (percent + 100) / 100);
            }
        }
    }

    //вывод списка всех сотрудников из отдела, со всеми данными
    public static void printDepartment(int department) {
        System.out.println("\nСписок всех сотрудников отдела " + department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id: " + employee.getId() + ". ФИО: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() +
                        ". Зарплата: " + employee.getSalary());
            }
        }
    }
}
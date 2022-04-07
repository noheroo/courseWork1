package ru.skypro;

class EmployeeBook {

    private final Employee[] employees = new Employee[10];

    //region добавление нового сотрудника в массив
    public void addEmployee(Employee Employee) {
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
    //endregion

    //region найти по id и удалить сотрудника
    public void deleteEmployeeViaId(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("\nСотрудник с id "+ id + " отсутствует в списке");
    }
    //endregion

    //region найти по ФИО и удалить сотрудника, не обращая внимание на регистр
    public void deleteEmployeeViaFIO(String lastName, String firstName, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getLastName().equalsIgnoreCase(lastName)  &&
                    employees[i].getFirstName().equalsIgnoreCase(firstName)  && employees[i].getMiddleName().equalsIgnoreCase(middleName)) {
                employees[i] = null;
                return;
            }
        }
        System.out.printf("Такого сотрудника нет %s %s %s %n", lastName, firstName, middleName);
    }
    //endregion

    //region найти по id и ФИО и удалить сотрудника, не обращая внимание на регистр
    public void deleteEmployeeViaIdAndFIO(int id, String lastName, String firstName, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id && employees[i].getLastName().equalsIgnoreCase(lastName)  &&
                    employees[i].getFirstName().equalsIgnoreCase(firstName)  && employees[i].getMiddleName().equalsIgnoreCase(middleName)) {
                employees[i] = null;
                return;
            }
        }
        System.out.printf("Такого сотрудника нет %s %s %s id %d %n", lastName, firstName, middleName, id);
    }
    //endregion

    // region изменение зарплаты
    public void changeSalary(String lastName, String firstName, String middleName, int newSalary) {
        if (newSalary < 0) {
            System.out.println("\nЗарплата не может быть отрицательной");
            return;
        }
        for (Employee employee : employees) {
            if (employee != null && employee.getLastName().equalsIgnoreCase(lastName) &&
                    employee.getFirstName().equalsIgnoreCase(firstName) &&
                    employee.getMiddleName().equalsIgnoreCase(middleName)) {
                employee.setSalary(newSalary);
            }
        }
    }
    //endregion

    // region изменение отдела
    public void changeDepartment(String lastName, String firstName, String middleName, int newDepartment) {
        if (newDepartment < 1 || newDepartment > 5) {
            System.out.println("\nНельзя изменить номер отдела, неверный номер ");
            return;
        }
        for (Employee employee : employees) {
            if (employee != null && employee.getLastName().equalsIgnoreCase(lastName) &&
                    employee.getFirstName().equalsIgnoreCase(firstName) && employee.getMiddleName().equalsIgnoreCase(middleName)) {
                employee.setDepartment(newDepartment);
            }
        }
    }
    //endregion

    //region проверка полный массив или нет
    private boolean isFull() {
        for (Employee employee : employees) {
            if (employee == null) {
                return false;
            }
        }
        return true;
    }
    //endregion

    //region сумма всех зарплат
    public int getSum() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    //endregion

    //region определение количества сотрудников
    private int getQuantityEmployee() {
        int quantity = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                quantity++;
            }
        }
        return quantity;
    }
    //endregion

    //region расчет средней зарплаты
    public float getAverageSalary() {
        return (float) getSum() / getQuantityEmployee();
    }
    //endregion

    //region Определение сотрудника с минимальной зарплатой
    public StringBuilder getEmployeeMinSalary() {
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
    //endregion

    //region Определение сотрудника с максисмальной зарплатой
    public StringBuilder getEmployeeMaxSalary() {
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
    //endregion

    //region вывод списка всех сотрудников со всеми данными
    public void printAll() {
        System.out.println("Список всех сотрудников");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    //endregion

    //region вывод списка ФИО всех сотрудников
    public void printFIO() {
        System.out.printf("%nСписок ФИО всех сотрудников%n");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
            }
        }
    }
    //endregion

    //region  индексация зарплаты
    public void salaryIndexing(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (percent + 100) / 100);
            }
        }
    }
    //endregion

    //region поиск сотрудников с зарплатой меньше, чем...
    public void searchSalaryLess(int salaryLess) {
        System.out.println("\nСотрудники, с зарплатой меньше " + salaryLess);
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salaryLess) {
                System.out.println("id: " + employee.getId() + ". ФИО: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() +
                        ". Зарплата: " + employee.getSalary());
            }
        }
    }
    //endregion

    //region поиск сотрудников с зарплатой больше, чем...
    public void searchSalaryMore(int salaryMore) {
        System.out.println("\nСотрудники, с зарплатой больше " + salaryMore);
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salaryMore) {
                System.out.println("id: " + employee.getId() + ". ФИО: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() +
                        ". Зарплата: " + employee.getSalary());
            }
        }
    }
    //endregion

    //region Определение сотрудника, в отделе, с минимальной зарплатой
    public StringBuilder getEmployeeInDepartmentMinSalary(int department) {
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
    //endregion

    //region Определение сотрудника, в отделе, с максисмальной зарплатой
    public StringBuilder getEmployeeInDepartmentMaxSalary(int department) {
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
    //endregion

    //region сумма затрат на зарплату по отделу
    public int getSumInDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    //endregion

    //region расчет средней зарплаты по отделу
    public float getAverageSalaryInDepartment(int department) {
        int quantity = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                quantity++;
            }
        }
        return (float) getSumInDepartment(department) / quantity;
    }
    //endregion

    //region индексация зарплаты в отделе
    public void salaryIndexingInDepartment(int department, int percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * (percent + 100) / 100);
            }
        }
    }
    //endregion

    //region вывод списка всех сотрудников из отдела, со всеми данными
    public void printDepartment(int department) {
        System.out.println("\nСписок всех сотрудников отдела " + department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id: " + employee.getId() + ". ФИО: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() +
                        ". Зарплата: " + employee.getSalary());
            }
        }
    }
    //endregion

    //region вывод сотрудников по отделам
    public void printAllEmployeeInDepartments() {
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            System.out.printf("В отделе №%d работают:%n", i);
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == i) {
                    System.out.println(employee);
                }
            }
        }
    }
    //endregion

}

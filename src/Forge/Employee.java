package Forge;

public class Employee {
    private final String name, surname, patronymic;
    private String department;
    private int salary;
    public int id;

    public static int idCounter;

    public Employee(String surname, String name, String patronymic, String department, int salary) {
        this.surname = surname.trim();
        this.name = name.trim();
        this.patronymic = patronymic.trim();
        this.department = department.trim();
        this.salary = salary;
        this.id = ++idCounter;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public String getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void printFullEmployeeInfo() {
        System.out.println(getSurname() + " " + getName() + " " + getPatronymic() + " " + getDepartment() + " " + getSalary());
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new RuntimeException("Значение не может быть отрицательным");
        }
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                getSurname() + " " + getName() + " " + getPatronymic() + "\n" +
                "Отдел: " + getDepartment() + "\n" +
                "Зарплата: " + getSalary() + " руб";
    }






}

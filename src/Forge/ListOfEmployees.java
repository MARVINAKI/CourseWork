package Forge;

import java.util.ArrayList;

public class ListOfEmployees {
    public static ArrayList<String> listOfEmployees;
    public static int size, count;
    private static final int indexID = 0, indexFullName = 1, indexDep = 2, indexSalary = 3;

    public ListOfEmployees() {
        listOfEmployees = new ArrayList<>();
    }


    public void addToListOfEmployees(Employee employee) {
        listOfEmployees.add(size++, String.valueOf(employee.getId()));
        listOfEmployees.add(size++, employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
        listOfEmployees.add(size++, employee.getDepartment());
        listOfEmployees.add(size++, String.valueOf(employee.getSalary()));
        count++;
    }

    public void updateListOfEmployees(Employee employee) {
        int position = employee.getId() * calculateStep() - calculateStep(); //4
        if (!(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic()).equals(listOfEmployees.get(position + 1))) {
            listOfEmployees.set(position + 1, employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
        }
        if (!employee.getDepartment().equals(listOfEmployees.get(position + 2))) {
            listOfEmployees.set(position + 2, employee.getDepartment());
        }
        if (!String.valueOf(employee.getSalary()).equals(listOfEmployees.get(position + 3))) {
            listOfEmployees.set(position + 3, String.valueOf(employee.getSalary()));
        }
    }

    /*public void addToList(String surname, String name, String patronymic, String department, int salary) {
        listOfEmployees.add(size++, String.valueOf(Employee.id));
        listOfEmployees.add(size++, surname + " " + name + " " + patronymic);
        listOfEmployees.add(size++, department);
        listOfEmployees.add(size++, String.valueOf(salary));
        count++;
    }*/

    private static int calculateStep() {
        if (count == 0) {
            return size;
        }
        return size / count;
    }



    /* ИНДЕКСЫ:         0 - id сотрудника - indexID
     *                  1 - ФИО - indexFullName
     *                  2 - отдел - indexDep
     *                  3 - зарплата - indexSalary
     *                  Шаг  - 4
     */


    public String getEmployee(Employee employee) {
        return String.valueOf(listOfEmployees.subList(((calculateStep()) * employee.getId()) - calculateStep(), (calculateStep()) * employee.getId()));
    }

    private String getIndex(int index) {
        return listOfEmployees.get(index);
    }

    private int getSize() {
        return size;
    }           //Размер списка

    private int getCount() {
        return count;
    }           //Количество сотрудников

    public int getSumSalary() {
        return calculateSalaryCostsInMonth();
    }           //Геттер расходов на ЗП в месяц

    public int getAverageSalary() {
        return getSumSalary() / count;
    }           //Геттер на среднюю ЗП

    public int getMinSalary() {
        int minSalary = Integer.parseInt(listOfEmployees.get(indexSalary));
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (minSalary > Integer.parseInt(listOfEmployees.get(c))) {
                minSalary = Integer.parseInt(listOfEmployees.get(c));
            }
            if (c + calculateStep() > size) {
                return minSalary;
            }
        }
        return minSalary;
    }           //Минимальная ЗП

    public int getMaxSalary() {
        int maxSalary = Integer.parseInt(listOfEmployees.get(indexSalary));
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (maxSalary < Integer.parseInt(listOfEmployees.get(c))) {
                maxSalary = Integer.parseInt(listOfEmployees.get(c));
            }
            if (c + calculateStep() > size) {
                return maxSalary;
            }
        }
        return maxSalary;
    }           //Максимальная ЗП

    public static String getMinSalaryEmplByDep(String department) {
        String employee = null;
        int salary = 0;
        for (int c = indexDep; c < size; c += calculateStep()) {
            if (department.equals(listOfEmployees.get(c)) && employee == null) {
                employee = listOfEmployees.get(c - 1);
                salary = Integer.parseInt(listOfEmployees.get(c + 1));
            }
            if (department.equals(listOfEmployees.get(c)) && Integer.parseInt(listOfEmployees.get(c + 1)) < salary) {
                employee = listOfEmployees.get(c - 1);
                salary = Integer.parseInt(listOfEmployees.get(c + 1));
            }
        }
        return employee;
    }           //Геттер на сотрудника с минимальной ЗП

    public static String getMaxSalaryEmplByDep(String department) {
        String employee = null;
        int salary = 0;
        for (int c = indexDep; c < size; c += calculateStep()) {
            if (department.equals(listOfEmployees.get(c)) && employee == null) {
                employee = listOfEmployees.get(c - 1);
                salary = Integer.parseInt(listOfEmployees.get(c + 1));
            }
            if (department.equals(listOfEmployees.get(c)) && Integer.parseInt(listOfEmployees.get(c + 1)) > salary) {
                employee = listOfEmployees.get(c - 1);
                salary = Integer.parseInt(listOfEmployees.get(c + 1));
            }
        }
        return employee;
    }           //Геттер на максимальную ЗП

    public static int getCostsSalaryByDep(String department) {
        int sumSalary = 0;
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (department.equals(listOfEmployees.get(c - 1))) {
                sumSalary += Integer.parseInt(listOfEmployees.get(c));
            }
        }
        return sumSalary;
    }           //Геттер на затраты по ЗП за месяц по отделу

    public static int getAverageSalaryByDep(String department) {
        int sumSalary = 0;
        int count = 0;
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (department.equals(listOfEmployees.get(c - 1))) {
                sumSalary += Integer.parseInt(listOfEmployees.get(c));
                count++;
            }
        }
        return sumSalary / count;
    }           //Геттер на среднюю ЗП по отделу


    private int calculateSalaryCostsInMonth() {
        int sumSalary = 0;
        for (int c = indexSalary; c < size; c += calculateStep()) {
            sumSalary += Integer.parseInt(listOfEmployees.get(c));
        }
        return sumSalary;
    }           //Метод расчёта затрат на зарплаты

    public static void indexingSalaryTotal(int percent) {
        for (int c = indexSalary; c < size; c += calculateStep()) {
            listOfEmployees.set(c, String.valueOf(Integer.parseInt(listOfEmployees.get(c)) + ((Integer.parseInt(listOfEmployees.get(c)) / 100) * percent)));
        }
    }           //Метод полной индексации

    public static void indexingSalaryByDep(String department, int percent) {
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (department.equals(listOfEmployees.get(c - 1))) {
                listOfEmployees.set(c, String.valueOf(Integer.parseInt(listOfEmployees.get(c)) + ((Integer.parseInt(listOfEmployees.get(c)) / 100) * percent)));
            }
        }
    }           //Метод индексации ЗП по отделу

    public static void printExceptDep() {
        int index = indexDep;
        for (int c = 0; c < size; c++) {
            if (c == index) {
                index += calculateStep();
                continue;
            }
            System.out.println(listOfEmployees.get(c));
        }
    }           //Метод печати исключающий печать конкретного параметра (отдел)

    public static void printEmployeesLowSalary(int salary) {
        for (int c = 0; c < size; c += calculateStep()) {
            if (Integer.parseInt(listOfEmployees.get(c + 3)) < salary) {
                for (int c1 = 0; c1 < calculateStep(); c1++) {
                    if (c1 == 2) {
                        continue;
                    }
                    System.out.println(listOfEmployees.get(c + c1));
                }
            }
        }
    }

    public static void printEmployeesUpSalary(int salary) {
        for (int c = 0; c < size; c += calculateStep()) {
            if (Integer.parseInt(listOfEmployees.get(c + 3)) >= salary) {
                for (int c1 = 0; c1 < calculateStep(); c1++) {
                    if (c1 == 2) {
                        continue;
                    }
                    System.out.println(listOfEmployees.get(c + c1));
                }
            }
        }
    }


    public void printSeparator() {
        System.out.println("-----------------------------");
    }

    public void printEmployeeByID(int id) {
        for (int c = (calculateStep()) - calculateStep(); c < size; c += calculateStep()) {
            if (id == Integer.parseInt(listOfEmployees.get(c))) {
                for (int c1 = c; c1 < (calculateStep()) * id; c1++) {
                    System.out.println(listOfEmployees.get(c1));
                }
            }
        }
    }

    public void printListOfAllEmployees() {
        for (String cellValue : listOfEmployees) {
            System.out.println(cellValue);
        }
    }           //Вывод списка всех сотрудников со всей информацией

    public void printSalaryCostsInMonth() {
        System.out.println(calculateSalaryCostsInMonth());
    }           //Вывод затрат на зарплату в месяц

    public void printAverageSalary() {
        System.out.println(calculateSalaryCostsInMonth() / count);
    }           //Вывод средней зарплаты

    public void printMinSalaryEmployee() {
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (getMinSalary() == Integer.parseInt(listOfEmployees.get(c))) {
                System.out.println(listOfEmployees.get(c - 2));
            }
        }
    }           //Сотрудник(и) с минимальной зарплатой

    public void printMaxSalaryEmployee() {
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (getMaxSalary() == Integer.parseInt(listOfEmployees.get(c))) {
                System.out.println(listOfEmployees.get(c - 2));
            }
        }
    }           //Сотрудник(и) с максимальной зарплатой

    public void printMinSalary() {
        System.out.println(getMinSalary());
    }           //Вывод минимальной зарплаты

    public void printMaxSalary() {
        System.out.println(getMaxSalary());
    }           //Вывод максимальной зарплаты

    public void printAllEmployeeFullName() {
        for (int c = indexFullName; c < size; c += calculateStep()) {
            System.out.println(listOfEmployees.get(c));
        }
    }

    public String toString() {
        return "ListOfEmployees{" +
                "listOfEmployees=" + listOfEmployees +
                '}';
    }
}

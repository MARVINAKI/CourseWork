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



    /* ??????????????:         0 - id ???????????????????? - indexID
     *                  1 - ?????? - indexFullName
     *                  2 - ?????????? - indexDep
     *                  3 - ???????????????? - indexSalary
     *                  ??????  - 4
     */


    public String getEmployee(Employee employee) {
        return String.valueOf(listOfEmployees.subList(((calculateStep()) * employee.getId()) - calculateStep(), (calculateStep()) * employee.getId()));
    }

    private String getIndex(int index) {
        return listOfEmployees.get(index);
    }

    private int getSize() {
        return size;
    }           //???????????? ????????????

    private int getCount() {
        return count;
    }           //???????????????????? ??????????????????????

    public int getSumSalary() {
        return calculateSalaryCostsInMonth();
    }           //???????????? ???????????????? ???? ???? ?? ??????????

    public int getAverageSalary() {
        return getSumSalary() / count;
    }           //???????????? ???? ?????????????? ????

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
    }           //?????????????????????? ????

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
    }           //???????????????????????? ????

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
    }           //???????????? ???? ???????????????????? ?? ?????????????????????? ????

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
    }           //???????????? ???? ???????????????????????? ????

    public static int getCostsSalaryByDep(String department) {
        int sumSalary = 0;
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (department.equals(listOfEmployees.get(c - 1))) {
                sumSalary += Integer.parseInt(listOfEmployees.get(c));
            }
        }
        return sumSalary;
    }           //???????????? ???? ?????????????? ???? ???? ???? ?????????? ???? ????????????

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
    }           //???????????? ???? ?????????????? ???? ???? ????????????


    private int calculateSalaryCostsInMonth() {
        int sumSalary = 0;
        for (int c = indexSalary; c < size; c += calculateStep()) {
            sumSalary += Integer.parseInt(listOfEmployees.get(c));
        }
        return sumSalary;
    }           //?????????? ?????????????? ???????????? ???? ????????????????

    public static void indexingSalaryTotal(int percent) {
        for (int c = indexSalary; c < size; c += calculateStep()) {
            listOfEmployees.set(c, String.valueOf(Integer.parseInt(listOfEmployees.get(c)) + ((Integer.parseInt(listOfEmployees.get(c)) / 100) * percent)));
        }
    }           //?????????? ???????????? ????????????????????

    public static void indexingSalaryByDep(String department, int percent) {
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (department.equals(listOfEmployees.get(c - 1))) {
                listOfEmployees.set(c, String.valueOf(Integer.parseInt(listOfEmployees.get(c)) + ((Integer.parseInt(listOfEmployees.get(c)) / 100) * percent)));
            }
        }
    }           //?????????? ???????????????????? ???? ???? ????????????

    public static void printExceptDep() {
        int index = indexDep;
        for (int c = 0; c < size; c++) {
            if (c == index) {
                index += calculateStep();
                continue;
            }
            System.out.println(listOfEmployees.get(c));
        }
    }           //?????????? ???????????? ?????????????????????? ???????????? ?????????????????????? ?????????????????? (??????????)

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
    }           //?????????? ???????????? ???????? ?????????????????????? ???? ???????? ??????????????????????

    public void printSalaryCostsInMonth() {
        System.out.println(calculateSalaryCostsInMonth());
    }           //?????????? ???????????? ???? ???????????????? ?? ??????????

    public void printAverageSalary() {
        System.out.println(calculateSalaryCostsInMonth() / count);
    }           //?????????? ?????????????? ????????????????

    public void printMinSalaryEmployee() {
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (getMinSalary() == Integer.parseInt(listOfEmployees.get(c))) {
                System.out.println(listOfEmployees.get(c - 2));
            }
        }
    }           //??????????????????(??) ?? ?????????????????????? ??????????????????

    public void printMaxSalaryEmployee() {
        for (int c = indexSalary; c < size; c += calculateStep()) {
            if (getMaxSalary() == Integer.parseInt(listOfEmployees.get(c))) {
                System.out.println(listOfEmployees.get(c - 2));
            }
        }
    }           //??????????????????(??) ?? ???????????????????????? ??????????????????

    public void printMinSalary() {
        System.out.println(getMinSalary());
    }           //?????????? ?????????????????????? ????????????????

    public void printMaxSalary() {
        System.out.println(getMaxSalary());
    }           //?????????? ???????????????????????? ????????????????

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

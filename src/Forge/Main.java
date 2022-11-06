package Forge;

public class Main {
    public static void main(String[] args) {

        ListOfEmployees acceptedEmployees = new ListOfEmployees();


        /*  Базовая сложность

            – Корректно создан класс Employee.
            – Реализованы геттеры для всех полей класса.
            – Реализованы сеттеры для всех полей класса.
            – Создано поле типа Employee[10] для хранения записей о сотрудниках.
            – Созданы методы, которые корректно выводят информацию:
                - список всех сотрудников со всеми данными,
                - поиск сотрудника с минимальной зарплатой,
                - поиск сотрудника с максимальной зарплатой,
                - подсчет среднего значения зарплат,
                - список Ф. И. О. всех сотрудников.

            – Программа работает корректно при изменении любых данных о сотрудниках и выводит верный результат.
            */


        Employee kostya = new Employee("Ivanov", "Konstantin", "Aleksandrovich", "dep1", 40000);
        acceptedEmployees.addToListOfEmployees(kostya);
        /*Добавление нового сотрудника, создаем новый объект (сотрудник) в классе Employee
         * и добавляем его в наш общий список сотрудников в классе ListOfEmployees*/
        Employee kristina = new Employee("Petrova", "Kristina", "Pavlovna", "dep2", 45000);
        acceptedEmployees.addToListOfEmployees(kristina);
        Employee yurij = new Employee("Ivanov", "Yurij", "Aleksandrovich", "dep3", 50000);
        acceptedEmployees.addToListOfEmployees(yurij);
        Employee yulia = new Employee("Maksimova", "Yulia", "Evgenjevna", "dep4", 55000);
        acceptedEmployees.addToListOfEmployees(yulia);
        Employee pavel = new Employee("Ivanov", "Pavel", "Petrovich", "dep5", 60000);
        acceptedEmployees.addToListOfEmployees(pavel);



        /* acceptedEmployees.addToListOfEmployees('Имя объекта(сотрудника)'); - занесение данных о сотруднике в наш список (приём на работу)
         * acceptedEmployees.updateListOfEmployees('Имя объекта(сотрудника'); - изменение данных в списке сотрудников*/



        /* Геттеры и сеттеры для класса Employee */
        acceptedEmployees.printSeparator();
        System.out.println(kostya.getId());
        System.out.println(kostya.getSurname() + " " + kostya.getName() + " " + kostya.getPatronymic());
        System.out.println(kostya.getDepartment());
        System.out.println(kostya.getSalary());
        acceptedEmployees.printSeparator();
        System.out.println("Меняем ЗП и отдел через сеттеры");
        kostya.setSalary(44000);
        kostya.setDepartment("dep2");
        System.out.println(kostya.getSalary() + " " + kostya.getDepartment());
        acceptedEmployees.updateListOfEmployees(kostya);

        acceptedEmployees.printSeparator();
        yulia.setDepartment("dep3");
        pavel.setDepartment("dep3");
        System.out.println(yulia);
        acceptedEmployees.printSeparator();
        System.out.println(pavel);
        acceptedEmployees.updateListOfEmployees(yulia);
        acceptedEmployees.updateListOfEmployees(pavel);
        acceptedEmployees.printSeparator();



        /* Создан класс ListOfEmployees (ArrayList<>), где хранятся все данные о сотрудниках класса Employee
         *  Использовал для хранения коллекцию вместо массива, посчитал, что массив ограничивает в возможностях, а список
         *  более функционален */

        System.out.println(acceptedEmployees);
        acceptedEmployees.printSeparator();
        System.out.print("Сотрудник с минимальной ЗП: ");
        acceptedEmployees.printMinSalaryEmployee();
        System.out.print("Сотрудник с максимальной ЗП: ");
        acceptedEmployees.printMaxSalaryEmployee();
        acceptedEmployees.printSeparator();
        System.out.print("Средняя ЗП по всем сотрудникам: ");
        acceptedEmployees.printAverageSalary();
        acceptedEmployees.printSeparator();
        System.out.println("ФИО всех сотрудников: ");
        acceptedEmployees.printAllEmployeeFullName();
        acceptedEmployees.printSeparator();


        /*            Повышенная сложность
         *
         *
         *            Создать дополнительные статические методы для решения следующих задач.
         *    1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
         *    2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
         *            1. Сотрудника с минимальной зарплатой.
         *            2. Сотрудника с максимальной зарплатой.
         *            3. Сумму затрат на зарплату по отделу.
         *            4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
         *            5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
         *            6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
         *    3. Получить в качестве параметра число и найти:
         *            1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
         *            2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
         *
         */

        System.out.print("Средняя ЗП до индексации: ");
        acceptedEmployees.printAverageSalary();
        System.out.println("Минимальная ЗП (до): " + acceptedEmployees.getMinSalary() + "\n" +
                "Максимальная ЗП (до): " + acceptedEmployees.getMaxSalary());
        ListOfEmployees.indexingSalaryTotal(10);
        System.out.print("Средняя ЗП после индексации на 10%: ");
        acceptedEmployees.printAverageSalary();
        System.out.println("Минимальная ЗП (после): " + acceptedEmployees.getMinSalary() + "\n" +
                "Максимальная ЗП (после): " + acceptedEmployees.getMaxSalary());
        acceptedEmployees.printSeparator();
        System.out.println("Индексация в отделе");
        ListOfEmployees.indexingSalaryByDep("dep3", 15);
        ListOfEmployees.printExceptDep();

        System.out.println("Сотрудник с минимальной ЗП в отделе dep2 " + ListOfEmployees.getMinSalaryEmplByDep("dep2"));
        System.out.println("Сотрудник с максимальной ЗП в отделе dep2 " + ListOfEmployees.getMaxSalaryEmplByDep("dep2"));
        acceptedEmployees.printSeparator();
        pavel.setSalary(88888);
        pavel.setDepartment("dep2");
        acceptedEmployees.updateListOfEmployees(pavel);
        System.out.println("Добавим в отдел сотрудника c более высокой ЗП");
        System.out.println("Сотрудник с минимальной ЗП в отделе dep2 " + ListOfEmployees.getMinSalaryEmplByDep("dep2"));
        System.out.println("Сотрудник с максимальной ЗП в отделе dep2 " + ListOfEmployees.getMaxSalaryEmplByDep("dep2"));
        acceptedEmployees.printSeparator();
        System.out.println("Расходы на ЗП по отделу dep2: " + ListOfEmployees.getCostsSalaryByDep("dep2"));
        System.out.println("Расходы на ЗП по отделу dep3: " + ListOfEmployees.getCostsSalaryByDep("dep3"));
        acceptedEmployees.printSeparator();
        System.out.println("Средняя ЗП по отделу dep2: " + ListOfEmployees.getAverageSalaryByDep("dep2"));
        acceptedEmployees.printSeparator();
        ListOfEmployees.printExceptDep();
        acceptedEmployees.printSeparator();
        System.out.println("Сотрудники с ЗП меньше 50000\n");
        ListOfEmployees.printEmployeesLowSalary(50000);
        System.out.println("Сотрудники с ЗП большей или равной 55000\n");
        ListOfEmployees.printEmployeesUpSalary(63250);


        /* Очень сложно выполнить не успел. В процессе выявил проблему вариативности параметров (одинаковые ЗП и тд) и их влияние на вывод,
         *                                                                    будет время обязательно исправлю и дошлю ДЗ*/



    }
}
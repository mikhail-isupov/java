package ru.gb.jcore.employees;

import java.util.ArrayList;
import java.util.List;

/**
 * Демонстрация работы метода для изменения зарплаты сотрудников
 */
public class Main {
    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иван", "Иванов", 25, 0, 30000, 79139131234L));
        employees.add(new Employee("Петр", "Петров", 45, 0, 30000, 79139135678L));
        employees.add(new Supervisor("Вася", "Пупкин", 60, 999, 300000, 79136660000L));
        employees.add(new Employee("Сидор", "Сидоров", 50, 1, 30000, 79131110000L));

        for (Employee employee : employees){
            System.out.println("Было: " + employee);
            Supervisor.changeEmployeeSalary(employee, 45, 30000);
            System.out.println("Стало: " + employee);
        }


    }
}

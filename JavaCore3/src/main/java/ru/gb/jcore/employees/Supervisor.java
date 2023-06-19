package ru.gb.jcore.employees;

/**
 * Класс для описания руководителя
 */
public class Supervisor extends Employee {

    public Supervisor(String name, String surname, int age, int position, int salary, long phone) {
        super(name, surname, age, position, salary, phone);
    }

    /**
     * Метод для изменения зарплаты сотрудников.
     *
     * @param employee    - Сотрудник
     * @param age         - возраст, после котрого зарплата изменяется
     * @param deltaSalary - величина, на которую изменяется зарплата
     */
    public static void changeEmployeeSalary(Employee employee, int age, int deltaSalary) {
        if (employee == null || employee instanceof Supervisor)
            return; // Руководитель не может сам себе поднять зарплату.
        if (employee.getAge() >= age) {
            int newSalary = employee.getSalary() + deltaSalary;
            employee.setSalary(newSalary);
        }
    }

    @Override
    public String toString() {
        return "Pуководитель " + super.toString();
    }
}

package ru.gb.jcore.employees;

/**
 * Класс для описания сотрудника
 */
public class Employee {
    private static int uid = 0; //счетчик для генерации уникального id для сотрудника
    public final int id; // уникальный id сотрудника.
    private String name, surname;
    private int age, position, salary;
    private long phone;

    public Employee(String name, String surname, int age, int position, int salary, long phone) {
        //создание обьекта - через сеттеры, поскольку в них логика работы с входными данными
        setName(name);
        setSurname(surname);
        setAge(age);
        setPosition(position);
        setSalary(salary);
        setPhone(phone);
        this.id = uid++;
    }

    public int getAge() {
        return this.age;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public long getPhone() {
        return this.phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s ID: %d Возраст: %d Должность: %d Зарплата: %d Телефон: %d",
                this.name, this.surname, this.id, this.age, this.position, this.salary, this.phone);
    }
}

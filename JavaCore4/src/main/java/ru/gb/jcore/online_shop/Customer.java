package ru.gb.jcore.online_shop;

/**
 * Класс для описания покупателя
 */
public class Customer {
    private String name, surname;
    private Gender sex;
    private int age;
    private long phone;

    /**
     * Конструктор объекта "Покупатель"
     *
     * @param name    - Имя
     * @param surname - Фамилия
     * @param sex - Пол
     * @param age     - Возраст
     * @param phone   - Телефон
     */
    public Customer(String name, String surname, Gender sex, int age, long phone) {
        setName(name);
        setSurname(surname);
        setSex(sex);
        setAge(age);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public boolean equals(Customer customer) { // Сравнение двух пользователей
        if (customer == null) return false;
        return (this.name.equalsIgnoreCase(customer.getName())
                && this.surname.equalsIgnoreCase(customer.getSurname())
                && this.sex.equals(customer.getSex())
                && this.age == customer.getAge());
        // Два пользователя считаются одинаковыми если совпадает ФИО, пол и возраст
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", this.name, this.surname, this.sex, this.age, this.phone);
    }
}

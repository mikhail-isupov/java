package ru.gb.jcore.online_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Эмуляция интернет-магазина
 */
public class OnlineShop {
    private static List<Customer> dbCustomers; // БД с покупателями
    private static List<Order> dbOrders; // БД заказов
    private static List<Product> dbPoducts; // БД с товарами

    private static void dbInit() { // Инициализация данных о покупателях и товарах
        dbCustomers = new ArrayList<>();
        dbOrders = new ArrayList<>();
        dbPoducts = new ArrayList<>();

        dbCustomers.add(new Customer("Иван", "Иванов", Gender.MALE, 25, 79139131234L));
        dbCustomers.add(new Customer("Светлана", "Кузнецова", Gender.FEMALE, 35, 79139135678L));

        dbPoducts.add(new Product("Водка", 300));
        dbPoducts.add(new Product("Икра", 3000));
        dbPoducts.add(new Product("Гречка", 100));
        dbPoducts.add(new Product("Хлеб", 50));
        dbPoducts.add(new Product("Кефир", 60));
    }

    private static Order makeOrder(Customer customer, Product product, int amount) throws CustomerException, ProductException, AmountException {
        boolean isCustomerExists = false;
        for (Customer c : dbCustomers) { // Поиск пользователя в БД
            if (c.equals(customer)) {
                isCustomerExists = true;
                break;
            }
        }
        if (!isCustomerExists)
            throw new CustomerException(customer.getName(), customer.getSurname(), customer.getSex(), customer.getAge());
        boolean isProductExists = false;
        for (Product p : dbPoducts) { // Поиск товара в БД
            if (p.equals(product)) {
                isProductExists = true;
                break;
            }
        }
        if (!isProductExists)
            throw new ProductException(product.getProductName());
        return new Order(customer, product, amount);
    }

    public static void main(String[] args) {
        dbInit();

        //Имитируем покупки пользователями товаров
        List<Customer> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        customers.addAll(dbCustomers); // Добавляем сначала всех реальных пользователей
        products.addAll(dbPoducts); // и реальные товары
        //добавляем фейковых покупателей и фейковые товары которых нет в БД
        customers.add(new Customer("Иван", "Иванов", Gender.PROGRESSIVE, 25, 79139131234L));
        customers.add(new Customer("Светлана", "Кузнецова", Gender.PROGRESSIVE, 35, 79139135678L));
        customers.add(new Customer("Нави", "Иванов", Gender.PROGRESSIVE, 25, 79139131234L));
        products.add(new Product("Пармезан", 5000));
        products.add(new Product("Шоколад", 1000));
        products.add(new Product("Пельмени", 500));
        Random rnd = new Random();
        for (Customer c : customers) {
            for (Product p : products) {
                try {
                    dbOrders.add(makeOrder(c, p, rnd.nextInt(-Order.MAX_ORDER, Order.MAX_ORDER))); // Пытаемся сгенерировать заказ и доьавить в список заказов
                } catch (ProductException productException) {
                    System.out.println(productException.getMessage());
                } catch (CustomerException customerException) {
                    System.out.println(customerException.getMessage());
                } catch (AmountException amountException) {
                    System.out.println(amountException.getMessage());
                    try {
                        dbOrders.add(makeOrder(c, p, 1)); // если неверное количество то покупаем 1 товар
                    } catch (Exception e) {
                    }// Тут мы уверены что и товар и пользователь есть поэтому обрабатывем try формально
                }
            }
        }
        System.out.println("Итоговый список заказов.");
        for (Order o : dbOrders) System.out.println(o);
    }
}

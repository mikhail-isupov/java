package ru.gb.jcore.online_shop;

/**
 * Класс для описания заказа
 */
public class Order {
    public static final int MAX_ORDER = 10; // Максимально возможное количество единиц товара для заказа
    private Customer customer;
    private Product product;
    private int amount, totalPrice;

    /**
     * Конструктор объекта "Заказ"
     * @param customer - Покупатель
     * @param product - Товар
     * @param amount - количество товара
     */
    public Order(Customer customer, Product product, int amount) throws AmountException {
        if (amount < 1 || amount > MAX_ORDER) {
            throw new AmountException(amount);
        }
        setCustomer(customer);
        setProduct(setRandomDiscount(product)); // в заказ идет продукт со случайной скидкой
        setAmount(amount);
        this.totalPrice = amount * this.product.getProductPrice();
    }
    private static Product setRandomDiscount(Product product) {// Назначается случайная скидка на продукт для покупателя
        Product discountedProduct = new Product(product.getProductName(),product.getProductPrice());// Создаем копию товара из БД
        int discount = Discount.getRandomDiscount();
        int newProductPrice = (100 - discount) * product.getProductPrice() / 100;// Новая цена с учетом скидки
        discountedProduct.setProductPrice(newProductPrice); // и назначаем случайную скидку
        return discountedProduct;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString(){
        return String.format("%s %s КОЛ-ВО %d шт. ИТОГО %d руб.", this.customer.toString(), this.product.toString(), this.amount, this.totalPrice);
    }
}

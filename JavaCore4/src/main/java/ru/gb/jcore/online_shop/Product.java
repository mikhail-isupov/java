package ru.gb.jcore.online_shop;

/**
 * Класс для описания товара
 */
public class Product {

    private String productName;
    private int productPrice;

    /**
     * Конструктор объекта "Товар"
     * @param productName - Наименование товара
     * @param productPrice - количество товара
     */
    public Product(String productName, int productPrice) {
        setProductName(productName);
        setProductPrice(productPrice);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public boolean equals(Product product){
        if (product == null) return false;
        return (this.productName.equalsIgnoreCase(product.getProductName()));
        // Два товара считаются одинаковыми если совпадают их названия
    }

    @Override
    public String toString(){
        return String.format("%s %d руб.", this.productName, this.productPrice);
    }
}

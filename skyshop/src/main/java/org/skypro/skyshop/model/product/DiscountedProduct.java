package org.skypro.skyshop.model.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String name, int price, int discountPercent) {
        super(name);
        if (price < 0) {
            throw new IllegalArgumentException("Введено неправильное название продукта!");
        }
        if (discountPercent < 0 || 100 < discountPercent) {
            throw new IllegalArgumentException("Введен неправильный процент скидки!");
        }
        this.basePrice = price;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return basePrice - basePrice * discountPercent / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }
}

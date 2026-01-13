package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public class BasketItem {
    private final Product product;
    private final int quantity;

    public BasketItem(Product product, int count) {
        this.product = product;
        this.quantity = count;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

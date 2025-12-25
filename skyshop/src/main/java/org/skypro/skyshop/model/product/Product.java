package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private String name;
    private final UUID id;

    @Override
    public UUID getId() {
        return id;
    }

    public Product(UUID id, String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Введено неправильное название продукта!");
        }
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getSearchableType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchableName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

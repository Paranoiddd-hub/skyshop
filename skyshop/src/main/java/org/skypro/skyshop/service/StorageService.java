package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        this.articleStorage = new HashMap<>();
        storageInitialization();
    }

    private void storageInitialization() {
        productStorage.put(UUID.randomUUID(), new SimpleProduct(UUID.randomUUID(), "Курица", 500));
        productStorage.put(UUID.randomUUID(), new SimpleProduct(UUID.randomUUID(), "Масло", 200));
        productStorage.put(UUID.randomUUID(), new FixPriceProduct(UUID.randomUUID(), "Хлеб"));
        productStorage.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "Яйца", 100, 10));
        productStorage.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "Гречка", 100, 20));
        productStorage.put(UUID.randomUUID(), new SimpleProduct(UUID.randomUUID(), "milk", 80));

        articleStorage.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Бородинский хлеб", "Ой вкусный хлеб прям вообще."));
        articleStorage.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Курица - не птица", "Курица – не птица, Болгария – не заграница"));
    }

    public Collection<Product> getAllProducts() {
        return productStorage.values();
    }

    public Collection<Article> getAllArticles() {
        return articleStorage.values();
    }

    public Collection<Searchable> getSearchables() {
        HashMap<UUID, Searchable> collection = new HashMap<>();
        collection.putAll(productStorage);
        collection.putAll(articleStorage);
        return collection.values();
    }
}

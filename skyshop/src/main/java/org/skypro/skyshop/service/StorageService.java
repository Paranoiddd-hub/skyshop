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
import java.util.Optional;
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
        Product chicken = new SimpleProduct(UUID.randomUUID(), "Курица", 500);
        Product butter = new SimpleProduct(UUID.randomUUID(), "Масло", 200);
        Product bread = new FixPriceProduct(UUID.randomUUID(), "Хлеб");
        Product eggs = new DiscountedProduct(UUID.randomUUID(), "Яйца", 100, 10);
        Product buckwheat = new DiscountedProduct(UUID.randomUUID(), "Гречка", 100, 20);
        Product milk = new SimpleProduct(UUID.randomUUID(), "Молоко", 80);
        Article breadArticle = new Article(UUID.randomUUID(), "Бородинский хлеб", "Ой вкусный хлеб прям вообще.");
        Article chikenArticle = new Article(UUID.randomUUID(), "Курица - не птица", "Курица – не птица, Болгария – не заграница");

        productStorage.put(chicken.getId(), chicken);
        productStorage.put(butter.getId(), butter);
        productStorage.put(bread.getId(), bread);
        productStorage.put(eggs.getId(), eggs);
        productStorage.put(buckwheat.getId(), buckwheat);
        productStorage.put(milk.getId(), milk);
        articleStorage.put(breadArticle.getId(), breadArticle);
        articleStorage.put(chikenArticle.getId(), chikenArticle);
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

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productStorage.get(id));
    }
}

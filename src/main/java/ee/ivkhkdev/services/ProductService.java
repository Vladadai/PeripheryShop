package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.models.Customer;
import ee.ivkhkdev.models.Product;
import ee.ivkhkdev.repositories.Storage;

import java.util.List;

public class ProductService implements Service<Product> {
    private final AppHelper<Product> appHelper;
    private Storage<Product> storage;

    public ProductService(AppHelper<Product> appHelper, Storage<Product> productStorage) {
        this.appHelper = appHelper;
        this.storage = productStorage;
    }

    @Override
    public void create(String... params) {
        Product product = appHelper.create(params);
        saveProduct(product);
    }

    @Override
    public void printList() {
        List<Product> products = storage.load();
        if (products.isEmpty()) {
            System.out.println("Список покупателей пуст.");
        } else {
            products.forEach(System.out::println);
        }
    }

    @Override
    public void edit(String name, String... params) {
        appHelper.edit(name, params);
        List<Product> products = storage.load();
        storage.saveAll(products);
    }

    @Override
    public Product findByName(String name) {
        return appHelper.findByName(name);
    }

    private void saveProduct(Product product) {
        List<Product> products = storage.load();
        products.add(product);
        storage.saveAll(products);
        System.out.println("Продукт сохранён: " + product);
    }
}

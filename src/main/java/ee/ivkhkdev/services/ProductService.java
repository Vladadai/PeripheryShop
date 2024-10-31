package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.repositories.Repository;

import java.util.List;

public class ProductService implements Service {
    private final List<Product> products;
    private final Repository<Product> repository;
    private final AppHelper<Product> appHelperProduct;

    public ProductService(List<Product> products, AppHelper<Product> appHelperProduct, Repository<Product> repository) {
        this.products = products;
        this.appHelperProduct = appHelperProduct;
        this.repository = repository;
    }

    public boolean add() {
        Product product = appHelperProduct.create();
        if (product == null) return false;

        products.add(product);
        repository.save(product);
        return true;
    }

    public boolean print() {
        return appHelperProduct.printList(products);
    }

    @Override
    public List<Product> list() {
        return products;
    }
}

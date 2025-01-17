package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.models.Customer;
import ee.ivkhkdev.models.Product;
import ee.ivkhkdev.models.Purchase;
import ee.ivkhkdev.repositories.Storage;

import java.util.List;

public class PurchaseService implements Service<Purchase> {
    private final AppHelper<Purchase> appHelper;
    private final Storage<Purchase> purchaseStorage;
    private final Storage<Product> productStorage;
    private final Storage<Customer> customerStorage;

    public PurchaseService(
            AppHelper<Purchase> appHelper,
            Storage<Purchase> purchaseStorage, Storage<Product> productStorage, Storage<Customer> customerStorage) {
        this.appHelper = appHelper;
        this.purchaseStorage = purchaseStorage;
        this.productStorage = productStorage;
        this.customerStorage = customerStorage;
    }

    @Override
    public void create(String... params) {
        Purchase purchase = appHelper.create(params);

        if (purchase != null) {
            savePurchase(purchase);
        }
    }

    @Override
    public void printList() {
        List<Purchase> purchases = purchaseStorage.load();
        if (purchases.isEmpty()) {
            System.out.println("Список покупателей пуст.");
        } else {
            purchases.forEach(System.out::println);
        }
    }

    @Override
    public void edit(String name, String... params) {
        throw new UnsupportedOperationException("Editing purchases is not supported.");
    }

    @Override
    public Purchase findByName(String name) {
        return appHelper.findByName(name);
    }

    private void savePurchase(Purchase purchase) {
        // Сохранение покупателя и товара с обновлениями
        List<Product> products = productStorage.load();
        List<Customer> customers = customerStorage.load();
        List<Purchase> purchases = purchaseStorage.load();

        purchases.add(purchase);
        purchaseStorage.saveAll(purchases);
        productStorage.saveAll(products);
        customerStorage.saveAll(customers);

        System.out.println("Покупка успешно сохранена: " + purchase);
    }
}

package ee.ivkhkdev;

import ee.ivkhkdev.helpers.CustomerAppHelper;
import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.helpers.PurchaseAppHelper;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.services.CustomerService;
import ee.ivkhkdev.services.ProductService;
import ee.ivkhkdev.services.PurchaseService;
import ee.ivkhkdev.repositories.Storage;
import ee.ivkhkdev.models.Customer;
import ee.ivkhkdev.models.Product;
import ee.ivkhkdev.models.Purchase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize storages
        Storage<Customer> customerStorage = new Storage<>("customers.dat");
        Storage<Product> productStorage = new Storage<>("products.dat");
        Storage<Purchase> purchaseStorage = new Storage<>("purchases.dat");

        // Initialize helpers
        CustomerAppHelper customerHelper = new CustomerAppHelper();
        ProductAppHelper productHelper = new ProductAppHelper();
        PurchaseAppHelper purchaseHelper = new PurchaseAppHelper();

        // Initialize services
        CustomerService customerService = new CustomerService(customerHelper, customerStorage);
        ProductService productService = new ProductService(productHelper, productStorage);
        PurchaseService purchaseService = new PurchaseService(purchaseHelper, purchaseStorage, productStorage, customerStorage);

        // Initialize input system
        Input input = new ConsoleInput(new Scanner(System.in));

        // Start the app
        App app = new App(input, productService, customerService, purchaseService, purchaseService);
        app.run();
    }
}

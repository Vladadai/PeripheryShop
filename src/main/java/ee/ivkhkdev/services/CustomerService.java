package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.models.Customer;
import ee.ivkhkdev.repositories.Storage;

import java.util.List;

public class CustomerService implements Service<Customer> {
    private final AppHelper<Customer> appHelper;
    private final Storage<Customer> storage;

    public CustomerService(AppHelper<Customer> appHelper, Storage<Customer> storage) {
        this.appHelper = appHelper;
        this.storage = storage;
    }

    @Override
    public void create(String... params) {
        Customer customer = appHelper.create(params);
        saveCustomer(customer);
    }

    @Override
    public void printList() {
        List<Customer> customers = storage.load();
        if (customers.isEmpty()) {
            System.out.println("Список покупателей пуст.");
        } else {
            customers.forEach(System.out::println);
        }
    }

    @Override
    public void edit(String name, String... params) {
        appHelper.edit(name, params);
        List<Customer> customers = storage.load();
        storage.saveAll(customers);
    }

    @Override
    public Customer findByName(String name) {
        return appHelper.findByName(name);
    }

    private void saveCustomer(Customer customer) {
        List<Customer> customers = storage.load();
        customers.add(customer);
        storage.saveAll(customers);
        System.out.println("Покупатель сохранён: " + customer);
    }
}

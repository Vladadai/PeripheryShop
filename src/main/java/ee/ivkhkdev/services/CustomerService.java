package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.repositories.Repository;


import java.util.List;

public class CustomerService implements Service{
    private final List<Customer> customers;
    private final Repository<Customer> repository;
    private AppHelper<Customer> appHelperCustomer;

    public CustomerService(List<Customer> customers, AppHelper<Customer> appHelperCustomer, Repository<Customer> repository) {
        this.customers = customers;
        this.appHelperCustomer = appHelperCustomer;
        this.repository = repository;
    }

    public boolean add() {
        Customer customer = appHelperCustomer.create();
        if(customer == null ) return false;
        for (int i = 0; i <= customers.size(); i++){
            if(i == 0 ){
                customers.add(customer);
                repository.save(customer);
                break;
            }else if(customers.get(i) == null) {
                customers.add(customer);
                repository.save(customer);
                break;
            }
        }
        return true;
    }

    public boolean print() {
        return appHelperCustomer.printList(customers);
    }

    @Override
    public List list() {
        return customers;
    }
}

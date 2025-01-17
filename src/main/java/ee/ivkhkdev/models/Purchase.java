package ee.ivkhkdev.models;

import java.io.Serializable;

public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;

    private Customer customer;
    private Product product;
    private int quantity;

    public Purchase(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Покупка: Покупатель - " + customer.getName() +
                ", Товар - " + product.getName() +
                ", Количество - " + quantity;
    }
}

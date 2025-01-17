package ee.ivkhkdev.helpers;

import ee.ivkhkdev.helpers.PurchaseAppHelper;
import ee.ivkhkdev.models.Customer;
import ee.ivkhkdev.models.Product;
import ee.ivkhkdev.models.Purchase;
import ee.ivkhkdev.repositories.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PurchaseAppHelperTest {
    private PurchaseAppHelper purchaseAppHelper;
    private Storage<Customer> mockCustomerStorage;
    private Storage<Product> mockProductStorage;
    private Storage<Purchase> mockPurchaseStorage;

    @BeforeEach
    void setUp() {
        mockCustomerStorage = Mockito.mock(Storage.class);
        mockProductStorage = Mockito.mock(Storage.class);
        mockPurchaseStorage = Mockito.mock(Storage.class);

        purchaseAppHelper = new PurchaseAppHelper();
    }

    @Test
    void testCreatePurchase() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer("John Doe", 1000.0);
        customers.add(customer);
        when(mockCustomerStorage.load()).thenReturn(customers);

        List<Product> products = new ArrayList<>();
        Product product = new Product("Laptop", 500.0, 10);
        products.add(product);
        when(mockProductStorage.load()).thenReturn(products);

        List<Purchase> purchases = new ArrayList<>();
        when(mockPurchaseStorage.load()).thenReturn(purchases);

        purchaseAppHelper.create("John Doe", "Laptop", "2");

        verify(mockProductStorage, times(1)).saveAll(products);
        verify(mockCustomerStorage, times(1)).saveAll(customers);
        verify(mockPurchaseStorage, times(1)).saveAll(purchases);

        assertEquals(8, product.getQuantity());
        assertEquals(0.0, customer.getBalance());
        assertEquals(1, purchases.size());
    }
}

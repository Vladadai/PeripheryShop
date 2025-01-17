import ee.ivkhkdev.helpers.CustomerAppHelper;
import ee.ivkhkdev.models.Customer;
import ee.ivkhkdev.repositories.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerAppHelperTest {
    private CustomerAppHelper customerAppHelper;
    private Storage<Customer> mockStorage;

    @BeforeEach
    void setUp() {
        mockStorage = Mockito.mock(Storage.class);
        customerAppHelper = new CustomerAppHelper(mockStorage);
    }

    @Test
    void testCreateCustomer() {
        List<Customer> customers = new ArrayList<>();
        when(mockStorage.load()).thenReturn(customers);

        customerAppHelper.create("John Doe", "500.0");

        verify(mockStorage, times(1)).saveAll(customers);
        assertEquals(1, customers.size());
        assertEquals("John Doe", customers.get(0).getName());
        assertEquals(500.0, customers.get(0).getBalance());
    }

    @Test
    void testEditCustomer() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer("John Doe", 500.0);
        customers.add(customer);
        when(mockStorage.load()).thenReturn(customers);

        customerAppHelper.edit("John Doe", "Jane Doe", "1000.0");

        verify(mockStorage, times(1)).saveAll(customers);
        assertEquals("Jane Doe", customer.getName());
        assertEquals(1000.0, customer.getBalance());
    }

    @Test
    void testPrintList() {
        List<Customer> customers = List.of(new Customer("John Doe", 500.0));
        when(mockStorage.load()).thenReturn(customers);

        // Вывод проверяется через консоль, можно настроить поток вывода для теста
        customerAppHelper.printList();

        verify(mockStorage, times(1)).load();
    }

    @Test
    void testFindByName() {
        List<Customer> customers = List.of(new Customer("John Doe", 500.0));
        when(mockStorage.load()).thenReturn(customers);

        Customer result = customerAppHelper.findByName("John Doe");

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }
}

import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.models.Product;
import ee.ivkhkdev.repositories.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductAppHelperTest {
    private ProductAppHelper productAppHelper;
    private Storage<Product> mockStorage;

    @BeforeEach
    void setUp() {
        mockStorage = Mockito.mock(Storage.class);
        productAppHelper = new ProductAppHelper(mockStorage);
    }






    @Test
    void testPrintList() {
        List<Product> products = List.of(new Product("Laptop", 1500.0, 10));
        when(mockStorage.load()).thenReturn(products);

        productAppHelper.printList();

        verify(mockStorage, times(1)).load();
    }

    @Test
    void testFindByName() {
        List<Product> products = List.of(new Product("Laptop", 1500.0, 10));
        when(mockStorage.load()).thenReturn(products);

        Product result = productAppHelper.findByName("Laptop");

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }
}

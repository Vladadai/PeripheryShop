package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.repositories.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static javax.management.Query.times;
import static jdk.internal.classfile.impl.verifier.VerifierImpl.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    private List<Product> products;
    private AppHelper<Product> appHelperProduct;
    private Repository<Product> repository;
    private ProductService productService;
    private PrintStream defaultOut;
    private ByteArrayOutputStream outMock;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        appHelperProduct = Mockito.mock(AppHelper.class);
        repository = Mockito.mock(Repository.class);
        productService = new ProductService(products, appHelperProduct, repository);
        outMock = new ByteArrayOutputStream();
        defaultOut = System.out;
        System.setOut(new PrintStream(outMock));
    }

    @AfterEach
    void tearDown() {
        products.clear();
        appHelperProduct = null;
        repository = null;
        productService = null;
        System.setOut(defaultOut);
        outMock = null;
    }

    @Test
    void add() {
        Product mockProduct = new Product("Keyboard", "Mechanical Keyboard", new BigDecimal("59.99"), "Logitech", 50, "Peripherals", "RGB, Mechanical", 4.5);
        when(appHelperProduct.create()).thenReturn(mockProduct);

        boolean result = productService.add();
        assertTrue(result);
        assertEquals(1, products.size());
        assertEquals(mockProduct, products.get(0));
        verify(repository, times(1)).save(mockProduct);
    }

    @Test
    void print() {
        Product product = new Product("Keyboard", "Mechanical Keyboard", new BigDecimal("59.99"), "Logitech", 50, "Peripherals", "RGB, Mechanical", 4.5);
        products.add(product);

        when(appHelperProduct.printList(products)).thenReturn(true);
        boolean result = productService.print();

        assertTrue(result);
        verify(appHelperProduct, times(1)).printList(products);
    }

    @Test
    void list() {
        Product product1 = new Product("Keyboard", "Mechanical Keyboard", new BigDecimal("59.99"), "Logitech", 50, "Peripherals", "RGB, Mechanical", 4.5);
        Product product2 = new Product("Mouse", "Wireless Mouse", new BigDecimal("29.99"), "Logitech", 100, "Peripherals", "Wireless", 4.7);
        products.add(product1);
        products.add(product2);

        List<Product> result = productService.list();
        assertEquals(2, result.size());
        assertEquals(product1, result.get(0));
        assertEquals(product2, result.get(1));
    }
}

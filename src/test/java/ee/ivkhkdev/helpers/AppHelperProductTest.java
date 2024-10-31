package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperProductTest {
    Input inputMock;
    AppHelper<Product> appHelperProduct;
    PrintStream defaultOut = System.out;
    ByteArrayOutputStream outMock;

    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(Input.class);
        appHelperProduct = new AppHelperProduct(inputMock);
        outMock = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outMock));
    }

    @AfterEach
    void tearDown() {
        inputMock = null;
        System.setOut(defaultOut);
        outMock = null;
    }

    @Test
    void create() {
        when(inputMock.nextLine()).thenReturn("Keyboard", "Mechanical keyboard", "59.99", "Logitech", "50", "Peripherals", "RGB, Mechanical", "4.5");
        Product actual = appHelperProduct.create();
        Product expected = new Product("Keyboard", "Mechanical keyboard", new BigDecimal("59.99"), "Logitech", 50, "Peripherals", "RGB, Mechanical", 4.5);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPrice(), actual.getPrice());
        assertEquals(expected.getBrand(), actual.getBrand());
        assertEquals(expected.getStockQuantity(), actual.getStockQuantity());
        assertEquals(expected.getCategory(), actual.getCategory());
        assertEquals(expected.getSpecifications(), actual.getSpecifications());
        assertEquals(expected.getRating(), actual.getRating());
    }

    @Test
    void printList() {
        Product product = new Product("Keyboard", "Mechanical keyboard", new BigDecimal("59.99"), "Logitech", 50, "Peripherals", "RGB, Mechanical", 4.5);
        List<Product> products = new ArrayList<>();
        products.add(product);

        boolean result = appHelperProduct.printList(products);
        assertTrue(result);

        String expectedOutput = "1. Keyboard - Mechanical keyboard. Цена: 59.99. Бренд: Logitech";
        assertTrue(outMock.toString().contains(expectedOutput));
    }
}

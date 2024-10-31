package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperCategoryTest {
    Input inputMock;
    AppHelper<Category> appHelperCategory;
    PrintStream defaultOut = System.out;
    ByteArrayOutputStream outMock;

    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(Input.class);
        appHelperCategory = new AppHelperCategory(inputMock);
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
        when(inputMock.nextLine()).thenReturn("Peripherals", "Computer peripherals and accessories");
        Category actual = appHelperCategory.create();
        Category expected = new Category("Peripherals", "Computer peripherals and accessories", null);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

    @Test
    void printList() {
        Category category = new Category("Peripherals", "Computer peripherals and accessories", null);
        List<Category> categories = new ArrayList<>();
        categories.add(category);

        boolean result = appHelperCategory.printList(categories);
        assertTrue(result);

        String expectedOutput = "1. Peripherals - Computer peripherals and accessories";
        assertTrue(outMock.toString().contains(expectedOutput));
    }
}

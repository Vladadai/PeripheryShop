package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.model.Category;
import ee.ivkhkdev.repositories.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {
    private List<Category> categories;
    private AppHelper<Category> appHelperCategory;
    private Repository<Category> repository;
    private CategoryService categoryService;
    private PrintStream defaultOut;
    private ByteArrayOutputStream outMock;

    @BeforeEach
    void setUp() {
        categories = new ArrayList<>();
        appHelperCategory = Mockito.mock(AppHelper.class);
        repository = Mockito.mock(Repository.class);
        categoryService = new CategoryService(categories, appHelperCategory, repository);
        outMock = new ByteArrayOutputStream();
        defaultOut = System.out;
        System.setOut(new PrintStream(outMock));
    }

    @AfterEach
    void tearDown() {
        categories.clear();
        appHelperCategory = null;
        repository = null;
        categoryService = null;
        System.setOut(defaultOut);
        outMock = null;
    }

    @Test
    void add() {
        Category mockCategory = new Category("Peripherals", "Computer peripherals and accessories", null);
        when(appHelperCategory.create()).thenReturn(mockCategory);

        boolean result = categoryService.add();
        assertTrue(result);
        assertEquals(1, categories.size());
        assertEquals(mockCategory, categories.get(0));
        verify(repository, times(1)).save(mockCategory);
    }

    @Test
    void print() {
        Category category = new Category("Peripherals", "Computer peripherals and accessories", null);
        categories.add(category);

        when(appHelperCategory.printList(categories)).thenReturn(true);
        boolean result = categoryService.print();

        assertTrue(result);
        verify(appHelperCategory, times(1)).printList(categories);
    }

    @Test
    void list() {
        Category category1 = new Category("Peripherals", "Computer peripherals and accessories", null);
        Category category2 = new Category("Monitors", "Computer display devices", null);
        categories.add(category1);
        categories.add(category2);

        List<Category> result = categoryService.list();
        assertEquals(2, result.size());
        assertEquals(category1, result.get(0));
        assertEquals(category2, result.get(1));
    }
}

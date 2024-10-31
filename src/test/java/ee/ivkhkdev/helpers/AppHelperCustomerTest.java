package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Customer;
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

class AppHelperUserTest {
    Input inputMock;
    AppHelper<Customer> appHelperUser;
    PrintStream defaultOut = System.out;
    ByteArrayOutputStream outMock;
    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(Input.class);
        appHelperUser = new AppHelperCustomer(inputMock);
        outMock = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outMock));
    }

    @AfterEach
    void tearDown() {
        inputMock = null;
        System.setOut(defaultOut);
        outMock=null;
    }

    @Test
    void create() {
        when(inputMock.nextLine()).thenReturn("Ivan","Ivanov","56565656");
        Customer actual = appHelperUser.create();
        Customer expected = new Customer("Ivan","Ivanov","56565656");
        assertEquals(actual.getFirstName(), expected.getFirstName());
        assertEquals(actual.getLastName(), expected.getLastName());
        assertEquals(actual.getPhone(), expected.getPhone());
    }

    @Test
    void printList() {
        Customer user = new Customer("Ivan","Ivanov","56565656");
        List<Customer> users = new ArrayList<>();
        users.add(user);
        boolean result = appHelperUser.printList(users);
        boolean expected = true;
        assertTrue(result);
        String expectedString = "1. Ivan Ivanov. 56565656";
        assertTrue(outMock.toString().contains(expectedString));
    }
}
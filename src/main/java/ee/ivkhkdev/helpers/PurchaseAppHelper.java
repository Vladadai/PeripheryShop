package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.models.Customer;
import ee.ivkhkdev.models.Product;
import ee.ivkhkdev.models.Purchase;

import java.util.Scanner;

public class PurchaseAppHelper implements AppHelper<Purchase> {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Purchase create(String... params) {
        System.out.println("Введите имя покупателя:");
        String customerName = scanner.nextLine();
        System.out.println("Введите имя продукта:");
        String productName = scanner.nextLine();
        System.out.println("Введите количество:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Пропустить остаток строки

        // Вернуть объект покупки
        return new Purchase(new Customer(customerName, 0), new Product(productName, 0, quantity), quantity);
    }


    @Override
    public void edit(String name, String... params) {
        throw new UnsupportedOperationException("Редактирование покупок не поддерживается.");
    }

    @Override
    public Purchase findByName(String name) {
        return null; // Поиск покупки по имени не применим.
    }
}

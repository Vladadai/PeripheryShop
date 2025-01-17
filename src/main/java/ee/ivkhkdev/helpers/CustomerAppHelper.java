package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.models.Customer;

import java.util.Scanner;

public class CustomerAppHelper implements AppHelper<Customer> {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Customer create(String... params) {
        System.out.println("Введите имя покупателя:");
        String name = scanner.nextLine();
        System.out.println("Введите баланс покупателя:");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Пропустить остаток строки

        return new Customer(name, balance);
    }

    @Override
    public void edit(String name, String... params) {
        System.out.println("Введите имя покупателя для редактирования:");
        String customerName = scanner.nextLine();

        System.out.println("Введите новое имя покупателя:");
        String newName = scanner.nextLine();
        System.out.println("Введите новый баланс покупателя:");
        double newBalance = scanner.nextDouble();
        scanner.nextLine(); // Пропустить остаток строки

        System.out.println("Покупатель обновлён: Имя - " + newName + ", Баланс - " + newBalance);
    }


    @Override
    public Customer findByName(String name) {
        System.out.println("Поиск покупателя по имени: " + name);
        return null;
    }
}

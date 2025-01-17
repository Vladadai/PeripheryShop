package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.models.Product;

import java.util.Scanner;

public class ProductAppHelper implements AppHelper<Product> {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Product create(String... params) {
        System.out.println("Введите название продукта:");
        String name = scanner.nextLine();
        System.out.println("Введите цену продукта:");
        double price = scanner.nextDouble();
        System.out.println("Введите количество продукта:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Пропустить остаток строки

        return new Product(name, price, quantity);
    }

    @Override
    public void edit(String name, String... params) {
        System.out.println("Введите название продукта для редактирования:");
        String productName = scanner.nextLine();

        System.out.println("Введите новое название продукта:");
        String newName = scanner.nextLine();
        System.out.println("Введите новую цену продукта:");
        double newPrice = scanner.nextDouble();
        System.out.println("Введите новое количество продукта:");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); // Пропустить остаток строки

        System.out.println("Продукт обновлён: Имя - " + newName + ", Цена - " + newPrice + ", Количество - " + newQuantity);
    }


    @Override
    public Product findByName(String name) {
        System.out.println("Поиск продукта по имени: " + name);
        return null;
    }
}

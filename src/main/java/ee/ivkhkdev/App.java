package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.models.Customer;
import ee.ivkhkdev.models.Product;
import ee.ivkhkdev.models.Purchase;

import java.util.Scanner;

public class App {
    private final Input input;
    private final Service<Product> productService;
    private final Service<Customer> customerService;
    private final Service<Purchase> purchaseService;

    public App(
            Input input,
            Service<Product> productService,
            Service<Customer> customerService,
            Service<Purchase> purchaseService,
            Service<Purchase> registerService
    ) {
        this.input = input;
        this.productService = productService;
        this.customerService = customerService;
        this.purchaseService = purchaseService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                case 1:
                    productService.create();
                    break;
                case 2:
                    productService.printList();
                    break;
                case 3:
                    productService.edit(null);
                    break;
                case 4:
                    customerService.create();
                    break;
                case 5:
                    customerService.printList();
                    break;
                case 6:
                    customerService.edit(null);
                    break;
                case 7:
                    purchaseService.create();
                    break;
                case 8:
                    purchaseService.printList();
                    break;
                default:
                    System.out.println("Некорректный выбор, попробуйте снова.");
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("0. Выход");
        System.out.println("1. Добавить продукт");
        System.out.println("2. Список продуктов");
        System.out.println("3. Редактировать продукт");
        System.out.println("4. Добавить покупателя");
        System.out.println("5. Список покупателей");
        System.out.println("6. Редактировать покупателя");
        System.out.println("7. Купить товар");
        System.out.println("8. История покупок");
        System.out.println("Введите номер действия:");
    }

}

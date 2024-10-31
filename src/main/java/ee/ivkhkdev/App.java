package ee.ivkhkdev;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.services.Service;

public class App {
    private Input input;
    private Service<Customer> customerService;
    public App(){

    }

    public void run() {
        boolean repeat = true;
        System.out.println("======= Shop =========");
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить покупателя");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Добавить покупателя");
                        if (customerService.print()) {
                            System.out.println("Покупатель добавлен");
                        }else {
                            System.out.println("Покупателя добавить не удалось");
                        };
                    break;
            }
        }while (repeat);
    }
}

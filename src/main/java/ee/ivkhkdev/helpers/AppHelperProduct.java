package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class AppHelperProduct implements AppHelper<Product> {
    private final Input input;

    public AppHelperProduct(Input input) {
        this.input = input;
    }

    @Override
    public Product create() {
        try {
            Product product = new Product();
            System.out.print("Название продукта: ");
            product.setName(input.nextLine());
            System.out.print("Описание продукта: ");
            product.setDescription(input.nextLine());
            System.out.print("Цена: ");
            product.setPrice(new BigDecimal(input.nextLine()));
            System.out.print("Бренд: ");
            product.setBrand(input.nextLine());
            System.out.print("Количество на складе: ");
            product.setStockQuantity(Integer.parseInt(input.nextLine()));
            System.out.print("Категория: ");
            product.setCategory(input.nextLine());
            System.out.print("Характеристики: ");
            product.setSpecifications(input.nextLine());
            System.out.print("Рейтинг: ");
            product.setRating(Double.parseDouble(input.nextLine()));
            return product;
        } catch (Exception e) {
            System.out.println("Error creating product: " + e.toString());
            return null;
        }
    }

    @Override
    public boolean printList(List<Product> products) {
        try {
            if (products.size() == 0) return false;
            for (int i = 0; i < products.size(); i++) {
                System.out.printf("%d. %s - %s. Цена: %s. Бренд: %s%n",
                        i + 1,
                        products.get(i).getName(),
                        products.get(i).getDescription(),
                        products.get(i).getPrice(),
                        products.get(i).getBrand()
                );
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error printing product list: " + e.toString());
            return false;
        }
    }
}

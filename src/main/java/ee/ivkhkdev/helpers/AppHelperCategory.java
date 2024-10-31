package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Category;

import java.util.List;

public class AppHelperCategory implements AppHelper<Category> {
    private final Input input;

    public AppHelperCategory(Input input) {
        this.input = input;
    }

    @Override
    public Category create() {
        try {
            Category category = new Category();
            System.out.print("Название категории: ");
            category.setName(input.nextLine());
            System.out.print("Описание категории: ");
            category.setDescription(input.nextLine());
            return category;
        } catch (Exception e) {
            System.out.println("Error creating category: " + e.toString());
            return null;
        }
    }

    @Override
    public boolean printList(List<Category> categories) {
        try {
            if (categories.size() == 0) return false;
            for (int i = 0; i < categories.size(); i++) {
                System.out.printf("%d. %s - %s%n",
                        i + 1,
                        categories.get(i).getName(),
                        categories.get(i).getDescription()
                );
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error printing category list: " + e.toString());
            return false;
        }
    }
}

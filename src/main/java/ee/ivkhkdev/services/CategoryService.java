package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.model.Category;
import ee.ivkhkdev.repositories.Repository;

import java.util.List;

public class CategoryService implements Service {
    private final List<Category> categories;
    private final Repository<Category> repository;
    private final AppHelper<Category> appHelperCategory;

    public CategoryService(List<Category> categories, AppHelper<Category> appHelperCategory, Repository<Category> repository) {
        this.categories = categories;
        this.appHelperCategory = appHelperCategory;
        this.repository = repository;
    }

    public boolean add() {
        Category category = appHelperCategory.create();
        if (category == null) return false;

        categories.add(category);
        repository.save(category);
        return true;
    }

    public boolean print() {
        return appHelperCategory.printList(categories);
    }

    @Override
    public List<Category> list() {
        return categories;
    }
}

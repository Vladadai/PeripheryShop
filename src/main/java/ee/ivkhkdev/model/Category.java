package ee.ivkhkdev.model;

import java.io.Serializable;
import java.util.UUID;

public class Category implements Serializable {
    private UUID id;
    private String name;
    private String description;
    private Category parentCategory;

    public Category() {
        this.id = UUID.randomUUID();
    }

    public Category(String name, String description, Category parentCategory) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Category getParentCategory() { return parentCategory; }
    public void setParentCategory(Category parentCategory) { this.parentCategory = parentCategory; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return id.equals(category.id) && name.equals(category.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parentCategory=" + (parentCategory != null ? parentCategory.getName() : "None") +
                '}';
    }
}

package ee.ivkhkdev.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class Product implements Serializable {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String brand;
    private int stockQuantity;
    private String category;
    private String specifications;
    private double rating;

    public Product() {
        this.id = UUID.randomUUID();
    }

    public Product(String name, String description, BigDecimal price, String brand, int stockQuantity, String category, String specifications, double rating) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.specifications = specifications;
        this.rating = rating;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSpecifications() { return specifications; }
    public void setSpecifications(String specifications) { this.specifications = specifications; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return id.equals(product.id) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", category='" + category + '\'' +
                ", specifications='" + specifications + '\'' +
                ", rating=" + rating +
                '}';
    }
}

package pl.first.thymeleaf.project.demo.repositories;

import org.springframework.stereotype.Repository;
import pl.first.thymeleaf.project.demo.model.Category;
import pl.first.thymeleaf.project.demo.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductsRepository {
    List<Product> products = new ArrayList<>();

    ProductsRepository() {
        products.add(new Product("MountainDew", 2.5, Category.GROCERIES));
        products.add(new Product("Armchair", 499, Category.HOUSEHOLD_ITEMS));
        products.add(new Product("Tire", 100, Category.OTHER));
    }

    public List<Product> getAll() {
        return products;
    }

    public List<Product> getByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().getPath().equals(category))
                .collect(Collectors.toList());
    }

    public void add(Product product) {
        products.add(product);
    }
}

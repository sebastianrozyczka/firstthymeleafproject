package pl.first.thymeleaf.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    private String name;
    private double price;
    private Category category;

    @Override
    public String toString() {
        return "Name: " + name +
                ", price: " + price +
                ", category: " + category.getName();
    }
}

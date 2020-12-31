package pl.first.thymeleaf.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    GROCERIES("Groceries"),
    HOUSEHOLD_ITEMS("Household items"),
    OTHER("Other products");

    private String name;
}

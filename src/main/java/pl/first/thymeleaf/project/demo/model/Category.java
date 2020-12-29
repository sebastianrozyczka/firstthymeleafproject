package pl.first.thymeleaf.project.demo.model;

public enum Category {
    GROCERIES("Groceries", "groceries"),
    HOUSEHOLD_ITEMS("Household items", "household_items"),
    OTHER("Other products", "other");

    Category(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    private String name;
    private String path;
}

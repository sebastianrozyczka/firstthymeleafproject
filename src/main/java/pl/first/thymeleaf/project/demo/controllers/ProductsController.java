package pl.first.thymeleaf.project.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.first.thymeleaf.project.demo.model.Category;
import pl.first.thymeleaf.project.demo.model.Product;
import pl.first.thymeleaf.project.demo.repositories.ProductsRepository;

import java.util.List;

@Controller
public class ProductsController {
    private final ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping({"/products", "/products/{category}"})
    public String productsAndAmount(@PathVariable(required = false) Category category, Model model) {
        List<Product> products;
        if (category == null) {
            products = productsRepository.getAll();
        } else {
            products = productsRepository.getByCategory(category);
        }
        calculateSumOfPrices(products, model);
        model.addAttribute("products", products);
        return "products";
    }

    private void calculateSumOfPrices(List<Product> products, Model model) {
        double sum = products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        model.addAttribute("sum", sum);
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());

        return "product";
    }

    @PostMapping("/add")
    public String add(Product product) {
        productsRepository.add(product);

        return "redirect:products";
    }
}

package pl.first.thymeleaf.project.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.first.thymeleaf.project.demo.model.Product;
import pl.first.thymeleaf.project.demo.repositories.ProductsRepository;

import java.util.List;

@Controller
public class ProductsController {
    private final ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    List<Product> products;

    @GetMapping({"/products", "/products/{category}"})
    public String productsAndAmount(@PathVariable(required = false, name = "category") String category, Model model) {
        if (category == null || category.isEmpty()) {
            products = productsRepository.getAll();
        } else {
            products = productsRepository.getByCategory(category);
        }
        calculateSumOfPrices(model);
        model.addAttribute("products", products);
        return "products";
    }

    private void calculateSumOfPrices(Model model) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
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

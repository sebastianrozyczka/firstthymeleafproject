package pl.first.thymeleaf.project.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.first.thymeleaf.project.demo.model.Category;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


@Controller
public class HomeController {
    @GetMapping("/")
    public String homepage(Model model) {
        final List<Category> categories =
                new ArrayList<>(EnumSet.allOf(Category.class));

        model.addAttribute("categories", categories);
        return "home";
    }
}

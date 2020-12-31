package pl.first.thymeleaf.project.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.first.thymeleaf.project.demo.model.Category;

import java.util.EnumSet;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homepage(Model model) {
        final EnumSet<Category> categories =
                EnumSet.allOf(Category.class);

        model.addAttribute("categories", categories);
        return "home";
    }
}

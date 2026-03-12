package com.example.handson6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String showListProduct() {
        return "product/list";
    }

    @GetMapping("/add")
    public String showFormProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", Category.values());
        return "product/form";
    }

    @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {

        System.out.println("Saved product data:");
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getCategory());
        System.out.println(product.getStock());
        System.out.println(product.getDescription());
        System.out.println(product.isActive());

        redirectAttributes.addFlashAttribute("message","Product saved successfully");

        return "redirect:/products";
    }
}

package net.ddns.wak.Task3.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.ddns.wak.Task3.model.Product;
import net.ddns.wak.Task3.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/products")
    public String viewProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }
    @PostMapping("/products")
    public String addProduct(Product p, Model model){
        productService.addProduct(p);
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }
}

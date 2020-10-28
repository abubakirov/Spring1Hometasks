package lesson02.controllers;

import lesson02.Services.ProductServiceImpl;
import lesson02.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public String list(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product == null ? new Product() : product);
        return "product";
    }

    @GetMapping("/price/{id}")
    @ResponseBody
    public String price(@PathVariable Long id) {
        Product product = productService.getById(id);
        return product == null ? "0" : product.getPrice().toString();
    }
}

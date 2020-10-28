package lesson02.controllers;

import lesson02.Services.ProductServiceImpl;
import lesson02.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }

    @PostMapping("/new")
    public String newProduct(Product product) {
        Product savedProduct = productService.save(product);
        return "redirect:/products/" + savedProduct.getId();
    }

    @GetMapping(params={"price_from"})
    public String productsByPrice(Model model,
                                  @RequestParam("price_from") Double priceFrom,
                                  @RequestParam(value = "price_to", required = false) Double priceTo) {
        priceTo = priceTo == null ? Double.MAX_VALUE: priceTo;
        List<Product> products = productService.getByPrice(priceFrom, priceTo);
        model.addAttribute("products", products);
        return "list";
    }
}

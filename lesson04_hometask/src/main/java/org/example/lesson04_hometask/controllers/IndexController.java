package org.example.lesson04_hometask.controllers;

import org.example.lesson04_hometask.InitData;
import org.example.lesson04_hometask.domain.Product;
import org.example.lesson04_hometask.repositories.ProductDAO;
import org.example.lesson04_hometask.services.ProductServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private final ProductServiceImpl productService;

    public IndexController(ProductServiceImpl productService) {
        this.productService = productService;

        this.productService.saveAll(InitData.getProducts());
    }

    @GetMapping("/")
    public String indexPage(Model uiModel) {
        return "index";
    }

    @GetMapping("/product/{id}")
    public String productGet(Model uiModel, @PathVariable("id") Long id) {
        Product product = productService.findById(id);
        uiModel.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/product/{id}")
    public String productPost(Model uiModel, @PathVariable("id") Long id) {
        Product newProduct = (Product)uiModel.getAttribute("product");
        productService.save(newProduct);
        uiModel.addAttribute("updated", true);
        return "product";
    }

    @GetMapping("/productMinPrice")
    public String productMinPrice(Model uiModel) {
        Product product = productService.findMinPrice();
        uiModel.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/productMaxPrice")
    public String productMaxPrice(Model uiModel) {
        Product product = productService.findMaxPrice();
        uiModel.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/list")
    public String list(Model uiModel) {
        List<Product> products = productService.findAll();
        uiModel.addAttribute("products", products);
        return "list";
    }

    @GetMapping(value = "/listBy3", params = {"page"})
    public String listBy3(Model uiModel, @RequestParam("page") int page) {
        Page<Product> products = productService.findAll(PageRequest.of(page - 1, 3));
        uiModel.addAttribute("products", products);
        uiModel.addAttribute("prevPageExists", page > 1);
        uiModel.addAttribute("nextPageExists", products.hasNext());
        uiModel.addAttribute("prevPage", page - 1);
        uiModel.addAttribute("nextPage", page + 1);
        return "listBy3";
    }

    @GetMapping(value="/formFilterByPrice")
    public String formFilterByPrice(Model uiModel) {
        return "formFilterByPrice";
    }

    @GetMapping(value = "/filteredResults", params={"min_price", "max_price"})
    public String filteredResults(Model uiModel, @RequestParam("min_price") double minPrice,
                                  @RequestParam("max_price") double maxPrice) {
        List<Product> products = productService.findByPrice(minPrice, maxPrice);
        uiModel.addAttribute("products", products);
        return "list";
    }
}

package com.abubakirov.lesson06_ht.service;

import com.abubakirov.lesson06_ht.domain.Product;
import com.abubakirov.lesson06_ht.repositories.ProductDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl {
    ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public void save(Product product) {
        productDAO.save(product);
    }

    @Transactional
    public void saveAll(Product ... products) {
        productDAO.saveAll(Arrays.asList(products));
    }

    @Transactional
    public Product findById(Long id) {
        return productDAO.findById(id).orElse(null);
    }

    @Transactional
    public Product findMinPrice() {
        List<Product> products = productDAO.findTop1ByOrderByPriceAsc();
        return products.size() == 0 ? null : products.get(0);
    }

    @Transactional
    public Product findMaxPrice() {
        List<Product> products = productDAO.findTop1ByOrderByPriceDesc();
        return products.size() == 0 ? null : products.get(0);
    }

    @Transactional
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Transactional
    public Page<Product> findAll(Pageable pageable) {
        return productDAO.findAll(pageable);
    }

    @Transactional
    public List<Product> findByPrice(double minPrice, double maxPrice) {
        return productDAO.findAllByPriceBetween(minPrice, maxPrice);
    }
}

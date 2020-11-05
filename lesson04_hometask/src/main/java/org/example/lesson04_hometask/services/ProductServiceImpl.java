package org.example.lesson04_hometask.services;

import org.example.lesson04_hometask.domain.Product;
import org.example.lesson04_hometask.repositories.ProductDAO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl {

    private ProductDAO productDAO;


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
        List<Product> products =  productDAO.findAll(Sort.by(Sort.Direction.ASC, "price"));
        return products.size() == 0 ? null : products.get(0);
    }

    @Transactional
    public Product findMaxPrice() {
        List<Product> products =  productDAO.findAll(Sort.by(Sort.Direction.DESC, "price"));
        return products.size() == 0 ? null : products.get(0);
    }

    @Transactional
    public List<Product> findAll() {
        return productDAO.findAll();
    }
}

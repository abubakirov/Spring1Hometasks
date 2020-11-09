package org.example.lesson04_hometask.repositories;

import org.example.lesson04_hometask.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    public List<Product> findTop1ByOrderByPriceAsc();
    public List<Product> findTop1ByOrderByPriceDesc();
    public Page<Product> findAll(Pageable pageable);
    public List<Product> findAllByPriceBetween(double minPrice, double maxPrice);
}

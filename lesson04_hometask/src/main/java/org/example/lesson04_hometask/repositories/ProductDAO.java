package org.example.lesson04_hometask.repositories;

import org.example.lesson04_hometask.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Long> {
}

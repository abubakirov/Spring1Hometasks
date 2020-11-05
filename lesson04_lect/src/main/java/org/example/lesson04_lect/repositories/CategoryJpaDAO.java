package org.example.lesson04_lect.repositories;

import org.example.lesson04_lect.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaDAO extends JpaRepository<Category, Long> {
}

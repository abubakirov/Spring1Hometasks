package org.example.lesson04_lect.repositories;

import org.example.lesson04_lect.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorJpaDAO extends JpaRepository<Author, Long> {
}

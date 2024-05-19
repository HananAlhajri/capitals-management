package com.demo.capmgnmt.repository;

import com.demo.capmgnmt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
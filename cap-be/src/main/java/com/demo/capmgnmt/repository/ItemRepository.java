package com.demo.capmgnmt.repository;

import com.demo.capmgnmt.entity.Category;
import com.demo.capmgnmt.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategory(Category category);
}
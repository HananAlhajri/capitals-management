package com.demo.capmgnmt.repository;

import com.demo.capmgnmt.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
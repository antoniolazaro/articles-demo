package com.article.demo.jpa.domain.article.repository;

import com.article.demo.jpa.domain.article.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
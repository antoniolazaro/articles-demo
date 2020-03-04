package com.article.demo.jpa.domain.user.repository;

import com.article.demo.jpa.domain.user.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
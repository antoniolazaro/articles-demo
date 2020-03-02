package com.article.demo.jpa.service;

import java.util.List;

import com.article.demo.jpa.model.User;
import com.article.demo.jpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Integer id) {
    if (id != null) {
      return repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("User %d not found", id)));
    } else {
      throw new RuntimeException("Id is null");
    }
  }

  public User save(User article) {
    return repository.save(article);
  }

  public User update(User user, Integer id) {
    if (id != null) {
      return repository.findById(id).map(userDB -> {
        userDB.setName(user.getTitle());
        userDB.setEmail(user.getEmail());
        userDB.setCelphone(user.getCelphone());
        return repository.save(articleDB);
      }).orElseGet(() -> {
        return repository.save(article);
      });
    } else {
      throw new RuntimeException("Id is null");
    }
  }

  public void deleteById(Integer id) {
    if (id != null) {
      repository.deleteById(id);
    } else {
      throw new RuntimeException("Id is null");
    }
  }
}
package com.article.demo.jpa.domain.user.service;

import java.util.List;

import com.article.demo.jpa.domain.user.model.User;
import com.article.demo.jpa.domain.user.repository.UserRepository;
import com.article.demo.jpa.exception.BusinessException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(String login) {
    return repository.findById(login)
        .orElseThrow(() -> new RuntimeException(String.format("User %d not found", login)));
  }

  public User save(User article) {
    return repository.save(article);
  }

  public User update(User user, String login) {
    return repository.findById(login).map(userDB -> {
      userDB.setName(user.getName());
      userDB.setEmail(user.getEmail());
      userDB.setCelPhone(user.getCelPhone());
      return repository.save(userDB);
    }).orElseGet(() -> {
      return repository.save(user);
    });
  }

  public void deleteById(String login) {
    repository.deleteById(login);
  }
}
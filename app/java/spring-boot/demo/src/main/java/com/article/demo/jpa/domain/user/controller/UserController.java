package com.article.demo.jpa.domain.user.controller;

import java.util.List;

import javax.validation.Valid;

import com.article.demo.jpa.domain.user.model.User;
import com.article.demo.jpa.domain.user.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jpa/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @GetMapping("/")
  public @ResponseBody ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<User> getById(@PathVariable(required = true) String login) {
    return ResponseEntity.ok(service.findById(login));
  }

  @PostMapping("/")
  public @ResponseBody ResponseEntity<User> save(@Valid @RequestBody User user) {
    return ResponseEntity.ok(service.save(user));
  }

  @PutMapping("/{id}")
  public @ResponseBody ResponseEntity<User> update(@RequestBody User user,
      @PathVariable(required = true) String login) {
    return ResponseEntity.ok(service.update(user, login));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable(required = true) String login) {
    service.deleteById(login);
  }

}
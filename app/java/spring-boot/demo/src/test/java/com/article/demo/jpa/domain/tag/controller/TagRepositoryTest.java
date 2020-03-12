package com.article.demo.jpa.domain.tag.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.article.demo.jpa.domain.tag.model.Tag;
import com.article.demo.jpa.domain.tag.repository.TagRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TagRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private TagRepository repository;

  @Test
  public void whenFindByName_ThenReturnValid() {

  }
}
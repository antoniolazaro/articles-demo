
package com.article.demo.jpa.domain.tag.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.article.demo.jpa.domain.tag.model.Tag;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TagCustomRepositoryImpl implements TagCustomRepository {

  private final EntityManager entityManager;

  public List<Tag> selectInsertedToday() {
    return entityManager
        .createNativeQuery(
            "select t.id,t.name from tag t where date_trunc('day',t.created_at) = date_trunc('day',now())", Tag.class)
        .getResultList();
  }

}

package com.article.demo.jpa.domain.tag.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.article.demo.jpa.domain.tag.model.Tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

  List<Tag> findByName(String name);

  @Query(name = "TagRepository.findNamePaged", value = "select t from Tag t where upper(t.name) like upper('%'||:name||'%') order by name")
  Page<Tag> findNamePaged(String name, Pageable pageable);

  @Query(name = "TagRepository.findByPartOfDescription", value = "select t from Tag t where upper(t.description) like upper('%'||:partOfDescription||'%') order by name")
  List<Tag> findByPartOfDescription(@Param("partOfDescription") String partOfDescription);

  @Query(name = "TagRepository.findByCreationPeriod", value = "select * from Tag t where createdAt >= :startPeriod and createdAt <= :endPeriod order by name", nativeQuery = true)
  List<Tag> findByCreationPeriod(@Param("startPeriod") LocalDateTime startPeriod,
      @Param("endPeriod") LocalDateTime endPeriod);

  @Modifying
  @Transactional
  @Query(name = "TagRepository.deleteByName", value = "delete from Tag t where t.name = :name")
  void deleteByName(@Param("name") String name);
}
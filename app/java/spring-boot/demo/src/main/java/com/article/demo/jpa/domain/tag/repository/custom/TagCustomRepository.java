package com.article.demo.jpa.domain.tag.repository.custom;

import java.util.List;

import com.article.demo.jpa.domain.tag.model.Tag;

public interface TagCustomRepository {

  List<Tag> selectInsertedToday();
}

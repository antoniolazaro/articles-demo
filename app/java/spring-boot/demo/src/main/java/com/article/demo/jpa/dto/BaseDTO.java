package com.article.demo.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDTO {

  private Integer currentPage = 0;
  private Integer pageSize = 10;
  private String sortBy;

}
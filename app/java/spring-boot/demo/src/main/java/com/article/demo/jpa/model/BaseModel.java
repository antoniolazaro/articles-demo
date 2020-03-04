package com.article.demo.jpa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.article.demo.jpa.dto.parser.ModelInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@MappedSuperclass
@SuperBuilder
public abstract class BaseModel implements ModelInterface {

  private static final long serialVersionUID = -7727369263694793386L;

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public boolean isNew() {
    return id == null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (!(o instanceof BaseModel))
      return false;

    BaseModel other = (BaseModel) o;

    return id != null && id.equals(other.getId());
  }

  @Override
  public int hashCode() {
    return 31;
  }
}
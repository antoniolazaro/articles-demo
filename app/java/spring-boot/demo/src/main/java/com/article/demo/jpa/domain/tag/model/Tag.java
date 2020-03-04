package com.article.demo.jpa.domain.tag.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.article.demo.jpa.domain.article.model.Article;
import com.article.demo.jpa.model.BaseModel;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Table(name = "tag", schema = "public")
@Entity(name = "Tag")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Tag extends BaseModel {

  private static final long serialVersionUID = 7155883597540238495L;

  @NaturalId(mutable = false)
  @Column(name = "name")
  @NotBlank(message = "Name is mandatory")
  @Size(min = 2, max = 30, message = "Name should have between {min} and {max} size.")
  private String name;

  @Column(name = "description")
  private String description;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
  private List<Article> articles;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Tag tag = (Tag) o;
    return Objects.equals(name, tag.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
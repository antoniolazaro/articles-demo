package com.article.demo.jpa.domain.article.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.article.demo.jpa.domain.tag.model.Tag;
import com.article.demo.jpa.domain.user.model.User;
import com.article.demo.jpa.model.BaseModel;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Table(name = "article", schema = "public")
@Entity(name = "Article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Article extends BaseModel {

  private static final long serialVersionUID = -2427443912020515373L;

  @Column(name = "title")
  @NotBlank(message = "Title is mandatory")
  @Size(min = 5, max = 200, message = "Title '${validatedValue}' should have {min} and {max} size")
  private String title;

  @Column(name = "short_description")
  @Size(min = 5, max = 100, message = "Short Description '${validatedValue}' should have {min} and {max} size")
  private String shortDescription;

  @Column(name = "content")
  @NotBlank(message = "Content is mandatory")
  @Size(min = 10, message = "Content should have at least {min} size")
  private String content;

  @ManyToOne(fetch = FetchType.EAGER)
  @NotNull(message = "User is mandatory")
  private User user;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "last_update_at")
  private LocalDateTime lastUpdateAt;

  @Column(name = "last_view_at")
  private LocalDateTime lastViewAt;

  @Column(name = "time_reading_average")
  private BigDecimal timeReadingAverage;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "article_tag", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private List<Tag> tags;

  @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Comment> comments;
}
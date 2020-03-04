package com.article.demo.jpa.domain.article.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.article.demo.jpa.domain.user.model.User;
import com.article.demo.jpa.model.BaseModel;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Table(name = "comment", schema = "public")
@Entity(name = "Comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Comment extends BaseModel {

  private static final long serialVersionUID = -1362822636066728651L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_login")
  @NotNull(message = "User is mandatory")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotNull(message = "Article is mandatory")
  private Article article;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "comment_origin")
  @NotBlank(message = "Content is mandatory")
  @Size(min = 5, message = "Content should have at least {min} size")
  private Comment commentOrigin;

  @Column(name = "content")
  private String content;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
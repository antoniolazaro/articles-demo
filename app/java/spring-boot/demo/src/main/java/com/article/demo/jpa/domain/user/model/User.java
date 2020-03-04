package com.article.demo.jpa.domain.user.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.article.demo.jpa.domain.article.model.Article;
import com.article.demo.jpa.dto.parser.ModelInterface;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "User")
@Table(name = "user", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements ModelInterface {

  private static final long serialVersionUID = -558778493058683547L;

  @Id
  @Column(name = "login")
  private String login;

  @NotBlank(message = "Login is mandatory")
  @Size(min = 5, max = 50, message = "Login should have between {min} and {max} size.")
  @Column(name = "name")
  @NotBlank(message = "Name is mandatory")
  @Size(min = 5, max = 200, message = "Name should have between {min} and {max} size.")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  @NotBlank(message = "Email is mandatory")
  @Size(min = 5, max = 100, message = "Email should have between {min} and {max} size.")
  @Email(message = "Invalid email")
  private String email;

  @Column(name = "celphone")
  private String celPhone;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "last_update_at")
  private LocalDateTime lastUpdateAt;

  @Column(name = "last_access_at")
  private LocalDateTime lastAccessAt;

  @Column(name = "last_publication_at")
  private LocalDateTime lastPublicationAt;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Article> articles;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return Objects.equals(login, user.login);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login);
  }
}

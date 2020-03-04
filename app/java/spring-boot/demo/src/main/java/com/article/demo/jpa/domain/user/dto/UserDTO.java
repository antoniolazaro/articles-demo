package com.article.demo.jpa.domain.user.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.article.demo.jpa.dto.BaseDTO;
import com.article.demo.jpa.dto.parser.DTOInterface;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO extends BaseDTO implements DTOInterface {

  private String login;
  private String name;
  private String email;
  private String celPhone;
  private LocalDateTime createdAt;
  private LocalDateTime lastUpdateAt;
  private LocalDateTime lastAccessAt;
  private LocalDateTime lastPublicationAt;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDTO user = (UserDTO) o;
    return Objects.equals(login, user.login);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login);
  }
}

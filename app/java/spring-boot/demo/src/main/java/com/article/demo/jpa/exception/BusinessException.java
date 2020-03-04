package com.article.demo.jpa.exception;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }

}
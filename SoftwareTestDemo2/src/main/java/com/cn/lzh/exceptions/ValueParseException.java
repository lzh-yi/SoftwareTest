package com.cn.lzh.exceptions;

/**
 * 类{@code ValueParseException}是一个自定义异常类。
 *
 * @author 李志豪
 * @version 1.0
 */
public class ValueParseException extends RuntimeException {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public ValueParseException() {
  }

  public ValueParseException(String message) {
    super(message);
  }

  public ValueParseException(Throwable cause) {
    super(cause);
  }

  public ValueParseException(String message, Throwable cause) {
    super(message, cause);
  }
}

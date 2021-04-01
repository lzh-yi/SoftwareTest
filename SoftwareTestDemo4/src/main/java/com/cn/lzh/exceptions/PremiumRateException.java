package com.cn.lzh.exceptions;

/**
 * {@code PremiumRateException}类是自定义的保险费率异常类。
 *
 * 如果点数小于0就抛出异常
 *
 * @author 李志豪
 * @version 1.0
 */
public class PremiumRateException extends RuntimeException  {

  public PremiumRateException() {
  }

  public PremiumRateException(String message) {
    super(message);
  }

  public PremiumRateException(Throwable cause) {
    super(cause);
  }

  public PremiumRateException(String message, Throwable cause) {
    super(message, cause);
  }

}

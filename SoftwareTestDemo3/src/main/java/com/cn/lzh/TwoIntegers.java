package com.cn.lzh;

/**
 * {@code TwoIntegers}类的目的是求两个整数的和。
 *
 * @author 李志豪
 * @version 1.0
 */
public class TwoIntegers {

  /**
   * 该方法求两个数的和。
   * <p>要求输入的两个参数范围为 [1,99]</p>
   *
   * @param n  其中一个加数
   * @param m  其中一个加数
   * @return  最终结果
   */
  public int sum(int n, int m) {
    // 前置断言
    assert n >= 1 && n <= 99;
    assert m >= 1 && m <= 99;

    return n + m;
  }

  /**
   * 该方法求两个数的和。
   * <p>要求输入的两个参数范围为 [1,99]。同时结果必须小于100</p>
   *
   * @param n  其中一个加数
   * @param m  其中一个加数
   * @return  最终结果
   */
  public int sumLt100(int n, int m) {
    // 前置断言
    assert n >= 1 && n <= 99;
    assert m >= 1 && m <= 99;
    assert n+m < 100;

    return n + m;
  }

  /**
   * 该方法求两个数的和或者差。
   * <p>要求输入的两个参数范围为 [1,99]。同时结果必须在 [0,99]</p>
   *
   * @param n  其中一个操作数
   * @param m  其中一个操作数
   * @param operation  运算标志。其中true为加法
   * @return  最终结果
   */
  public int sumAndSub(int n, int m, boolean operation) {
    // 前置断言
    assert n >= 1 && n <= 99;
    assert m >= 1 && m <= 99;

    if (operation) {
      assert n + m < 100 && n + m > -1;
      return n + m;
    }else {
      assert n - m < 100 && n - m > -1;
      return n - m;
    }
  }
}

package com.lzh.main;

/**
 * {@code Triangle}类的主要目的是{@literal 测试三角形是否为等边、等腰、不等边三角形，或不是三角形}。
 *
 * @author 李志豪
 * @version 1.0
 */
public class Triangle {

  /**
   * 该方法的作用是根据输入的三个参数来判断该三个参数构成的三角形类型。
   *
   * <section>
   *   <p>该函数的3个参数a、b和c分别作为三角形的三条边，要求a、b和c必须满足以下条件：</p>
   *   <ul>
   *     <li>整数</li>
   *     <li>3个数</li>
   *     <li>边长大于等于1，小于等于101</li>
   *     <li>任意两边之和大于第三边</li>
   *   </ul>
   *   <br />
   *   <p>该函数的返回值为以下几种情况:</p>
   *   <ul>
   *     <li>如果不满足条件1、2，则返回值为"输入错误"</li>
   *     <li>如果不满足条件3、4，则返回值为为"非三角形"</li>
   *     <li>如果三条边相等，则返回值为"等边三角形"</li>
   *     <li>如果恰好有两条边相等，则返回值为为"等腰三角形"</li>
   *     <li>如果三条边都不相等，则返回值为为"不等边三角形"</li>
   *   </ul>
   * </section>
   *
   * @param a  三角形的一条边
   * @param b  三角形的一条边
   * @param c  三角形的一条边
   */
  public String classify(int a, int b, int c) {
    // 输入范围检测
    if ((a<1 || a>300) || (b<1 || b>300) || (c<1 || c>300)) {
      return "非三角形";
    }
    if (!((a + b > c) && (a + c > b) && (b + c > a))) {
      return "非三角形";
    }else if ((a == b) && (a == c) && (b == c)) {
      return "等边三角形";
    }else if ((a==b) || (a==c) || (b==c)) {
      return "等腰三角形";
    }else {
      return "不等边三角形";
    }
  }

}

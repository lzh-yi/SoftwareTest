package com.lzh.test;

import com.lzh.main.Triangle;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * 该类是{@link com.lzh.main.Triangle}类的测试类。
 *
 * <p>该测试类对{@link com.lzh.main.Triangle}类进行四类边界值测试:</p>
 * <ul>
 *   <li>边界值分析</li>
 *   <li>健壮性测试</li>
 *   <li>最坏情况测试</li>
 *   <li>健壮最坏情况测试</li>
 * </ul>
 *
 * 该测试类使用{@code Juni5}测试框架。
 *
 * @author 李志豪
 * @version 1.0
 */
class TriangleTest {

  /**
   * 测试的基类
   */
  private final Triangle triangle = new Triangle();

  /**
   *该方法测试{@link com.lzh.main.Triangle}实例的{@link com.lzh.main.Triangle#classify(int, int, int)}方法。
   *
   * @param a  输入的参数
   * @param b  输入的参数
   * @param c  输入的参数
   * @param expected  期望值
   */
  @Order(1)
  @ParameterizedTest
  @CsvFileSource(resources = "/triangle/general_boundary.csv",numLinesToSkip = 1)
  @DisplayName("三角形一般边界测试")
  void paramTriangleByGeneralBoundary (String info,int a, int b, int c, String expected) throws IOException {
    String type = triangle.classify(a,b,c);
    Assertions.assertEquals(type,expected);
  }

  /**
   *该方法测试{@link com.lzh.main.Triangle}实例的{@link com.lzh.main.Triangle#classify(int, int, int)}方法
   *
   * @param a  输入的参数
   * @param b  输入的参数
   * @param c  输入的参数
   * @param expected  期望值
   */
  @Order(2)
  @ParameterizedTest
  @CsvFileSource(resources = "/triangle/robustness_is_the_worst_case.csv",numLinesToSkip = 1)
  @DisplayName("三角形健壮性最坏情况测试")
  void paramTriangleByRobustnessIsTheWorstCase (String info,int a, int b, int c, String expected) throws IOException {
    String type = triangle.classify(a,b,c);
    Assertions.assertEquals(type,expected);
  }

  /**
   *该方法测试{@link com.lzh.main.Triangle}实例的{@link com.lzh.main.Triangle#classify(int, int, int)}方法
   *
   * @param a  输入的参数
   * @param b  输入的参数
   * @param c  输入的参数
   * @param expected  期望值
   */
  @Order(3)
  @ParameterizedTest
  @CsvFileSource(resources = "/triangle/robust.csv",numLinesToSkip = 1)
  @DisplayName("三角形健壮测试")
  void paramTriangleByRobust (String info,int a, int b, int c, String expected) throws IOException {
    String type = triangle.classify(a,b,c);
    Assertions.assertEquals(type,expected);
  }

  /**
   *该方法测试{@link com.lzh.main.Triangle}实例的{@link com.lzh.main.Triangle#classify(int, int, int)}方法
   *
   * @param a  输入的参数
   * @param b  输入的参数
   * @param c  输入的参数
   * @param expected  期望值
   */
  @Order(4)
  @ParameterizedTest
  @CsvFileSource(resources = "/triangle/equivalenceclass.csv",numLinesToSkip = 1)
  @DisplayName("三角形弱一般等价类测试")
  void paramTriangleByEquivalenceClass (String info,int a, int b, int c, String expected) throws IOException {
    String type = triangle.classify(a,b,c);
    Assertions.assertEquals(type,expected);
  }

  /**
   *该方法测试{@link com.lzh.main.Triangle}实例的{@link com.lzh.main.Triangle#classify(int, int, int)}方法
   *
   * @param a  输入的参数
   * @param b  输入的参数
   * @param c  输入的参数
   * @param expected  期望值
   */
  @Order(5)
  @ParameterizedTest
  @CsvFileSource(resources = "/triangle/worst_case.csv",numLinesToSkip = 1)
  @DisplayName("三角形最坏情况测试")
  void paramTriangleByWorstCase (String info,int a, int b, int c, String expected) throws IOException {
    String type = triangle.classify(a,b,c);
    Assertions.assertEquals(type,expected);
  }
}
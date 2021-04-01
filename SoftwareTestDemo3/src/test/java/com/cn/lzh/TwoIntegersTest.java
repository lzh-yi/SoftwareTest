package com.cn.lzh;


import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * {@code TwoIntegersTest}类是 {@link TwoIntegers}类的测试类。
 *
 * @author 李志豪
 * @version 1.0
 */
class TwoIntegersTest {
  private final TwoIntegers adder = new TwoIntegers();

  // 无效输入测试用例
  @ParameterizedTest(name = "num1={0}, num2={1}")
  @CsvSource({
    "0, 50",
    "100, 50",
    "50, 0",
    "50, 100",
  })
  void sumInvalidCases(int num1, int num2) {
    Assertions.assertThrows(
      AssertionError.class,
      () -> adder.sum(num1, num2));
  }

  //有效输入测试用例
  @ParameterizedTest(name = "num1={0}, num2={1}, result={2}")
  @CsvSource({
    "50, 50, 100",
    "1, 50, 51",
    "2,50,52",
    "99, 50, 149",
    "98,50,148",
    "50, 50, 100",
    "50, 1, 51",
    "50, 2, 52",
    "50,99,149",
    "50,98,148"
  })
  void sumValidCases(int num1, int num2, int result) {
    Assertions.assertEquals(result, adder.sum(num1, num2));
  }

  //采用参数生成方法实现有效输入测试用例
  @ParameterizedTest(name = "num1={0}, num2={1}, result={2}")
  @MethodSource("generator")
  void sumValidCasesWithMethodParam(int num1, int num2, int result) {
    Assertions.assertEquals(result, adder.sum(num1, num2));
  }

  // 参数生成方法必须为static
  private static Stream<Arguments> generator(){
    return Stream.of(
      Arguments.of(50,50,100),
      Arguments.of(1,50,51),
      Arguments.of(2,50,52),
      Arguments.of(99,50,149),
      Arguments.of(98,50,148),
      Arguments.of(50,50,100),
      Arguments.of(50,1,51),
      Arguments.of(50,2,52),
      Arguments.of(50,99,149),
      Arguments.of(50,98,148)
    );
  }

  // 测试结果是否小于100
  @ParameterizedTest(name = "num1={0}, num2={1}")
  @CsvSource({
    "50, 50",
    "100, 50",
  })
  void sumLt100Test(int num1, int num2) {
    Assertions.assertThrows(
      AssertionError.class,
      () -> adder.sumLt100(num1, num2));
  }

  // 测试结果是否在 [0,100]
  @ParameterizedTest(name = "num1={0}, num2={1}, operation={2}")
  @CsvSource({
    "50, 50,true",
    "0, 0,true",
    "0, 0,false",
    "100, 50,true",
    "-1, 101,true",
    "101, -1,true",
    "101, 1,false",
    "100, -1,false",
    "99, 0,false",
    "99, 1,true",
  })
  void sumAndSubTest(int num1, int num2, boolean operation) {
    Assertions.assertThrows(
      AssertionError.class,
      () -> adder.sumAndSub(num1, num2, operation));
  }
}
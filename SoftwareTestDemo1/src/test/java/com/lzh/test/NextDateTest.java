package com.lzh.test;

import com.lzh.main.NextDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * 该类是{@code NextDate}类的测试类。
 *
 * <p>该测试类基于决策表进行测试</p>
 * 该测试类使用{@code Juni5}测试框架。
 * @author 李志豪
 * @version 1.0
 */
class NextDateTest {
  private final NextDate nextDate = new NextDate();

  /**
   *该方法测试{@code com.lzh.main.NextDate}实例的{@link com.lzh.main.NextDate#testDate(int, int, int)} (int, int, int)}方法.
   * @param year  输入的年份
   * @param month  输入的月份
   * @param day  输入的天数
   * @param expected  期望值
   */
  @ParameterizedTest
  @CsvFileSource(resources = "/nextDate/nextDate.csv",numLinesToSkip = 1)
  void paramTriangle (String id,int year, int month, int day, String expected) {
    String type = nextDate.testDate(year,month,day);
    Assertions.assertEquals(type,expected);

  }

}
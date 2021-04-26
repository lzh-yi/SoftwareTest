package com.cn.lzh.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointUtilTest {

  @ParameterizedTest(name = "num1={0}, num2={1},num3={2}, num4={3}")
  @CsvSource(value = {
    "-1, M, false, 2",
    "122, M, false, 8",
    "22, F, true, -1",
    "22, 男, true, -1",
    "22, 女, true, -1",
    "22, 女, xxx, -1"
    })
  void testGetPoint(Integer age, char sex, Boolean marriageStatus,int people) {
    Assertions.assertThrows(
        AssertionError.class,
        () -> PointUtil.getPoint(age, sex, marriageStatus, people));

  }
}
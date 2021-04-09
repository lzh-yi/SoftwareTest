package com.cn.lzh.utils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.cn.lzh.exceptions.PremiumRateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PremiumRateUtilTest {

  @ParameterizedTest(name = "num1={0}, num2={1},num3={2}, num4={3}, num5={4}")
  @CsvSource(value={
    "22, M, true, 1, 0.006",
    "45, F, false, 4, 0.001",
    "65, M, true, 8, 0.001",
  })
  void testGetPremiumRate(Integer age, char sex, Boolean marriageStatus,int people, double premiumRate) {
    // 先获取点数
    int points = PointUtil.getPoint(age, sex, marriageStatus, people);
    Assertions.assertEquals(premiumRate, PremiumRateUtil.getPremiumRate(points));

  }

  // 无效输入测试用例
  @Test
  void testGetPremiumRateInvalidCases() {
    Throwable throwable = assertThrows(PremiumRateException.class, ()-> {
      PremiumRateUtil.getPremiumRate(0);
      PremiumRateUtil.getPremiumRate(-1);
    });
    assertAll(
      () -> assertEquals("点数必须大于0",throwable.getMessage()),
      () -> assertEquals("点数必须大于0",throwable.getMessage())
    );
  }
}
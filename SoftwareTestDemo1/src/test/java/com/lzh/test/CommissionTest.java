package com.lzh.test;

import com.lzh.main.Commission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CommissionTest {
  /**
   * 测试的基类
   */
  private final Commission commission = new Commission();


  @ParameterizedTest
  @CsvFileSource(resources = "/commission/commission.csv",numLinesToSkip = 1)
  void testCountMoney(String id, int look_price, int stock_price, int barrel_price,String expected) {
    System.out.println(look_price);
    String type = this.commission.CountMoney(look_price,stock_price,barrel_price);
    Assertions.assertEquals(type,expected);
  }
}
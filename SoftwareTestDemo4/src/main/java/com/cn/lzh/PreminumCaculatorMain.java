package com.cn.lzh;

/**
 * {@code PreminumCaculatorMain}类用于计算保险公司人寿保险保费。
 *
 * @author 李志豪
 * @version 1.0
 */

public class PreminumCaculatorMain {

  /**
   *该方法计算保险公司人寿保险保费。
   *
   * @param crossSumValue  投保额
   * @param premiumRate  保险费率
   * @return  保费
   */
  public double getCrossSumValue(int crossSumValue, double premiumRate) {

    return crossSumValue * premiumRate;
  }


}

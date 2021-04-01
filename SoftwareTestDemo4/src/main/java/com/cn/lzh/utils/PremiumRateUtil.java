package com.cn.lzh.utils;

import com.cn.lzh.exceptions.PremiumRateException;

/**
 * {@code PremiumRateUtil}工具类计算保险费率。
 *
 * @author 李志豪
 * @version 1.0
 */
public class PremiumRateUtil {

  public static double getPremiumRate(int points) {
    if (points < 10 && points >0) {
      return 0.001;
    }else if (points >= 10) {
      return  0.006;
    }else {
      throw new PremiumRateException("点数必须大于0");
    }

  }

}

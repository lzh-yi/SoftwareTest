package com.lzh.main;

/**
 * @author 李志豪
 * @version 1.0
 */
public class Commission {

  /**
   * 抢机的价格{@value}
   */
  public static double LOOK_PRICE = 45.0;
  /**
   * 抢托的价格{@value}
   */
  public static double STOCK_PRICE = 30.0;
  /**
   * 抢管的价格{@value}
   */
  public static double BARREL_PRICE  = 25.0;

  /**
   *该方法用于计算销售额统以及佣金。
   *
   * @param totalLocks  抢机的数量,已知抢机的价格{@value #LOOK_PRICE}
   * @param totalStocks 抢托的数量,已知抢托的价格{{@value #BARREL_PRICE}
   * @param totalBarrel 抢管的数量,已知抢管的价格{{@value #STOCK_PRICE}
   * @return  返回格式为 {@literal 销售额:佣金}
   */
  public String CountMoney(int totalLocks, int totalStocks, int totalBarrel) {
    // 边界值检测
    if ((totalLocks<0 || totalLocks>70) || (totalStocks<0 || totalStocks>80) || (totalBarrel<0 || totalBarrel>90)) {
      return "输入错误";
    }
    // 总销售额
    double allsales = totalLocks* Commission.LOOK_PRICE+totalStocks* Commission.STOCK_PRICE+totalBarrel* Commission.BARREL_PRICE;
    // 佣金
    double commission = 0;
    if(allsales>1800) {
      commission = (allsales -1800)*0.2 +800 * 0.15 + 1000*0.1;
    } else if (allsales>1000) {
      commission = (allsales -1000)*0.15 + 1000*0.1;
    }else {
      commission = allsales *0.1;
    }

    // 返回格式为 总销售额-佣金
    return allsales + "-" + commission;
  }

}

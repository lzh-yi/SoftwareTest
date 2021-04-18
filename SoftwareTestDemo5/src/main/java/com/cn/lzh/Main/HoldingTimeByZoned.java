package com.cn.lzh.Main;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * {@code HoldingTimeByZoned}类处理电话账单计费
 *
 * @author 李志豪
 * @version 1.0
 */
public class HoldingTimeByZoned {

  /**
   * 输出日志信息的成员变量
   */
  private static final Logger log = LoggerFactory.getLogger(HoldingTimeByZoned.class);
  /**
   * 开始通话时间
   */
  private ZonedDateTime startingTime;
  /**
   * 结束通话时间
   */
  private ZonedDateTime endingTime;

  public HoldingTimeByZoned(ZonedDateTime startingTime, ZonedDateTime endingTime) {
    this.startingTime = startingTime;
    this.endingTime = endingTime;
  }

  /**
   * 获取通话时间
   *
   * @return
   */
  public long getHoldingTime() {
    // 通话时长
    long minute = 0;
    long between;

    // 获取时区
    ZoneId zoneId = startingTime.getZone();
    ZoneRules zoneRules = zoneId.getRules();

    Boolean isDstOfStart = zoneRules.isDaylightSavings( startingTime.toInstant() );
    Boolean isDstOfEnd = zoneRules.isDaylightSavings( endingTime.toInstant() );

    log.info("start:{},夏令时:{},end:{},夏令时:{}",
      startingTime.toLocalDateTime(),
      isDstOfStart,
      endingTime.toLocalDateTime(),
      isDstOfEnd
    );
    between = endingTime.toEpochSecond() - startingTime.toEpochSecond();

    if (between < 0) {
      // 得到通话时长
      minute = between / 60;
    } else {
      //不到一分钟，算一分钟
      minute = (between + 59) / 60;
    }

    log.info("between:{},minutes:{}",between,minute);

    if (minute > 1800 || minute < 0) {
      throw new RuntimeException("通话时间不正确");
    } else {
      return minute;
    }
  }
}
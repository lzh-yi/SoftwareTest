package com.lzh.main;

/**
 * {@code NextDate}类的主要目的是根据输入的日期输出下一天的日期。
 *
 * @author 李志豪
 * @version 1.0
 */
public class NextDate {

  /**
   *该函数的作用是根据输入的日期输入指定日期的下一天的日期。
   *
   * <p>如果输入为：1964年8月16日，则输出为1964年8月17日。</p>
   * <br />
   * <section
   * 要求输入变量{@code day}、{@code month}和{@code year}都是整数值，并且满足以下条件：
   * <blockquote><pre>
   *   Con1.  1≤month≤12
   *   Con2.  1≤day≤31
   *   Con3.  1900≤year≤2050
   * </pre></blockquote>
   *
   * <p>该函数返回值为一下两种:</p>
   * <ul>
   *   <li>若输入的日期不正确，则返回"输入错误"</li>
   *   <li>若输入的日期正确，则返回输入日期的下一天的日期</li>
   * </ul>
   *</section>
   *
   * @param year  输入的年份
   * @param month 输入的月份
   * @param day   输入的天
   */
  public String testDate(int year, int month, int day) {
    // 检查输入
    if ((year<1900 || year>2050) || (month<0 || month>12)) {
      return "输入错误";
    }
    if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
      if(day>31||day<1) {
        return "输入错误";
      }
    }else if(month==4||month==6||month==9||month==11) {
      if(day>30||day<1) {
        return "输入错误";
      }
    }
    // 对闰年和平年的2月份进行检查
    if((year%4==0&&year%100!=0)||(year%400==0)) {
      if(month==2) {
        if(day>29) {
          return "输入错误";
        } else {
          if(day==29) {
            day=1;
          } else {
            day++;
          }
        }
      }
    } else {
      if(month==2) {
        if(day>28) {
          return "输入错误";
        } else {
          if(day==28) {
            day=1;
          } else {
            day++;
          }
        }
      }
    }
    switch (month) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
        if(day==31) {
          month++;
          day=1;
          return year + " " + month + " " + day;
        } else {
          day++;
          return year + " " + month + " " + day;
        }
      case 2:
        if(day==1) {
          month++;
          return year + " " + month + " " + day;
        }
        else {
          return year + " " + month + " " + day;
        }
      case 4:
      case 6:
      case 9:
      case 11:
        if(day==30) {
          month++;
          day=1;
          return year + " " + month + " " + day;
        } else {
          day++;
          return year + " " + month + " " + day;
        }
      case 12:
        if(day==31) {
          year++;
          month=1;
          day=1;
          return year + " " + month + " " + day;
        }
        else {
          day++;
          return year + " " + month + " " + day;
        }
    }
    return "";
  }


}



package com.cn.lzh.utils;

/**
 * {@code PointUtil}工具类生成点数。
 *
 * @author 李志豪
 * @version 1.0
 */
public class PointUtil {

  public static int getPoint(Integer age, char sex, Boolean marriageStatus,int people) {

    int point = 0;
    assert age != null;
    assert age>1 && age<100;
    assert people>=0;
    assert sex =='F' || sex == 'M';
    assert marriageStatus ==true || marriageStatus == false;
    // 先判断年龄
    if (age >= 20 && age <= 39) {
      point+=6;
    }else if (age >= 40 && age <= 59) {
      point+=4;
    }else {
      point+=2;
    }
    // 判断性别
    if (sex == 'F') {
      point+=3;
    }else if (sex == 'M') {
      point += 4;
    }
    // 判断婚姻状况
    if (marriageStatus == true) {
      point+=3;
    }else if (marriageStatus ==false) {
      point += 5;
    }
    // 判断抚养人数
    if (people >=6) {
      point-=3;
    }else {
      point-=0.5*people;
    }
    return point;
  }

}

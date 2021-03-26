package com.cn.lzh.config;

import com.cn.lzh.exceptions.ValueParseException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 类{@code Configuration}是一个配置类。
 * <p>该类能读取配置文件并且解析，能够根据指定的键输出对应的值;在没有对应的值的时候能够抛出异常。</p>
 *
 * @author 李志豪
 * @version 1.0
 */
public class Configuration {
  private Properties props = new Properties();

  /**
   * 读取属性配置文件
   *
   * @param confFile  配置文件
   */
  public void fromFile(File confFile) {
    try(FileInputStream in = new FileInputStream(confFile);){
      props.load(new InputStreamReader(in, StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new ValueParseException("配置文件解析错误");
    }
  }

  /**
   * 获取键值
   *
   * @param key  键
   * @return value  键对应的值
   */
  public String getProp(String key) {
    return props.getProperty(key);
  }

  /**
   * 获取布尔类型键值
   *
   * @param key  键
   * @return value  键对应的值
   */
  public boolean getBoolean(String key) {
    String value = props.getProperty(key);
    if ("true".equalsIgnoreCase(value)) {
      return true;
    }
    if ("false".equalsIgnoreCase(value)) {
      return false;
    }
    throw new ValueParseException("键值不存在");
  }

  /**
   *返回指定键的布尔值；如果值不存在，则返回传入的缺省值。
   *
   * @param key  键值
   * @param defaultValue  默认缺省值
   * @return  返回指定键的布尔值或者缺省值
   */
  public Boolean getBooleanWithDefault(String key, Boolean defaultValue) {
    String value = props.getProperty(key);
    if ("true".equalsIgnoreCase(value)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(value)) {
      return Boolean.FALSE;
    }
    return defaultValue;

  }

  /**
   *返回指定键的整数值；如果键值不存在，则返回缺省值。
   *
   * @param key
   * @param defaultValue
   * @return
   */
  public Integer getInt(String key, int defaultValue) {
    String value = props.getProperty(key);
    try {
      return Integer.valueOf(value);
    }catch (NumberFormatException e) {
      return defaultValue;
    }

  }

  /**
   *返回指定键的日期值；如果键值不存在，则返回缺省值。
   *
   * <p><strong>注意:</strong>该方法只支持yyyy-MM-dd形式的字符串转变为Date类</p>
   *
   * @param key
   * @param defaultValue
   * @return
   */
  public Date getDate(String key, Date defaultValue) {
    String value = props.getProperty(key);
    DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date date = fmt.parse(value);
      return date;
    } catch (ParseException e) {
      return defaultValue;
    }

  }
}

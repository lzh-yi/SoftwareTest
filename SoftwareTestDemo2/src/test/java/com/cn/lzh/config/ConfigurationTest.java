package com.cn.lzh.config;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.cn.lzh.exceptions.ValueParseException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * 类{@code ConfigurationTest}是{@link com.cn.lzh.config.Configuration Configuration }类的测试类。
 *
 * @author 李志豪
 * @version 1.0
 */
public class ConfigurationTest
{
  @TempDir
  static Path tempDir;
  static Path path;

  private final Configuration configuration = new Configuration();

  /**
   * 在测试之前先初始化好要测试的配置文件。
   *
   * @throws IOException
   */
  @BeforeAll
  public static void init() throws IOException {
    path = tempDir.resolve("app.conf");
    Files.write(path, Arrays.asList(
      "ea=false",
      "closeable=true",
      "country=true",
      "sex=false",
      "age=46",
      "name=李白",
      "word=word",
      "language=English",
      "nowDate=2020-04-10",
      "integer=90",
      "nowDateErr=20ida",
      "integerErr=hello",
      "integerErr1=12hello"
    ));

  }

  @Test
  @DisplayName("当键存在时应该返回键值,不存在或者键值类型不匹配时抛出异常")
  void value_should_exit_when_key_exist() throws IOException{
    configuration.fromFile(path.toFile());

    // act
    String ea = configuration.getProp("ea");
    String closeable = configuration.getProp("closeable");
    String name = configuration.getProp("name");
    String age = configuration.getProp("age");


    // assert
    assertEquals("false", ea);
    assertEquals("true", closeable);
    assertEquals(false, configuration.getBoolean("sex"));
    assertEquals(true, configuration.getBoolean("country"));
    assertEquals("李白", name);
    assertEquals("46", age);

    // act
    Throwable throwable = assertThrows(ValueParseException.class, () ->{
      // 类型不匹配

      configuration.getBoolean("word");
      configuration.getBoolean("language");
      // 键值不存在
      configuration.getBoolean("address");
    });

    // assert
    assertAll(
      () -> assertEquals("键值不存在",throwable.getMessage()),
      () -> assertEquals("键值不存在",throwable.getMessage()),
      () -> assertEquals("键值不存在",throwable.getMessage())
    );
  }


  @Test
  @DisplayName("当配置文件不存在时应该抛出异常")
  public void fromFileTest() {
    // act
    Throwable throwable = assertThrows(ValueParseException.class, () ->{
      configuration.fromFile(new File("1.txt"));
    });
    // assert
    assertAll(
      () -> assertEquals("配置文件解析错误",throwable.getMessage())
    );

  }

  @Test
  @DisplayName("当键值的布尔值或整数值或者日期值不存在时，返回缺省值;存在的话直接返回对应的值")
  public void getBooleanWithDefaultAndGetIntAndGetDateTest() throws ParseException {
    configuration.fromFile(path.toFile());
    // 创建缺省日期对象
    Date defaultValue = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      defaultValue = sdf.parse("9999-12-31");
    } catch (ParseException e) {
      throw new ValueParseException("日期格式化错误");
    }
    // 获取整数值
    Integer integer = configuration.getInt("integer",Integer.MAX_VALUE);
    Integer integerErr = configuration.getInt("integerErr",Integer.MAX_VALUE);
    Integer integerErr1 = configuration.getInt("integerErr1",Integer.MAX_VALUE);
    // 获取日期值
    Date nowDate = configuration.getDate("nowDate",defaultValue);
    Date nowDateErr = configuration.getDate("nowDateErr",defaultValue);
    // 获取布尔值
    Boolean ea = configuration.getBooleanWithDefault("ea", Boolean.FALSE);
    Boolean closeable = configuration.getBooleanWithDefault("closeable", Boolean.FALSE);
    Boolean name = configuration.getBooleanWithDefault("name", Boolean.FALSE);
    Boolean age = configuration.getBooleanWithDefault("age", Boolean.FALSE);

    // 测试
    assertEquals(Boolean.FALSE, ea);
    assertEquals(Boolean.TRUE, closeable);
    assertEquals(Boolean.FALSE, name);
    assertEquals(Boolean.FALSE, age);
    assertEquals(Integer.valueOf(90), integer);
    assertEquals(Integer.MAX_VALUE, integerErr);
    assertEquals(Integer.MAX_VALUE, integerErr1);
    assertEquals(sdf.parse("2020-04-10"), nowDate);
    assertEquals(defaultValue, nowDateErr);

  }
}
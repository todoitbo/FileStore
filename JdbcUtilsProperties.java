package utils;

import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtilsProperties
{
  private static String driverClass;
  private static String url;
  private static String username;
  private static String password;
  
  private static void readConfig()
    throws Exception
  {
    InputStream in = JdbcUtilsProperties.class.getClassLoader().getResourceAsStream("database.properties");
    Properties properties = new Properties();
    properties.load(in);
    driverClass = properties.getProperty("driverClass");
    url = properties.getProperty("url");
    username = properties.getProperty("username");
    password = properties.getProperty("password");
  }
  
  public static Connection getConnection()
  {
    Connection con = null;
    try
    {
      readConfig();
      Class.forName(driverClass);
      con = DriverManager.getConnection(url, username, password);
    }
    catch (Exception ex)
    {
      System.out.println(ex + "数据库连接失败!");
    }
    return con;
  }
  
  public static void close(Connection con2, Statement sta, ResultSet set)
  {
    if (set != null) {
      try
      {
        set.close();
      }
      catch (Exception localException) {}
    }
    if (sta != null) {
      try
      {
        sta.close();
      }
      catch (Exception localException1) {}
    }
    if (con2 != null) {
      try
      {
        con2.close();
      }
      catch (Exception localException2) {}
    }
  }
  
  public static void close(Connection con, Statement sta)
  {
    if (sta != null) {
      try
      {
        sta.close();
      }
      catch (Exception localException) {}
    }
    if (con != null) {
      try
      {
        con.close();
      }
      catch (Exception localException1) {}
    }
  }
}

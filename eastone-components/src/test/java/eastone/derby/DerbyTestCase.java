/*
 * File:DerbyTestCase.java Type:eastone.derby.DerbyTestCase
 */
package eastone.derby;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Derby 数据库.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-8 下午9:27:54</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class DerbyTestCase extends TestCase {

  /**
   * 停止Derby数据库时的SQL异常代码.
   */
  private static final int SHUTDOWN_DERBY_DB_SQL_CODE = 45000;

  /**
   * 递归删除目录下的所有文件及子目录下所有文件.
   * @param dir 将要删除的文件目录.
   * @return 是否成功删除.
   */
  private static boolean deleteDir(final File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      // 递归删除目录中的子目录下
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }
    // 目录此时为空，可以删除
    return dir.delete();
  }

  /**
   * 测试@Test标记是否正常运行.
   */
  @Test
  public void testEmptyMethod() {
    // do nothing
  }

  /**
   * 测试 {@link BeforeClass}执行次数的计数器.
   * @see #testBeforeClass()
   * @see {@link #testBeforeClass1()}
   * @see {@link #testBeforeClass2()}
   */
  private static int beforeClassRunCount = 0;

  /**
   * 类加载之前执行.
   */
  @BeforeClass
  public static void testBeforeClass() {
    beforeClassRunCount++;
  }

  /**
   * 测试此方法执行时 {@link #beforeClassRunCount}的值是否正确.
   */
  @Test
  public void testBeforeClass1() {
    assertEquals(beforeClassRunCount, 1);
  }

  /**
   * 测试此方法执行时 {@link #beforeClassRunCount}的值是否正确.
   */
  @Test
  public void testBeforeClass2() {
    assertEquals(beforeClassRunCount, 1);
  }

  /**
   * 测试Derby数据库的创建、连接和停止.
   */
  @BeforeClass
  public static void testInitConnectAndShutdownDerbyDB() {
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    String dbName = "." + File.separator + "testDb";
    String connectionURL = "jdbc:derby:" + dbName + ";create=true";
    File dbfile = new File(dbName);

    //连接之前数据库文件不存在.
    assertFalse(dbfile.exists());

    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    Connection connect = null;
    try {
      //连接并创建数据库.
      connect = DriverManager.getConnection(connectionURL);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connect != null) {
        try {
          connect.close();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    }

    //停止数据库.
    connect = null;
    try {
      String shutdownUrl = "jdbc:derby:" + dbName + ";shutdown=true";
      connect = DriverManager.getConnection(shutdownUrl);
    } catch (SQLException e) {
      assertEquals(SHUTDOWN_DERBY_DB_SQL_CODE, e.getErrorCode());
      assertEquals("08006", e.getSQLState());
    }

    assertNull(connect);

    //删除数据库文件.
    assertTrue(dbfile.exists());
    if (dbfile.isDirectory()) {
      deleteDir(dbfile);
    } else {
      dbfile.deleteOnExit();
    }
    assertFalse(dbfile.exists());
  }

}

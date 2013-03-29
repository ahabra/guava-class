package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.common.base.Function;

public class WithConnection {

  private static Connection getConnection() {
    try {
      return DriverManager.getConnection("url;user;password");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static void closeConnection(Connection con) {
    try {
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static <T> T execute(Function<Connection, T> closure) {
    Connection con= getConnection();
    try {
      return closure.apply(con);
    } finally {
      closeConnection(con);
    }
  }

}

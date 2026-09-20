package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnexion {
  private static final String URL = "jdbc:postgresql://localhost/subtrack";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL);
  }
}

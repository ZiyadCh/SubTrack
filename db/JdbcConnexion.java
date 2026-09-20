package db;

import java.sql.*;

public class JdbcConnexion {

  private static String url = "jdbc:postgresql://localhost/subtrack";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url);
  }
}

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnexion {
  private static final String URL = "jdbc:postgresql://localhost/subtrack";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL);
  }

  public static void main(String[] args) {
    // Sans ORM : Code JDBC brut
    String sql = "SELECT id, name, email FROM users WHERE id = ?";
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setLong(1, userId);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
      User user = new User();
      user.setId(rs.getLong("id"));
      user.setName(rs.getString("name"));
      user.setEmail(rs.getString("email"));
      return user;
    }
  }
}

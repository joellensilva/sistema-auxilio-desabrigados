import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/sistema-ad";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado ao banco de dados!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
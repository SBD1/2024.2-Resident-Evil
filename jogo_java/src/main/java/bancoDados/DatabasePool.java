package bancoDados;

// DatabasePool.java
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePool {
    private static HikariDataSource dataSource;

    static {
        try {
            Dotenv dotenv = Dotenv.configure()
                    .load();

            HikariConfig config = new HikariConfig();
            String host = dotenv.get("DB_HOST");
            String port = dotenv.get("DB_PORT");
            String database = dotenv.get("DB_NAME");

            String jdbcUrl = "jdbc:mysql://" + host + ":" + port + "/" + database + "?serverTimezone=UTC";
            config.setJdbcUrl(jdbcUrl);
            config.setUsername(dotenv.get("DB_USER"));
            config.setPassword(dotenv.get("DB_PASSWORD"));

            int poolSize = Integer.parseInt(dotenv.get("DB_CONNECTION_LIMIT", "10"));
            config.setMaximumPoolSize(poolSize);

            dataSource = new HikariDataSource(config);
            System.out.println("Pool de conexões ao banco de dados estabelecido com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao configurar o pool de conexões: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void shutdown() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}

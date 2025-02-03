package retaguarda.combate;

import bancoDados.DatabasePool;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CombateService {

    public static void combateTurno(int idProtagonista, int idInimigo) {
        String sql = "{CALL combateTurno(?, ?)}";
        try (Connection connection = DatabasePool.getConnection();
             CallableStatement stmt = connection.prepareCall(sql)) {

            stmt.setInt(1, idProtagonista);
            stmt.setInt(2, idInimigo);

            boolean hasResultSet = stmt.execute();

            if (hasResultSet) {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs.next()) {
                        String resultado = rs.getString("Resultado");
                        System.out.println(resultado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

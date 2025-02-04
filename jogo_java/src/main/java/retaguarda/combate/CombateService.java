package retaguarda.combate;

import bancoDados.DatabasePool;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CombateService {
    public static void combateTurnoInstancia(int idProtagonista, int idInstanciaNpc) {
        String sql = "{CALL combateTurnoInstancia(?, ?)}";
        try (Connection conn = DatabasePool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idProtagonista);
            stmt.setInt(2, idInstanciaNpc);

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

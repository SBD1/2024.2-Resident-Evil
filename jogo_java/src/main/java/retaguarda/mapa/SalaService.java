package retaguarda.mapa;

import bancoDados.DatabasePool;
import retaguarda.mapa.Sala;
import java.sql.*;

public class SalaService {

    public static Sala getSalaPorNumero(int numero) {
        String sql = "SELECT numero, nome, nome_mapa FROM sala WHERE numero = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Sala(rs.getInt("numero"), rs.getString("nome"), rs.getString("nome_mapa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

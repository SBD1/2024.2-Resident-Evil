package retaguarda.mapa;

import bancoDados.DatabasePool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaService {

    public static Sala getSalaPorNumero(int numero) {
        String sql = "SELECT numero, nome, nome_mapa, descriçao FROM sala WHERE numero = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Sala(
                            rs.getInt("numero"),
                            rs.getString("nome"),
                            rs.getString("nome_mapa"),
                            rs.getString("descriçao")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

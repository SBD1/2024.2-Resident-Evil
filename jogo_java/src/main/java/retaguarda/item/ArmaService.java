package retaguarda.item;

import bancoDados.DatabasePool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArmaService {
    public static Arma getArmaById(int idItem) {
        String sql = "SELECT a.id_item, i.nome, i.descricao, i.valor, i.peso, " +
                "a.dano, a.nivel, a.chanceerro, a.chancecritico, a.maxmuni " +
                "FROM arma a JOIN item i ON a.id_item = i.iditem " +
                "WHERE a.id_item = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idItem);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Arma(
                            rs.getInt("id_item"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getInt("valor"),
                            rs.getInt("peso"),
                            Tipo.arma,
                            rs.getInt("dano"),
                            rs.getInt("nivel"),
                            rs.getInt("chanceerro"),
                            rs.getInt("chancecritico"),
                            rs.getInt("maxmuni")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

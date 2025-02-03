package retaguarda.item;

import bancoDados.DatabasePool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipamentoService {
    public static Equipamento getEquipamentoById(int idItem) {
        String sql = "SELECT e.id_item, i.nome, i.descricao, i.valor, i.peso, " +
                "e.defesa, e.nivel " +
                "FROM equipamento e JOIN item i ON e.id_item = i.iditem " +
                "WHERE e.id_item = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idItem);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Equipamento(
                            rs.getInt("id_item"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getInt("valor"),
                            rs.getInt("peso"),
                            Tipo.equipamento,
                            rs.getInt("defesa"),
                            rs.getInt("nivel")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

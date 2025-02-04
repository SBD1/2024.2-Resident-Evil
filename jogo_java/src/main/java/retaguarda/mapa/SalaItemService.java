package retaguarda.mapa;

import bancoDados.DatabasePool;
import retaguarda.item.InstanciaItem;
import retaguarda.item.Item;
import retaguarda.item.ItemSala;
import retaguarda.item.Tipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaItemService {
    public static List<InstanciaItem> listarItensDaSala(int numeroSala) {
        List<InstanciaItem> itens = new ArrayList<>();
        String sql = "SELECT * FROM ( " +
                "  SELECT i.id AS idinstanciaitem, a.id_item, 'arma' AS tipo, a.nome, a.descricao, a.valor, a.peso, i.quantidade " +
                "  FROM item_sala i " +
                "  JOIN item it ON i.id_item = it.iditem " +
                "  JOIN arma a ON a.id_item = it.iditem " +
                "  WHERE i.fk_sala = ? AND it.tipo = 'arma' " +
                "  UNION ALL " +
                "  SELECT i.id AS idinstanciaitem, c.id_item, 'consumivel' AS tipo, c.nome, c.descricao, c.valor, c.peso, i.quantidade " +
                "  FROM item_sala i " +
                "  JOIN item it ON i.id_item = it.iditem " +
                "  JOIN consumivel c ON c.id_item = it.iditem " +
                "  WHERE i.fk_sala = ? AND it.tipo = 'consumivel' " +
                "  UNION ALL " +
                "  SELECT i.id AS idinstanciaitem, e.id_item, 'equipamento' AS tipo, e.nome, e.descricao, e.valor, e.peso, i.quantidade " +
                "  FROM item_sala i " +
                "  JOIN item it ON i.id_item = it.iditem " +
                "  JOIN equipamento e ON e.id_item = it.iditem " +
                "  WHERE i.fk_sala = ? AND it.tipo = 'equipamento' " +
                "  UNION ALL " +
                "  SELECT i.id AS idinstanciaitem, d.id_item, 'dinheiro' AS tipo, d.nome, d.descricao, d.valor, d.peso, i.quantidade " +
                "  FROM item_sala i " +
                "  JOIN item it ON i.id_item = it.iditem " +
                "  JOIN dinheiro d ON d.id_item = it.iditem " +
                "  WHERE i.fk_sala = ? AND it.tipo = 'dinheiro' " +
                ") AS result";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numeroSala);
            stmt.setInt(2, numeroSala);
            stmt.setInt(3, numeroSala);
            stmt.setInt(4, numeroSala);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idInstanciaItem = rs.getInt("idinstanciaitem");
                    int idItem = rs.getInt("id_item");
                    String tipoStr = rs.getString("tipo");
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    int valor = rs.getInt("valor");
                    int peso = rs.getInt("peso");
                    Item item = new Item(idItem, nome, descricao, valor, peso, Tipo.fromString(tipoStr));
                    InstanciaItem instanciaItem = new InstanciaItem(idInstanciaItem, item, null);
                    itens.add(instanciaItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;
    }

    public static boolean removerItemDaSala(int idItemSala) {
        String sql = "DELETE FROM item_sala WHERE id = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idItemSala);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

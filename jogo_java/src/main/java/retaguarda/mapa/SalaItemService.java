package retaguarda.mapa;

import bancoDados.DatabasePool;
import retaguarda.item.Item;
import retaguarda.item.ItemSala;
import retaguarda.item.Tipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaItemService {

    public static List<ItemSala> listarItensDaSala(int numeroSala) {
        List<ItemSala> itens = new ArrayList<>();
        String sql = "SELECT isal.id, isal.fk_sala, isal.id_item, isal.quantidade, " +
                "it.nome, it.descricao, it.valor, it.peso, it.tipo " +
                "FROM item_sala isal " +
                "JOIN item it ON isal.id_item = it.iditem " +
                "WHERE isal.fk_sala = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numeroSala);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getInt("id_item"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getInt("valor"),
                            rs.getInt("peso"),
                            Tipo.fromString(rs.getString("tipo"))
                    );
                    ItemSala itemSala = new ItemSala(
                            rs.getInt("id"),
                            rs.getInt("fk_sala"),
                            item,
                            rs.getInt("quantidade")
                    );
                    itens.add(itemSala);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;
    }

    public static boolean removerItemDaSala(int itemSalaId) {
        String sql = "DELETE FROM item_sala WHERE id = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, itemSalaId);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

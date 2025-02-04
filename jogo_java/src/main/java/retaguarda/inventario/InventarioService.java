package retaguarda.inventario;


import bancoDados.DatabasePool;
import retaguarda.inventario.Inventario;
import retaguarda.item.InstanciaItem;
import retaguarda.item.Item;
import retaguarda.item.Tipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioService {
    public static Inventario carregarInventario(int idProtagonista) {
        try (Connection conn = DatabasePool.getConnection()) {
            String sql = "SELECT * FROM ( " +
                    "  SELECT i.idinstanciaitem, a.id_item, 'arma' AS tipo, a.nome, a.descricao, a.valor, a.peso " +
                    "  FROM instanciaitem i " +
                    "  JOIN item it ON i.id_item = it.iditem " +
                    "  JOIN arma a ON a.id_item = it.iditem " +
                    "  JOIN inventario inv ON i.id_inventario = inv.idinventario " +
                    "  WHERE inv.id_protagonista = ? AND it.tipo = 'arma' " +
                    "  UNION ALL " +
                    "  SELECT i.idinstanciaitem, c.id_item, 'consumivel' AS tipo, c.nome, c.descricao, c.valor, c.peso " +
                    "  FROM instanciaitem i " +
                    "  JOIN item it ON i.id_item = it.iditem " +
                    "  JOIN consumivel c ON c.id_item = it.iditem " +
                    "  JOIN inventario inv ON i.id_inventario = inv.idinventario " +
                    "  WHERE inv.id_protagonista = ? AND it.tipo = 'consumivel' " +
                    "  UNION ALL " +
                    "  SELECT i.idinstanciaitem, e.id_item, 'equipamento' AS tipo, e.nome, e.descricao, e.valor, e.peso " +
                    "  FROM instanciaitem i " +
                    "  JOIN item it ON i.id_item = it.iditem " +
                    "  JOIN equipamento e ON e.id_item = it.iditem " +
                    "  JOIN inventario inv ON i.id_inventario = inv.idinventario " +
                    "  WHERE inv.id_protagonista = ? AND it.tipo = 'equipamento' " +
                    "  UNION ALL " +
                    "  SELECT i.idinstanciaitem, d.id_item, 'dinheiro' AS tipo, d.nome, d.descricao, d.valor, d.peso " +
                    "  FROM instanciaitem i " +
                    "  JOIN item it ON i.id_item = it.iditem " +
                    "  JOIN dinheiro d ON d.id_item = it.iditem " +
                    "  JOIN inventario inv ON i.id_inventario = inv.idinventario " +
                    "  WHERE inv.id_protagonista = ? AND it.tipo = 'dinheiro' " +
                    ") AS result";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idProtagonista);
                stmt.setInt(2, idProtagonista);
                stmt.setInt(3, idProtagonista);
                stmt.setInt(4, idProtagonista);
                try (ResultSet rs = stmt.executeQuery()) {
                    List<InstanciaItem> itens = new ArrayList<>();
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
                    return new Inventario(100, idProtagonista, 0, itens);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void pegarItemProtagonista(int idProtagonista, int idItem) {
        try (Connection conn = DatabasePool.getConnection()) {
            String sqlInventario = "SELECT idinventario FROM inventario WHERE id_protagonista = ?";
            int idInventario = 0;
            try (PreparedStatement stmt = conn.prepareStatement(sqlInventario)) {
                stmt.setInt(1, idProtagonista);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        idInventario = rs.getInt("idinventario");
                    }
                }
            }
            if (idInventario != 0) {
                String sqlInsert = "INSERT INTO instanciaitem (id_item, id_inventario, nome_missao) VALUES (?, ?, NULL)";
                try (PreparedStatement stmt = conn.prepareStatement(sqlInsert)) {
                    stmt.setInt(1, idItem);
                    stmt.setInt(2, idInventario);
                    int rows = stmt.executeUpdate();
                    if (rows > 0) {
                        System.out.println("Item adicionado ao inventário!");
                    } else {
                        System.out.println("Falha ao adicionar o item.");
                    }
                }
            } else {
                System.out.println("Inventário não encontrado para o protagonista.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package retaguarda.inventario;

import bancoDados.DatabasePool;
import retaguarda.item.Item;
import retaguarda.item.InstanciaItem;
import retaguarda.item.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioService {

    public static Inventario carregarInventario(int idEntidade) {
        try (Connection connection = DatabasePool.getConnection()) {
            String sql = """
                SELECT 
                    i.id_instanciaitem, 
                    it.iditem, 
                    it.nome AS nome_item, 
                    it.descricao AS descricao_item, 
                    it.valor, 
                    it.peso, 
                    it.tipo, 
                    i.descricao AS descricao_instancia
                FROM 
                    instanciaitem i
                JOIN 
                    item it ON i.id_item = it.iditem
                JOIN 
                    inventario inv ON i.id_inventario = inv.idinventario
                WHERE 
                    inv.id_entidade = ?
            """;

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, idEntidade);

                try (ResultSet rs = stmt.executeQuery()) {
                    List<InstanciaItem> itens = new ArrayList<>();

                    while (rs.next()) {
                        Tipo tipo = Tipo.fromString(rs.getString("tipo"));

                        Item item = new Item(
                                rs.getInt("iditem"),
                                rs.getString("nome_item"),
                                rs.getString("descricao_item"),
                                rs.getInt("valor"),
                                rs.getInt("peso"),
                                tipo
                        );

                        InstanciaItem instanciaItem = new InstanciaItem(
                                rs.getInt("id_instanciaitem"),
                                item,
                                rs.getString("descricao_instancia")
                        );

                        itens.add(instanciaItem);
                    }

                    return new Inventario(100, idEntidade, 0, itens);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

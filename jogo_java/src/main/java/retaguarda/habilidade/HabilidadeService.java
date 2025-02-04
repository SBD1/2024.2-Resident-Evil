package retaguarda.habilidade;

import bancoDados.DatabasePool;
import retaguarda.item.Consumivel;
import retaguarda.item.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadeService {
    /*public static List<Habilidade> listarHabilidadesDisponiveis() {
        List<Consumivel> consumiveis = new ArrayList<>();
        String sql = "SELECT c.id_item,c.nome,c.descricao,c.efeito,c.valor,c.peso FROM consumivel c";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Consumivel consumivel = new Consumivel(
                        rs.getInt("id_item"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("valor"),
                        rs.getInt("peso"),
                        Tipo.consumivel,
                        rs.getString("efeito")
                );
                consumiveis.add(consumivel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumiveis;
    }

    public static Consumivel getConsumivelById(int idItem) {
        String sql = "SELECT c.id_item,c.nome,c.descricao,c.efeito,c.valor,c.peso" +
                "FROM consumivel c WHERE c.id_item = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idItem);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Consumivel(
                            rs.getInt("id_item"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getInt("valor"),
                            rs.getInt("peso"),
                            Tipo.consumivel,
                            rs.getString("efeito")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void atualizarConsumivel(Consumivel consumivel) {
        String sql = "UPDATE consumivel SET nome = ?, descricao = ?, valor = ?, peso = ?, efeito = ? " +
                "WHERE id_item = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, consumivel.getNome());
            stmt.setString(2, consumivel.getDescricao());
            stmt.setInt(3, consumivel.getValor());
            stmt.setInt(4, consumivel.getPeso());
            stmt.setString(5, consumivel.getEfeito());
            stmt.setInt(6, consumivel.getIdItem());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}

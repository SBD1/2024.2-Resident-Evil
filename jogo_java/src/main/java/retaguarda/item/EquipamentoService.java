package retaguarda.item;

import bancoDados.DatabasePool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoService {

    public static List<Equipamento> listarEquipamentosDisponiveis() {
        List<Equipamento> equipamentos = new ArrayList<>();
        String sql = "SELECT e.id_item, e.nome, e.defesa, e.nivel, e.descricao, e.valor, e.peso " +
                "FROM equipamento e";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Equipamento equip = new Equipamento(
                        rs.getInt("id_item"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("valor"),
                        rs.getInt("peso"),
                        Tipo.equipamento,
                        rs.getInt("defesa"),
                        rs.getInt("nivel")
                );
                equipamentos.add(equip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipamentos;
    }

    public static Equipamento getEquipamentoById(int idItem) {
        String sql = "SELECT e.id_item, e.nome, e.defesa, e.nivel, e.descricao, e.valor, e.peso " +
                "FROM equipamento e WHERE e.id_item = ?";
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

    public static void atualizarEquipamento(Equipamento equipamento) {
        String sql = "UPDATE equipamento SET nome = ?, defesa = ?, nivel = ?, descricao = ?, valor = ?, peso = ? " +
                "WHERE id_item = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setInt(2, equipamento.getDefesa());
            stmt.setInt(3, equipamento.getNivel());
            stmt.setString(4, equipamento.getDescricao());
            stmt.setInt(5, equipamento.getValor());
            stmt.setInt(6, equipamento.getPeso());
            stmt.setInt(7, equipamento.getIdItem());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

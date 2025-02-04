package retaguarda.item;

import bancoDados.DatabasePool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArmaService {

    public static List<Arma> listarArmasDisponiveis() {
        List<Arma> armas = new ArrayList<>();
        String sql = "SELECT a.id_item, a.nome, a.dano, a.nivel, a.chanceerro, a.chancecritico, a.maxmuni, a.descricao, a.valor, a.peso " +
                "FROM arma a";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Arma arma = new Arma(
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
                armas.add(arma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armas;
    }

    public static Arma getArmaById(int idItem) {
        String sql = "SELECT a.id_item, a.nome, a.dano, a.nivel, a.chanceerro, a.chancecritico, a.maxmuni, a.descricao, a.valor, a.peso " +
                "FROM arma a WHERE a.id_item = ?";
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

    public static void atualizarArma(Arma arma) {
        String sql = "UPDATE arma SET nome = ?, dano = ?, nivel = ?, chanceerro = ?, chancecritico = ?, maxmuni = ?, descricao = ?, valor = ?, peso = ? " +
                "WHERE id_item = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, arma.getNome());
            stmt.setInt(2, arma.getDano());
            stmt.setInt(3, arma.getNivel());
            stmt.setInt(4, arma.getChancErro());
            stmt.setInt(5, arma.getChanceCritico());
            stmt.setInt(6, arma.getMaxMuni());
            stmt.setString(7, arma.getDescricao());
            stmt.setInt(8, arma.getValor());
            stmt.setInt(9, arma.getPeso());
            stmt.setInt(10, arma.getIdItem());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package retaguarda.mapa;

import bancoDados.DatabasePool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaminhoService {

    public static List<Integer> listarSalasConectadas(int salaAtual) {
        List<Integer> salas = new ArrayList<>();
        String sql = "SELECT prox_sala FROM caminho WHERE sala_atual = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salaAtual);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    salas.add(rs.getInt("prox_sala"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salas;
    }
}

package retaguarda.protagonista;

import bancoDados.DatabasePool;
import retaguarda.inventario.Inventario;
import retaguarda.inventario.InventarioService;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProtagonistaService {

    public static void criarProtagonista(String nickname) {
        try (Connection connection = DatabasePool.getConnection()) {
            String sql = "{CALL inserirProtagonista(?)}";
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setString(1, nickname);
                stmt.execute();
                System.out.println("Protagonista inserido com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Protagonista carregarProtagonista(String nickname) {
        try (Connection connection = DatabasePool.getConnection()) {
            String sql = """
                SELECT 
                    p.id_entidade, p.nickname, p.killcount, p.dinheirorecebido, p.fk_sala_numero,
                    e.vida, e.dano
                FROM 
                    protagonista p
                JOIN 
                    entidade e ON p.id_entidade = e.identidade
                WHERE 
                    p.nickname = ?
            """;
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, nickname);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Inventario inventario = InventarioService.carregarInventario(rs.getInt("id_entidade"));
                        Protagonista protagonista = new Protagonista(
                                rs.getInt("id_entidade"),
                                rs.getString("nickname"),
                                rs.getInt("vida"),
                                rs.getInt("dano"),
                                rs.getInt("killcount"),
                                rs.getInt("dinheirorecebido"),
                                inventario
                        );
                        protagonista.setSala(rs.getInt("fk_sala_numero"));
                        return protagonista;
                    } else {
                        System.out.println("Protagonista não encontrado.");
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

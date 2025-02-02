package retaguarda.protagonista;
import bancoDados.DatabasePool;

import java.sql.Connection;
import java.sql.CallableStatement;

public class ProtagonistaService {
    public static void criarProtagonista(String protagonista) {
        try (Connection connection = DatabasePool.getConnection()) {
            connection.setAutoCommit(true);
            String sql = "{CALL inserirProtagonista(?)}";
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setString(1, protagonista);
                stmt.execute();
            }
            System.out.println("Protagonista inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pegarProtagonista(){
        try(Connection connection = DatabasePool.getConnection()){
            connection.setAutoCommit(true);
            String sql = "{SELECT id_entidade, nickname, killcount, dinheirorecebido, vida, dano }"
        }
    }
}

package retaguarda.npc;

import bancoDados.DatabasePool;
import retaguarda.npc.InstanciaNpc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstanciaNpcService {

    public static boolean salaPossuiBoss(int salaNumero) {
        String sql = "SELECT COUNT(*) AS conta_chefe " +
                "FROM instancianpc i JOIN npc n ON i.id_entidadenpc = n.id_entidade " +
                "WHERE i.fk_sala_numero = ? AND n.tipo = 'chefe'";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salaNumero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("conta_chefe");
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Integer obterInstanciaBossNaSala(int salaNumero) {
        String sql = "SELECT i.idinstancianpc " +
                "FROM instancianpc i JOIN npc n ON i.id_entidadenpc = n.id_entidade " +
                "WHERE i.fk_sala_numero = ? AND n.tipo = 'chefe' LIMIT 1";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salaNumero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idinstancianpc");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Integer> listarInstanciasPorSala(int salaNumero) {
        List<Integer> instancias = new ArrayList<>();
        String sql = "SELECT idinstancianpc FROM instancianpc WHERE fk_sala_numero = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salaNumero);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    instancias.add(rs.getInt("idinstancianpc"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instancias;
    }

    public static InstanciaNpc carregarInstanciaNpc(int idInstancia) {
        String sql = "SELECT i.idinstancianpc, i.id_entidadenpc, i.vida_atual, n.tipo " +
                "FROM instancianpc i JOIN npc n ON i.id_entidadenpc = n.id_entidade " +
                "WHERE i.idinstancianpc = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idInstancia);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idInst = rs.getInt("idinstancianpc");
                    int idEnt = rs.getInt("id_entidadenpc");
                    int vida = rs.getInt("vida_atual");
                    String tipo = rs.getString("tipo");
                    int baseDamage = 0;

                    if ("zumbi".equalsIgnoreCase(tipo)) {
                        String sqlDano = "SELECT dano, vida FROM zumbi WHERE id_entidade = ?";
                        try (PreparedStatement stmtD = conn.prepareStatement(sqlDano)) {
                            stmtD.setInt(1, idEnt);
                            try (ResultSet rsD = stmtD.executeQuery()) {
                                if (rsD.next()) {
                                    baseDamage = rsD.getInt("dano");
                                    if (vida == 0) {
                                        vida = rsD.getInt("vida");
                                    }
                                }
                            }
                        }
                    } else if ("chefe".equalsIgnoreCase(tipo)) {
                        String sqlDano = "SELECT dano, vida FROM chefe WHERE id_entidade = ?";
                        try (PreparedStatement stmtD = conn.prepareStatement(sqlDano)) {
                            stmtD.setInt(1, idEnt);
                            try (ResultSet rsD = stmtD.executeQuery()) {
                                if (rsD.next()) {
                                    baseDamage = rsD.getInt("dano");
                                    if (vida == 0) {
                                        vida = rsD.getInt("vida");
                                    }
                                }
                            }
                        }
                    } else if ("plaga".equalsIgnoreCase(tipo)) {
                        String sqlDano = "SELECT dano, vida FROM plaga WHERE id_entidade = ?";
                        try (PreparedStatement stmtD = conn.prepareStatement(sqlDano)) {
                            stmtD.setInt(1, idEnt);
                            try (ResultSet rsD = stmtD.executeQuery()) {
                                if (rsD.next()) {
                                    baseDamage = rsD.getInt("dano");
                                    if (vida == 0) {
                                        vida = rsD.getInt("vida");
                                    }
                                }
                            }
                        }
                    } else if ("cachorro_zumbi".equalsIgnoreCase(tipo)) {
                        String sqlDano = "SELECT dano, vida FROM cachorro_zumbi WHERE id_entidade = ?";
                        try (PreparedStatement stmtD = conn.prepareStatement(sqlDano)) {
                            stmtD.setInt(1, idEnt);
                            try (ResultSet rsD = stmtD.executeQuery()) {
                                if (rsD.next()) {
                                    baseDamage = rsD.getInt("dano");
                                    if (vida == 0) {
                                        vida = rsD.getInt("vida");
                                    }
                                }
                            }
                        }
                    }

                    return new InstanciaNpc(idInst, idEnt, vida, baseDamage, tipo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void atualizarVidaInstancia(int idInstancia, int novaVida) {
        String sql = "UPDATE instancianpc SET vida_atual = ? WHERE idinstancianpc = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, novaVida);
            stmt.setInt(2, idInstancia);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removerInstanciaNpc(int idInstancia) {
        String updateInventario = "UPDATE inventario SET id_instancianpc = NULL WHERE id_instancianpc = ?";
        String deleteInstancia = "DELETE FROM instancianpc WHERE idinstancianpc = ?";
        try (Connection conn = DatabasePool.getConnection()) {
            try (PreparedStatement stmtUpdate = conn.prepareStatement(updateInventario)) {
                stmtUpdate.setInt(1, idInstancia);
                stmtUpdate.executeUpdate();
            }
            try (PreparedStatement stmtDelete = conn.prepareStatement(deleteInstancia)) {
                stmtDelete.setInt(1, idInstancia);
                stmtDelete.executeUpdate();
            }
            System.out.println("Instância de NPC removida com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao remover a instância de NPC:");
            e.printStackTrace();
        }
    }

    public static void resetarVidaInstancia(int idInstancia) {
        String sql = "{CALL resetarVidaBoss(?)}";
        try (Connection conn = DatabasePool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, idInstancia);
            boolean hasResultSet = stmt.execute();
            if (hasResultSet) {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs.next()) {
                        String resultado = rs.getString("Resultado");
                        System.out.println(resultado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean salaPossuiMercador(int sala){
        String sql = "SELECT COUNT(*) AS conta_mercador " +
                "FROM instancianpc i JOIN npc n ON i.id_entidadenpc = n.id_entidade " +
                "WHERE i.fk_sala_numero = ? AND n.tipo = 'mercador'";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sala);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("conta_mercador");
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

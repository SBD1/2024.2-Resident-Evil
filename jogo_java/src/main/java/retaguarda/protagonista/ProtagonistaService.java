package retaguarda.protagonista;


import bancoDados.DatabasePool;
import retaguarda.inventario.Inventario;
import retaguarda.inventario.InventarioService;
import retaguarda.item.Arma;
import retaguarda.item.Equipamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProtagonistaService {
    public static void criarProtagonista(String nickname) throws SQLException {
        try (Connection conn = DatabasePool.getConnection()) {
            conn.setAutoCommit(false);
            String sqlEntidade = "INSERT INTO entidade (tipo) VALUES ('protagonista')";
            try (PreparedStatement stmt = conn.prepareStatement(sqlEntidade, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.executeUpdate();
                int id = 0;
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                }
                if (id == 0) {
                    conn.rollback();
                    System.out.println("Erro ao criar entidade para o protagonista.");
                    return;
                }

                String sqlProt = "INSERT INTO protagonista (id_entidade, nickname, killcount, dinheirorecebido, fk_sala_numero, vida, dano, arma_equipada) VALUES (?, ?, 0, 0, 1, 100, 0, ?)";
                try (PreparedStatement stmtProt = conn.prepareStatement(sqlProt)) {
                    stmtProt.setInt(1, id);
                    stmtProt.setString(2, nickname);
                    stmtProt.setInt(3, 16);
                    stmtProt.executeUpdate();
                }

                int idInventario = 0;
                String sqlInventario = "INSERT INTO inventario (pesomax, id_protagonista, id_instancianpc) VALUES (?, ?, NULL)";
                try (PreparedStatement stmtInv = conn.prepareStatement(sqlInventario, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    stmtInv.setInt(1, 99999);
                    stmtInv.setInt(2, id);
                    int rows = stmtInv.executeUpdate();
                    if (rows == 0) {
                        conn.rollback();
                        System.out.println("Falha ao criar o inventário para o protagonista.");
                        return;
                    }
                    try (ResultSet rs = stmtInv.getGeneratedKeys()) {
                        if (rs.next()) {
                            idInventario = rs.getInt(1);
                        }
                    }
                }

                String sqlDarErva = "INSERT INTO instanciaitem (id_item, id_inventario, nome_missao) VALUES (?, ?, NULL)";
                try (PreparedStatement stmtDarErva = conn.prepareStatement(sqlDarErva)) {
                    for (int i = 0; i < 4; i++) {
                        stmtDarErva.setInt(1, 4);
                        stmtDarErva.setInt(2, idInventario);
                        stmtDarErva.executeUpdate();
                    }
                }

                conn.commit();
                conn.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Protagonista carregarProtagonista(String nickname) {
        try (Connection conn = DatabasePool.getConnection()) {
            String sql = "SELECT p.id_entidade, p.nickname, p.killcount, p.dinheirorecebido, " +
                    "p.fk_sala_numero, p.vida, p.dano, p.arma_equipada, p.equipamento_equipado " +
                    "FROM protagonista p WHERE p.nickname = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nickname);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("id_entidade");
                        Inventario inv = InventarioService.carregarInventario(id);
                        Protagonista prot = new Protagonista(
                                id,
                                rs.getString("nickname"),
                                rs.getInt("vida"),
                                rs.getInt("dano"),
                                rs.getInt("killcount"),
                                rs.getInt("dinheirorecebido"),
                                inv
                        );
                        prot.setSala(rs.getInt("fk_sala_numero"));
                        int idArma = rs.getInt("arma_equipada");
                        if(idArma >0){
                            Arma arma = retaguarda.item.ArmaService.getArmaById(idArma);
                            prot.setArmaEquipada(arma);
                        }
                        int idEquipamento = rs.getInt("equipamento_equipado");
                        if(idEquipamento>0){
                            Equipamento equipamento = retaguarda.item.EquipamentoService.getEquipamentoById(idEquipamento);
                            prot.setEquipamentoEquipada(equipamento);
                        }
                        return prot;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void atualizarDinheiro(int idProtagonista, int novoDinheiro) {
        String sql = "UPDATE protagonista SET dinheirorecebido = ? WHERE id_entidade = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, novoDinheiro);
            stmt.setInt(2, idProtagonista);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consumirConsumivel(int idProtagonista, int idInstanciaItem, Protagonista protagonista) {
        String getEfeitoSql = "SELECT c.efeito FROM instanciaitem i " +
                "JOIN item it ON i.id_item = it.iditem " +
                "JOIN consumivel c ON it.iditem = c.id_item " +
                "WHERE i.idinstanciaitem = ?";
        String updateVidaSql = "UPDATE protagonista SET vida = IF(vida + ? > 100, 100, vida + ?) WHERE id_entidade = ?";
        String deleteItemSql = "DELETE FROM instanciaitem WHERE idinstanciaitem = ?";
        String selectVidaSql = "SELECT vida FROM protagonista WHERE id_entidade = ?";

        try (Connection conn = DatabasePool.getConnection()) {
            try (PreparedStatement getEfeitoStmt = conn.prepareStatement(getEfeitoSql)) {
                getEfeitoStmt.setInt(1, idInstanciaItem);
                try (ResultSet rs = getEfeitoStmt.executeQuery()) {
                    if (rs.next()) {
                        String efeito = rs.getString("efeito").trim();
                        int valorCura = 0;
                        if ("Cura toda a vida".equalsIgnoreCase(efeito)) {
                            valorCura = 100;
                        } else if ("Cura 30 de vida".equalsIgnoreCase(efeito)) {
                            valorCura = 30;
                        } else if ("Cura 25 de vida".equalsIgnoreCase(efeito)) {
                            valorCura = 25;
                        } else if ("Cura 15 de vida".equalsIgnoreCase(efeito)) {
                            valorCura = 15;
                        } else if ("Cura 5 de vida".equalsIgnoreCase(efeito)) {
                            valorCura = 5;
                        } else {
                            System.out.println("Efeito do consumível não reconhecido.");
                            return;
                        }
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateVidaSql)) {
                            updateStmt.setInt(1, valorCura);
                            updateStmt.setInt(2, valorCura);
                            updateStmt.setInt(3, idProtagonista);
                            int rows = updateStmt.executeUpdate();
                            if (rows > 0) {
                                System.out.println("Vida atualizada no banco.");
                            } else {
                                System.out.println("Falha ao atualizar a vida no banco.");
                            }
                        }
                        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteItemSql)) {
                            deleteStmt.setInt(1, idInstanciaItem);
                            int delRows = deleteStmt.executeUpdate();
                            if (delRows > 0) {
                                System.out.println("Consumível utilizado: " + efeito);
                            } else {
                                System.out.println("Falha ao remover o consumível do inventário.");
                            }
                        }
                        try (PreparedStatement selectStmt = conn.prepareStatement(selectVidaSql)) {
                            selectStmt.setInt(1, idProtagonista);
                            try (ResultSet rsVida = selectStmt.executeQuery()) {
                                if (rsVida.next()) {
                                    int novaVida = rsVida.getInt("vida");
                                    protagonista.setVida(novaVida);
                                    System.out.println("Vida atualizada para: " + novaVida);
                                }
                            }
                        }
                    } else {
                        System.out.println("Consumível não encontrado ou não é um consumível.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void atualizarVida(int idProtagonista, int novaVida) {
        String sql = "UPDATE protagonista SET vida = ? WHERE id_entidade = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, novaVida);
            stmt.setInt(2, idProtagonista);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void incrementarKillCount(int idProtagonista) {
        String sql = "UPDATE protagonista SET killcount = killcount + 1 WHERE id_entidade = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProtagonista);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removerProtagonista(int idProtagonista) {
        String sql = "DELETE FROM entidade WHERE identidade = ?";
        try (Connection conn = DatabasePool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProtagonista);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Protagonista removido. GAME OVER. Obrigado por jogar!");
                Thread.sleep(1000);
            } else {
                System.out.println("Nenhum protagonista foi removido. GAME OVER. Obrigado por jogar!");
            }
            System.exit(0);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

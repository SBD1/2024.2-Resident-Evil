package retaguarda.protagonista;


import retaguarda.inventario.Inventario;
import retaguarda.item.Arma;
import retaguarda.item.Equipamento;
import bancoDados.DatabasePool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Protagonista {
    private int id;
    private String nickname;
    private int vida;
    private int dano;
    private int killcount;

    private int dinheiroRecebido;
    private int sala;
    private Inventario inventario;

    private Arma armaEquipada;
    private Equipamento equipamentoEquipada;

    public Protagonista(int id, String nickname, int vida, int dano, int killcount, int dinheiroRecebido, Inventario inventario) {
        this.id = id;
        this.nickname = nickname;
        this.vida = vida;
        this.dano = dano;
        this.killcount = killcount;
        this.dinheiroRecebido = dinheiroRecebido;
        this.inventario = inventario;
        this.sala = 0;
    }

    public void moverParaSala(int novaSala) {
        this.sala = novaSala;
        System.out.println(nickname + " se moveu para a sala " + novaSala);
    }

    public int getId() { return id; }
    public String getNickname() { return nickname; }
    public int getVida() { return vida; }
    public int getDano() { return dano; }
    public int getKillcount() { return killcount; }
    public int getDinheiroRecebido() { return dinheiroRecebido; }
    public Inventario getInventario() { return inventario; }
    public int getSala() { return sala; }
    public void setSala(int sala) { this.sala = sala; }
    public Arma getArmaEquipada() { return armaEquipada; }
    public Equipamento getEquipamentoEquipada() { return equipamentoEquipada; }
    public void setVida(int vida) {this.vida = vida;}

    public void setArmaEquipada(Arma arma) {
        this.armaEquipada = arma;
        try (Connection conn = DatabasePool.getConnection()) {
            String sql = "UPDATE protagonista SET arma_equipada = ? WHERE id_entidade = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                if (arma != null) {
                    stmt.setInt(1, arma.getIdItem());
                } else {
                    stmt.setNull(1, java.sql.Types.INTEGER);
                }
                stmt.setInt(2, this.id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setEquipamentoEquipada(Equipamento equipamento) {
        this.equipamentoEquipada = equipamento;
        try (Connection conn = DatabasePool.getConnection()) {
            String sql = "UPDATE protagonista SET equipamento_equipado = ? WHERE id_entidade = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                if (equipamento != null) {
                    stmt.setInt(1, equipamento.getIdItem());
                } else {
                    stmt.setNull(1, java.sql.Types.INTEGER);
                }
                stmt.setInt(2, this.id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

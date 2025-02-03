package retaguarda.protagonista;

import retaguarda.inventario.Inventario;
import retaguarda.item.Arma;
import retaguarda.item.Equipamento;

public class Protagonista {
    private int id;
    private String nickname;
    private int vida;
    private int dano;
    private int killcount;
    private int dinheiroRecebido;
    private Inventario inventario;
    private int sala;
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

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getVida() {
        return vida + (equipamentoEquipada != null ? equipamentoEquipada.getDefesa() : 0);
    }

    public int getDano() {
        return dano + (armaEquipada != null ? armaEquipada.getDano() : 0);
    }

    public int getDinheiroRecebido() {
        return dinheiroRecebido;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void equiparArma(Arma arma) {
        this.armaEquipada = arma;
    }

    public Equipamento getEquipamentoEquipada() {
        return equipamentoEquipada;
    }

    public void equiparEquipamento(Equipamento equipamento) {
        this.equipamentoEquipada = equipamento;
    }
}

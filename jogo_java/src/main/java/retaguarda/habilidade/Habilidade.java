package retaguarda.habilidade;

import retaguarda.item.InstanciaItem;
import java.util.List;

public class Habilidade {
    private String nome;
    private int tempo_recarga_turno;
    private int tempo_recarga_tempo;
    private int dano;

    public Habilidade(String nome, int tempo_recarga_turno, int tempo_recarga_tempo, int dano) {
        this.nome = nome;
        this.tempo_recarga_tempo = tempo_recarga_tempo;
        this.tempo_recarga_turno = tempo_recarga_turno;
        this.dano = dano;
    }

    public int getDano() { return dano; }
    public int getTempo_recarga_tempo() { return tempo_recarga_tempo; }
    public int getTempo_recarga_turno() { return tempo_recarga_turno; }
    public String nome() { return nome; }

    public void setDano(int dano) {
        this.dano = dano;
    }
    public void setTempo_recarga_tempo(int tempo_recarga_tempo) {
        this.tempo_recarga_tempo = tempo_recarga_tempo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTempo_recarga_turno(int tempo_recarga_turno){
        this.tempo_recarga_turno = tempo_recarga_turno;
    }
}

package retaguarda.mapa;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
    private String nome;
    private Map<Integer, Sala> salas;

    public Mapa(String nome) {
        this.nome = nome;
        this.salas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarSala(Sala sala) {
        salas.put(sala.getNumero(), sala);
    }

    public Sala getSala(int numero) {
        return salas.get(numero);
    }
}

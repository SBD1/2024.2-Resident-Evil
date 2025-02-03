package retaguarda.mapa;

public class Sala {
    private int numero;
    private String nome;
    private String nome_mapa;

    public Sala(int numero, String nome, String nome_mapa) {
        this.numero = numero;
        this.nome = nome;
        this.nome_mapa = nome_mapa;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeMapa() {
        return nome_mapa;
    }

}

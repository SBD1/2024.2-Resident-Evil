package retaguarda.mapa;

public class Sala {
    private int numero;
    private String nome;
    private String nomeMapa;
    private String descricao;

    public Sala(int numero, String nome, String nomeMapa, String descricao) {
        this.numero = numero;
        this.nome = nome;
        this.nomeMapa = nomeMapa;
        this.descricao = descricao;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeMapa() {
        return nomeMapa;
    }

    public String getDescricao() {
        return descricao;
    }
}

package retaguarda.item;

public class Item {
    private int iditem;
    private String nome;
    private String descricao;
    private int valor;
    private int peso;
    private Tipo tipo;

    public Item(int iditem, String nome, String descricao, int valor, int peso, Tipo tipo) {
        this.iditem = iditem;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.peso = peso;
        this.tipo = tipo;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}

package retaguarda.item;

public class Item {

    private int idItem;

    private String nome;
    private String descricao;
    private int valor;
    private int peso;
    private Tipo tipo;


    public Item(int idItem, String nome, String descricao, int valor, int peso, Tipo tipo) {
        this.idItem = idItem;

        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.peso = peso;
        this.tipo = tipo;
    }


    public int getIdItem() { return idItem; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public int getValor() { return valor; }
    public int getPeso() { return peso; }
    public Tipo getTipo() { return tipo; }

}

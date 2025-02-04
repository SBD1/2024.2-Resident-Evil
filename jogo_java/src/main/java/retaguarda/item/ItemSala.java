package retaguarda.item;

public class ItemSala {
    private int id;
    private int fkSala;
    private Item item;
    private int quantidade;

    public ItemSala(int id, int fkSala, Item item, int quantidade) {
        this.id = id;
        this.fkSala = fkSala;
        this.item = item;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public int getFkSala() { return fkSala; }
    public Item getItem() { return item; }
    public int getQuantidade() { return quantidade; }
}

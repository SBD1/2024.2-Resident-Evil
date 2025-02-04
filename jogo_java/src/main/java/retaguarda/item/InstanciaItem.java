package retaguarda.item;

public class InstanciaItem {
    private int idInstanciaItem;
    private Item item;

    private String descricao;

    public InstanciaItem(int idInstanciaItem, Item item, String descricao) {
        this.idInstanciaItem = idInstanciaItem;
        this.item = item;
        this.descricao = descricao;
    }

    public int getIdInstanciaItem() { return idInstanciaItem; }
    public Item getItem() { return item; }
    public String getDescricao() { return descricao; }

    public int getId(){
        return this.idInstanciaItem;

    }
}

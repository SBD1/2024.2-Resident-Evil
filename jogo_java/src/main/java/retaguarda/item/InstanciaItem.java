package retaguarda.item;

public class InstanciaItem {
    private int idInstanciaItem;
    private Item item;
    private String nomeMissao;

    public InstanciaItem(int idInstanciaItem, Item item, String nomeMissao) {
        this.idInstanciaItem = idInstanciaItem;
        this.item = item;
        this.nomeMissao = nomeMissao;
    }

    public int getIdInstanciaItem() {
        return idInstanciaItem;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }
}

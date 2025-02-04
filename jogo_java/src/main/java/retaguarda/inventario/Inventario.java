package retaguarda.inventario;

import retaguarda.item.InstanciaItem;

import java.util.List;

public class Inventario {
    private int idInventario;
    private int pesoMax;
    private int idEntidade;
    private int idInstanciaNPC;
    private List<InstanciaItem> itens;

    public Inventario(int pesoMax, int idEntidade, int idInstanciaNPC, List<InstanciaItem> itens) {
        this.pesoMax = pesoMax;
        this.idEntidade = idEntidade;
        this.idInstanciaNPC = idInstanciaNPC;

        this.itens = itens;
    }

    public void adicionarItem(InstanciaItem instanciaItem) {
        itens.add(instanciaItem);
    }

    public void removerItem(int idInstanciaItem) {
        itens.removeIf(item -> item.getIdInstanciaItem() == idInstanciaItem);
    }

    public List<InstanciaItem> listarItens() {
        return itens;
    }

}

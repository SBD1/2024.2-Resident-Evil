package retaguarda.inventario;

import retaguarda.item.InstanciaItem;

import java.util.List;

public class Inventario {
    private int idinventario;
    private int pesomax;
    private int id_entidade;
    private int id_instancianpc;
    private List<InstanciaItem> itens;

    public Inventario(int idinventario, int pesomax, int id_entidade, int id_instancianpc, List<InstanciaItem> itens) {
        this.idinventario = idinventario;
        this.pesomax = pesomax;
        this.id_entidade = id_entidade;
        this.id_instancianpc = id_instancianpc;
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

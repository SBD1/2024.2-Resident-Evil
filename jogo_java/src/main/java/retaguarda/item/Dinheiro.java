package retaguarda.item;

public class Dinheiro extends Item{
    private int quantidade;

    public Dinheiro(int idItem, int quantidade) {
        super(idItem, "Dinheiro", "Moeda do jogo", quantidade, 0, Tipo.dinheiro);
        this.quantidade = quantidade;
    }
}

package retaguarda.item;

public class Consumivel extends Item{
    private String efeito;

    public Consumivel(int iditem, String nome, String descricao, int valor, int peso, Tipo tipo, String efeito) {
        super(iditem, nome, descricao, valor, peso, Tipo.consumivel);
        this.efeito = efeito;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }
}

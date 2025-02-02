package retaguarda.item;

public class Equipamento extends Item{
    private int defesa;
    private int nivel;

    public Equipamento(int iditem, String nome, String descricao, int valor, int peso, Tipo tipo, int defesa, int nivel) {
        super(iditem, nome, descricao, valor, peso, Tipo.equipamento);
        this.defesa = defesa;
        this.nivel = nivel;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}

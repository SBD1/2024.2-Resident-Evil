package retaguarda.item;

public class Arma extends Item{
    private int dano;
    private int nivel;
    private int chancErro;
    private int chanceCritico;
    private int maxMuni;

    public Arma(int iditem, String nome, String descricao, int valor, int peso, Tipo tipo, int dano, int nivel, int chancErro, int chanceCritico, int maxMuni) {
        super(iditem, nome, descricao, valor, peso, Tipo.arma);
        this.dano = dano;
        this.nivel = nivel;
        this.chancErro = chancErro;
        this.chanceCritico = chanceCritico;
        this.maxMuni = maxMuni;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getChancErro() {
        return chancErro;
    }

    public void setChancErro(int chancErro) {
        this.chancErro = chancErro;
    }

    public int getChanceCritico() {
        return chanceCritico;
    }

    public void setChanceCritico(int chanceCritico) {
        this.chanceCritico = chanceCritico;
    }

    public int getMaxMuni() {
        return maxMuni;
    }

    public void setMaxMuni(int maxMuni) {
        this.maxMuni = maxMuni;
    }

    public int getDanoEfetivo() {
        return (int) Math.round(dano * (1 + 0.2 * (nivel - 1)));
    }
}

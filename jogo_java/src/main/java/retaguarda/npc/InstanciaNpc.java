package retaguarda.npc;

public class InstanciaNpc {
    private int idInstancia;
    private int idEntidade;
    private int vidaAtual;
    private int baseDamage;
    private String tipo;

    public InstanciaNpc(int idInstancia, int idEntidade, int vidaAtual, int baseDamage, String tipo) {
        this.idInstancia = idInstancia;
        this.idEntidade = idEntidade;
        this.vidaAtual = vidaAtual;
        this.baseDamage = baseDamage;
        this.tipo = tipo;
    }

    public int getIdInstancia() { return idInstancia; }
    public int getIdEntidade() { return idEntidade; }
    public int getVidaAtual() { return vidaAtual; }
    public void setVidaAtual(int vidaAtual) { this.vidaAtual = vidaAtual; }
    public int getBaseDamage() { return baseDamage; }
    public String getTipo() { return tipo; }
}

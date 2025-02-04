package retaguarda.item;

public enum Tipo {

    arma, consumivel, equipamento, dinheiro;

    public static Tipo fromString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Tipo não pode ser nulo.");
        }
        switch (str.toLowerCase()) {
            case "arma": return arma;
            case "consumivel": return consumivel;
            case "equipamento": return equipamento;
            case "dinheiro": return dinheiro;
            default: throw new IllegalArgumentException("Tipo desconhecido: " + str);
        }
    }

}

package retaguarda.item;

public enum Tipo {
    arma,
    equipamento,
    consumivel,
    dinheiro;

    public static Tipo fromString(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo não pode ser nulo.");
        }

        return switch (tipo.toLowerCase()) {
            case "arma" -> arma;
            case "equipamento" -> equipamento;
            case "consumivel" -> consumivel;
            case "dinheiro" -> dinheiro;
            default -> throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
        };
    }
}

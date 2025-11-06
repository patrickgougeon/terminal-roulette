package modelo;

public enum Armas {
    PISTOLA_COMPACTA(3),
    PISTOLA(4),
    REVOLVER(6),
    FUZIL(8);

    private final int capacidade;

    Armas(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
